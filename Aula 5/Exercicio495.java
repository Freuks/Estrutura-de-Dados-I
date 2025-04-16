import javax.swing.JOptionPane;
import java.util.Arrays;

public class Exercicio495 {
    public static void main(String[] args) {
        String[] nomes = new String[5];
        
        for (int i = 0; i < 5; i++) {
            nomes[i] = JOptionPane.showInputDialog("Digite nome " + (i + 1) + ": ");
        }
        ordena(nomes);
        
        StringBuilder resultado = new StringBuilder("NOMES ORDENADOS\n");
        for (int i = 0; i < 5; i++) {
            resultado.append("\n").append(i + 1).append(" - ").append(nomes[i]);
        }
        JOptionPane.showMessageDialog(null, resultado.toString());
    }
    static void ordena(String[] vet) {
        Arrays.sort(vet);
    }
}