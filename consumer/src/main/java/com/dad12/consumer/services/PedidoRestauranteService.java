package com.dad12.consumer.services;

import com.dad12.consumer.models.PedidoRestaurante;
import com.dad12.consumer.repositories.PedidoRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoRestauranteService {

    @Autowired private PedidoRepositoryImpl repository;

    public void salvarPedido(final PedidoRestaurante pedidoRestaurante) {
        repository.salvarPedido(pedidoRestaurante);
    }
}
