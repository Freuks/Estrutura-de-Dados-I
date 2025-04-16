import javax.swing.JOptionPane;

public class Exercicio490 {
    public static void main(String[] args) {
        String[] nome = new String[10];
        
        for (int L = 0; L < 10; L++) {
            nome[L] = JOptionPane.showInputDialog("Digite palavra em letras minusculas " + (L + 1) + ": ");
            restantes(nome[L], nome[L].length(), 'c');
        }
        StringBuilder resultado = new StringBuilder();
        for (int L = 0; L < 10; L++) {
            resultado.append("\n").append(L + 1).append(" - ").append(nome[L]);
        }
        JOptionPane.showMessageDialog(null, resultado.toString());
    }
    static int restantes(String[] vet, int tam, char x) {
        int cont = 0;
        for (int i = 0; i < tam; i++) {
            if (vet[i].charAt(i) == x) {
                vet[i] = vet[i].substring(0, i) + '*' + vet[i].substring(i + 1);
                cont++;
            }
        }
        return cont;
    }
}