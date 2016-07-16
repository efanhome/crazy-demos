package com.efanhome;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;

public class DoSignServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

    private static final String defaultURL = "http://xmpingan.s.baimao.com/operate_membercard/dosignin.htm?aid=10031&wechatid=oQYAHt4bNRfHQMhWZDGd8mhdcsFY";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");
        response.setStatus(200);
        PrintWriter out = response.getWriter();

        String uri = request.getParameter("url");
        if(uri == null || uri.trim().length() == 0){
            uri = defaultURL;
        }
        URL url = new URL(uri);

        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        StringBuffer json = new StringBuffer();
        String line;

        while ((line = reader.readLine()) != null) {
            json.append(line);
        }
        reader.close();

        out.print(json.toString());
        out.close();
    }
}
