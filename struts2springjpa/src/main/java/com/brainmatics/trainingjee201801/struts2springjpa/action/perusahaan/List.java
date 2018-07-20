package com.brainmatics.trainingjee201801.struts2springjpa.action.perusahaan;

import com.brainmatics.trainingjee201801.struts2springjpa.dao.PerusahaanDao;
import com.brainmatics.trainingjee201801.struts2springjpa.entity.Perusahaan;
import com.opensymphony.xwork2.ActionSupport;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@Data
public class List extends ActionSupport {
    @Autowired private PerusahaanDao perusahaanDao;
    
    private Page<Perusahaan> dataPerusahaan;
    
    public String execute(){
        dataPerusahaan = perusahaanDao.findAll(PageRequest.of(0,10));
        return SUCCESS;
    }
}
