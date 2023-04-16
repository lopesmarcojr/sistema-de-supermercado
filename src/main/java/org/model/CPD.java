package org.model;

import javax.persistence.*;
import java.io.Serializable;

public class CPD implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer matricula;
    private String nome;
    private String cpf;
    private String email;

    public CPD(){

    }
    public CPD(Integer id, Integer matricula, String nome, String cpf, String email) {
        this.id = id;
        this.matricula = matricula;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "CPD - " +
                "ID: " + id +
                ", Matricula: " + matricula +
                ", Nome: " + nome + '\'' +
                ", CPF: " + cpf + '\'' +
                ", eMAIL: " + email + '\'' +
                '}';
    }
}
