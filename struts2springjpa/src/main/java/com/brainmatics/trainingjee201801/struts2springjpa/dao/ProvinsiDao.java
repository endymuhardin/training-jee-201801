package com.brainmatics.trainingjee201801.struts2springjpa.dao;

import java.util.Date;
import org.springframework.stereotype.Component;

@Component
public class ProvinsiDao {
    public String waktu(){
        return "Waktu saat ini : "+new Date().toString();
    }
}
