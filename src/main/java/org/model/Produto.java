package org.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Integer id;
    private String descricao;
    private int identificação;

    public Produto() {
    }

    public Produto(Integer id, String descricao, int identificação) {
        this.id = id;
        this.descricao = descricao;
        this.identificação = identificação;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getIdentificação() {
        return identificação;
    }

    public void setIdentificação(int identificação) {
        this.identificação = identificação;
    }

    @Override
    public String toString() {
        return "Produto:" +
                "Descricao: '" + descricao + '\'' +
                ", Identificação:'" + identificação + '\'' +
                '}';
    }
}
