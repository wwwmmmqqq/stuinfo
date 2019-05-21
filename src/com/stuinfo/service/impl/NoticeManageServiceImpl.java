package com.stuinfo.service.impl;

import java.util.List;

import com.stuinfo.dao.NoticeManageDao;
import com.stuinfo.domain.DO.stuinfo_notice;
import com.stuinfo.domain.VO.NoticeVO;
import com.stuinfo.service.NoticeManageService;

import util.TeamUtil;

public class NoticeManageServiceImpl implements NoticeManageService {
	private NoticeManageDao noticeManageDao;

	public NoticeManageDao getNoticeManageDao() {
		return noticeManageDao;
	}

	public void setNoticeManageDao(NoticeManageDao noticeManageDao) {
		this.noticeManageDao = noticeManageDao;
	}

	@Override
	public List<stuinfo_notice> listNoticesAll() {
		return noticeManageDao.listNoticesAll();
	}

	@Override
	public List<stuinfo_notice> listReadNoticesAll() {
		return noticeManageDao.listReadNoticesAll();
	}

	@Override
	public int NoticeOk(String noticeId) {
		int i = 0;
		stuinfo_notice stuinfoNotice = new stuinfo_notice();
		stuinfoNotice = noticeManageDao.getNoticeByid(noticeId);
		if (stuinfoNotice != null) {
			stuinfoNotice.setNotice_status("0");
			stuinfoNotice.setNotice_infomodified(TeamUtil.getStringSecond());
			i = noticeManageDao.saveNotice(stuinfoNotice);
		}
		return i;
	}

	@Override
	public NoticeVO VO_Notice_By_PageAndSearch(NoticeVO noticeVO) {
		/* studentInfoVO = new StudentInfoVO(); */
		/*
		 * listSchoolStudentAll()是没有setFirstResult()和setMaxResults()约束的
		 * 这样可以获取到所有满足条件的记录
		 */
		List<stuinfo_notice> noticeSize = noticeManageDao.listNoticesAll();
		// 获取总记录数
		int i = noticeSize.size();
		noticeVO.setTotalRecords(i);
		noticeVO.setTotalPages(((i - 1) / noticeVO.getPageSize()) + 1);
		// 判断是否有上一页和下一页
		if (noticeVO.getPageIndex() <= 1) {
			noticeVO.setHavePrePage(false);
		} else {
			noticeVO.setHavePrePage(true);
		}
		if (noticeVO.getPageIndex() >= noticeVO.getPageSize()) {
			noticeVO.setHaveNextPage(false);
		} else {
			noticeVO.setHaveNextPage(true);
		}
		List<stuinfo_notice> noticeList = noticeManageDao.getNoticeByPage(noticeVO.getPageIndex(),
				noticeVO.getPageSize());
		noticeVO.setStuinfoNotice(noticeList);
		return noticeVO;
	}

	@Override
	public NoticeVO VO_Read_Notice_By_PageAndSearch(NoticeVO noticeVO) {
		List<stuinfo_notice> noticeReadSize = noticeManageDao.listNoticesAll();
		// 获取总记录数
		int i = noticeReadSize.size();
		noticeVO.setTotalRecords(i);
		noticeVO.setTotalPages(((i - 1) / noticeVO.getPageSize()) + 1);
		// 判断是否有上一页和下一页
		if (noticeVO.getPageIndex() <= 1) {
			noticeVO.setHavePrePage(false);
		} else {
			noticeVO.setHavePrePage(true);
		}
		if (noticeVO.getPageIndex() >= noticeVO.getPageSize()) {
			noticeVO.setHaveNextPage(false);
		} else {
			noticeVO.setHaveNextPage(true);
		}
		List<stuinfo_notice> noticeReadList = noticeManageDao.getReadNoticeByPage(noticeVO.getPageIndex(),
				noticeVO.getPageSize());
		noticeVO.setStuinfoNotice(noticeReadList);
		return noticeVO;
	}

}
