import javax.swing.JOptionPane;

public class Exercicio480 {
    public static void main(String[] args) {
        int n = Integer.parseInt(JOptionPane.showInputDialog("Digite numero: "));
        int x = reverse(n);
        
        String resultado = n + " - " + x;
        if (x == n) {
            resultado += "\nE um numero capicua";
        } else {
            resultado += "\nNao e um numero capicua";
        }
        JOptionPane.showMessageDialog(null, resultado);
    }
    static int reverse(int num) {
        int soma = 0;
        while (num != 0) {
            int r = num % 10;
            soma = soma * 10 + r;
            num = num / 10;
        }
        return soma;
    }
}