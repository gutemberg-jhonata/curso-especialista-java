import com.algaworks.comercial.ServicoDeVenda;
import com.algaworks.comercial.Venda;

import java.util.List;

public class Principal3 {

    public static void main(String[] args) {
        var servicoDeVenda = new ServicoDeVenda();
        List<Venda> vendas = servicoDeVenda.obterTodas();

        vendas.stream()
            .filter(Venda::isFechada)
            .flatMap(venda -> venda.getItens().stream())
            .map(Venda.Item::descricao)
            .distinct()
            .sorted()
            .forEach(System.out::println);

        /*List<String> descricoes = new ArrayList<>();
        for (Venda venda : vendas) {
            if (venda.isFechada()) {
                for (Venda.Item item : venda.getItens()) {
                    if (!descricoes.contains(item.descricao())) {
                        descricoes.add(item.descricao());
                    }
                }
            }
        }

        Collections.sort(descricoes);

        for (String descricao : descricoes) {
            System.out.println(descricao);
        }*/
    }

}
