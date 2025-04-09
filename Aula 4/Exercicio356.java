import javax.swing.JOptionPane;

public class Exercicio356 {
    public static void main(String[] args) {
        String[] nomes = new String[15];
        double[] pr1 = new double[15];
        double[] pr2 = new double[15];
        int[] media = new int[15];
        String[] sit = new String[15];
        StringBuilder relatorio = new StringBuilder("RELACAO FINAL\n\n");

        for (int L = 0; L <= 14; L++) {
            nomes[L] = JOptionPane.showInputDialog(null, "Digite o " + (L + 1) + " nome:");
            while (nomes[L].length() > 30) {
                nomes[L] = JOptionPane.showInputDialog(null, "Nomes com ate 30 caracteres!\nDigite novamente o " + (L + 1) + " nome:");
            }

            pr1[L] = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite a nota 1 do aluno " + nomes[L] + ":"));
            pr2[L] = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite a nota 2 do aluno " + nomes[L] + ":"));

            media[L] = (int) Math.round((pr1[L] + pr2[L]) / 2);
            sit[L] = (media[L] >= 5) ? "AP" : "RP";
        }

        for (int L = 0; L <= 14; L++) {
            relatorio.append(String.format("%2d- %-30s\t%.1f\t%.1f\t%d\t%s\n", 
                L + 1, nomes[L], pr1[L], pr2[L], media[L], sit[L]));
        }

        JOptionPane.showMessageDialog(null, relatorio.toString());
    }
}