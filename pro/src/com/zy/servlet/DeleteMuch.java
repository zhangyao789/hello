package com.zy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zy.model.DeptMode;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class DeleteMuch
 */
@WebServlet("/DeleteMuch")
public class DeleteMuch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMuch() {
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
		String str = request.getParameter("uid");
		JSONArray array = JSONArray.fromObject(str);
		System.out.println("array.size()"+array.size());
		int[] ids = new int[array.size()];
		Iterator list = array.iterator();
		int i =0;
		while(list.hasNext()) {
			JSONObject json_test = (JSONObject)list.next();
			Iterator iterator = json_test.keys();
			while(iterator.hasNext()) {
				String key = (String) iterator.next();
				String value = json_test.getString(key);
				if(key.equals("id")) {
					System.out.println(key+"---"+value);
					ids[i] = Integer.valueOf(value);
					i++;
				}
			}
			
			
			
		}
		for (int is : ids) {
			System.out.println(is+"i");
		}
		PrintWriter pw = response.getWriter();
		DeptMode um = new DeptMode();
		if(um.MuchDeleteUser(ids) > 0) {
			pw.print("ok!");
		}else {
			pw.print("ojk");
		}
		
		
	}

}
