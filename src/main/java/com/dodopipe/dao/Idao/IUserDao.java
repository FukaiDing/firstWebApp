package com.dodopipe.dao.Idao;

import com.dodopipe.beans.Userbean;

import java.util.List;

public interface IUserDao extends IBaseDao{

	public boolean insertInfo(Userbean userbean);


	public Userbean findByName(String username);
}
