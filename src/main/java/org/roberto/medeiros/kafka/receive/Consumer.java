package org.roberto.medeiros.kafka.receive;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.roberto.medeiros.model.Noticia;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Consumer {

    private ObjectMapper mapper = new ObjectMapper();

    @KafkaListener(topics = "topic-object", groupId = "group-teste")
    public void consume(String message){

        try {
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            Noticia noticia = mapper.readValue(message, Noticia.class);

            System.out.println(String.format("Recebendo Messagem -> %s",noticia.toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
