package org.dao;

import org.model.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class DaoProduto {

    List<Produto> produtos = new ArrayList<>();
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
    EntityManager em = emf.createEntityManager();

    public void adicionarNovoProduto(String descricao, int identificacao){
        Produto produto = new Produto(null, descricao, identificacao);
        em.getTransaction().begin();
        em.persist(produto);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    public void listarProdutos(){
        int id = 1;
        Produto produto = null;
        do{
             produto = em.find(Produto.class, id);
             produtos.add(produto);
             id++;
        }while(produto != null);
        for(Produto p : produtos){
            System.out.println(p);
        }
    }
}
