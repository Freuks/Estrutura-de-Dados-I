import javax.swing.JOptionPane;

public class Exercicio23 {
    public static void main(String[] args) {
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite um numero de tres casas:"));
        int dezena = (numero / 10) % 10;
        JOptionPane.showMessageDialog(null, "Algarismo da casa das dezenas: " + dezena);
    }
}
