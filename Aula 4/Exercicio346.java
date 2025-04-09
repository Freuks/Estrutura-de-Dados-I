import javax.swing.JOptionPane;

public class Exercicio346 {
    public static void main(String[] args) {
        String frase = "";
        int op;
        
        do {
            String menu = "MENU\n" +
            "1 - Imprime o comprimento da frase\n" +
            "2 - Imprime os dois primeiros e os dois ultimos caracteres da frase\n" +
            "3 - Imprime a frase espelhada\n" +
            "4 - Termina o algoritmo\n" +
            "OPCAO:";
            
            String opcao = JOptionPane.showInputDialog(null, menu);
            op = Integer.parseInt(opcao);
            
            switch (op) {
                case 1:
                    frase = JOptionPane.showInputDialog(null, "Digite uma frase:");
                    JOptionPane.showMessageDialog(null, "Numero de caracteres da frase: " + frase.length());
                    break;
                    
                case 2:
                    frase = JOptionPane.showInputDialog(null, "Digite uma frase:");
                    if (frase.length() >= 2) {
                        String doisPrimeiros = frase.substring(0, 2);
                        String doisUltimos = frase.substring(frase.length() - 2);
                        String resultado = "Os dois primeiros caracteres: " + doisPrimeiros + "\n" +
                        "Os dois ultimos caracteres: " + doisUltimos;
                        JOptionPane.showMessageDialog(null, resultado);
                    } else {
                        JOptionPane.showMessageDialog(null, "A frase precisa ter pelo menos 2 caracteres!");
                    }
                    break;
                    
                case 3:
                    frase = JOptionPane.showInputDialog(null, "Digite uma frase:");
                    String espelhada = "";
                    for (int i = frase.length() - 1; i >= 0; i--) {
                        espelhada += frase.charAt(i);
                    }
                    JOptionPane.showMessageDialog(null, "Frase espelhada: " + espelhada);
                    break;
                    
                case 4:
                    JOptionPane.showMessageDialog(null, "Fim do algoritmo");
                    break;
                    
                default:
                    JOptionPane.showMessageDialog(null, "Opcao nao disponivel");
            }
        } while (op != 4);
    }
}