package com.example.WEB.BanquetPackage;

import com.example.WEB.ProposalPackage.Proposal;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.w3c.dom.Text;

import java.util.Set;

@Entity
@Table(name = "products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(unique = true)
    private String name;
    @Column(name = "category")
    private  String category;
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
    private Integer cost;
    @OneToMany(mappedBy = "productId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Proposal> proposalId;

    public Products() {
    }

    public Products(Integer id, String name, String description, String category, Integer cost) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Set<Proposal> getProposalId() {
        return proposalId;
    }

    public void setProposalId(Set<Proposal> proposalId) {
        this.proposalId = proposalId;
    }

    public void setCategory(String category) {this.category = category;}

    public String getCategory() {return category;}
}
