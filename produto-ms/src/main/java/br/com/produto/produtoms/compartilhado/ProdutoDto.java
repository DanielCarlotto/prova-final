package br.com.produto.produtoms.compartilhado;

public class ProdutoDto {
    private String cod;
    private String nome;
    private float preco;
    private Integer qtdEstoque;

    
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

    public float getPreco() {
        return preco;
    }
    public void setPreco(float preco) {
        this.preco = preco;
    }

    public Integer getQtdEstoque() {
        return qtdEstoque;
    }
    public void setQtdEstoque(Integer qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }
    
}
