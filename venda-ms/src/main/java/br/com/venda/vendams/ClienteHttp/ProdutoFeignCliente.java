package br.com.venda.vendams.ClienteHttp;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.venda.vendams.compartilhado.Produto;

@FeignClient(name = "produto-ms")
public interface ProdutoFeignCliente {

    @GetMapping(path = "/api/produto/{codigo}/lista")
    List<Produto> obterProdutos(@PathVariable String codigo);
    
}
