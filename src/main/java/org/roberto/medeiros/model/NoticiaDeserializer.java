package org.roberto.medeiros.model;

import org.apache.kafka.common.serialization.Deserializer;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class NoticiaDeserializer implements Deserializer<Noticia>  {
    @Override
    public void configure(Map<String, ?> map, boolean b) {

    }

    @Override
    public Noticia deserialize(String topic, byte[] data) {
        ObjectMapper mapper = new ObjectMapper();
        Noticia noticia = null;
        try {
            noticia = mapper.readValue(data, Noticia.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return noticia;
    }

    @Override
    public void close() {

    }
}
