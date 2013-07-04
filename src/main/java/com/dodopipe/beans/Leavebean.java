package com.dodopipe.beans;

import java.sql.Date;
import java.sql.Timestamp;

public class Leavebean{

	private int id;
	private String name;
	private String reason;
	private Timestamp startDate;
	private Timestamp endDate;
	private String note;
	private Date leaveDate;
	private String remark;
	
	public Leavebean(String name, Timestamp startDate,Timestamp endDate,String reason){
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.reason = reason;
	}
	public Leavebean(String name, Timestamp startDate,Timestamp endDate,String reason,String note){
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.reason = reason;
		this.note = note;
	}

	public Leavebean(){

	}

	public int getId(){
		return id;
	}

	public void setId(int id){
		this.id = id;
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getReason(){
		return reason;
	}

	public void setReason(String reason){
		this.reason = reason;
	}

	public Timestamp getStartDate(){
		return startDate;
	}

	public void setStartDate(Timestamp startDate){
		this.startDate = startDate;
	}

	public Timestamp getEndDate(){
		return endDate;
	}

	public void setEndDate(Timestamp endDate){
		this.endDate = endDate;
	}
	
	public String getNote(){
		return note;
	}

	public void setNote(String note){
		this.note = note;
	}

	public Date getLeaveDate(){
		return leaveDate;
	}

	public void setLeaveDate(Date leaveDate){
		this.leaveDate = leaveDate;
	}

	public String getRemark(){
		return remark;
	}

	public void setRemark(String remark){
		this.remark = remark;
	}

}