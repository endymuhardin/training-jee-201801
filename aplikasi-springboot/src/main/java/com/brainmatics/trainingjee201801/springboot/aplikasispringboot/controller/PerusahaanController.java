package com.brainmatics.trainingjee201801.springboot.aplikasispringboot.controller;

import com.brainmatics.trainingjee201801.springboot.aplikasispringboot.dao.PerusahaanDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PerusahaanController {
    
    @Autowired private PerusahaanDao perusahaanDao;
    
    @GetMapping("/perusahaan/list")
    public ModelMap daftarPerusahaan(Pageable page){
        return new ModelMap().addAttribute("dataPerusahaan", perusahaanDao.findAll(page));
    }
    
    @GetMapping("/perusahaan/form")
    public void tampilkanFormEdit(){
        
    }
    
    @PostMapping("/perusahaan/form")
    public String prosesFormEdit(){
        return "redirect:list";
    }
}
