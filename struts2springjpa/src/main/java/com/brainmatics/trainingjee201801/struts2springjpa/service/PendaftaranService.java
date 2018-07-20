package com.brainmatics.trainingjee201801.struts2springjpa.service;

import com.brainmatics.trainingjee201801.struts2springjpa.dao.PerusahaanDao;
import com.brainmatics.trainingjee201801.struts2springjpa.entity.Perusahaan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service @Transactional
public class PendaftaranService {
    @Autowired private PerusahaanDao perusahaanDao;
    
    public void simpan(Perusahaan p){
        perusahaanDao.save(p);
    }
}
