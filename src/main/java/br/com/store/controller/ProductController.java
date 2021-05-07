package br.com.store.controller;

import br.com.store.constant.Constant;
import br.com.store.model.Product;
import br.com.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(Constant.API_PRODUCT)
    public void save(@RequestBody Product product){
        productService.sendProductRabbit(product);
        //productService.save(client);
    }

    @GetMapping(Constant.API_PRODUCT)
    public List<Product> findAll(){
        return productService.findAll();
    }

    @PutMapping(Constant.API_PRODUCT)
    public void update (@RequestBody Product product){
        productService.save(product);
    }

    @DeleteMapping(Constant.API_PRODUCT + "/{id}")
    public void delete(@PathVariable("id") String id){
        productService.delete(id);
    }

    @GetMapping(Constant.API_PRODUCT + "/{id}")
    public Optional<Product> findById(@PathVariable("id") String id){
        return productService.findById(id);
    }
}
