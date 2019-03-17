package com.zy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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

import net.sf.json.JSONObject;

/**
 * Servlet implementation class DeptServlet1
 */
//@WebServlet("/DeptServlet1")
public class DeptServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeptServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		int id = Integer.valueOf(request.getParameter("uid"));
		User user= new DeptMode().SelectUserByid(id);
		Map<String,Object> map=new HashMap<>();
			map.put("id", user.getUid());
			map.put("name", user.getUname());
			map.put("pwd", user.getUpwd());
			map.put("did", user.getDepts().getDid());
			map.put("age", user.getUage());
			map.put("dnam", user.getDepts().getDname());
			map.put("uimg", user.getUimg());
			map.put("text", user.getUtest());
   	    JSONObject array=JSONObject.fromObject(map);
   	    PrintWriter pw=response.getWriter();
	    pw.print(array.toString());		
	}

}
