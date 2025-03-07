package com.example.simpleproject.user.service;

import com.example.simpleproject.user.dto.NguoiDungDto;
import com.example.simpleproject.user.model.NguoiDungModel;
import com.example.simpleproject.user.repository.NguoiDungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class NguoiDungService {

    @Autowired
    private NguoiDungRepository nguoiDungRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    private String taiKhoan;

    public NguoiDungModel taoTaiKhoan(NguoiDungDto nguoiDungDto){
        taiKhoan = nguoiDungDto.getTaiKhoan();

        if (!kiemTraTaiKhoan(taiKhoan)){
            throw new RuntimeException("Tài khoản không được chứa ký tự đặt biệt !");
        }
        ;
        if (nguoiDungRepository.findByTaiKhoanAndEmail(taiKhoan,nguoiDungDto.getEmail()) != null){
            throw new RuntimeException("Tài khoản đã tồn tại");
        }

        NguoiDungModel nguoiDungModel = new NguoiDungModel();
        nguoiDungModel.setHoTen(nguoiDungDto.getHoTen());
        nguoiDungModel.setTaiKhoan(nguoiDungDto.getTaiKhoan());
        nguoiDungModel.setEmail(nguoiDungDto.getEmail());
        nguoiDungModel.setMatKhau(passwordEncoder.encode(nguoiDungDto.getMatKhau()));

        return nguoiDungRepository.save(nguoiDungModel);
    }

//    Kiểm tra xem tài khoản nhập vào có chứa các ký tự đặt biệt hay không
    public  boolean kiemTraTaiKhoan(String taiKhoan){
        String bieuThucKiemTra =  "^[a-zA-Z0-9_]*$";
        Pattern pattern = Pattern.compile(bieuThucKiemTra);
        Matcher matcher = pattern.matcher(taiKhoan);
        return matcher.matches();
    }


}
