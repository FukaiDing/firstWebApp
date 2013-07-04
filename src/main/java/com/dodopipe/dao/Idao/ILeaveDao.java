package com.dodopipe.dao.Idao;

import com.dodopipe.beans.Leavebean;

import java.util.List;

public interface ILeaveDao extends IBaseDao{

	public boolean insertInfo(Leavebean bean);

	public List getAllByName(String username);

	public List getInfoByBean(Leavebean bean);

	public Leavebean getLeavebeanById(int id);

	public boolean updateInfo(int id,String note,String remark);
}