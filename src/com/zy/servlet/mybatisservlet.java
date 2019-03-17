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


import net.sf.json.JSON;
import net.sf.json.JSONArray;

/**
 * Servlet implementation class mybatisservlet
 */
//@WebServlet("/mybatisservlet")
public class mybatisservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mybatisservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		List<User> l = new DeptMode().SelectUserAll();
		List<Map<String, Object>> list = new ArrayList<>();
		Map<String,Object> map = null;
		for (User user : l) {
			map = new HashMap<>();
			map.put("id", user.getUid());
			map.put("name", user.getUname());
			map.put("utime", user.getUdate());
			map.put("age", user.getUage());
			map.put("dnam", user.getDepts().getDname());
			list.add(map);
			
		}
		JSONArray array = JSONArray.fromObject(list);
		PrintWriter pw = response.getWriter();
		pw.print(array.toString());
	}

}
