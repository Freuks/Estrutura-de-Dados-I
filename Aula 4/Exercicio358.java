import javax.swing.JOptionPane;

public class Exercicio358 {
    public static void main(String[] args) {
        double[] precocompra = new double[100];
        double[] precovenda = new double[100];
        int totlucromenor10 = 0;
        int totlucromenor20 = 0;
        int totlucromaior20 = 0;

        for (int A = 0; A < 100; A++) {
            precocompra[A] = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o preco de compra da mercadoria " + (A + 1) + ":"));
            precovenda[A] = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o preco de venda da mercadoria " + (A + 1) + ":"));
        }

        for (int A = 0; A < 100; A++) {
            double lucro = ((precovenda[A] - precocompra[A]) / precocompra[A]) * 100;

            if (lucro < 10.0) {
                totlucromenor10++;
            } else if (lucro <= 20.0) {
                totlucromenor20++;
            } else {
                totlucromaior20++;
            }
        }

        String resultado = "RELATORIO DE LUCROS\n\n" +
        "Total com lucro < 10%: " + totlucromenor10 + "\n" +
        "Total com 10% <= lucro <= 20%: " + totlucromenor20 + "\n" +
        "Total com lucro > 20%: " + totlucromaior20;

        JOptionPane.showMessageDialog(null, resultado);
    }
}