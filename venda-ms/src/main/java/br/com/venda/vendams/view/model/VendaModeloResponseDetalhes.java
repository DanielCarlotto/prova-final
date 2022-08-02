package br.com.venda.vendams.view.model;

import java.time.LocalDate;
import java.util.List;

import br.com.venda.vendams.compartilhado.Produto;

public class VendaModeloResponseDetalhes {
    private String cod;
    private int qtd;
    private LocalDate data;
    private double valorTotal;
    private List<Produto> produtos;
    
    public String getCod() {
        return cod;
    }
    public void setCod(String cod) {
        this.cod = cod;
    }

    public int getQtd() {
        return qtd;
    }
    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }

    public double getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<Produto> getProduto() {
        return produtos;
    }
    public void setProduto(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
