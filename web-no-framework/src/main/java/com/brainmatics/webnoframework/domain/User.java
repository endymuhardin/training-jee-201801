package com.brainmatics.webnoframework.domain;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class User {
    private String id;
    private String nama;
    private String email;
    private String noHp;
    private LocalDate tanggalLahir;
    private String alamat;
    private KabupatenKotamadya kabupatenKotamadya;
}
