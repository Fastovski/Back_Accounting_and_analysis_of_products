package com.example.WEB.BanquetPackage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ProductsRepository extends JpaRepository<Products,Integer> {
    @Modifying(clearAutomatically = true)
    @Query("UPDATE Products p set p.name = ?2, p.description = ?3, p.cost = ?4, p.category = ?5 where p.id = ?1")
    public void update(Integer id, String name, String description, Integer cost, String category);
}
