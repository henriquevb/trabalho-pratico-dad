package com.dad12.consumer.listener;

import com.dad12.consumer.models.PedidoRestaurante;
import com.dad12.consumer.services.PedidoRestauranteService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "rabbitmq.queue", id = "listener")
public class RabbitMQListener {

    @Autowired
    private PedidoRestauranteService service;

    @RabbitHandler
    public void receiver(String menuOrder) throws JsonProcessingException {
        final var pedido = PedidoRestaurante.fromJson(menuOrder);
        service.salvarPedido(pedido);
        System.out.println("MenuOrder listener invoked - Consuming Message with MenuOrder Identifier : " + pedido);
    }
}

