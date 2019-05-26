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
		//设置返回的二进制文件流，不是网页
		response.setContentType("application/x-msdownload");
		//ulogo是赋值下载图片的图片名称 包含扩展名
		String logo=request.getParameter("ulogo");	        
	    System.out.println("image:"+logo);	       
	    response.setHeader("Content-Disposition", "attachment;filename="+java.net.URLEncoder.encode(logo,"utf-8"));
	        //获取下载文件的真实路径，可以是Tomcat上传的文件夹路径
	    String filename="F:\\neweclipse\\pro\\WebContent\\image/"+logo;//+filename	          
	          //创建文件输入流
	    FileInputStream fis=new FileInputStream(filename);
	        //创建缓冲输入流
	    BufferedInputStream bis=new BufferedInputStream(fis);
	        //获取响应的输出流
	    OutputStream  os=response.getOutputStream();
	        //创建缓冲输出流
	    BufferedOutputStream bos=new BufferedOutputStream(os);	          
	        //把输入流的数据写入到输出流
	    byte[] b=new byte[1024];
	    int len=0;
	    while((len=bis.read(b))!=-1){
	          bos.write(b, 0, len);
	    }
	    bos.close();
	    bis.close();		
		
		
		
		
	}

}
