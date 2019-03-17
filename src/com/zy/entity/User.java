package com.zy.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 实体类对象，目的是映射DB表结构，和页面表单标签相互呼应的。
 * @author Jerry
 * 一个User对象属于一个Depts对象
 */
public class User {
    private int uid,uage,d_id,currepage,pagesize;
    private String uname,upwd,uimg,utest ,udate;
    //java实体类对象 主外键约束的体现形式
    private Detps depts;
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(int curr,int size) {
		currepage = curr;
		pagesize = size;
	}
	
	
	public User(int uage, int d_id, String uname, String upwd, String utest) {
		super();
		this.uage = uage;
		this.d_id = d_id;
		this.uname = uname;
		this.upwd = upwd;
		this.utest = utest;
	}
	public User(int uid, int uage, int d_id, String uname, String upwd, String utest) {
		super();
		this.uid = uid;
		this.uage = uage;
		this.d_id = d_id;
		this.uname = uname;
		this.upwd = upwd;
		this.utest = utest;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getUage() {
		return uage;
	}
	public void setUage(int uage) {
		this.uage = uage;
	}
	public int getD_id() {
		return d_id;
	}
	public void setD_id(int d_id) {
		this.d_id = d_id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public String getUimg() {
		return uimg;
	}
	public void setUimg(String uimg) {
		this.uimg = uimg;
	}
	public String getUtest() {
		return utest;
	}
	public void setUtest(String utest) {
		this.utest = utest;
	}
	public String getUdate() {
		return udate;
	}
	public void setUdate(String udate) {
		this.udate = udate;
	}
	public Detps getDepts() {
		return depts;
	}
	public void setDepts(Detps depts) {
		this.depts = depts;
	}
	public int getCurrepage() {
		return currepage;
	}
	public void setCurrepage(int currepage) {
		this.currepage = currepage;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	

	

}
