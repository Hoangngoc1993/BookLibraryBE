package com.java.BookLibraryBE.entity;

public class BookRequest {
    public int maSach;
    public String tenSach;
    public String tacGia;
    public int namXuatBan;
    public int maNgonNgu;
    public int maTheLoai;
    public int maTrangThai;
    public String gioiThieu;

    public BookRequest() {
    }

    public BookRequest(int maSach, String tenSach, String tacGia, int namXuatBan, int maNgonNgu, int maTheLoai, int maTrangThai, String gioiThieu) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.namXuatBan = namXuatBan;
        this.maNgonNgu = maNgonNgu;
        this.maTheLoai = maTheLoai;
        this.maTrangThai = maTrangThai;
        this.gioiThieu = gioiThieu;
    }

    public int getMaSach() {
        return maSach;
    }

    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public int getNamXuatBan() {
        return namXuatBan;
    }

    public void setNamXuatBan(int namXuatBan) {
        this.namXuatBan = namXuatBan;
    }

    public int getMaNgonNgu() {
        return maNgonNgu;
    }

    public void setMaNgonNgu(int maNgonNgu) {
        this.maNgonNgu = maNgonNgu;
    }

    public int getMaTheLoai() {
        return maTheLoai;
    }

    public void setMaTheLoai(int maTheLoai) {
        this.maTheLoai = maTheLoai;
    }

    public int getMaTrangThai() {
        return maTrangThai;
    }

    public void setMaTrangThai(int maTrangThai) {
        this.maTrangThai = maTrangThai;
    }

    public String getGioiThieu() {
        return gioiThieu;
    }

    public void setGioiThieu(String gioiThieu) {
        this.gioiThieu = gioiThieu;
    }
}
