package com.dad12.producer.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoRestaurante {
    private String nomeCliente;
    private String enderecoDeEntrega;
    private List<String> pedido;

    public String toJson() {
        final var mapper = new ObjectMapper();
        String json = null;
        try {
             json = mapper.writeValueAsString(this);
            System.out.println("ResultingJSONstring = " + json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }
}
