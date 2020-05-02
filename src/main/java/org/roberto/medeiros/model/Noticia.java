package org.roberto.medeiros.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class Noticia {
    private String nome;
    private String descricao;
}
