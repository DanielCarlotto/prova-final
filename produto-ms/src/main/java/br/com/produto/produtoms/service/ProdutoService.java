package br.com.produto.produtoms.service;

import java.util.List;
import java.util.Optional;

import br.com.produto.produtoms.compartilhado.ProdutoDto;

public interface ProdutoService {
    ProdutoDto adicionarProduto(ProdutoDto poduto);
    List<ProdutoDto> obterTodos();
    Optional<ProdutoDto> obterPorCodigo(String cod);
    void removerProduto(String cod);
    
    
    

}
