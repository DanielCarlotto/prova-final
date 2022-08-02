package br.com.produto.produtoms.view.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class ProdutoModeloInclusao {

    @NotBlank(message= "O codigo não pode estar em branco!!!")
    @NotEmpty(message= "O codigo não pode estar vazio!!!")
    private String cod;
    private String nome;
    private double preco;
    private int qtdEstoque;

    
    public String getCod() {
        return cod;
    }
    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }
    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }
}
