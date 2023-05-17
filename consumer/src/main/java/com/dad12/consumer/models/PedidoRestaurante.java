package com.dad12.consumer.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("pedidos")
public class PedidoRestaurante {

    @Id
    private String id;
    private String nomeCliente;
    private String enderecoDeEntrega;
    private List<String> pedido;

    public static PedidoRestaurante fromJson(String json) throws JsonProcessingException {
        final var objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, PedidoRestaurante.class);
    }
}
