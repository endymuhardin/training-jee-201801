<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Daftar Perusahaan</title>
    </head>
    <body>
        <h1>Daftar Perusahaan</h1>
        
        <a href="edit">Tambah Data</a>
        
        <table border="1" cellpadding="4">
            <thead>
                <tr>
                    <th>Kode</th>
                    <th>Nama</th>
                    <th>&nbsp;</th>
                </tr>
            </thead>
            <tbody>
                <s:iterator value="dataPerusahaan.content">
                <tr>
                    <td>${kode}</td>
                    <td>${nama}</td>
                    <td>
                        <a href="edit?id=${id}">edit</a>
                    </td>
                </tr>
                </s:iterator>
            </tbody>
        </table>
        Jumlah data : ${dataPerusahaan.totalElements}
        Jumlah halaman : ${dataPerusahaan.totalPages}
    </body>
</html>
