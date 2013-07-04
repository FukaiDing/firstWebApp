package com.dodopipe.dao.Idao;

import com.dodopipe.beans.Checkbean;
import java.util.List;
import java.sql.Date;

public interface ICheckDao extends IBaseDao{

	public boolean insertInfo(Checkbean checkbean);
	
	public boolean updateInfo(Checkbean checkbean);

	public Checkbean getCheckbeanByName(String username);

	public Checkbean getCheckbeanByName(String username,Date data);

	public List getAllByName(String username);

	public List getAllByBean(Checkbean checkbean);
}