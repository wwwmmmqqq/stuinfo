package com.stuinfo.dao;

import java.util.List;

import com.stuinfo.domain.DO.stuinfo_notice;

public interface NoticeManageDao {

	public List<stuinfo_notice> listNoticesAll();

	public boolean NoticeOk(stuinfo_notice stuinfoNotice);

	public stuinfo_notice getNoticeByid(String noticeId);

	public int saveNotice(stuinfo_notice stuinfoNotice);

	public List<stuinfo_notice> getNoticeByPage(int pageIndex, int pageSize);

	public List<stuinfo_notice> listReadNoticesAll();

	public List<stuinfo_notice> getReadNoticeByPage(int pageIndex, int pageSize);

}
