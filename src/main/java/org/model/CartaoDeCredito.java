package org.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class CartaoDeCredito implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private double limiteDeCredito;
    private String bandeira;
    private Long numero;
    private int codigoDeSeguranca;
    private Date dataDeValidade;
    @OneToOne
    @MapsId
    private Cliente cliente;

    public CartaoDeCredito(){

    }

    public CartaoDeCredito(Integer id, double limiteDeCredito, String bandeira, Long numero, int codigoDeSeguranca, Date dataDeValidade, Cliente cliente) {
        this.id = id;
        this.limiteDeCredito = limiteDeCredito;
        this.bandeira = bandeira;
        this.numero = numero;
        this.codigoDeSeguranca = codigoDeSeguranca;
        this.dataDeValidade = dataDeValidade;
        this.cliente = cliente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getLimiteDeCredito() {
        return limiteDeCredito;
    }

    public void setLimiteDeCredito(double limiteDeCredito) {
        this.limiteDeCredito = limiteDeCredito;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public int getCodigoDeSeguranca() {
        return codigoDeSeguranca;
    }

    public void setCodigoDeSeguranca(int codigoDeSeguranca) {
        this.codigoDeSeguranca = codigoDeSeguranca;
    }

    public Date getDataDeValidade() {
        return dataDeValidade;
    }

    public void setDataDeValidade(Date dataDeValidade) {
        this.dataDeValidade = dataDeValidade;
    }


}
