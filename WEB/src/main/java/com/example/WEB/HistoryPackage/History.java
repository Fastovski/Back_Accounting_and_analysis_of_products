package com.example.WEB.HistoryPackage;

import com.example.WEB.ClienPackage.Client;
import com.example.WEB.ProposalPackage.Proposal;
import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "history")
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    private Date sending;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "clientId", nullable = false)
    private Client clientId;
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "proposalId", nullable = false)
    private Proposal proposalId;

    public History() {
    }

    public History(Integer id, Date sending, Client clientId) {
        this.id = id;
        this.sending = sending;
        this.clientId = clientId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getSending() {
        return sending;
    }

    public void setSending(Date sending) {
        this.sending = sending;
    }

    public Client getClientId() {
        return clientId;
    }

    public void setClientId(Client clientId) {
        this.clientId = clientId;
    }

    public Proposal getProposalId() {
        return proposalId;
    }

    public void setProposalId(Proposal proposalId) {
        this.proposalId = proposalId;
    }
}
