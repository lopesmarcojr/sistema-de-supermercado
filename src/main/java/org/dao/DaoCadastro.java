package org.dao;

import org.model.Cliente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.Serializable;

public class DaoCadastro implements Serializable {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
    EntityManager em = emf.createEntityManager();

    public void cadastrarNovoCliente(String nome, String cpf, String email){
        Cliente cliente  = new Cliente(null, nome, cpf, email);
        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    public void cadastrarNovoCartão(){}
}
