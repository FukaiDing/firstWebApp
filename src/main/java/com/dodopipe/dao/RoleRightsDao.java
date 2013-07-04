package com.dodopipe.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import org.springframework.jdbc.core.RowMapper; 

import com.dodopipe.beans.RoleRightsbean;
import com.dodopipe.dao.Idao.IRoleRightsDao;


public class RoleRightsDao extends BaseDao implements IRoleRightsDao {

	public List getRoleRightsbeanByRole(String role){

		String sql = "select * from rolerights where role = ?";
		Object[] params = new Object[] {role};

        List<RoleRightsbean> roleRightsbeans = getJdbcTemplate().query(sql,params,new RoleRightsMapper());  
        
        if(roleRightsbeans.isEmpty()){
            
           return null;  
        }

        return roleRightsbeans;
	}

	protected class RoleRightsMapper implements RowMapper {  
  
        public RoleRightsbean mapRow(ResultSet rs, int rowNum) throws SQLException {  
            RoleRightsbean roleRightsbean = new RoleRightsbean(); 
            roleRightsbean.setId(rs.getInt("id"));
            roleRightsbean.setRole(rs.getString("role"));
            roleRightsbean.setUrl(rs.getString("url"));
            roleRightsbean.setRights(rs.getString("rights"));
            roleRightsbean.setParams(rs.getString("params"));
            return roleRightsbean;  
        }
    }
}