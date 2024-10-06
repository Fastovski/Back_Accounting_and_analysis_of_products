package com.example.WEB.ContactPackage;

import com.example.WEB.ClienPackage.ClientRepository;
import com.example.WEB.ProposalPackage.Proposal;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class ContractController {
    private final ContractRepository contractRepository;
    private final ClientRepository clientRepository;

    public ContractController(ContractRepository contractRepository, ClientRepository clientRepository) {
        this.contractRepository = contractRepository;
        this.clientRepository = clientRepository;
    }
    @GetMapping("/contract/getBy/{id}")
    public List<Contract> getProposalById(@PathVariable("id") Integer id){
        return contractRepository.findAllByProposalId_ClientId_UserId_IdAndBoughtEqualsAndProposalId_ApproveEquals(id, false, true);
    }
    @GetMapping("/contract/get/{id}")
    public List<Contract> getContractsById(@PathVariable("id") Integer id){
        return contractRepository.findAllByProposalId_ClientId_UserId_IdAndBoughtEqualsAndProposalId_ApproveEquals(id, true, true);
    }
    @GetMapping("/contract/all")
    public List<Contract> getProposal(){
        return contractRepository.findAllByBoughtEqualsAndProposalId_ApproveEquals(false, false);
    }
    @Transactional
    @PutMapping("/contracts/buy/{id}")
    public void payment(@PathVariable("id") Integer id, @RequestBody Proposal proposal){
        contractRepository.update(id);
        clientRepository.updateCash(proposal.getTotalCost(), clientRepository.findById(proposal.getClientId().getId()).get().getUserId());
    }
    @GetMapping("/contract/allPaid")
    public List<Contract> getAllPaidContracts(){
        return contractRepository.findAllByBoughtEquals(true);
    }
}
