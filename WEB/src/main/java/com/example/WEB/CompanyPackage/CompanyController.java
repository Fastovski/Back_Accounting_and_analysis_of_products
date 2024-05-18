package com.example.WEB.CompanyPackage;

import com.example.WEB.ProposalPackage.ProposalRepository;
import com.example.WEB.CompanyPackage.Company;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000/")
public class CompanyController {
    private final CompanyRepository companyRepository;

    public CompanyController(CompanyRepository companyRepository, ProposalRepository proposalRepository) {
        this.companyRepository = companyRepository;
    }

    @GetMapping("/company/all")
    public List<Company> getAll() {
        return companyRepository.findAll();
    }

    @GetMapping("/company/all/text")
    public String getAllAsText() {
        List<Company> companies = companyRepository.findAll();
        StringBuilder sb = new StringBuilder();
        for (Company company : companies) {
            sb.append("ID: ").append(company.getId()).append("\n");
            sb.append("Phone Number: ").append(company.getPhoneNumber()).append("\n");
            sb.append("Mail: ").append(company.getMail()).append("\n");
            sb.append("About Us: ").append(company.getAboutUs()).append("\n");
            sb.append("Certificate: ").append(company.getCertificate()).append("\n");
            sb.append("--------------------\n");
        }
        return sb.toString();
    }

    @Transactional
    @PutMapping("/company/update/{id}")
    public void updateCompany(@PathVariable("id") Integer id, @RequestBody Company company){
        companyRepository.update(company.getPhoneNumber(), company.getMail(), company.getAboutUs(), company.getCertificate(), id);
    }
}



