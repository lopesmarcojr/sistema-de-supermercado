package org.example;



import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        long numeroDoCartao = Math.abs(random.nextLong());
        String numero = String.valueOf(numeroDoCartao);
        String primeiraSecao = numero.substring(0,4);
        String segundaSecao = numero.substring(4,8);
        String terceiraSecao = numero.substring(9,13);
        String quartaSecao = numero.substring(14,18);
        System.out.println(numero);
        System.out.println(primeiraSecao);
        System.out.println(segundaSecao);
        System.out.println(terceiraSecao);
        System.out.println(quartaSecao);
        System.out.println(Integer.parseInt(primeiraSecao));
        Random randomMonths = ThreadLocalRandom.current();
        LocalDateTime date = LocalDateTime.now().plusMonths(randomMonths.nextInt(365) + 1);
        Date data = Date.from(date.atZone(ZoneId.of("America/Sao_Paulo")).toInstant());
        System.out.println(data);
    }
}