package com.dad12.producer.controllers;

import com.dad12.producer.models.PedidoRestaurante;
import com.dad12.producer.senders.RabbitMQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestauranteController {

    @Autowired
    private RabbitMQSender sender;

    @PostMapping(value = "/delivery")
    public String pedidosDelivery(@RequestBody PedidoRestaurante pedido) {
        sender.send(pedido);
        return "Sucesso";
    }
}
