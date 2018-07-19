package com.brainmatics.trainingjee201801.entity;

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
import org.eclipse.persistence.annotations.UuidGenerator;

@Entity @Table(name = "kabupaten_kota")
@Getter @Setter @EqualsAndHashCode(of = {"id"}) @ToString
@UuidGenerator(name="KAB_ID_GEN")
public class KabupatenKota implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "KAB_ID_GEN")
    private String id;

    @NotNull @Size(min = 3)
    private String kode;
    
    @NotNull @Size(min = 3)
    private String nama;
    
    @ManyToOne
    @JoinColumn(name = "id_provinsi")
    private Provinsi provinsi;
    
}
