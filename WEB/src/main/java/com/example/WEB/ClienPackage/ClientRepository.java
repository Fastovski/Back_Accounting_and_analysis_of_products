package com.example.WEB.ClienPackage;

import com.example.WEB.UserPackage.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ClientRepository extends JpaRepository<Client,Integer> {
    @Modifying(clearAutomatically = true)
    @Query("UPDATE Client m set m.cash = m.cash + ?1 where m.userId = ?2")
    public void update(Integer cash, User user);
    @Modifying(clearAutomatically = true)
    @Query("UPDATE Client m set m.cash = m.cash - ?1 where m.userId = ?2")
    public void updateCash(Integer cash, User user);

    public Client findByUserId_Id(Integer id);
}
