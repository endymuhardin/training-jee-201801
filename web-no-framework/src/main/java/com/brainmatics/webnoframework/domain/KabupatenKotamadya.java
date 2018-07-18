package com.brainmatics.webnoframework.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class KabupatenKotamadya {
    private String id;
    private String kode;
    private String nama;
    // private String idProvinsi; // don't do this
    private Provinsi provinsi;
}
