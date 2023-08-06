import com.algaworks.estoque.CadastroProduto;
import com.algaworks.estoque.Fabricante;
import com.algaworks.estoque.Produto;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;

public class Principal {

    public static void main(String[] args) {
        var cadastroProduto = new CadastroProduto();
        List<Produto> produtos = cadastroProduto.obterTodos();

//        for (Produto produto : produtos) {
//            produto.ativar();
//            System.out.println(produto);
//        }

        /*boolean temProdutoNoEstoque = produtos.stream()
            .peek(System.out::println)
            .anyMatch(Produto::temEstoque);
        System.out.println(temProdutoNoEstoque);*/

        /*boolean todosProdutosPossuemEstoque = produtos.stream()
            .peek(System.out::println)
            .allMatch(Produto::temEstoque);
        System.out.println(todosProdutosPossuemEstoque);*/

        /*boolean nenhumProdutoPossuiEstoque = produtos.stream()
            .peek(System.out::println)
            .noneMatch(Produto::temEstoque);
        System.out.println(nenhumProdutoPossuiEstoque);*/

        /*produtos.stream()
            .filter(Produto::temEstoque)
            .sorted(Comparator.comparingInt(Produto::getQuantidade))
            .forEach(produto -> 
                System.out.printf(
                    "%s = %d unidades%n", 
                    produto.getNome(), 
                    produto.getQuantidade()
                )
            );*/
        
        produtos.stream()
            .filter(Produto::temEstoque)
            .map(Produto::getFabricante)
            .distinct()
            .forEach(System.out::println);

        /*produtos.stream()
            .peek(produto -> produto.setNome(produto.getNome().toUpperCase()))
            .peek(System.out::println)
            .filter(Produto::temEstoque)
            .filter(Produto::isInativo)
            .forEach(produto -> {
                System.out.println("Ativando: " + produto);
                produto.ativar();
            });;*/

        /*Optional<Produto> produtoOptional = produtos.stream()
            .peek(System.out::println)
            .filter(Produto::temEstoque)
            .filter(Produto::isInativo)
            .findFirst();

        Produto produto = produtoOptional.orElseThrow(
            () -> new RuntimeException("Produto não encontrado")
        );

        System.out.println("---------");
        System.out.println(produto);*/

        /*Stream<Produto> stream = produtos.stream();

        Stream<Produto> streamComEstoque = stream
            .filter(Produto::temEstoque);

        Stream<Produto> streamComEstoqueInativo = streamComEstoque
            .filter(Produto::isInativo);

        streamComEstoqueInativo.forEach(produto -> {
            produto.ativar();
            System.out.println(produto);
        });*/
    }

}
