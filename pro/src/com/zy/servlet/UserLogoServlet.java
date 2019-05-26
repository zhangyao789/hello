package com.zy.servlet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserLogoServlet
 */
@WebServlet("/UserLogoServlet")
public class UserLogoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogoServlet() {
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
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		//���÷��صĶ������ļ�����������ҳ
		response.setContentType("application/x-msdownload");
		//ulogo�Ǹ�ֵ����ͼƬ��ͼƬ���� ������չ��
		String logo=request.getParameter("ulogo");	        
	    System.out.println("image:"+logo);	       
	    response.setHeader("Content-Disposition", "attachment;filename="+java.net.URLEncoder.encode(logo,"utf-8"));
	        //��ȡ�����ļ�����ʵ·����������Tomcat�ϴ����ļ���·��
	    String filename="F:\\neweclipse\\pro\\WebContent\\image/"+logo;//+filename	          
	          //�����ļ�������
	    FileInputStream fis=new FileInputStream(filename);
	        //��������������
	    BufferedInputStream bis=new BufferedInputStream(fis);
	        //��ȡ��Ӧ�������
	    OutputStream  os=response.getOutputStream();
	        //�������������
	    BufferedOutputStream bos=new BufferedOutputStream(os);	          
	        //��������������д�뵽�����
	    byte[] b=new byte[1024];
	    int len=0;
	    while((len=bis.read(b))!=-1){
	          bos.write(b, 0, len);
	    }
	    bos.close();
	    bis.close();		
		
		
		
		
	}

}
