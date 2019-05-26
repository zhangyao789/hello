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

import com.zy.entity.Detps;
import com.zy.model.DeptMode;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class ChartsServlet
 */
@WebServlet("/ChartsServlet")
public class ChartsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChartsServlet() {
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
		
		List<List<Object>> list=new ArrayList<>();
		DeptMode dm=new DeptMode();
    	List<Detps> ld=dm.GetDeptNumbers();
    	List<Object> lst=null;
    	 
    	for (Detps detps : ld) {
    		lst=new ArrayList<>();
			System.out.println(detps.getDname()+"  -  "+detps.getNums());
		    lst.add(detps.getDname());
		    lst.add(detps.getNums());
			list.add(lst);
    	}
		

	    
	   
	    Map<String, Object> map=new HashMap<>();

	    map.put("title", "部门员工所占比例");
	    map.put("li", list);
	    JSONObject obj=JSONObject.fromObject(map);
	    
        //通过response创建字符流，响应ajax通道
		PrintWriter pw=response.getWriter();
		pw.print(obj.toString());
		
		
		
	}

}
