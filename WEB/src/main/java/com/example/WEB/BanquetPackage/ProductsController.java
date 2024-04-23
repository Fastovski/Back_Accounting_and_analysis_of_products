package com.example.WEB.BanquetPackage;

import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class ProductsController {
    private final ProductsRepository productsRepository;

    public ProductsController(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }
    @GetMapping("/banquet/get")
    public List<Products> getAllProduct(){
        return productsRepository.findAll();
    }

    @GetMapping("/banquet/one/{id}")
    public Products getOneProduct(@PathVariable("id") Integer id){
        return productsRepository.findById(id).orElse(null);
    }

    @PostMapping("/banquet/add")
    public void addNewProduct(@RequestBody Products product){
        productsRepository.save(product);
    }
    @Transactional
    @PutMapping("/banquet/update/{id}")
    public void update(@PathVariable("id") Integer id, @RequestBody Products products){
        productsRepository.update(id, products.getName(), products.getDescription(), products.getCost(), products.getCategory());
    }
    @Transactional
    @DeleteMapping("/banquet/delete/{id}")
    public void delete(@PathVariable("id") Integer id){
        productsRepository.deleteById(id);
    }
}
