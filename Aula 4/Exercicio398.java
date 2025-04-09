import javax.swing.JOptionPane;
import java.util.Arrays;
import java.util.Comparator;

public class Exercicio398 {
    public static void main(String[] args) {
        int[] codigos = new int[50];
        int[] quantidades = new int[50];
        double[] precos = new double[50];
        int k = 0;
        double totalVendas = 0.0;

        while(k < 50) {
            String input = JOptionPane.showInputDialog(null, "Digite o codigo do produto (-1 para encerrar cadastro):");
            int codigo = Integer.parseInt(input);
            
            if(codigo == -1) break;
            
            codigos[k] = codigo;
            quantidades[k] = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a quantidade do produto " + codigo + ":"));
            precos[k] = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o preco do produto " + codigo + ":"));
            k++;
        }

        while(true) {
            String input = JOptionPane.showInputDialog(null, "Digite o codigo do produto para venda (0 para encerrar):");
            int codVenda = Integer.parseInt(input);
            
            if(codVenda == 0) break;
            
            boolean encontrado = false;
            for(int i = 0; i < k; i++) {
                if(codigos[i] == codVenda) {
                    encontrado = true;
                    int qtdVenda = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a quantidade para venda:"));
                    
                    if(quantidades[i] >= qtdVenda) {
                        quantidades[i] -= qtdVenda;
                        double valorVenda = qtdVenda * precos[i];
                        totalVendas += valorVenda;
                        JOptionPane.showMessageDialog(null, "Venda realizada!\nValor: R$ " + String.format("%.2f", valorVenda));
                    } else {
                        JOptionPane.showMessageDialog(null, "Estoque insuficiente!");
                    }
                    break;
                }
            }
            
            if(!encontrado) {
                JOptionPane.showMessageDialog(null, "Produto nao cadastrado!");
            }
        }

        Integer[] indices = new Integer[k];
        for(int i = 0; i < k; i++) indices[i] = i;
        
        Arrays.sort(indices, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return Integer.compare(quantidades[b], quantidades[a]);
            }
        });

        StringBuilder relatorio = new StringBuilder();
        relatorio.append("RELATORIO FINAL\n\n");
        relatorio.append("Total vendido no dia: R$ ").append(String.format("%.2f", totalVendas)).append("\n\n");
        relatorio.append("ESTOQUE ATUAL (ordenado por quantidade)\n");
        relatorio.append("CODIGO\tQUANTIDADE\tPRECO\n");
        
        for(int i = 0; i < k; i++) {
            int idx = indices[i];
            relatorio.append(codigos[idx]).append("\t")
                    .append(quantidades[idx]).append("\t\t")
                    .append("R$ ").append(String.format("%.2f", precos[idx])).append("\n");
        }

        JOptionPane.showMessageDialog(null, relatorio.toString());
    }
}