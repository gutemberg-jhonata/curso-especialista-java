import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

import com.algaworks.agencia.CadastroHotel;
import com.algaworks.agencia.Hotel;

public class Principal {

    public static void main(String[] args) {
        CadastroHotel cadastro = new CadastroHotel();
        cadastro.adicionar("Jaguaribe Lodge", "Fortim/CE", 1300);
        cadastro.adicionar("Vila Selvagem", "Fortim/CE", 1400);
        cadastro.adicionar("Hotel Fazenda Dona Carolina", "Itatiba/SP", 2200);
        cadastro.adicionar("Tivoli Ecoresort", "Praia do Forte/BA", 2000);
        cadastro.adicionar("Mercure", "Uberlândia/MG", 400);

        //cadastro.removerPorCidade("Fortim/CE");
        //cadastro.remover(new Hotel("Vila Selvagem", "Fortim/CE", 0));
        //cadastro.removerTodos();

        ArrayList<Hotel> hoteis = cadastro.obterTodos();
        imprimirHoteis(hoteis);
    }

    private static void imprimirHoteis(ArrayList<Hotel> hoteis) {
        ListIterator<Hotel> hotelIterator = hoteis.listIterator(hoteis.size());
        while(hotelIterator.hasPrevious()) {
            Hotel hotel = hotelIterator.previous();
            System.out.printf(
                "%s (%s) -> %.2f%n", 
                hotel.getNome(), 
                hotel.getCidade(), 
                hotel.getPrecoDiaria()
            );
        }

        /*for (int i = 0; i < hoteis.size(); i++) {
            Hotel hotel = hoteis.get(i);
            System.out.printf(
                "%s (%s) -> %.2f%n", 
                hotel.getNome(), 
                hotel.getCidade(), 
                hotel.getPrecoDiaria()
            );
        }*/
    }

}
