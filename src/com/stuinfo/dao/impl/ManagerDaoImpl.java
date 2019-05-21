package com.stuinfo.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.stuinfo.dao.ManagerDao;

public class ManagerDaoImpl implements ManagerDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public boolean UpdatePassword(String ordinarymanager_id, String newPassword, String time) {
		boolean flag = true;

		try {
			Session session = getSession();
			String hql = "update stuinfo_ordinarymanager set ordinarymanager_password = '" + newPassword
					+ "',ordinarymanager__infomodified='" + time + "' where ordinarymanager_id='" + ordinarymanager_id
					+ "'";
			Query query = session.createQuery(hql);
			query.executeUpdate();
		} catch (HibernateException e) {
			flag = false;
			e.printStackTrace();
		}

		return flag;
	}
}
