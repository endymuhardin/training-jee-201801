package com.brainmatics.webnoframework.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/perusahaan/list")
public class DaftarPerusahaan extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter output = resp.getWriter();
        
        output.println("<html><head><title>Daftar Perusahaan</title></head><body>");
        output.println("<h1>Daftar Perusahaan</h1>");
        output.println("</body></html>");
        
        output.close();
    }
    
}
