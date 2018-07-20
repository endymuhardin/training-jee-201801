package com.brainmatics.trainingjee201801.struts2springjpa.action.perusahaan;

import com.brainmatics.trainingjee201801.struts2springjpa.entity.Perusahaan;
import com.brainmatics.trainingjee201801.struts2springjpa.service.PendaftaranService;
import com.opensymphony.xwork2.ActionSupport;
import lombok.Data;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class Edit extends ActionSupport {

    @Autowired private PendaftaranService pendaftaranService;
    
    private String id;
    private Perusahaan perusahaan = new Perusahaan();
    private String kode;
    private String nama;

    public String execute() {
        if (id == null) {
            perusahaan = new Perusahaan();
        }
        return SUCCESS;
    }

    @Action(value = "/save",
            results = {
                @Result(name = "success", location = "list", type = "redirect")}
    )
    public String simpan() {
        perusahaan.setKode(kode);
        perusahaan.setNama(nama);
        pendaftaranService.simpan(perusahaan);
        perusahaan = new Perusahaan();
        this.id = perusahaan.getId();
        return SUCCESS;
    }

}
