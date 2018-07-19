package com.brainmatics.trainingjee201801.sb;

import com.brainmatics.trainingjee201801.entity.Perusahaan;
import com.brainmatics.trainingjee201801.entity.Provinsi;
import com.brainmatics.trainingjee201801.entity.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class PendaftaranSessionBean {
    private static final String JPQL_CARI_PERUSAHAAN_BY_NAMA = "select p from Perusahaan p where p.nama = ?1";
    private static final String JPQL_CARI_PERUSAHAAN_BY_KODE = "select p from Perusahaan p where p.kode = :kode";
    private static final String JPQL_SEMUA_USER = "select u from User order by u.nama";
    private static final String JPQL_SEMUA_PROVINSI = "select u from Provinsi order by u.nama";
    private static final String JPQL_SEMUA_PERUSAHAAN = "select u from Perusahaan order by u.nama";

    @PersistenceContext private EntityManager entityManager;
    
    public List<Provinsi> semuaProvinsi(){
        return entityManager.createQuery(JPQL_SEMUA_PROVINSI)
                .getResultList();
    }
    
    public List<Perusahaan> semuaPerusahaan(){
        return entityManager.createQuery(JPQL_SEMUA_PERUSAHAAN)
                .getResultList();
    }
    
    public List<Perusahaan> cariPerusahaan(String nama, Integer jumlahData, Integer halaman){
        return entityManager.createQuery(JPQL_CARI_PERUSAHAAN_BY_NAMA)
                .setParameter(1, nama)
                .setMaxResults(jumlahData)
                .setFirstResult(halaman * jumlahData)
                .getResultList();
    }
    
    public Perusahaan simpan(Perusahaan p){
        entityManager.persist(p);
        return p;
    }
    
    public Perusahaan cariPerusahaanById(String id){
        return entityManager.find(Perusahaan.class, id);
    }
    
    public Perusahaan cariPerusahaanByKode(String kode){
        return (Perusahaan) entityManager.createQuery(JPQL_CARI_PERUSAHAAN_BY_KODE)
                .setParameter("kode", kode)
                .getSingleResult();
    }
    
    public List<User> semuaUser(Integer jumlahData, Integer halaman){
        return entityManager.createQuery(JPQL_SEMUA_USER)
                .setMaxResults(jumlahData)
                .setFirstResult(halaman * jumlahData)
                .getResultList();
    }

}
