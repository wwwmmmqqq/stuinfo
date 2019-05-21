package com.stuinfo.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.stuinfo.dao.NoticeManageDao;
import com.stuinfo.domain.DO.stuinfo_notice;

public class NoticeManageDaoImpl implements NoticeManageDao {
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Override
	public List<stuinfo_notice> listNoticesAll() {
		List<stuinfo_notice> listNotices = new ArrayList<>();
		Session session = getSession();
		String hql = "from stuinfo_notice where notice_status='1'";
		Query query = session.createQuery(hql);
		listNotices = query.list();
		session.clear();
		return listNotices;
	}

	@Override
	public List<stuinfo_notice> listReadNoticesAll() {
		List<stuinfo_notice> listReadNotices = new ArrayList<>();
		Session session = getSession();
		String hql = "from stuinfo_notice where notice_status='0'";// 未读状态为0
		Query query = session.createQuery(hql);
		listReadNotices = query.list();
		session.clear();
		return listReadNotices;
	}

	@Override
	public List<stuinfo_notice> getNoticeByPage(int pageIndex, int pageSize) {
		List<stuinfo_notice> listNotices = new ArrayList<>();
		Session session = getSession();
		String hql = "from stuinfo_notice where notice_status='1'";
		/* String hql = "select count(*) from stuinfo_stubaseinfo"; */
		Query query = session.createQuery(hql);
		// 两个set方法约束每页的查询条件
		// 设置从第几条开始查询
		query.setFirstResult((pageIndex - 1) * pageSize);
		// 设置最大的查询结果为每页显示的记录数
		query.setMaxResults(pageSize);
		// 查询结果为一个list
		listNotices = query.list();
		return listNotices;
	}

	@Override
	public List<stuinfo_notice> getReadNoticeByPage(int pageIndex, int pageSize) {
		List<stuinfo_notice> listReadNotices = new ArrayList<>();
		Session session = getSession();
		String hql = "from stuinfo_notice where notice_status='0'";
		Query query = session.createQuery(hql);
		// 两个set方法约束每页的查询条件
		// 设置从第几条开始查询
		query.setFirstResult((pageIndex - 1) * pageSize);
		// 设置最大的查询结果为每页显示的记录数
		query.setMaxResults(pageSize);
		// 查询结果为一个list
		listReadNotices = query.list();
		return listReadNotices;
	}

	@Override
	public boolean NoticeOk(stuinfo_notice stuinfoNotice) {
		boolean flag = true;
		try {
			Session session = getSession();
			session.saveOrUpdate(stuinfoNotice);
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public stuinfo_notice getNoticeByid(String noticeId) {
		Session session = getSession();
		stuinfo_notice stuinfoNotice = null;
		String hql = "from stuinfo_notice where notice_id='" + noticeId + "'";
		Query query = session.createQuery(hql);
		stuinfoNotice = (stuinfo_notice) query.uniqueResult();
		return stuinfoNotice;
	}

	@Override
	public int saveNotice(stuinfo_notice stuinfoNotice) {
		int flag = 1;
		try {
			Session session = getSession();
			session.saveOrUpdate(stuinfoNotice);
		} catch (Exception e) {
			flag = -1;
			e.printStackTrace();
		}
		return flag;
	}

}
