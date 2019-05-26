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

import net.sf.json.JSONArray;

/**
 * Servlet implementation class DeptServlet2
 */
@WebServlet("/DeptServlet2")
public class DeptServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeptServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//��һ�η���ҳ���ʱ��bootstrap�����ṩ�����ģ��������������ύ�������Ǳر��ģ�������������Ҳ�ύ���п���û�е�
		//�����жϣ����û�ύ����ô�ṩһ��Ĭ��ֵ
		DeptMode dm=new DeptMode();
		//��ǰ��ʾҳ��List���ϣ�����tableȫ������list
		List<Detps> l=dm.GetDeptList();
		List<Map<String,Object>> list=new ArrayList<>();
		Map<String,Object> map=null;
		for (Detps us : l) {
			map=new HashMap<>();
//			diid+"'>"+data[i].ddname
			map.put("diid", us.getDid());
			map.put("ddname", us.getDname());
			list.add(map);
		}
		//System.out.println(list.size()+" ////");
   	    JSONArray array=JSONArray.fromObject(list);
   	    PrintWriter pw=response.getWriter();
	    pw.print(array.toString());		
	}

	
}
