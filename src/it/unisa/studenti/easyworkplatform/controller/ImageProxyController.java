package it.unisa.studenti.easyworkplatform.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.studendi.easyworkplatform.proxy.ProxyImage;

/**
 * Servlet implementation class ImageProxy
 */
@WebServlet("/ImageProxyController")
public class ImageProxyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageProxyController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String name 	= request.getParameter("name");
		Path iconPath	= Paths.get(realPath(request)).resolve("../../icon/").resolve(name + ".png");
		File f 	= null;
		InputStream in = null;
		ProxyImage prox  = null;
		
		if(iconPath.toFile().exists()){
//			f = iconPath.toFile();
			prox = new ProxyImage(iconPath);
			
		}
		else{
			iconPath = Paths.get(realPath(request)).resolve("../../icon/").resolve("default.png");
			f = iconPath.toFile();
		}
		
		
		in = prox.display();
        byte[] buff = new byte[8000];
        int bytesRead = 0;
        ByteArrayOutputStream bao = new ByteArrayOutputStream();

        while((bytesRead = in.read(buff)) != -1) {
           bao.write(buff, 0, bytesRead);
        }

        byte[] data = bao.toByteArray();
        
        response.setContentType(getServletContext().getMimeType(iconPath.toString()));
        response.setContentLength(data.length);
        response.getOutputStream().write(data);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private String realPath(HttpServletRequest request){
	    String requestURI = request.getRequestURI();
	    String realPath = request.getSession().getServletContext().getRealPath(requestURI);
	    return realPath;
	}

}
