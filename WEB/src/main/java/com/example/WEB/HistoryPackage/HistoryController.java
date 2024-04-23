package com.example.WEB.HistoryPackage;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class HistoryController {
    private final HistoryRepository historyRepository;

    public HistoryController(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    @GetMapping("/history/all")
    public List<History> getHistory() {
        return historyRepository.findAll();
    }
    @GetMapping("/history/by/{id}")
    public List<History> getHistoryBy(@PathVariable("id") Integer id) {
        return historyRepository.findByClientId_UserId_Id(id);
    }
}
