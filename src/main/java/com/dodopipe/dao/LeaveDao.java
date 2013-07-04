package com.dodopipe.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import org.springframework.jdbc.core.RowMapper; 

import com.dodopipe.beans.Leavebean;
import com.dodopipe.dao.Idao.ILeaveDao;

import java.lang.StringBuffer;

public class LeaveDao extends BaseDao implements ILeaveDao{


	public boolean insertInfo(Leavebean bean){
		try{
            String sql = "insert into askfor_leave (username,startDate,endDate,reason,note) value (?,?,?,?,?)";
            getJdbcTemplate().update(sql,new Object[]{bean.getName(),bean.getStartDate(),bean.getEndDate(),bean.getReason(),"no-reply"}); 
            return true;
        } catch(Exception e){
        	e.printStackTrace();
        }
        return false;
	}

    public List getAllByName(String username){

        String sql = "select * from askfor_leave where username = ? and note = ?";  
        Object[] params = new Object[] {username,"no-reply"};

        List<Leavebean> leavebeans = getJdbcTemplate().query(sql,params,new LeaveMapper());  
        
        sql = "select * from askfor_leave where username = ? and note != ?";
        leavebeans.addAll(getJdbcTemplate().query(sql,params,new LeaveMapper()));

        if(leavebeans.isEmpty()){
            
           return null;  
        }

        return leavebeans;
    }

    public List getInfoByBean(Leavebean leavebean){
        StringBuffer sql = new StringBuffer("select * from askfor_leave where 1 = 1 ");
        List<Object> params = new ArrayList<Object>();
        List leavebeans = new ArrayList();
        if(leavebean.getName() != null && leavebean.getName() != ""){
            sql.append("and username = ? ");
            params.add(leavebean.getName());
        }
        if(leavebean.getStartDate() != null){
            sql.append("and leaveDate = ? ");
            params.add(leavebean.getStartDate());    
        }
        if(leavebean.getEndDate() != null){
            sql.append("and leaveDate = ? ");
            params.add(leavebean.getEndDate());    
        }
        if(leavebean.getNote() != null && leavebean.getNote()!= ""){
            sql.append("and note = ? ");
            params.add(leavebean.getNote());
            leavebeans =getJdbcTemplate().query(sql.toString(),params.toArray(),new LeaveMapper());     
        } else {
            params.add("no-reply");
            String sql1 = sql.toString() + "and note = ? ";
            leavebeans = getJdbcTemplate().query(sql1,params.toArray(),new LeaveMapper());
            String sql2 = sql.toString() + "and note != ?";
            leavebeans.addAll(getJdbcTemplate().query(sql2,params.toArray(),new LeaveMapper()));
        }

        if(leavebeans.isEmpty()){
            
           return null;  
        }

        return leavebeans;

    }

    public Leavebean getLeavebeanById(int id){

        String sql = "select * from askfor_leave where id = ?";
        List leavebeans = getJdbcTemplate().query(sql,new Object[]{id},new LeaveMapper());

        if(leavebeans.isEmpty()){

            return null;
        }

        return (Leavebean)leavebeans.get(0);

    }

    public boolean updateInfo(int id,String note,String remark){
        try{
            String sql = "update askfor_leave set note = ? , remark = ? where id = ?";
            if("original".equals(note)){
                return false;   
            }
            getJdbcTemplate().update(sql,new Object[]{note,remark,id}); 
            return true;
        } catch(Exception e){
            e.printStackTrace();
            return false;
        }

    }

    protected class LeaveMapper implements RowMapper{

        public Leavebean mapRow(ResultSet rs, int rowNum) throws SQLException {  
            Leavebean leavebean = new Leavebean(); 
            leavebean.setId(rs.getInt("id"));
            leavebean.setName(rs.getString("username"));
            leavebean.setStartDate(rs.getTimestamp("startDate"));
            leavebean.setEndDate(rs.getTimestamp("endDate"));
            leavebean.setReason(rs.getString("reason"));
            leavebean.setNote(rs.getString("note"));
            leavebean.setLeaveDate(rs.getDate("leaveDate"));
            leavebean.setRemark(rs.getString("remark"));

            return leavebean;  
        }
    }
}