package org.roberto.medeiros.rest;


import com.fasterxml.jackson.core.JsonProcessingException;
import org.roberto.medeiros.kafka.send.Producer;
import org.roberto.medeiros.model.Noticia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/kafka")
public class ProucerRest {
    private final Producer producer;

    @Autowired
    public ProucerRest(Producer producer) {
        this.producer = producer;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message){
        this.producer.sendMessage(message);
    }

    @PostMapping(value = "/publish/noticia")
    public void sendNoticiaToKafkaTopic(@RequestBody Noticia noticia) throws JsonProcessingException {


        this.producer.sendNoticias(noticia);
    }
}
