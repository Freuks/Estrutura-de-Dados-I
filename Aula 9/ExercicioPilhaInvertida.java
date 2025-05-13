import java.util.Scanner;
import java.util.Stack;

public class InverterPalavrasTempoReal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String linha, invertida;
        
        System.out.println("Digite uma frase:");

        while (true) {
            linha = scanner.nextLine();
            if (linha.isEmpty()) {
                break;
            }
            invertida = inverterLetras(linha);
            System.out.println("Invertido: " + invertida);
        }
        
        scanner.close();
        System.out.println("Programa encerrado.");
    }

    public static String inverterLetras(String frase) {
        Stack<Character> pilha = new Stack<>();
        StringBuilder resultado = new StringBuilder();
        char c;
        int i;
        
        for (i = 0; i < frase.length(); i++) {
            c = frase.charAt(i);
            
            if (c != ' ') {
                pilha.push(c);
            } else {
                while (!pilha.isEmpty()) {
                    resultado.append(pilha.pop());
                }
                resultado.append(' ');
            }
        }
        
        while (!pilha.isEmpty()) {
            resultado.append(pilha.pop());
        }
        
        return resultado.toString();
    }
}