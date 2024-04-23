package com.example.WEB.UserPackage;

import com.example.WEB.UserPackage.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    public Optional<User> findByEmail(String email);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE User u set u.name = ?2, u.email = ?3  where u.id = ?1")
    public void update(Integer id, String name, String email);
}
