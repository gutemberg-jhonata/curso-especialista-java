import com.algaworks.estoque.CadastroProduto;
import com.algaworks.estoque.Categoria;
import com.algaworks.estoque.Fabricante;
import com.algaworks.estoque.Produto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.IntBinaryOperator;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.management.RuntimeErrorException;

public class Principal {

    public static void main(String[] args) {
        var cadastroProduto = new CadastroProduto();
        List<Produto> produtos = cadastroProduto.obterTodos();
        //List<Produto> produtos = new ArrayList<>();

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
        
        /*produtos.stream()
            .filter(Produto::temEstoque)
            .map(Produto::getFabricante)
            .distinct()
            .forEach(System.out::println);*/
        
        /*produtos.stream()
            .filter(Produto::temEstoque)
            .flatMap(produto -> produto.getCategorias().stream())
            .distinct()
            .forEach(System.out::println);*/

        /*List<Categoria> categorias = produtos.stream()
            .filter(Produto::temEstoque)
            .flatMap(produto -> produto.getCategorias().stream())
            .distinct()
            .collect(() -> new ArrayList<>(), 
                (lista, elemento) -> lista.add(elemento),
                (lista1, lista2) -> lista1.addAll(lista2));*/

        /*List<Categoria> categorias = produtos.stream()
            .filter(Produto::temEstoque)
            .flatMap(produto -> produto.getCategorias().stream())
            .distinct()
            .toList(); // nao modificavel
            //.collect(Collectors.toUnmodifiableList());
            //.collect(Collectors.toCollection(ArrayList::new));
            //.collect(Collectors.toList());
            //.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        System.out.println(categorias);*/

        /*Map<Fabricante, List<Produto>> produtosPorFabricante = produtos.stream()
            .filter(Produto::temEstoque)
            .collect(Collectors.groupingBy(Produto::getFabricante));*/
        
        /*Map<String, Long> produtosPorFabricante = produtos.stream()
            .filter(Produto::temEstoque)
            .collect(Collectors.groupingBy(
                produto -> produto.getFabricante().nome(),
                Collectors.counting()));
        
        System.out.println(produtosPorFabricante);*/

        /*Map<String, Integer> estoquePorFabricante = produtos.stream()
            .filter(Produto::temEstoque)
            .collect(Collectors.groupingBy(
                produto -> produto.getFabricante().nome(),
                Collectors.summingInt(Produto::getQuantidade)));
        
        System.out.println(estoquePorFabricante);*/

        Map<Boolean, List<Produto>> estoquePorFabricante = produtos.stream()
            .collect(Collectors.partitioningBy(Produto::temEstoque));
        
        System.out.println(estoquePorFabricante);

        /*IntBinaryOperator operacaoSoma = (subTotal, valor) -> {
            System.out.println(subTotal + " + " + valor);
            return subTotal + valor;
        };

        produtos.stream()
            .filter(Produto::temEstoque)
            .mapToInt(Produto::getQuantidade)
            .reduce(0, operacaoSoma);*/

        /*int totalEstoque = produtos.stream()
            .filter(Produto::temEstoque)
            .mapToInt(Produto::getQuantidade)
            .sum();
            //.reduce(0, Integer::sum);
            //.reduce(0, Integer::max);
            //.reduce(0, Integer::min);

        System.out.println(totalEstoque);*/

        /*double mediaEstoque = produtos.stream()
            .mapToInt(Produto::getQuantidade)
            .average()
            .orElseThrow(
                () -> new RuntimeException("Não há produtos para cálcular a média"));

        System.out.println(mediaEstoque);*/

        /*long totalProdutosComEstoque = produtos.stream()
            .filter(Produto::temEstoque)
            .count();

        System.out.println(totalProdutosComEstoque);*/

        /*OptionalInt maiorQuantidadeOptional = produtos.stream()
            .filter(Produto::temEstoque)
            .mapToInt(Produto::getQuantidade)
            .reduce(Integer::max);

        int maiorQuantidade = maiorQuantidadeOptional.orElseThrow(
            () -> new RuntimeException("Quantidade não encontrada.")
        );

        System.out.println(maiorQuantidade);*/

        /*BigDecimal valorEmEstoque = produtos.stream()
            .map(produto -> produto.getPreco()
                .multiply(new BigDecimal(produto.getQuantidade())))
            .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal valorEmEstoque2 = produtos.stream()
            .reduce(BigDecimal.ZERO, (subTotal, produto) -> {
                BigDecimal valorEstoqueProduto = produto.getPreco()
                    .multiply(new BigDecimal(produto.getQuantidade()));
                return subTotal.add(valorEstoqueProduto);
            } , BigDecimal::add);*/

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
