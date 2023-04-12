package org.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DaoCPD {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
    EntityManager em = emf.createEntityManager();
}
