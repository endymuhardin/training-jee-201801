package com.brainmatics.webnoframework.dao;

import com.brainmatics.webnoframework.domain.Perusahaan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.UUID;

public class PerusahaanDao {
    
    private static final String SQL_INSERT = "insert into perusahaan (id, kode, nama) values (?,?,?)";
    private Connection connection;
    
    public PerusahaanDao(Connection conn){
        this.connection = conn;
    }
    
    public void simpan(Perusahaan p){
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_INSERT);
            ps.setString(1, UUID.randomUUID().toString());
            ps.setString(2, p.getKode());
            ps.setString(3, p.getNama());
            ps.executeUpdate();
        } catch (Exception err){
            err.printStackTrace();
        }
    }
}
