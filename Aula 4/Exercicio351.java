import javax.swing.JOptionPane;

public class Exercicio351 {
    public static void main(String[] args) {
        String[] nomes = new String[5];
        int num;

        for (int L = 0; L <= 4; L++) {
            nomes[L] = JOptionPane.showInputDialog(null, "Digite o nome " + (L + 1) + ":");
        }

        do {
            String input = JOptionPane.showInputDialog(null, 
                "Digite o numero da pessoa (1 a 5):\n" +
                "1: " + nomes[0] + "\n" +
                "2: " + nomes[1] + "\n" +
                "3: " + nomes[2] + "\n" +
                "4: " + nomes[3] + "\n" +
                "5: " + nomes[4]);
            num = Integer.parseInt(input);

            if (num < 1 || num > 5) {
                JOptionPane.showMessageDialog(null, "Numero fora do intervalo! Tente novamente.");
            }
        } while (num < 1 || num > 5);

        JOptionPane.showMessageDialog(null, "Nome selecionado: " + nomes[num - 1]);
    }
}