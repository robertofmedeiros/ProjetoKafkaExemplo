package org.roberto.medeiros.test;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.roberto.medeiros.model.Noticia;

import java.io.IOException;

public class TesteJson {
    public static void main(String args[]){

        ObjectMapper mapper = new ObjectMapper();

        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        String teste = "{\"nome\":\"mkyong\",\"descricao\":37, \"teste\":\"teste\"}";

        try {
            Noticia noticia = mapper.readValue(teste, Noticia.class);

            System.out.println(String.format("Recebendo Messagem -> %s",noticia.toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
