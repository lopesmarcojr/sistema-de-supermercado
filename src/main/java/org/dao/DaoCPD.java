package org.dao;

import org.model.CPD;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DaoCPD {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
    EntityManager em = emf.createEntityManager();

    public void criarnovoCPD(int matricula, String nome, String cpf, String email){
        CPD cpd = new CPD(null, matricula, nome, cpf, email);
        em.getTransaction().begin();
        em.persist(cpd);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    public void consultarCPD(int matricula){
        em.getTransaction().begin();
        CPD c = em.find(CPD.class, matricula);
        if(c.equals(null)){
            System.out.println("CPD não encontrado no sistema");
        }
        else{
            System.out.println(c);
        }
    }
    public void listarCPDS(){
        int id = 1;
        CPD c = null;
        do{
            em.getTransaction().begin();
            c = em.find(CPD.class, id);
            id++;
            System.out.println(c);
        }while(c != null);
    }

    public void removerCPD(int matricula){
        em.getTransaction().begin();
        CPD c = em.find(CPD.class, matricula);
        if(c != null){
            em.remove(c);
            System.out.println("CPD removido do sistema com sucesso!");
            em.getTransaction().commit();
        }
        else{
            System.out.println("CPD não encontrado no sistema");
        }
        em.close();
        emf.close();
    }
}
