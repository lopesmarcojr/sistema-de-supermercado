package org.dao;

import org.model.CartaoDeCredito;
import org.model.Cliente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DaoCadastro implements Serializable {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
    EntityManager em = emf.createEntityManager();
    List<Cliente> clientes = new ArrayList<>();


    public void cadastrarNovoCliente(String nome, String cpf, String email){
        Cliente cliente  = new Cliente(null, nome, cpf, email);
        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();
        clientes.add(cliente);
        em.close();
        emf.close();
    }

    public void cadastrarNovoCartão(){
        Random random = new Random();
        long numeroDoCartao = Math.abs(random.nextLong());
        String numero = String.valueOf(numeroDoCartao);
        String primeiraSecao = numero.substring(0,4);
        String segundaSecao = numero.substring(4,8);
        String terceiraSecao = numero.substring(9,13);
        String quartaSecao = numero.substring(14,18);
        int numeroDeSegurança = random.nextInt(999);
        double limite = 1000;
        String bandeira = "Padrão";
        if(Integer.parseInt(primeiraSecao.substring(0)) == 4){
            bandeira = "Visa";
        }
        if(Integer.parseInt(primeiraSecao.substring(0,2)) >= 51 && 55 <= Integer.parseInt(primeiraSecao.substring(0,2))){
            bandeira = "Mastercard";
        }
        CartaoDeCredito cartaoDeCredito = new CartaoDeCredito(null, );

    }
}
