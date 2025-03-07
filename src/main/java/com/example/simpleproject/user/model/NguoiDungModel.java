package com.example.simpleproject.user.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class NguoiDungModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "hoTen")
    private String hoTen;

    @Column(name = "taiKhoan")
    private String taiKhoan;

    @Column(name = "matKhau")
    private String matKhau;

    @Column(name = "email")
    private  String email;



}
