package com.stuinfo.service;

import java.util.List;

import com.stuinfo.domain.DO.stuinfo_notice;
import com.stuinfo.domain.VO.NoticeVO;

public interface NoticeManageService {

	public List<stuinfo_notice> listNoticesAll();

	public int NoticeOk(String noticeId);

	public NoticeVO VO_Notice_By_PageAndSearch(NoticeVO noticeVO);

	public List<stuinfo_notice> listReadNoticesAll();

	public NoticeVO VO_Read_Notice_By_PageAndSearch(NoticeVO noticeVO);

}
