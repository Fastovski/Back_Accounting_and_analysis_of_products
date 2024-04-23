package com.example.WEB.ContactPackage;

import com.example.WEB.ContactPackage.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContractRepository extends JpaRepository<Contract,Integer> {
    public List<Contract> findAllByProposalId_ClientId_UserId_IdAndBoughtEqualsAndProposalId_ApproveEquals(Integer id, Boolean bool, Boolean bol);
    public List<Contract> findAllByBoughtEqualsAndProposalId_ApproveEquals(Boolean bool, Boolean bol);
    @Modifying(clearAutomatically = true)
    @Query("UPDATE Contract o set o.bought=true where o.id = ?1")
    public void update(Integer id);
}
