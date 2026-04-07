package br.com.fiap.study_apir.model;

import java.math.BigDecimal;

import lombok.Data;
//Final diz que é um valor obrigatório, e exige declarar uma
//variavel ou criar um construtor.
import lombok.Setter;

//O @RequiredArgsConstructor faz a criação do construtor
//de forma automática.
//@Getter
//@Setter
//@RequiredArgsConstructor

//No lugar de colocar esses 3 comandos acima, pode usar o 
//@Data
public class Produto {
    private Long id;
    private String nome;
    private BigDecimal valor;

    public Produto(Long id, String nome, BigDecimal valor) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getValor() {
        return valor;
    }
}