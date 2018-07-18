create table perusahaan (
  id VARCHAR(36),
  kode VARCHAR(100) NOT NULL,
  nama VARCHAR(255) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE (kode)
) Engine = InnoDB ;
