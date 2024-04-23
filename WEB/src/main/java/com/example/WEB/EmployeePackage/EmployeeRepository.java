package com.example.WEB.EmployeePackage;

import com.example.WEB.UserPackage.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    @Modifying(clearAutomatically = true)
    @Query("UPDATE Employee m set m.operation = m.operation+?2 where m.userId = ?1")
    public void update(User id, Integer one);

}
