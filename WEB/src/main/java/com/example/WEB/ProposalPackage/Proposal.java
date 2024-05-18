package com.example.WEB.ProposalPackage;

import com.example.WEB.BanquetPackage.Products;
import com.example.WEB.ClienPackage.Client;
import com.example.WEB.ContactPackage.Contract;
import com.example.WEB.HistoryPackage.History;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "proposal")
public class Proposal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    private Date deliveryTime;
    private Integer totalCost;
    private Boolean approve;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "clientId", nullable = false)
    private Client clientId;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "productId", nullable = false)
    private Products productId;
    @OneToOne(mappedBy = "proposalId", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JsonIgnore
    private History historyId;
    @OneToOne(mappedBy = "proposalId", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JsonIgnore
    private Contract contractId;

    public Proposal() {
    }

    public Proposal(Integer id, Date deliveryTime, Integer totalCost, Boolean approve, Client clientId, Products productId) {
        this.id = id;
        this.deliveryTime = deliveryTime;
        this.totalCost = totalCost;
        this.approve = approve;
        this.clientId = clientId;
        this.productId = productId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Integer getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Integer totalCost) {
        this.totalCost = totalCost;
    }

    public Client getClientId() {
        return clientId;
    }

    public void setClientId(Client clientId) {
        this.clientId = clientId;
    }

    public History getHistoryId() {
        return historyId;
    }

    public void setHistoryId(History historyId) {
        this.historyId = historyId;
    }

    public Boolean getApprove() {
        return approve;
    }

    public void setApprove(Boolean approve) {
        this.approve = approve;
    }

    public Products getProductId() {
        return productId;
    }

    public void setProductId(Products productId) {
        this.productId = productId;
    }

    public Contract getContractId() {
        return contractId;
    }

    public void setContractId(Contract contractId) {
        this.contractId = contractId;
    }
}