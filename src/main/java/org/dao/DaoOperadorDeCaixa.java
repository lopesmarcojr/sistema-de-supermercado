package org.dao;

import org.model.OperadorDeCaixa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class DaoOperadorDeCaixa {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
    EntityManager em = emf.createEntityManager();
    Scanner sc = new Scanner(System.in);

    public void criarOperadorDeCaixa(Integer id, int matricula, String nome, String cpf, String email){
        OperadorDeCaixa operadorDeCaixa = new OperadorDeCaixa(null, matricula, nome, cpf, email);
        em.getTransaction().begin();
        em.persist(operadorDeCaixa);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    public void consultarOperadorDeCaixa(int matricula){
        em.getTransaction().begin();
        OperadorDeCaixa operadorDeCaixa = em.find(OperadorDeCaixa.class, matricula);
        if(operadorDeCaixa != null){
            System.out.println(operadorDeCaixa);
        }
        else {
            System.out.println("Operador de caixa não cadastrado");
        }
    }
    public void consultarOperadores(){
        em.getTransaction().begin();
        int id = 1;
        OperadorDeCaixa operadorDeCaixa = null;
        do{
            operadorDeCaixa = em.find(OperadorDeCaixa.class, id);
            System.out.println(operadorDeCaixa);
            id++;
        }while(operadorDeCaixa != null);
    }
    public void atualizarDadosDeOperador(int matricula){
        em.getTransaction().begin();
        OperadorDeCaixa operadorDeCaixa = em.find(OperadorDeCaixa.class, matricula);
        if(operadorDeCaixa != null){
            System.out.println("Nome: ");
            String nome = sc.next();
            System.out.println("Matricula: ");
            int mat = sc.nextInt();
            System.out.println("CPF: ");
            String cpf = sc.next();
            operadorDeCaixa.setNome(nome);
            operadorDeCaixa.setMatricula(mat);
            operadorDeCaixa.setCpf(cpf);
            em.getTransaction().commit();
        }
        em.close();
        emf.close();
    }
    public void removerOperador(int matricula){
        em.getTransaction().begin();
        OperadorDeCaixa operadorDeCaixa = em.find(OperadorDeCaixa.class, matricula);
        if(operadorDeCaixa != null){
            em.remove(operadorDeCaixa);
            System.out.println("Operador de caixa removido com sucesso!");
        }
        else{
            System.out.println("Operador de caixa não cadastrado");
        }
        em.close();
        emf.close();
    }




}
