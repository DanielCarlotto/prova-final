package br.com.venda.vendams.view.controller;

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

import br.com.venda.vendams.compartilhado.VendaDto;
import br.com.venda.vendams.service.VendaService;
import br.com.venda.vendams.view.model.VendaModeloRequest;
import br.com.venda.vendams.view.model.VendaModeloResponse;
import br.com.venda.vendams.view.model.VendaModeloResponseDetalhes;

@RestController
@RequestMapping("/api/vendas")
public class VendaController {

    @Autowired
    private VendaService service;

    @GetMapping(value="/status")
    public String statusServico(@Value("${local.server.port}") String porta) {
        return String.format("Serviço ativo e executando na porta %s", porta);
    }

    @PostMapping
    public ResponseEntity<VendaModeloResponse> criarPessoa(@RequestBody @Valid VendaModeloRequest pessoa) {
        ModelMapper mapper = new ModelMapper();
        VendaDto dto = mapper.map(pessoa, VendaDto.class);
        dto = service.criarVenda(dto);
        return new ResponseEntity<>(mapper.map(dto, VendaModeloResponse.class), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<VendaModeloResponse>> obterTodasVendas() {
        List<VendaDto> dtos = service.obterTodasVendas();

        if(dtos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        ModelMapper mapper = new ModelMapper();
        List<VendaModeloResponse> resp = dtos.stream()
                    .map(dto -> mapper.map(dto, VendaModeloResponse.class))
                    .collect(Collectors.toList());

        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<VendaModeloResponseDetalhes> obterPorId(@PathVariable String id) {
        Optional<VendaDto> venda = service.obterPorId(id);

        if(venda.isPresent()) {
            return new ResponseEntity<>(
                new ModelMapper().map(venda.get(), VendaModeloResponseDetalhes.class), 
                HttpStatus.OK
            );
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> removerVenda(@PathVariable String id) {
        service.removerVenda(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } 
    
}
