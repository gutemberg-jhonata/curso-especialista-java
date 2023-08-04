import com.gutinhotech.estoque.Carro;
import com.gutinhotech.estoque.GerenciadorEstoque;
import com.gutinhotech.estoque.Roupa;

public class Principal {

    public static void main(String[] args) {
        var estoqueRoupas = new GerenciadorEstoque<Roupa>();
        estoqueRoupas.adicionar(new Roupa("Camiseta básica branca", 20));
        estoqueRoupas.adicionar(new Roupa("Camiseta básica preta", 10));
        imprimirEstoque(estoqueRoupas);

        var estoqueCarros = new GerenciadorEstoque<Carro>();
        estoqueCarros.adicionar(new Carro("BMW X1", 4));
        estoqueCarros.adicionar(new Carro("Honda HR-V", 8));
        imprimirEstoque(estoqueCarros);
    }

    private static void imprimirEstoque(GerenciadorEstoque<?> gerenciadorEstoque) {
        System.out.println("Estoque: " + gerenciadorEstoque.getQuantidadeTotal());
    }

}