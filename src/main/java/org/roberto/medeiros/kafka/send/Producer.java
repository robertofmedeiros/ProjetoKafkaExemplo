package org.roberto.medeiros.kafka.send;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.java.Log;
import org.roberto.medeiros.model.Noticia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    private static final String TOPIC = "teste-topic";
    private static final String TOPICNoticia = "topic-object";
    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;
    public void sendMessage(String message){
        this.kafkaTemplate.send(TOPIC,message);
    }

    public void sendNoticias(Noticia noticia) throws JsonProcessingException {

        String message = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(noticia);

        this.kafkaTemplate.send(TOPICNoticia,message);
    }
}
