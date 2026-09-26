package apiJogos.controller;


import apiJogos.model.Jogos;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/jogos")
public class jogosController {

    List<Jogos> bancoDados = new ArrayList<>(); //Simula um banco de dados temporario

    @GetMapping("/Listar_jogos") public ResponseEntity<List<Jogos>> listarJogos() {//puxa o banco de dados temporario
        return ResponseEntity.ok(bancoDados); //exibe o banco de dados temporario
    }

    @GetMapping("/Buscar_ID/{id}") public ResponseEntity<List<Jogos>> BuscaID(@PathVariable Long id){// define que a busca será realizada pelo ID
        for (Jogos jogo : bancoDados) {//Puxa os (Jogos) no (bancoDados) e adiciona na nova variavel (jogo)
            if (jogo.getId().equals(id)) {// pega o id do (Jogo) e compara com o ID que foi pesquisado
                return ResponseEntity.ok(Collections.singletonList(jogo));// mostra o resultado. OBS: não sei pq mas só funciona com esse Collections.singletonList(jogo)
            }
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/filtro") public ResponseEntity<List<Jogos>> BuscarFiltro(@RequestParam(required = false) String nome,
                                                                           @RequestParam(required = false) String genero,
                                                                           @RequestParam(required = false) String dificuldade) { //metodo para pesquisar por filtro um jogo
        List<Jogos> resultado = new ArrayList<>(); //Cria um novo banco de dados temporario para aplicar o filtro

        for (Jogos jogo : bancoDados){
            boolean acho = true;// faz a conferencia se o que foi pesquisado passou pelo filtro (true não passou e false passou)
            if (nome != null && !jogo.getNome()
                    .toLowerCase().//transforma tudo em letra minuscula
                    contains(nome.toLowerCase())){//Vai pesquisar se tem apreviado e transforma em letra minuscula tbm
                acho = false;
            }

            if (genero != null && !jogo.getGenero().equalsIgnoreCase(genero)){//ignora se é letra minuscula ou maiuscula
                acho = false;
            }

            if (dificuldade !=null && !jogo.getDificuldade().equalsIgnoreCase(dificuldade)){//ignora se é letra minuscula ou maiuscula
                acho = false;
            }

            if (acho){
                resultado.add(jogo);
            }
        }
        return ResponseEntity.ok(resultado);

    }

    @PostMapping("/gravar") public String gravarJogo(@RequestBody Jogos jogos){ //metodo para gravar um novo jogo
        if(jogos == null){
            return "ta vazio";
        }else{
            bancoDados.add(jogos);
            return "Jogo gravado";
        }
    }



    @PutMapping("/{id}") public ResponseEntity<Jogos> atualizar(@PathVariable Long id,
                                                                @RequestBody Jogos jogoAtualizado) {
        for (Jogos jogo : bancoDados) {
            if (jogo.getId().equals(id)) {
                jogo.setNome(jogoAtualizado.getNome());// altera o nome
                jogo.setGenero(jogoAtualizado.getGenero());// altera o genero
                jogo.setDificuldade(jogoAtualizado.getDificuldade());// altera a dificuldade
                jogo.setAno_jogado(jogoAtualizado.getAno_jogado());// altera o ano jogado

                return ResponseEntity.ok(jogo);
            }
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}") public ResponseEntity<Void> excluir(@PathVariable Long id) {//metodo para exluir um jogo
        for (Jogos jogo : bancoDados) {
            if (jogo.getId().equals(id)) {
                bancoDados.remove(jogo);
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build();
    }
}

