package com.example.WEB.ProposalPackage;

import com.example.WEB.ClienPackage.Client;
import com.example.WEB.ClienPackage.ClientRepository;
import com.example.WEB.ContactPackage.Contract;
import com.example.WEB.ContactPackage.ContractController;
import com.example.WEB.ContactPackage.ContractRepository;
import com.example.WEB.EmployeePackage.EmployeeRepository;
import com.example.WEB.HistoryPackage.History;
import com.example.WEB.HistoryPackage.HistoryController;
import com.example.WEB.HistoryPackage.HistoryRepository;
import com.example.WEB.UserPackage.User;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class ProposalController {
    private final ProposalRepository proposalRepository;
    private final ClientRepository clientRepository;
    private final EmployeeRepository employeeRepository;
//    private final HistoryRepository historyRepository;
//    private final ContractRepository contractRepository;

    public ProposalController(ProposalRepository proposalRepository, ClientRepository clientRepository, EmployeeRepository employeeRepository) {
        this.proposalRepository = proposalRepository;
        this.clientRepository = clientRepository;
        this.employeeRepository = employeeRepository;
//        this.historyRepository = historyRepository; //
//        this.contractRepository = contractRepository;
    }

    @GetMapping("/proposal/all")
    public List<Proposal> getAllProposal() {
        return proposalRepository.findAll();
    }

    @PostMapping("/proposal/add")
    public void newProposal(@RequestBody Proposal proposal) {
        Client client = clientRepository.findByUserId_Id(proposal.getClientId().getId());
        proposal.setClientId(client);
        History history = new History();
        Date d = new Date();
        history.setClientId(client);
        history.setSending(new java.sql.Date(d.getTime()));
        history.setProposalId(proposal);
        Contract contract = new Contract();
        contract.setConclusion(new java.sql.Date(d.getTime()));
        contract.setBought(false);
        contract.setProposalId(proposal);
        proposal.setHistoryId(history);
        proposal.setContractId(contract);
        proposalRepository.save(proposal);
    }
    @Transactional
    @PutMapping("/proposal/approve/{id}")
    public void approveProposal(@PathVariable("id") Integer id, @RequestBody User user){
        proposalRepository.update(id);
        employeeRepository.update(user, 1);
    }
    @Transactional
    @DeleteMapping("/proposal/delete/{id}")
    public void delete(@PathVariable("id") Integer id) {
        proposalRepository.deleteById(id);
    }
}
