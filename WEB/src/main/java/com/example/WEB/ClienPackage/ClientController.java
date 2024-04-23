package com.example.WEB.ClienPackage;

import com.example.WEB.UserPackage.User;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.FileWriter;
import java.io.IOException;

@RestController
@CrossOrigin("http://localhost:3000")
public class ClientController {
    private final ClientRepository clientRepository;

    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @GetMapping("/client/getMoney/{id}")
    public Client getMoney(@PathVariable("id") Integer id){
        return clientRepository.findByUserId_Id(id);
    }
    @Transactional
    @PutMapping("/client/money/{id}")
    public void addMoney(@PathVariable("id") Integer id, @RequestBody Client client){
        clientRepository.update(client.getCash(),new User(id));
        try(FileWriter writer = new FileWriter("Чек.txt", false))
        {
            //запись всей строки
            String str = "Чек на пополнение баланса" +
                    "\nНа сумму: " +client.getCash();
            writer.write(str);
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
