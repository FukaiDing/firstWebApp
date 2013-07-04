package com.dodopipe.beans;

import java.sql.Date;
import java.sql.Timestamp;

public class Checkbean{

	private int id;
	private String name;
	private Timestamp check_first;
	private Timestamp check_second;
	private Double time;
	private Date data;
	private String flag;

	public Checkbean(int id,String name,Timestamp check_first,Timestamp check_second,Double time,Date data,String flag){
		this.id = id;
		this.name = name;
		this.check_first = check_first;
		this.check_second = check_second;
		this.time = time;
		this.data = data;
		this.flag = flag;
	}

	public Checkbean(){
		
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

	public Timestamp getCheck_first(){
		return check_first;
	}
	public void setCheck_first(Timestamp check_first){
		this.check_first = check_first;
	}

	public Timestamp getCheck_second(){
		return check_second;
	}
	public void setCheck_second(Timestamp check_second){
		this.check_second = check_second;
	}

	public Date getData(){
		return data;
	}
	public void setData(Date data){
		this.data = data;
	}

	public Double getTime(){
		return time;
	}
	public void setTime(Double time){
		this.time = time;
	}

	public String getFlag(){
		return flag;
	}
	public void setFlag(String flag){
		this.flag = flag;
	}
}