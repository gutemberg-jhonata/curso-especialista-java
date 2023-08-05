package com.algaworks.agencia;

import java.util.*;

public class CadastroPacoteViagem {

    private final List<PacoteViagem> pacotesViagem = new ArrayList<>();

    public void adicionar(String descricao, double precoDiaria) {
        PacoteViagem pacoteViagem = new PacoteViagem(descricao, precoDiaria);
        if (pacotesViagem.contains(pacoteViagem)) {
            throw new PacoteViagemJaExistenteException("Este pacote de viagem já foi adicionado.");
        }
        pacotesViagem.add(pacoteViagem);
    }

    public List<PacoteViagem> obterTodos() {
        // TODO retornar lista de pacotes
        return null;
    }

    public void ordenar() {
        // TODO ordenar pacotes pela ordem natural
    }

    public void ordenarPorPrecoDecrescente() {
        // TODO ordenar pacotes pelo preço (decrescente)
    }

    public void removerPorDescricao(String descricao) {
        // TODO iterar nos pacotes com Iterator e remover aqueles com descrição informada,
        //  lançando exceção se nenhum pacote foi removido
    }

    public PacoteViagem buscarPorDescricao(String descricao) {
        // TODO iterar pacotes com enhanced for, localizar e retornar
        //  pacote com descrição informada (ou lançar exceção se não encontrar)
        return null;
    }

}
