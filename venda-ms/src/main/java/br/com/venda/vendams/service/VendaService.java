package br.com.venda.vendams.service;

import java.util.List;
import java.util.Optional;

import br.com.venda.vendams.compartilhado.VendaDto;

public interface VendaService {
    VendaDto criarVenda(VendaDto venda);
    List<VendaDto> obterTodasVendas();
    Optional<VendaDto> obterPorId(String id);
    void removerVenda(String id);
}
