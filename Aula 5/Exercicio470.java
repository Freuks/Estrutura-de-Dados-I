import javax.swing.JOptionPane;

public class Exercicio470 {
    public static void main(String[] args) {
        int num = Integer.parseInt(JOptionPane.showInputDialog("Digite um numero >0: "));
        int pri = primo(num);
        
        if (pri == 0) {
            JOptionPane.showMessageDialog(null, num + " e primo");
        } else {
            JOptionPane.showMessageDialog(null, num + " nao e primo");
        }
    }
    static int primo(int n) {
        int c = 0;
        int p = 2;
        
        while (c == 0 && p <= n / 2) {
            if (n % p == 0) {
                c = 1;
            }
            p++;
        }
        return c;
    }
}