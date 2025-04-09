import javax.swing.JOptionPane;

public class Exercicio370 {
    public static void main(String[] args) {
        int nv = Integer.parseInt(JOptionPane.showInputDialog(null, "Entre com o numero de voos:"));
        String[] nomeVoo = new String[nv];
        int[] lugares = new int[nv];

        for(int i = 0; i < nv; i++) {
            nomeVoo[i] = JOptionPane.showInputDialog(null, "Entre com a identificacao do voo " + (i+1) + ":");
            lugares[i] = Integer.parseInt(JOptionPane.showInputDialog(null, 
            "Entre com a quantidade de lugares disponiveis no voo " + nomeVoo[i] + ":"));
        }

        String nvd;
        do {
            nvd = JOptionPane.showInputDialog(null, 
                "Entre com o numero do voo desejado ou escreva Sair para terminar:");
            
            if(!nvd.equals("Sair")) {
                boolean vooEncontrado = false;
                
                for(int i = 0; i < nv; i++) {
                    if(nvd.equals(nomeVoo[i])) {
                        vooEncontrado = true;
                        if(lugares[i] > 0) {
                            lugares[i]--;
                            String id = JOptionPane.showInputDialog(null, "Qual o numero da identidade do cliente?");
                            JOptionPane.showMessageDialog(null, 
                                "Identidade: " + id + "\nVoo: " + nvd + 
                                "\nLugares restantes: " + lugares[i]);
                        } else {
                            JOptionPane.showMessageDialog(null, "Nao existem mais lugares neste voo.");
                        }
                        break;
                    }
                }
                
                if(!vooEncontrado) {
                    JOptionPane.showMessageDialog(null, "Nao existe este voo");
                }
            }
        } while(!nvd.equals("Sair"));
    }
}