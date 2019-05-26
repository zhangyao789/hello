package com.zy.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.zy.entity.User;
import com.zy.model.DeptMode;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet2")
public class UpdateServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
  //创建ServletConfig对象,为了当前request对象失效
  	private ServletConfig sConfig=null;
  	@Override
  	public void init(ServletConfig config) throws ServletException {
  		// TODO Auto-generated method stub
  		sConfig=config;
  	}
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
		//设置页面返回类型
		response.setContentType("text/html");
		//new
		SmartUpload sm=new SmartUpload();
		//利用当前配置文件对象，初始化SmartUpload
		sm.initialize(sConfig, request, response);
		//设置file size
		sm.setTotalMaxFileSize(4096*2048);      
		try {
			  //执行提交form集体 SmartUpload模式上传.把上传二进制、text都临时放入sm对象中
			sm.upload();
			//把文本对象获取
			User user=new User();
			int uid=Integer.valueOf(sm.getRequest().getParameter("id"));
			user.setUid(uid);
			System.out.println(uid);
			String uname=sm.getRequest().getParameter("name");
			String uage=sm.getRequest().getParameter("age");
			String upwd=sm.getRequest().getParameter("pwd");
			String u_did=sm.getRequest().getParameter("did");
			String utext=sm.getRequest().getParameter("text");
			user.setD_id(Integer.valueOf(u_did));
			user.setUage(Integer.valueOf(uage));
			user.setUname(uname);
			user.setUpwd(upwd);
			user.setUtest(utext);
			System.out.println(uid+","+uname+","+upwd+","+uage+",did:"+u_did+","+utext);
		    //获取上传二进制文件的路径,直接赋值一个Tomcat发布的绝对路径也行
			String uploadFile=request.getRealPath("images/uploadFiles");
	        System.out.println(uploadFile+" file");
	        File upFile=new File(uploadFile);
	        if(!upFile.exists()) {
	        	//如果该文件夹找不到，创建文件夹
	        	upFile.mkdir();
	        }
	        //按照多文件上传的模式程序逻辑
	        String fileName=null;
	        boolean f=false;
	        System.out.println("file size:"+sm.getFiles().getCount());
	        for (int i = 0; i <sm.getFiles().getCount(); i++) {
				//通过sm获取二进制文件
	        	com.jspsmart.upload.File file=sm.getFiles().getFile(i);
	        	System.out.println(file.getFilePathName()+
	        			" - "+file.getFileName()+" - "+file.getFileExt());
	        	fileName=file.getFileName();
	        	if(!fileName.equals("")) {
	        		//获取扩展名
	        		int iu=fileName.lastIndexOf(".");
	        		//获取“.”后面的扩展名
	        		String fname=fileName.substring(iu, fileName.length());
	        		if(fname.equals(".png")||fname.equals(".jpg")||fname.equals(".gif")) {
	        			//执行上传
	        			file.saveAs("images/uploadFiles/"+fileName,sm.SAVE_VIRTUAL);
	        			f=true;
	        			user.setUimg(fileName);
	        		}
	        	}
			}
	        if(f) {
	    		DeptMode dm = new DeptMode();
	    		dm.UpdateTeach(user);
	        	PrintWriter pw=response.getWriter();
	     	    pw.print("ok");		
	        }
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
