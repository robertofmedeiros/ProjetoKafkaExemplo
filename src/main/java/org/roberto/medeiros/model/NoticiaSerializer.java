package org.roberto.medeiros.model;

import org.apache.kafka.common.serialization.Serializer;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class NoticiaSerializer implements Serializer<Noticia> {
    @Override
    public void configure(Map<String, ?> map, boolean b) {

    }

    @Override
    public byte[] serialize(String topic, Noticia noticia) {
        byte[] data = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            data = objectMapper.writeValueAsString(noticia).getBytes();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public void close() {

    }
}
