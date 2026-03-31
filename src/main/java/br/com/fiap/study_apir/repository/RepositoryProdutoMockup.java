package br.com.fiap.study_apir.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.fiap.study_apir.model.Produto;

public class RepositoryProdutoMockup {
    private List<Produto> produtos = new ArrayList<>();

    public RepositoryProdutoMockup() {
        produtos.add(new Produto(1L, "Maça", BigDecimal.valueOf(10.50)));
        produtos.add(new Produto(3L, "Uva", BigDecimal.valueOf(15.23)));

    }

    public List<Produto> findAll(){
        return produtos;
    }

    //O Uso do Option é para definir que a resposta pode
    //ou não ser nulo

    public Optional<Produto> findById(Long id){
        
        //Metodo 1: (Usando if/for / Não é usado Optional)
        
        // for(Produto produto:produtos){
        //     if(produto.getId().equals(id)){
        //         return produto;
        //     }
        // }
        // return null;

        //Metodo 2:
       return produtos.stream()
       .filter(p -> p.getId().equals(id))
       .findFirst();
    }

    public boolean deletedById(Long id){
        return produtos.removeIf(p -> p.getId().equals(id));
    }

}
