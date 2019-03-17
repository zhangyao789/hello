package com.zy.entity;

import java.util.List;

public class Detps {
	private List<User> listuser;
	private int did;
	private String dname,dtime,dtest;
	public List<User> getListuser() {
		return listuser;
	}
	public void setListuser(List<User> listuser) {
		this.listuser = listuser;
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getDtime() {
		return dtime;
	}
	public void setDtime(String dtime) {
		this.dtime = dtime;
	}
	public String getDtest() {
		return dtest;
	}
	public void setDtest(String dtest) {
		this.dtest = dtest;
	}

	
	
}
