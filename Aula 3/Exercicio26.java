import javax.swing.JOptionPane;

public class Exercicio26 {
    public static void main(String[] args) {
        int data = Integer.parseInt(JOptionPane.showInputDialog("Digite a data no formato DDMMAA:"));
        int dia = data / 10000;
        int mes = (data % 10000) / 100;
        int ano = data % 100;
        int ndata = mes * 10000 + dia * 100 + ano;

        String mensagem = "DIA: " + dia +
        "\nMES: " + mes +
        "\nANO: " + ano +
        "\n\nDATA NO FORMATO MMDDAA: " + ndata;
        JOptionPane.showMessageDialog(null, mensagem);
    }
}
