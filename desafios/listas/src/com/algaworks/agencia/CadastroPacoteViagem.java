package com.algaworks.agencia;

import java.util.*;

public class CadastroPacoteViagem {

    private final List<PacoteViagem> pacotesViagem = new LinkedList<>();

    public void adicionar(String descricao, double precoDiaria) {
        PacoteViagem pacoteViagem = new PacoteViagem(descricao, precoDiaria);
        if (pacotesViagem.contains(pacoteViagem)) {
            throw new PacoteViagemJaExistenteException("Este pacote de viagem já foi adicionado.");
        }
        pacotesViagem.add(pacoteViagem);
    }

    public List<PacoteViagem> obterTodos() {
        return pacotesViagem;
    }

    public void ordenar() {
        pacotesViagem.sort(Comparator.naturalOrder());;
    }

    public void ordenarPorPrecoDecrescente() {
        Comparator<PacoteViagem> precoPacoteViagemComparator = (o1, o2) -> 
            Double.compare(
                o1.getPrecoPorPessoa(), 
                o2.getPrecoPorPessoa()
            );

        pacotesViagem.sort(
            precoPacoteViagemComparator
                .reversed()
                .thenComparing(Comparator.naturalOrder())
        );
    }

    public void removerPorDescricao(String descricao) {
        Iterator<PacoteViagem> iterator = pacotesViagem.iterator();
        while (iterator.hasNext()) {
            PacoteViagem pacoteViagem = iterator.next();
            if (pacoteViagem.getDescricao().equals(descricao)) {
                iterator.remove();
                return;
            }
        }
        throw new PacoteViagemNaoEncontradoException("Pacote de viagem não encontrado para remoção.");
    }

    public PacoteViagem buscarPorDescricao(String descricao) {
        for (PacoteViagem pacoteViagem: pacotesViagem) {
            if (pacoteViagem.getDescricao().equals(descricao)) {
                return pacoteViagem;
            }
        }
        throw new PacoteViagemNaoEncontradoException("Pacote de viagem não encontrado.");
    }

}
