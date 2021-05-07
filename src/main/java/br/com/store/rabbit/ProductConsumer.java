package br.com.store.rabbit;

import br.com.store.model.Product;
import br.com.store.service.ProductService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class ProductConsumer {

    @Autowired
    private ProductService productService;

    @RabbitListener(queues = {"${queue.produto.name}"})
    public void receive (@Payload Product product){
        System.out.println("Id: "+ product.get_id() + "\nNome: " + product.getName());
        productService.save(product);
    }
}
