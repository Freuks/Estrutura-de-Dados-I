import javax.swing.JOptionPane;

public class Exercicio460 {
    public static void main(String[] args) {
        for (int c = 1; c <= 3; c++) {
            int a = Integer.parseInt(JOptionPane.showInputDialog("Digite numero: "));
            JOptionPane.showMessageDialog(null, "Dobro: " + dob(a));
        }
    }
    static int dob(int x) {
        return x * 2;
    }
}