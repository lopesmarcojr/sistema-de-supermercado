package org.dao;

import com.mysql.cj.xdevapi.Client;
import org.model.Cliente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class DaoCliente {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
    EntityManager em = emf.createEntityManager();

    List<Cliente> clientes = new ArrayList<>();

    public void criarCliente(int id, String nome, String cpf, String email, int registro){
        Cliente cliente = new Cliente(null, nome, cpf, email, registro);
        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    public void consultarCliente(int registro){
        em.getTransaction().begin();
        Cliente cliente = em.find(Cliente.class, registro);
        if(cliente != null){
            System.out.println(cliente);
        }
        else{
            System.out.println("Cliente não encontrado");
        }
        em.close();
        emf.close();
    }

    public void listarClientes(){
        int id = 1;
        em.getTransaction().begin();
        Cliente cliente = null;
        do{
            cliente = em.find(Cliente.class, 1);
            clientes.add(cliente);
            id++;
        }while(cliente != null);
        for(Cliente c : clientes){
            System.out.println(c);
        }
    }

    public void deletarCliente(int registro){
        em.getTransaction().begin();
        Cliente cliente = em.find(Cliente.class, registro);
        if(cliente != null){
            em.remove(cliente);
            System.out.println("Cliente removido com sucesso do sistema");
        }
        else{
            System.out.println("Cliente não encontrado");
        }
        em.close();
        emf.close();
    }
}
