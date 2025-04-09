import javax.swing.JOptionPane;

public class Exercicio348 {
    public static void main(String[] args) {
        String[] nomes = new String[5];
        double[] pr1 = new double[5];
        double[] pr2 = new double[5];
        double[] media = new double[5];

        for (int L = 0; L <= 4; L++) {
            nomes[L] = JOptionPane.showInputDialog(null, "Digite o " + (L + 1) + " nome:");
            pr1[L] = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite a nota 1 do aluno " + nomes[L] + ":"));
            pr2[L] = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite a nota 2 do aluno " + nomes[L] + ":"));
            media[L] = (pr1[L] + pr2[L]) / 2;
        }

        String relatorio = "RELACAO FINAL\n\n";
        for (int L = 0; L <= 4; L++) {
            relatorio += (L + 1) + "- " + nomes[L] + "\n" +
            "Nota 1:  " + pr1[L] + "\tNota 2: " + pr2[L] + "\tMedia: " + media[L] + "\n\n";
        }
        JOptionPane.showMessageDialog(null, relatorio);
    }
}