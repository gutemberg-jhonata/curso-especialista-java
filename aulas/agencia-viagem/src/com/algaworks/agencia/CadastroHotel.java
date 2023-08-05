package com.algaworks.agencia;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CadastroHotel {

    private final List<Hotel> hoteis = new LinkedList<>();

    public void adicionar(String nome, String cidade, double precoDiaria) {
        Hotel hotel = new Hotel(nome, cidade, precoDiaria);

        if (hoteis.contains(hotel)) {
            throw new HotelJaExistenteException("Hotel já foi adicionado");
        }

        hoteis.add(hotel);
    }

    public List<Hotel> obterTodos() {
        return hoteis;
    }
    
    public Hotel[] obterTodosComoArray() {
        return hoteis.toArray(new Hotel[0]);
    }

    public void ordenar() {
        Collections.sort(hoteis);
    }

    public void ordenarPorPreco() {
        //Collections.sort(hoteis, new PrecoHotelComparator());
        hoteis.sort(new PrecoHotelComparator()
            .reversed()
            .thenComparing(Comparator.naturalOrder()));
    }

    public void removerPorCidade(String cidade) {
        Iterator<Hotel> hotelIterator = hoteis.iterator();
        while(hotelIterator.hasNext()) {
            Hotel hotel = hotelIterator.next();
            if (hotel.getCidade().equals(cidade)) {
                hotelIterator.remove();
                //hoteis.remove(hotel);
            }
        }

        /*ArrayList<Hotel> hoteisParaRemocao = new ArrayList<>();

        for (int i = 0; i < hoteis.size(); i++) {
            Hotel hotel = hoteis.get(i);
            if (hotel.getCidade() == cidade) {
                hoteisParaRemocao.add(hotel);
                // hoteis.remove(i);
                // i--;
            }
        }

        hoteis.removeAll(hoteisParaRemocao);*/
    }

    public void remover(Hotel hotel) {
        boolean removido = hoteis.remove(hotel);
        if (!removido) {
            throw new HotelNaoEncontradoException("Hotel não encontrado para remoção");
        }
    }

    public void removerTodos() {
        hoteis.clear();
    }

}
