package com.example.WEB.ClientPackage;

import com.example.WEB.UserPackage.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "client")

public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  Integer id;
    private Integer cash;
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userId", nullable = false)
    private User userId;

//    @OneToMany(mappedBy = "clientId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JsonIgnore
//    private Set<Proposal> proposalId;
//    @OneToMany(mappedBy = "clientId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JsonIgnore
//    private Set<History> historyId;
    public Client() {
    }
    public Client(Integer id, Integer cash) {
        this.id = id;
        this.cash = cash;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUserId() {
        return userId;
    }
    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Integer getCash() {
        return cash;
    }

    public void setCash(Integer cash) {
        this.cash = cash;
    }

//    public Set<Proposal> getProposalId() {
//        return proposalId;
//    }

//    public void setProposalId(Set<Proposal> proposalId) {
//        this.proposalId = proposalId;
//    }
//}
}
