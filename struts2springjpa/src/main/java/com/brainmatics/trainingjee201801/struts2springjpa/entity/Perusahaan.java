package com.brainmatics.trainingjee201801.struts2springjpa.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Entity @Data
public class Perusahaan {
    @Id
    private String id;
    
    
    private String kode;
    
    private String nama;
}
