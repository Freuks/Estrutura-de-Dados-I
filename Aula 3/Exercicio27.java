import javax.swing.JOptionPane;

public class Exercicio27 {
    public static void main(String[] args) {
        int x = 2;
        int y = 5;
        String mensagem = "x = " + x +
        "\ny = " + y;
        x++;
        y--;

        mensagem += "\n\nnovo valor de x = " + x +
        "\nnovo valor de y = " + y;
        JOptionPane.showMessageDialog(null, mensagem);
    }
}
