package com.dad12.producer.senders;

import com.dad12.producer.models.PedidoRestaurante;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;
    @Autowired
    private Queue queue;

    public void send(PedidoRestaurante pedidoRestaurante) {
        rabbitTemplate.convertAndSend(queue.getName(), pedidoRestaurante.toJson());
        System.out.println("Enviando msg para a fila : " + pedidoRestaurante);
    }
}
