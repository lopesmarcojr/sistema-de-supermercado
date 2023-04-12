package org.example;


import java.lang.annotation.Native;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        long numeroDoCartao = Math.abs(random.nextLong());
        String numero = String.valueOf(numeroDoCartao);
        String primeiraSecao = numero.substring(0,2);
        String segundaSecao = numero.substring(4,8);
        String terceiraSecao = numero.substring(9,13);
        String quartaSecao = numero.substring(14,18);
        System.out.println(numero);
        System.out.println(primeiraSecao);
        System.out.println(segundaSecao);
        System.out.println(terceiraSecao);
        System.out.println(quartaSecao);
        System.out.println(Integer.parseInt(primeiraSecao));
    }
}