package com.example.simpleproject.user.repository;

import com.example.simpleproject.user.model.NguoiDungModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NguoiDungRepository extends JpaRepository<NguoiDungModel,Long> {
    NguoiDungModel findByTaiKhoanAndEmail(String taiKhoan,String email);
}
