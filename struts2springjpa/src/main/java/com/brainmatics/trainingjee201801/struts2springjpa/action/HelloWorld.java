package com.brainmatics.trainingjee201801.struts2springjpa.action;

import com.brainmatics.trainingjee201801.struts2springjpa.dao.PerusahaanDao;
import com.brainmatics.trainingjee201801.struts2springjpa.dao.ProvinsiDao;
import com.brainmatics.trainingjee201801.struts2springjpa.entity.Perusahaan;
import com.brainmatics.trainingjee201801.struts2springjpa.service.PendaftaranService;
import com.opensymphony.xwork2.ActionSupport;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@Data
public class HelloWorld extends ActionSupport {

    @Autowired private ProvinsiDao provinsiDao;
    @Autowired private PerusahaanDao perusahaanDao;
    @Autowired private PendaftaranService pendaftaranService;
    
    private String message;

    public String execute() {
        // insert data
        
        Perusahaan p = new Perusahaan();
        p.setId("12");
        p.setKode("AAA");
        p.setNama("Perusahaan AAA");
        pendaftaranService.simpan(p);
        
        Page<Perusahaan> hasil = perusahaanDao.findAll(PageRequest.of(10, 10));
        message = provinsiDao.waktu();
        return SUCCESS;
    }
}
