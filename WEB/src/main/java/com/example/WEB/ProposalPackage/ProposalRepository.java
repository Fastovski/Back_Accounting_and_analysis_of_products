package com.example.WEB.ProposalPackage;

import com.example.WEB.ProposalPackage.Proposal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ProposalRepository extends JpaRepository<Proposal,Integer> {

    @Modifying(clearAutomatically = true)
    @Query("UPDATE Proposal o set o.approve=true where o.id = ?1")
    public void update(Integer id);
}
