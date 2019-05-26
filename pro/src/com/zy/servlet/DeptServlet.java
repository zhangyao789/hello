package com.zy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zy.entity.User;
import com.zy.model.DeptMode;

import net.sf.json.*;
/**
 * Servlet implementation class UsersServlet
 * http://localhost:8083/WebTest/users
 */
//@WebServlet("/dept")
public class DeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public DeptServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//第一次访问页面的时候bootstrap不能提供参数的，所以两个参数提交服务器是必备的，所以两个参数也提交是有可能没有的
		//所以判断，如果没提交，那么提供一个默认值
		
		int current=0;
		if(request.getParameter("curr")!=null) {
		   current=Integer.valueOf(request.getParameter("curr"));	
		}
		int size=5;
		if(request.getParameter("size")!=null) {
			size=Integer.valueOf(request.getParameter("size"));	
		}	
		String from=request.getParameter("from");
		String to=request.getParameter("to");
		String name=request.getParameter("name");
		String age=request.getParameter("age");
		String text=request.getParameter("txt");
		String u_did=request.getParameter("did");
		
		
		System.out.println(from+","+to+","+name+","+age+","+text+","+u_did);
		//System.out.println(current+ "  - "+size);
		User user=new User(current, size);
		if(!u_did.equals(null)
				&& !u_did.equals("") ){
			user.setD_id(Integer.valueOf(u_did));
			
		}
		if(!from.equals(null)
				&& !from.equals("") ){
			System.out.println(from);
		    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");//yyyy-mm-dd, 会出现时间不对, 因为小写的mm是代表: 秒
		    Date utilDate;
			try {
				utilDate = sdf.parse(from);
				  System.out.println(utilDate);//查看utilDate的值
				  SimpleDateFormat ft = 
					      new SimpleDateFormat ("yyyy-MM-dd");
				//
					      System.out.println("from " + ft.format(utilDate));
					      user.setFrom( ft.format(utilDate));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(!to.equals(null)
				&& !from.equals("") ){
			System.out.println(to);
		    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");//yyyy-mm-dd, 会出现时间不对, 因为小写的mm是代表: 秒
		    Date utilDate;
			try {
				utilDate = sdf.parse(to);
				  System.out.println(utilDate);//查看utilDate的值
				  SimpleDateFormat ft = 
					      new SimpleDateFormat ("yyyy-MM-dd");
				//
					      System.out.println("to: " + ft.format(utilDate));
					      user.setTo(ft.format(utilDate));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		user.setUname("%"+name+"%");
		user.setUtest("%"+text+"%");
		user.setAge("%"+age+"%");
		DeptMode dm=new DeptMode();
		//当前显示页的List集合，不是table全部数据list
		List<User> l=dm.SelectUsersByObject(user);
		List<Map<String,Object>> list=new ArrayList<>();
		Map<String,Object> map=null;
		for (User us : l) {
			map=new HashMap<>();
			map.put("id", us.getUid());
			map.put("name", us.getUname());
			map.put("utime", us.getUdate());
			map.put("age", us.getUage());
			map.put("dnam", us.getDepts().getDname());
			map.put("uimg", us.getUimg());
			list.add(map);
		}		
		int count=dm.CountUsers(user);
		System.out.println(count);
        //{"":"","":[{},"{},{}]} 服务器分页json需要通用的格式，easyui 和bootstrap一样
		Map<String, Object> mapj=new HashMap<>();
   	    mapj.put("total",count);
   	    mapj.put("rows",list);
   	   
   	    JSONObject array=JSONObject.fromObject(mapj);
   	    PrintWriter pw=response.getWriter();
	    pw.print(array.toString());		
	}
	
	

}
