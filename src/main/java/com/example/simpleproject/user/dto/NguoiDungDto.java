package com.example.simpleproject.user.dto;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class NguoiDungDto {
    private String hoTen;

    private String taiKhoan;

    @Column(name = "matKhau")
    private String matKhau;

    @Column(name = "email")
    private String email;

}
