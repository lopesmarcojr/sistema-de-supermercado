package org.dao;

import org.model.OperadorDeCaixa;
import org.model.RecebedorDeMercadoria;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class DaoRM {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
    EntityManager em = emf.createEntityManager();

    Scanner sc = new Scanner(System.in);

    public void criarNovoRecebedor(Integer id, int matricula, String nome, String cpf, String email){
        RecebedorDeMercadoria recebedorDeMercadoria = new RecebedorDeMercadoria(null, matricula, nome, cpf, email);
        em.getTransaction().begin();
        em.persist(recebedorDeMercadoria);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    public void consultarRecebedor(int matricula){
        em.getTransaction().begin();
        RecebedorDeMercadoria recebedorDeMercadoria = em.find(RecebedorDeMercadoria.class, matricula);
        if(recebedorDeMercadoria != null){
            System.out.println(recebedorDeMercadoria);
        }
        else{
            System.out.println("Recebedor não encontrado");
        }
    }
    public void consultarRecebedores(){
        int id = 1;
        RecebedorDeMercadoria recebedorDeMercadoria = null;
        do{
            em.getTransaction().begin();
            recebedorDeMercadoria = em.find(RecebedorDeMercadoria.class, id);
            System.out.println(recebedorDeMercadoria);
            id++;
        }while(recebedorDeMercadoria != null);
    }

    public void atulizarDadosDeRecebedor(int matricula){
        em.getTransaction().begin();
        RecebedorDeMercadoria recebedorDeMercadoria = em.find(RecebedorDeMercadoria.class, matricula);
        if(recebedorDeMercadoria != null){
            System.out.println("Nome: ");
            String nome = sc.next();
            System.out.println("Matricula: ");
            int mat = sc.nextInt();
            System.out.println("CPF: ");
            String cpf = sc.next();
            recebedorDeMercadoria.setNome(nome);
            recebedorDeMercadoria.setCpf(cpf);
            recebedorDeMercadoria.setMatricula(mat);
            em.getTransaction().commit();
            System.out.println("Dados atualizados com sucesso");
        }
        else{
            System.out.println("Recebedor não encontrado");
        }
        em.close();
        emf.close();
    }

    public void removerRecebedor(int matricula){
        em.getTransaction().begin();
        RecebedorDeMercadoria recebedorDeMercadoria = em.find(RecebedorDeMercadoria.class, matricula);
        if(recebedorDeMercadoria != null){
            em.remove(recebedorDeMercadoria);
            em.getTransaction().commit();
            System.out.println("Recebedor removido com sucesso!");
        }
        else{
            System.out.println("Recebedor não encontrado");
        }
        em.close();
        emf.close();
    }

}
