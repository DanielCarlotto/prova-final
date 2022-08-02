package br.com.venda.vendams.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.venda.vendams.ClienteHttp.ProdutoFeignCliente;
import br.com.venda.vendams.compartilhado.VendaDto;
import br.com.venda.vendams.model.Venda;
import br.com.venda.vendams.repository.VendaRepositorio;

@Service
public class VendaServiceImpl implements VendaService{

    @Autowired
    private VendaRepositorio repo;

    @Autowired
    private ProdutoFeignCliente produtos;

    @Override
    public VendaDto criarVenda(VendaDto venda) {
        return salvarVenda(venda);
    }

    @Override
    public List<VendaDto> obterTodasVendas() {
        List<Venda> vendas = repo.findAll();

        return vendas.stream()
            .map(venda -> new ModelMapper().map(venda, VendaDto.class))
            .collect(Collectors.toList());
    }

    @Override
    public Optional<VendaDto> obterPorId(String id) {
        Optional<Venda> venda = repo.findById(id);

       if(venda.isPresent()) {
          VendaDto dto = new ModelMapper().map(venda, VendaDto.class);


          dto.setProduto(produtos.obterProdutos(id));

          return Optional.of(dto);
       }

       return Optional.empty();
    }

    @Override
    public void removerVenda(String id) {
        repo.deleteById(id);
    }

    private VendaDto salvarVenda(VendaDto venda) {
        ModelMapper mapper = new ModelMapper();
        Venda vendaEntidade = mapper.map(venda, Venda.class);
        vendaEntidade = repo.save(vendaEntidade);

        return mapper.map(vendaEntidade, VendaDto.class);
    }
    
}
