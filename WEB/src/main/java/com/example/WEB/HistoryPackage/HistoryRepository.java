package com.example.WEB.HistoryPackage;

import com.example.WEB.HistoryPackage.History;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoryRepository extends JpaRepository<History,Integer> {
    public List<History> findByClientId_UserId_Id(Integer id);
}
