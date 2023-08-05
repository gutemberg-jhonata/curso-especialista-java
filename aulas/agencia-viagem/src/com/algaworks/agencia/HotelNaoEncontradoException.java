package com.algaworks.agencia;

public class HotelNaoEncontradoException extends RuntimeException {
    public HotelNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
