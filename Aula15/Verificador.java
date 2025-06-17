

import java.util.Scanner;

public class Verificador {

    public static boolean expressaoEstaCorreta(String expressao) {
        PilhaDinamica pilha = new PilhaDinamica();

        for (char c : expressao.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                pilha.push(c);
            }
            else if (c == ')' || c == ']' || c == '}') {
                if (pilha.isEmpty()) {
                    return false;
                }

                char topo = pilha.pop();

                if (c == ')' && topo != '(') {
                    return false;
                }
                if (c == ']' && topo != '[') {
                    return false;
                }
                if (c == '}' && topo != '{') {
                    return false;
                }
            }
        }

        return pilha.isEmpty();
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("-Verificador de Parametrizacao de Expressoes-");
        System.out.println("Digite uma expressão para verificar ou 'sair' para terminar.");

        while (true) {
            System.out.print("\n> ");
            String linha = teclado.nextLine();

            if (linha.equalsIgnoreCase("sair")) {
                break;
            }

            if (expressaoEstaCorreta(linha)) {
                System.out.println("Resultado: Expressao CORRETA");
            } else {
                System.out.println("Resultado: Expressao INCORRETA");
            }
        }

        teclado.close();
        System.out.println("Programa finalizado.");
    }
}