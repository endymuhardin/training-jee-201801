package com.brainmatics.trainingjee201801.struts2springjpa.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

@Entity @Table(name = "t_user", indexes = @Index(columnList = "email"))
@Getter @Setter @EqualsAndHashCode(of = {"id"}) @ToString
public class User {
    @Id
    @GeneratedValue(generator = "uuid" )
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    @NotNull
    private String nama;
    
    @NotNull
    private String email;
    
    @NotNull
    @Column(name = "no_hp")
    private String noHp;
    
    @NotNull
    private String alamat;
    
    @NotNull
    @ManyToOne @JoinColumn(name = "id_kabupaten_kota")
    private KabupatenKota kabupatenKota;
    
    @ManyToMany
    @JoinTable(
            name = "user_perusahaan",
            joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_perusahaan")
    )
    private Set<Perusahaan> daftarPerusahaan = new HashSet<>();
}
