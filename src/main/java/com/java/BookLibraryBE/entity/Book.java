package com.java.BookLibraryBE.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class Book {
    public int maSach;
    public String tenSach;
    public String tacGia;
    public int namXuatBan;
    public int maNgonNgu;
    public int maTheLoai;
    public int maTrangThai;
    public String gioiThieu;
    public LocalDateTime ngayGioCapNhat;
    public int delete_flag;

    public Book() {
    }

    public Book(int maSach, String tenSach, String tacGia, int namXuatBan, int maNgonNgu, int maTheLoai, int maTrangThai, String gioiThieu, LocalDateTime ngayGioCapNhat, int delete_flag) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.namXuatBan = namXuatBan;
        this.maNgonNgu = maNgonNgu;
        this.maTheLoai = maTheLoai;
        this.maTrangThai = maTrangThai;
        this.gioiThieu = gioiThieu;
        this.ngayGioCapNhat = ngayGioCapNhat;
        this.delete_flag = delete_flag;
    }
}
