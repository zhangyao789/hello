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
  //����ServletConfig����,Ϊ�˵�ǰrequest����ʧЧ
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
		//����ҳ�淵������
		response.setContentType("text/html");
		//new
		SmartUpload sm=new SmartUpload();
		//���õ�ǰ�����ļ����󣬳�ʼ��SmartUpload
		sm.initialize(sConfig, request, response);
		//����file size
		sm.setTotalMaxFileSize(4096*2048);      
		try {
			  //ִ���ύform���� SmartUploadģʽ�ϴ�.���ϴ������ơ�text����ʱ����sm������
			sm.upload();
			//���ı������ȡ
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
		    //��ȡ�ϴ��������ļ���·��,ֱ�Ӹ�ֵһ��Tomcat�����ľ���·��Ҳ��
			String uploadFile=request.getRealPath("images/uploadFiles");
	        System.out.println(uploadFile+" file");
	        File upFile=new File(uploadFile);
	        if(!upFile.exists()) {
	        	//������ļ����Ҳ����������ļ���
	        	upFile.mkdir();
	        }
	        //���ն��ļ��ϴ���ģʽ�����߼�
	        String fileName=null;
	        boolean f=false;
	        System.out.println("file size:"+sm.getFiles().getCount());
	        for (int i = 0; i <sm.getFiles().getCount(); i++) {
				//ͨ��sm��ȡ�������ļ�
	        	com.jspsmart.upload.File file=sm.getFiles().getFile(i);
	        	System.out.println(file.getFilePathName()+
	        			" - "+file.getFileName()+" - "+file.getFileExt());
	        	fileName=file.getFileName();
	        	if(!fileName.equals("")) {
	        		//��ȡ��չ��
	        		int iu=fileName.lastIndexOf(".");
	        		//��ȡ��.���������չ��
	        		String fname=fileName.substring(iu, fileName.length());
	        		if(fname.equals(".png")||fname.equals(".jpg")||fname.equals(".gif")) {
	        			//ִ���ϴ�
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
