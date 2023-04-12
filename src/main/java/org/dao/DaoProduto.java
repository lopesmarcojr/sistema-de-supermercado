package org.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DaoProduto<E> {

    private static EntityManagerFactory emf;
    private EntityManager em;

    static {
        try{
            emf = Persistence.createEntityManagerFactory("exemplo-jpa");
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
