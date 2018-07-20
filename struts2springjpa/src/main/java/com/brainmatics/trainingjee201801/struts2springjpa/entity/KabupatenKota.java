package com.brainmatics.trainingjee201801.struts2springjpa.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;


@Entity @Table(name = "kabupaten_kota")
@Getter @Setter @EqualsAndHashCode(of = {"id"}) @ToString
public class KabupatenKota implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "uuid" )
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @NotNull @Size(min = 3)
    private String kode;
    
    @NotNull @Size(min = 3)
    private String nama;
    
    @ManyToOne
    @JoinColumn(name = "id_provinsi")
    private Provinsi provinsi;
    
}
