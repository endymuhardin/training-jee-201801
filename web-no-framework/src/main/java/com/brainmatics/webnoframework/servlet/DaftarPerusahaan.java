package com.brainmatics.webnoframework.servlet;

import com.brainmatics.webnoframework.dao.PerusahaanDao;
import com.brainmatics.webnoframework.domain.Perusahaan;
import com.brainmatics.webnoframework.helpers.KonfigurasiAplikasi;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/perusahaan/list")
public class DaftarPerusahaan extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection(
                    KonfigurasiAplikasi.JDBC_URL,
                    KonfigurasiAplikasi.JDBC_USERNAME,
                    KonfigurasiAplikasi.JDBC_PASSWORD);
            
            PerusahaanDao pd = new PerusahaanDao(conn);
            
            PrintWriter output = resp.getWriter();
            
            output.println("<html><head><title>Daftar Perusahaan</title></head><body>");
            output.println("<h1>Daftar Perusahaan</h1>");
            
            output.println("<table><thead><tr><th>Kode</th><th>Nama</th></tr></thead>");
            output.println("<tbody>");
            
            List<Perusahaan> dataPerusahaan = pd.cariPerusahaan();
            for(Perusahaan x : dataPerusahaan) {
                output.println("<tr><td>"+x.getKode()+"</td><td>"+x.getNama()+"</td></tr>");
            }
            
            output.println("</tbody></table>");
            output.println("</body></html>");
            
            output.close();
            
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(DaftarPerusahaan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
