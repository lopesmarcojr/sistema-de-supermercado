package org.model;

import java.io.Serializable;
import java.util.List;

public class Carrinho implements Serializable {

    private static final long serialVersionUID = 1L;
    private Produto produto;
    private Cliente cliente;
    private int identificacao;

    List<Produto> produtos;
    public Carrinho(Produto produto, Cliente cliente, int identificacao) {
        this.produto = produto;
        this.cliente = cliente;
        this.identificacao = identificacao;
    }

    public Carrinho() {
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(int identificacao) {
        this.identificacao = identificacao;
    }
}
