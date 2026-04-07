package br.com.fiap.study_apir.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.fiap.study_apir.model.Produto;

@Service
public class RepositoryProdutoMockup {
    private List<Produto> produtos = new ArrayList<>();
    //Cria os IDs de forma automática
    private long ID = 1L;

    public RepositoryProdutoMockup() {
        produtos.add(new Produto(ID++, "Maça", BigDecimal.valueOf(10.50)));
        produtos.add(new Produto(ID++, "Uva", BigDecimal.valueOf(15.23)));

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

    public Produto create(Produto produto) {
        //Atribuir o id novo ao produto a ser criado
        produto.setId(ID++);
        //Salvar no BD
        produtos.add(produto);
        //Retornar produto novo
        return produto;
    }

    public boolean update(Long id, Produto produto){
        Optional<Produto> optProduto = this.findById(id);
        if (optProduto.isPresent()) {
            Produto produtoAtual = optProduto.get();
            produtoAtual.setNome(produto.getNome());
            produtoAtual.setValor(produto.getValor());
            return true;
        }
        return false;
    }

}
