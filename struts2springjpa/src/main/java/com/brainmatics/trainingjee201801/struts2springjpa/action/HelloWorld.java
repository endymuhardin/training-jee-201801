package com.brainmatics.trainingjee201801.struts2springjpa.action;

import com.brainmatics.trainingjee201801.struts2springjpa.dao.ProvinsiDao;
import com.opensymphony.xwork2.ActionSupport;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class HelloWorld extends ActionSupport {

    @Autowired private ProvinsiDao provinsiDao;
    
    private String message;

    public String execute() {
        message = provinsiDao.waktu();
        return SUCCESS;
    }
}
