package com.stuinfo.service;

import com.stuinfo.domain.DO.stuinfo_stubaseinfo;

public interface LoginAndLogoutService {

	public int login(String username, String password);

	public Object loginInformation(int role, String username);

	public boolean save_NewStudent(stuinfo_stubaseinfo newStudent);

}
