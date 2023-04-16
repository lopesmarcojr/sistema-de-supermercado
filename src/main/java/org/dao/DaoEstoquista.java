package org.dao;

import jdk.swing.interop.SwingInterOpUtils;
import org.model.Estoquista;
import org.model.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DaoEstoquista {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
    EntityManager em = emf.createEntityManager();
    Scanner sc = new Scanner(System.in);

    public void cadastrarNovoEstoquista(Integer matricula, String nome, String cpf, String email){
        Estoquista estoquista = new Estoquista(null, matricula, nome, cpf, email);
        em.getTransaction().begin();
        em.persist(estoquista);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    public void consultarEstoquista(Integer matricula){
        em.getTransaction().begin();
        Estoquista estoquista = em.find(Estoquista.class, matricula);
        if(estoquista.equals(null)){
            System.out.println("Estoquista não encontrado");
        }
        else{
            System.out.println(estoquista.getNome());
            System.out.println(estoquista.getMatricula());
            System.out.println(estoquista.getEmail());
        }
    }

    public void listarEstoquistas(){

    }
    public void atualizarDadosDeEstoquista(Integer matricula){
        em.getTransaction().begin();
        Estoquista estoquista = em.find(Estoquista.class, matricula);
        if(estoquista.equals(null)){
            System.out.println("Estoquista não encontrado");
        }
        else{
            System.out.println("Matrícula: ");
            Integer mat = sc.nextInt();
            System.out.println("Nome: ");
            String nome = sc.next();
            System.out.println("CPF: ");
            String cpf = sc.next();
            System.out.println("Email: ");
            String email = sc.next();
            estoquista.setNome(nome);
            estoquista.setCpf(cpf);
            estoquista.setMatricula(mat);
            estoquista.setEmail(email);
            em.getTransaction().commit();

        }
        em.close();
        emf.close();
    }
    public void removerEstoquista(Integer matricula){
        em.getTransaction().begin();
        Estoquista estoquista = em.find(Estoquista.class, matricula);
        if(estoquista.equals(null)){
            System.out.println("Estoquista não encontrado");
        }
        else{
            em.remove(estoquista);
            em.getTransaction().commit();
        }
        em.close();
        emf.close();
    }
}
