create table perusahaan (
  id VARCHAR(36),
  kode VARCHAR(100) NOT NULL,
  nama VARCHAR(255) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE (kode)
) Engine = InnoDB ;

create table provinsi (
    id VARCHAR(36),
    kode VARCHAR(100) NOT NULL,
    nama VARCHAR(255) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE (kode)
) Engine = InnoDB ;

create table kabupaten_kota (
    id VARCHAR(36),
    kode VARCHAR(100) NOT NULL,
    nama VARCHAR(255) NOT NULL,
    id_provinsi varchar(36) not null,
    PRIMARY KEY (id),
    foreign key (id_provinsi) references provinsi(id),
    UNIQUE (kode)
) Engine = InnoDB ;

create table t_user (
    id varchar(36), 
    nama varchar(255) not null,
    email varchar(255) not null,
    no_hp varchar(255) not null,
    alamat varchar(255) not null,
    id_kabupaten_kota varchar(36) not null,
    primary key (id),
    foreign key (id_kabupaten_kota) references kabupaten_kota(id)
);

create table user_perusahaan (
    id_user VARCHAR(36),
    id_perusahaan varchar(36) not null,
    PRIMARY KEY (id_user, id_perusahaan),
    foreign key (id_user) references t_user(id),
    foreign key (id_perusahaan) references perusahaan(id)
) Engine = InnoDB ;
