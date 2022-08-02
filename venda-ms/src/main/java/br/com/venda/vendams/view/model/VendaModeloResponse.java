package br.com.venda.vendams.view.model;

import java.time.LocalDate;

public class VendaModeloResponse {
    private String id;
    private int qtd;
    private LocalDate data;
    private double valorTotal;

   
    public String getCod() {
        return id;
    }
    public void setCod(String id) {
        this.id = id;
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
}
