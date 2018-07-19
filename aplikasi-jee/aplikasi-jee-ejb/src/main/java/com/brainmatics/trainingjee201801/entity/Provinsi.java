package com.brainmatics.trainingjee201801.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.eclipse.persistence.annotations.UuidGenerator;

@Entity @Table(name = "provinsi")
@UuidGenerator(name="PROVINSI_ID_GEN")
@Getter @Setter @EqualsAndHashCode(of = {"id"}) @ToString
public class Provinsi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "PROVINSI_ID_GEN")
    private String id;
    
    @NotNull
    private String kode;
    
    @NotNull
    private String nama;

    @OneToMany(mappedBy = "provinsi", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<KabupatenKota> daftarKabupatenKota = new HashSet<>();
    
}
