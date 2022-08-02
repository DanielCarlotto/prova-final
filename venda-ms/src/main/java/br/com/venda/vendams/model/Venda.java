package br.com.venda.vendams.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("venda")
public class Venda {

    @Id
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
