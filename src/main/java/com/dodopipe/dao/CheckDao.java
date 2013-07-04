package com.dodopipe.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import org.springframework.jdbc.core.RowMapper; 

import com.dodopipe.dao.Idao.ICheckDao;
import com.dodopipe.beans.Checkbean;

import java.sql.Date;

public class CheckDao extends BaseDao implements ICheckDao{
	public boolean insertInfo(Checkbean checkbean){
		try{
            String sql = null;
            Checkbean check = getCheckbeanByName(checkbean.getName(),checkbean.getData());
            if(check == null){
                sql = "insert into check_time (username,check_first,check_second,data,flag) value (?,?,?,?,?)";
                getJdbcTemplate().update(sql,new Object[]{checkbean.getName(),checkbean.getCheck_first(),checkbean.getCheck_second(),checkbean.getData(),checkbean.getFlag()}); 
            } else {
                sql = "update check_time set check_second = ?,time = ? where data = ?";
                Double time = (checkbean.getCheck_first().getTime() - check.getCheck_first().getTime()) / 3600000.0;
                getJdbcTemplate().update(sql,new Object[]{checkbean.getCheck_first(),time,checkbean.getData()});
            }
            sql = "update check_time set flag = '2' where data != ?";
            getJdbcTemplate().update(sql,new Object[]{checkbean.getData()});
            return true;
        } catch(Exception e){
        	e.printStackTrace();
        }
        return false;
	}

	public boolean updateInfo(Checkbean checkbean){
		try{
			String sql = null;
            Checkbean check = getCheckbeanByName(checkbean.getName(),checkbean.getData());
            if(check == null){
                sql = "update check_time set check_second = ?,flag = '2' where data = ? and username = ?";
        	   getJdbcTemplate().update(sql,new Object[]{checkbean.getCheck_second(),checkbean.getData(),checkbean.getName()}); 
            } else {
                sql = "update check_time set check_second = ?,flag = '2',time = ? where data = ? and username = ?";
                Double time = (checkbean.getCheck_second().getTime() - check.getCheck_first().getTime()) / 3600000.0;
                getJdbcTemplate().update(sql,new Object[]{checkbean.getCheck_second(),time,checkbean.getData(),checkbean.getName()});
            }
        	return true;
        } catch(Exception e){
        	e.printStackTrace();
        }
        return false;
	}

    public Checkbean getCheckbeanByName(String username){
        Date cur_time = new Date(new java.util.Date().getTime());
        String sql = "select * from check_time where username = ? and data = ? and flag = ?";  
        Object[] params = new Object[] {username,cur_time,"1"};
        List checkbeans = getJdbcTemplate().query(sql,params,new CheckMapper());  
        
        if(checkbeans.isEmpty()){
            Checkbean checkbean = new Checkbean();
            checkbean.setFlag("2");
           return checkbean;  
        }

        return (Checkbean)checkbeans.get(0);
    }
    public Checkbean getCheckbeanByName(String username,Date data){
        String sql = "select * from check_time where username = ? and data = ?";  
        Object[] params = new Object[] {username,data};
        List checkbeans = getJdbcTemplate().query(sql,params,new CheckMapper());  
        
        if(checkbeans.isEmpty()){
            
           return null;  
        }

        return (Checkbean)checkbeans.get(0);
    }

    public List getAllByName(String username){

        String sql = "select * from check_time where username = ?";  
        Object[] params = new Object[] {username};

        List<Checkbean> checkbeans = getJdbcTemplate().query(sql,params,new CheckMapper());  
        
        if(checkbeans.isEmpty()){
            
           return null;  
        }

        return checkbeans;
    }

    public List getAllByBean(Checkbean checkbean){
        StringBuffer sql = new StringBuffer("select * from check_time where 1 = 1 ");
        List<Object> params = new ArrayList<Object>();
        if(checkbean.getName() != null && checkbean.getName() != ""){
            sql.append("and username = ? ");
            params.add(checkbean.getName());
        }
        if(checkbean.getCheck_first() != null){
            sql.append("and data >= ? ");
            params.add(checkbean.getCheck_first());
        }
        if(checkbean.getCheck_second() != null){
            sql.append("and data <= ? ");
            params.add(checkbean.getCheck_second());
        }

        List checkbeans = getJdbcTemplate().query(sql.toString(),params.toArray(),new CheckMapper());

        if(checkbeans.isEmpty()){
            
           return null;  
        }

        return checkbeans;
    }

    protected class CheckMapper implements RowMapper {  
  
        public Checkbean mapRow(ResultSet rs, int rowNum) throws SQLException {  
            Checkbean checkbean = new Checkbean(); 
            checkbean.setId(rs.getInt("id"));
            checkbean.setName(rs.getString("username"));
            checkbean.setCheck_first(rs.getTimestamp("check_first"));
            checkbean.setCheck_second(rs.getTimestamp("check_second"));
            checkbean.setTime(rs.getDouble("time"));
            checkbean.setData(rs.getDate("data"));
            checkbean.setFlag(rs.getString("flag"));

            return checkbean;  
        }
    }
}