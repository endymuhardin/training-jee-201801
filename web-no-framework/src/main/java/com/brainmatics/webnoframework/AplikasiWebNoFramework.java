package com.brainmatics.webnoframework;

import com.brainmatics.webnoframework.dao.PerusahaanDao;
import com.brainmatics.webnoframework.domain.Perusahaan;
import java.sql.Connection;
import java.sql.DriverManager;

public class AplikasiWebNoFramework {
    public static void main(String[] args) throws Exception {
        Perusahaan p = new Perusahaan();
        p.setKode("P-001");
        p.setNama("Perusahaan 001");
        
        String url = "jdbc:mysql://localhost/trainingjee201801?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String username = "trainingjee201801";
        String password = "test123";
        
        Connection conn = DriverManager.getConnection(url, username, password);
        
        PerusahaanDao pd = new PerusahaanDao(conn);
        pd.simpan(p);
        
        conn.close();
    }
}
