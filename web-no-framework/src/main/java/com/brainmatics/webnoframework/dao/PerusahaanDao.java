package com.brainmatics.webnoframework.dao;

import com.brainmatics.webnoframework.domain.Perusahaan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PerusahaanDao {
    
    private static final String SQL_SEMUA = "select * from perusahaan order by kode";
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

    public List<Perusahaan> cariPerusahaan() {
        List<Perusahaan> hasil = new ArrayList<Perusahaan>();
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_SEMUA);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Perusahaan p = new Perusahaan();
                p.setId(rs.getString("id"));
                p.setKode(rs.getString("kode"));
                p.setNama(rs.getString("nama"));
                hasil.add(p);
            }
            
        } catch (Exception err){
            err.printStackTrace();
        }
        return hasil;
    }
}
