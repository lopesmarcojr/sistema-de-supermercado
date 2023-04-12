package org.dao;

import org.model.Cliente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DaoCliente {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
    EntityManager em = emf.createEntityManager();

}
