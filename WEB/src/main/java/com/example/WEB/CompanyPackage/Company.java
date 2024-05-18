package com.example.WEB.CompanyPackage;

import jakarta.persistence.*;

@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "mail")
    private String mail;

    @Column(name = "aboutUs", columnDefinition = "TEXT")
    private String aboutUs;

    @Column(name = "certificate", columnDefinition = "LONGTEXT")
    private String certificate;

    public Company() {
    }

    public Company(Integer id, String phoneNumber, String mail, String aboutUs, String certificate) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.mail = mail;
        this.aboutUs = aboutUs;
        this.certificate = certificate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAboutUs() {
        return aboutUs;
    }

    public void setAboutUs(String aboutUs) {
        this.aboutUs = aboutUs;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }
}