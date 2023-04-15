package org.dao;

import org.model.CartaoDeCredito;
import org.model.Cliente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.xml.crypto.Data;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class DaoCadastro implements Serializable {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
    EntityManager em = emf.createEntityManager();
    List<Cliente> clientes = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    public void cadastrarNovoCliente(String nome, String cpf, String email){
        Cliente cliente  = new Cliente(null, nome, cpf, email);
        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();
        clientes.add(cliente);
        em.close();
        emf.close();
    }
    public void cadastrarNovoCartão(String cpf){
        Random random = new Random();
        long numeroDoCartao = Math.abs(random.nextLong());
        int numeroDeSegurança = random.nextInt(999);
        double limite = 1000;
        String bandeira = "Mastercard";
        Data validadeDoCartao = null;
        Random randomMonths = ThreadLocalRandom.current();
        LocalDateTime date = LocalDateTime.now().plusMonths(randomMonths.nextInt(365) + 1);
        java.util.Date data = Date.from(date.atZone(ZoneId.of("America/Sao_Paulo")).toInstant());
        CartaoDeCredito cartaoDeCredito = new CartaoDeCredito(null, limite, bandeira, numeroDoCartao, numeroDeSegurança, data);
        em.getTransaction().begin();
        Cliente cliente = em.find(Cliente.class, cpf);
        if(cliente.equals(null)){
            System.out.println("Não é possível cadastrar esse cartão ao cliente, pois o cliente não existe");
        }
        else{
            cliente.setCartaoDeCredito(cartaoDeCredito);
        }
    }
    public void atualizarDadosCadastrais(String cpf){
        em.getTransaction().begin();
        Cliente cliente = em.find(Cliente.class,cpf);
        if(cliente.equals(null)){
            System.out.println("Cliente não encontrado no sistema");
        }
        else{
            System.out.println("Nome: ");
            String nome = sc.next();
            System.out.println("CPF: ");
            String cpfCliente = sc.next();
            System.out.println("Email: ");
            String email = sc.next();
            cliente.setNome(nome);
            cliente.setEmail(email);
            cliente.setCpf(cpf);
            em.getTransaction().commit();
            em.close();
            emf.close();
        }
    }
    public void consultarCliente(String cpf){
        em.getTransaction().begin();
        Cliente cliente = em.find(Cliente.class,cpf);
        if(cliente.equals(null)){
            System.out.println("Cliente não encontrado no sistema");
        }
        else{
            System.out.println(cliente.getNome());
            System.out.println(cliente.getCpf());
            System.out.println(cliente.getEmail());
        }
    }
    public void removerCliente(String cpf){
        em.getTransaction().begin();
        Cliente cliente = em.find(Cliente.class,cpf);
        if(cliente.equals(null)){
            System.out.println("Cliente não encontrado no sistema");
        }
        else{
            em.remove(cliente);
            em.getTransaction().commit();
        }
        em.close();
        emf.close();
    }
    public void cancelarCartao(){

    }
}
