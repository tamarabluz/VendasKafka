package org.tamara.VendasK.Serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serializer;
import org.tamara.VendasK.Model.Vendas;

public class VendaSerializer implements Serializer<Vendas> {


    @Override
    public byte[] serialize(String topic, Vendas vendas) {
        try {
            return new ObjectMapper().writeValueAsBytes(vendas);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

}
