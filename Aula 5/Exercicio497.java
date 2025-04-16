import javax.swing.JOptionPane;
import java.util.Arrays;

public class Exercicio497 {
    public static void main(String[] args) {
        int[] nun = new int[10];
        
        for (int l = 0; l < 10; l++) {
            nun[l] = Integer.parseInt(JOptionPane.showInputDialog("Digite numero " + (l + 1) + ": "));
        }
        int n = Integer.parseInt(JOptionPane.showInputDialog("Digite numero de busca: "));
        ordena(nun);
        int cc = busca(nun, nun.length, n);
        
        StringBuilder vetor = new StringBuilder("VETOR\n");
        for (int l = 0; l < 10; l++) {
            vetor.append("\n").append(l + 1).append(" - ").append(nun[l]);
        }
        
        if (cc >= 0) {
            vetor.append("\n\nposicao no vetor: ").append(cc + 1);
        } else {
            vetor.append("\n\nNAO ENCONTRADO");
        }
        JOptionPane.showMessageDialog(null, vetor.toString());
    }
    static int busca(int[] vet, int tam, int chave) {
        int ini = 0;
        int fim = tam - 1;
        
        while (ini <= fim) {
            int meio = (ini + fim) / 2;
            if (chave == vet[meio]) {
                return meio;
            } else if (chave < vet[meio]) {
                fim = meio - 1;
            } else {
                ini = meio + 1;
            }
        }
        return -1;
    }
    static void ordena(int[] vet) {
        Arrays.sort(vet);
    }
}