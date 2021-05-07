package br.com.store.rabbit;

import br.com.store.model.Product;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queue;

    public void send(Product produto){
        rabbitTemplate.convertAndSend(this.queue.getName(), produto);
    }
}
