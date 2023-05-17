package com.dad12.consumer.repositories;

import com.dad12.consumer.models.PedidoRestaurante;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PedidoRepository {
    void salvarPedido(PedidoRestaurante pedido);
}
