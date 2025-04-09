import javax.swing.JOptionPane;

public class Exercicio354 {
    public static void main(String[] args) {
        int[] num = new int[15];
        StringBuilder relatorio = new StringBuilder("RELACAO DOS NUMEROS\n\n");

        for (int L = 0; L <= 14; L++) {
            num[L] = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o " + (L + 1) + " numero:"));
        }

        for (int L = 0; L <= 14; L++) {
            relatorio.append(L + 1).append("- ").append(num[L]);
            if (num[L] % 2 == 0) {
                relatorio.append(" PAR\n");
            } else {
                relatorio.append(" IMPAR\n");
            }
        }

        JOptionPane.showMessageDialog(null, relatorio.toString());
    }
}