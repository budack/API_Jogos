package apiJogos.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Jogos {
    private Long id;
    private String nome;
    private String genero;
    private String dificuldade;
    private Integer ano_jogado;
}
