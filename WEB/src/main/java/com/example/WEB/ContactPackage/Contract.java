package com.example.WEB.ContactPackage;

import com.example.WEB.ProposalPackage.Proposal;
import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "contract")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    private Date conclusion;
    private Boolean bought;
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "proposalId", nullable = false)
    private Proposal proposalId;

    public Contract() {
    }

    public Contract(Integer id, Date conclusion, Boolean bought) {
        this.id = id;
        this.conclusion = conclusion;
        this.bought = bought;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getConclusion() {
        return conclusion;
    }

    public void setConclusion(Date conclusion) {
        this.conclusion = conclusion;
    }

    public Proposal getProposalId() {
        return proposalId;
    }

    public void setProposalId(Proposal proposalId) {
        this.proposalId = proposalId;
    }

    public Boolean getBought() {
        return bought;
    }

    public void setBought(Boolean bought) {
        this.bought = bought;
    }
}
