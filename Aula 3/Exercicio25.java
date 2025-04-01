import javax.swing.JOptionPane;

public class Exercicio25 {
    public static void main(String[] args) {
        int data = Integer.parseInt(JOptionPane.showInputDialog("Digite a data no formato DDMMAA:"));
        int dia = data / 10000;
        int mes = (data % 10000) / 100;
        int ano = data % 100;

        String mensagem = "DIA: " + dia +
        "\nMES: " + mes +
        "\nANO: " + ano;
        JOptionPane.showMessageDialog(null, mensagem);
    }
}
