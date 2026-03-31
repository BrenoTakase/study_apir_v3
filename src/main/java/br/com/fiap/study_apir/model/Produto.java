package br.com.fiap.study_apir.model;

import java.math.BigDecimal;

import lombok.Data;
//Final diz que é um valor obrigatório, e exige declarar uma
//variavel ou criar um construtor.

//O @RequiredArgsConstructor faz a criação do construtor
//de forma automática.
// @Getter
// @Setter
// @RequiredArgsConstructor

//No lugar de colocar esses 3 comandos acima, pode usar o 
@Data
public class Produto {
    private final Long id;
    private final String nome;
    private final BigDecimal valor;
}