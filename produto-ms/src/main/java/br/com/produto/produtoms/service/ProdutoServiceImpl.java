package br.com.produto.produtoms.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.produto.produtoms.compartilhado.ProdutoDto;
import br.com.produto.produtoms.model.Produto;
import br.com.produto.produtoms.repository.ProdutoRepositorio;

@Service
public class ProdutoServiceImpl implements ProdutoService {
    
    @Autowired
    private ProdutoRepositorio produtoRepo;

    @Override
    public ProdutoDto adicionarProduto (ProdutoDto produto) {
        return salvarProduto (produto);
    }

    @Override 
    public List<ProdutoDto> obterTodos() {
        List<Produto> produtos = produtoRepo.findAll();

        return produtos.stream()
        .map(produto -> new ModelMapper().map(produto,ProdutoDto.class))
        .collect(Collectors.toList());
    } // produto -> new ModelMapper().map(produto,ProdutoDto.class))

    @Override
    public Optional<ProdutoDto> obterPorCodigo(String cod) {
        Optional<Produto> produto = produtoRepo.findById(cod);

        if(produto.isPresent()) {
            return Optional.of(new ModelMapper().map(produto.get(), ProdutoDto.class));
        }
        return Optional.empty();
    }

    @Override
    public void removerProduto(String cod) {
        produtoRepo.deleteById(cod);
    }

    private ProdutoDto salvarProduto(ProdutoDto produto) {
        ModelMapper mapper = new ModelMapper();
        Produto produtoEntidade = mapper.map(produto, Produto.class);
        produtoEntidade = produtoRepo.save(produtoEntidade);

        return mapper.map(produtoEntidade, ProdutoDto.class);
    }

    
}
