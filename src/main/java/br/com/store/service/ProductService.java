package br.com.store.service;

import br.com.store.model.Product;
import br.com.store.rabbit.ProductProducer;
import br.com.store.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductProducer productProducer;

    public void sendProductRabbit(Product product){
        productProducer.send(product);
    }

    public void save(Product product){
        productRepository.save(product);
    }

    public List<Product> findAll (){
        return productRepository.findAll();
    }

    public Optional<Product> findById(String id){
        return productRepository.findById(id);
    }

    public void delete(String id){
        productRepository.deleteById(id);
    }

    public void deleteAll(){
        productRepository.deleteAll();
    }
}
