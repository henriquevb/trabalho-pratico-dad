package com.dad12.consumer.repositories;

import com.dad12.consumer.models.PedidoRestaurante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PedidoRepositoryImpl implements PedidoRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void salvarPedido(PedidoRestaurante pedido) {
        mongoTemplate.save(pedido);
        System.out.println("PEDIDO SALVO COM SUCESSO.");
    }
}
