package com.example.WEB.CompanyPackage;

import com.example.WEB.CompanyPackage.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CompanyRepository extends JpaRepository<Company,Integer> {
    @Modifying(clearAutomatically = true)
    @Query("UPDATE Company c set c.phoneNumber = ?1, c.mail = ?2, c.aboutUs = ?3, c.certificate = ?4 where c.id = ?5")
    public void update(String phoneNumber, String mail, String aboutUs, String certificate, Integer id);
}
