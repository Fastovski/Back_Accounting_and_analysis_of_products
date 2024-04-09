package com.example.WEB.UserPackage;

import com.example.WEB.ClientPackage.Client;
import com.example.WEB.EmployeePackage.Employee;
import com.example.WEB.PassEncoder.Hash;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:3000/")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/auth")
    public User authorization(@RequestBody User user){
       User pers = userRepository.findByEmail(user.getEmail()).orElse(null);
        if(pers != null){
            if(Hash.HashPassword(user.getPassword()).equals(pers.getPassword())){
                return pers;
            }else return new User();
        }else return  new User();
    }
    @PostMapping("/reg")
    public User registration(@RequestBody User user){
        Client client = new Client();
        client.setUserId(user);
        //client.setCash(0);
        user.setPassword(Hash.HashPassword(user.getPassword()));
        user.setRole(Role.User);
        user.setClientId(client);
       return userRepository.save(user);
    }

}
