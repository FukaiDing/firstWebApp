package com.dodopipe.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import org.springframework.jdbc.core.RowMapper; 

import com.dodopipe.dao.Idao.IUserDao;
import com.dodopipe.beans.Userbean;

public class UserDao extends BaseDao implements IUserDao{

	public boolean insertInfo(Userbean userbean){
		try{
			String sql = "insert into employee (username,password,role) value (?,?,?)";
          	getJdbcTemplate().update(sql,new Object[]{userbean.getUsername(),userbean.getPassword(),userbean.getRole()});
            return true;
        } catch(Exception e){
        	e.printStackTrace();
        }
        return false;
	}

    public Userbean findByName(String username){
        
        String sql = "select * from employee where username = ?";  
        String[] params = new String[] {username};

        List users = getJdbcTemplate().query(sql,params,new UserMapper());  
        
        if(users.isEmpty()){  
           return null;  
        }

        return (Userbean)users.get(0); 
    }


    protected class UserMapper implements RowMapper {  
  
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {  
            Userbean userbean = new Userbean(); 
            userbean.setUsername(rs.getString("username"));
            userbean.setPassword(rs.getString("password"));
            userbean.setRole(rs.getString("role"));

            return userbean;  
        }
    }
}
