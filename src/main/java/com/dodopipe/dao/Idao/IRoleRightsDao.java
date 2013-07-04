package com.dodopipe.dao.Idao;

import com.dodopipe.beans.RoleRightsbean;
import java.util.List;

public interface IRoleRightsDao extends IBaseDao{

	public List getRoleRightsbeanByRole(String role);
}