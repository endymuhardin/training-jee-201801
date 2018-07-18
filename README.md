# Training Java EE 7 #

## Materi Training ##

* Membuat aplikasi dengan Java EE (Servlet, JSF)
* Membuat aplikasi dengan Struts 2
* Membuat aplikasi dengan Spring MVC

## Software yang dibutuhkan ##

* Java SDK
* Dependency Management

    * Apache Maven
    * Gradle

* Editor

    * Netbeans
    * Eclipse
    * Intellij IDEA
    * Visual Studio Code

* Database Server

    * MySQL
    * PostgreSQL

## Arsitektur Aplikasi ##

![Arsitektur Aplikasi Web](img/arsitektur-web.jpg)

## Contoh Aplikasi ##

![Studi Kasus](img/contoh-aplikasi.jpg)


## Setup Database ##

1. Login ke database sebagai user `root`

        mysql -u root

2. Buat user untuk aplikasi

        CREATE USER 'trainingjee201801'@'localhost' IDENTIFIED BY 'test123';

3. Berikan ijin akses untuk database

        grant all on trainingjee201801.* to trainingjee201801@localhost;

4. Buat database

        create database trainingjee201801

5. Masuk ke database

        use trainingjee201801;

6. Buat tabel yang dibutuhkan

    ```sql
    create table perusahaan (
      id VARCHAR(36),
      kode VARCHAR(100) NOT NULL,
      nama VARCHAR(255) NOT NULL,
      PRIMARY KEY (id),
      UNIQUE (kode)
    ) Engine = InnoDB ;
    ```


