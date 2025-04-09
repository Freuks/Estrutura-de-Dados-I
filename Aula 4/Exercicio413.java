import javax.swing.JOptionPane;
import java.lang.Math;

public class Exercicio413 {
    public static void main(String[] args) {
        int[][] matriz = new int[5][5];
        int soma = 0;

        for(int l = 0; l < 5; l++) {
            for(int c = 0; c < 5; c++) {
                matriz[l][c] = Integer.parseInt(JOptionPane.showInputDialog(null, 
                    "Digite elemento " + (l+1) + "-" + (c+1) + ":"));
            }
        }

        StringBuilder matrizStr = new StringBuilder("Matriz completa:\n");
        for(int l = 0; l < 5; l++) {
            for(int c = 0; c < 5; c++) {
                matrizStr.append(matriz[l][c]).append("\t");
            }
            matrizStr.append("\n");
        }
        JOptionPane.showMessageDialog(null, matrizStr.toString());

        for(int l = 1; l < 5; l++) {
            for(int c = 5 - l; c < 5; c++) {
                if(matriz[l][c] % 2 != 0) {
                    soma += matriz[l][c] * matriz[l][c];
                }
            }
        }

        double resultado = Math.sqrt(soma);
        JOptionPane.showMessageDialog(null, 
            "Raiz quadrada da soma dos quadrados dos impares abaixo da DS: " + 
            String.format("%.2f", resultado));
    }
}