package com.zy.entity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 实体类对象，目的是映射DB表结构，和页面表单标签相互呼应的。
 * @author Jerry
 * 一个User对象属于一个Depts对象
 */
public class User {
    private int uid,uage,d_id,currentpage,pagesize;
    private String uname,upwd,uimg,utest ,udate,age="",from="",to="";
    //java实体类对象 主外键约束的体现形式
    private Detps depts;
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(int curr,int size) {
		currentpage = curr;
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
	
	
	public int getCurrentpage() {
		return currentpage;
	}
	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		if(to.equals("")||to.equals(null)){
			 Date dNow = new Date( );
		      SimpleDateFormat ft = 
		      new SimpleDateFormat ("yyyy-MM-dd");

//		      System.out.println("Current Date: " + ft.format(dNow));
		      return  ft.format(dNow) ;
		}else	{	 
			return to;
		}
	}
	public void setTo(String to) {
		this.to = to;
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

	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	

	

}
