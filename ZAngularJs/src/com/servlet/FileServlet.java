package com.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FileServlet
 */
@WebServlet("/FileServlet")
public class FileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 		OutputStream out = response.getOutputStream();
		 		
		 		String title = request.getParameter("title");
		 		System.out.println("参数是："+title);
		 		String requestHeader = request.getHeader("user-agent");
		 		boolean flag = true;
				if(flag){
					response.setContentType("application/pdf");
					
					if(isMobileDevice(requestHeader)){
						 //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型  
				        response.setContentType("multipart/form-data");  
				        //2.设置文件头：最后一个参数是设置下载文件名(假如我们叫a.pdf)  
				        response.setHeader("Content-Disposition", "attachment;fileName="+System.currentTimeMillis()+"_jishenbaogao.pdf");  
				        response.setCharacterEncoding("UTF-8");
					}
					 FileInputStream in = new FileInputStream(new File("G:/Work2016/1011/111111.pdf"));
					  byte[] b = new byte[512];
				        while ((in.read(b)) != -1) {
				            out.write(b);
				        }
				        out.flush();
				        in.close();
				}else{
					String data = "文件不存在";
					System.out.println(data);
					response.setHeader("Content-type", "text/html;charset=UTF-8"); 
					//response.setCharacterEncoding("UTF-8");
					out.write(data.getBytes("UTF-8"));
					out.flush();
				}
				out.close();
	}

	public boolean  isMobileDevice(String requestHeader){
        /**
         * android : 所有android设备
         * mac os : iphone ipad
         * windows phone:Nokia等windows系统的手机
         */
        String[] deviceArray = new String[]{ "Android", "iPhone", "iPod","iPad", "Windows Phone"};
        if(requestHeader == null)
            return false;
        
        requestHeader = requestHeader.toLowerCase();
        for(int i=0;i<deviceArray.length;i++){
            if(requestHeader.indexOf(deviceArray[i].toLowerCase())>0){
                return true;
            }
        }
        return false;
}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
