package br.com.produto.produtoms.view.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.produto.produtoms.compartilhado.ProdutoDto;
import br.com.produto.produtoms.service.ProdutoService;
import br.com.produto.produtoms.view.model.ProdutoModeloInclusao;
import br.com.produto.produtoms.view.model.ProdutoModeloResponse;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {
    
    @Autowired
    private ProdutoService service;

    @GetMapping(value = "/status")
    public String statusServico(@Value("${local.server.port}")String porta) {
        return String.format("Serviço ativo e executando na porta %s", porta);
    }

    @PostMapping
    public ResponseEntity<ProdutoModeloResponse> adicionarProduto(@RequestBody @Valid ProdutoModeloInclusao produto) {
        ModelMapper mapper = new ModelMapper();
        ProdutoDto dto = mapper.map(produto, ProdutoDto.class);
        dto = service.adicionarProduto(dto);
        return new ResponseEntity<>(mapper.map(dto, ProdutoModeloResponse.class), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoModeloResponse>> obterTodos() {
        List<ProdutoDto> dtos = service.obterTodos();

        if(dtos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        ModelMapper mapper = new ModelMapper();
        List<ProdutoModeloResponse> resp = dtos.stream()
            .map(dto -> mapper.map(dto, ProdutoModeloResponse.class))
            .collect(Collectors.toList());

        return new ResponseEntity<List<ProdutoModeloResponse>>(resp, HttpStatus.OK);
    }

    @GetMapping(value="/{cod}")
    public ResponseEntity<ProdutoModeloResponse> obterPorCodigo(@PathVariable String cod) {
        Optional<ProdutoDto> produto = service.obterPorCodigo(cod);

        if(produto.isPresent()) {
            return new ResponseEntity<>(
                new ModelMapper().map(produto.get(), ProdutoModeloResponse.class), 
                HttpStatus.OK
            );
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value="/{cod}")
    public ResponseEntity<Void> removerProduto(@PathVariable String cod) {
        service.removerProduto(cod);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
