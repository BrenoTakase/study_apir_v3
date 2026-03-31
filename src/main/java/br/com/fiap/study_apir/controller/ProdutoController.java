package br.com.fiap.study_apir.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.study_apir.model.Produto;
import br.com.fiap.study_apir.repository.RepositoryProdutoMockup;

@RestController
@RequestMapping("api/${api.version}/produtos")
public class ProdutoController {

    private RepositoryProdutoMockup mockup = new RepositoryProdutoMockup();

    @PostMapping
    public ResponseEntity<String> create() {
        return ResponseEntity.status(HttpStatus.CREATED).body("Produto criado");
    }

    @GetMapping
    public ResponseEntity<List<Produto>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(mockup.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Long id) {
       //Metodo 1: (Usando if/for / Não é usado Optional)
        // Produto produto = mockup.findById(id);
        // if (produto != null) {
        //     return ResponseEntity.ok(produto);
        // } else {
        //     return ResponseEntity.notFound().build();
        // }

        //Metodo 2: (Usando Optional)
        // Optional<Produto> optProduto = mockup.findById(id);
        //     if (optProduto.isPresent()) {
        //         return ResponseEntity.ok(optProduto.get());
        //     } else {
        //         return ResponseEntity.notFound().build();
        //     }


        //Metodo 3: (Mais otimizado)
           return mockup.findById(id)
           .map(ResponseEntity::ok)
           .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping
    public ResponseEntity<String> update() {
        return ResponseEntity.status(HttpStatus.OK).body("Produto atualizado");
    }

    //O @PathVariable identifica que a variavel vem do path e não
    //de uma query (parâmetro)
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        mockup.deletedById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Produto excluido");
    }

}