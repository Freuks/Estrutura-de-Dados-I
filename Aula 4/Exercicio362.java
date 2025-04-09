import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Exercicio362 {
    public static void main(String[] args) {
        int[] vet1 = new int[10];
        int[] vet2 = new int[20];
        ArrayList<Integer> comuns = new ArrayList<>();

        for(int i = 0; i < 10; i++) {
            vet1[i] = Integer.parseInt(JOptionPane.showInputDialog(null, 
                "Digite o elemento " + (i+1) + " do Vetor 1 (10 elementos):"));
        }

        for(int i = 0; i < 20; i++) {
            vet2[i] = Integer.parseInt(JOptionPane.showInputDialog(null, 
                "Digite o elemento " + (i+1) + " do Vetor 2 (20 elementos):"));
        }

        for(int i = 0; i < 10; i++) {
            for(int c = 0; c < 20; c++) {
                if(vet1[i] == vet2[c] && !comuns.contains(vet1[i])) {
                    comuns.add(vet1[i]);
                    break;
                }
            }
        }

        StringBuilder resultado = new StringBuilder("Elementos comuns:\n\n");
        if(!comuns.isEmpty()) {
            for(int num : comuns) {
                resultado.append(num).append("\n");
            }
        } else {
            resultado.append("Nao existem elementos comuns");
        }

        JOptionPane.showMessageDialog(null, resultado.toString());
    }
}