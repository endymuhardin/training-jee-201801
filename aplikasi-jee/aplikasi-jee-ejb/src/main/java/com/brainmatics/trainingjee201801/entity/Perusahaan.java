package com.brainmatics.trainingjee201801.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Getter @Setter @EqualsAndHashCode(of = {"id"}) @ToString
public class Perusahaan {
    @Id
    @GeneratedValue(generator = "uui")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    @NotNull
    private String kode;
    
    @NotNull
    private String nama;
    
    @ManyToMany(mappedBy = "daftarPerusahaan")
    private Set<User> daftarAnggota = new HashSet<>();
}
