package com.stuinfo.service.impl;

import com.stuinfo.dao.ManagerDao;
import com.stuinfo.service.ManagerService;

import util.TeamUtil;
import util.md5;

public class ManagerServiceImpl implements ManagerService {
	private ManagerDao managerDao;

	public ManagerDao getManagerDao() {
		return managerDao;
	}

	public void setManagerDao(ManagerDao managerDao) {
		this.managerDao = managerDao;
	}

	@Override
	public boolean UpdatePassword(String ordinarymanager_id, String newPassword) {
		boolean flag = false;
		if (ordinarymanager_id == null || ordinarymanager_id.trim().length() <= 0) {
			return false;
		}
		if (newPassword == null || newPassword.trim().length() <= 0) {
			return false;
		}
		flag = managerDao.UpdatePassword(ordinarymanager_id, md5.GetMD5Code(newPassword), TeamUtil.getStringSecond());
		return flag;
	}

}
