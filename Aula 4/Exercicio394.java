import javax.swing.JOptionPane;

public class Exercicio394 {
    public static void main(String[] args) {
        String[] nomes = new String[50];
        double[] nota1 = new double[50];
        double[] nota2 = new double[50];
        double[] media = new double[50];
        boolean nomesCadastrados = false;
        boolean notas1Cadastradas = false;
        boolean notas2Cadastradas = false;
        
        String op;
        do {
            op = JOptionPane.showInputDialog(null,
                "ESCOLA VIVA\n\n" +
                "1 - Entrar nomes\n" +
                "2 - Entrar 1ª nota\n" +
                "3 - Entrar 2ª nota\n" +
                "4 - Calcular média\n" +
                "5 - Listar no display\n" +
                "6 - Sair\n\n" +
                "OPCAO:");
            
            switch(op) {
                case "1":
                    for(int i = 0; i < 50; i++) {
                        nomes[i] = JOptionPane.showInputDialog(null, 
                            "Digite o " + (i+1) + " nome (máximo 30 caracteres):").toUpperCase();
                        while(nomes[i].length() > 30) {
                            nomes[i] = JOptionPane.showInputDialog(null, 
                                "Nome muito longo! Digite novamente o " + (i+1) + " nome (máximo 30 caracteres):").toUpperCase();
                        }
                    }
                    nomesCadastrados = true;
                    break;
                    
                case "2":
                    if(!nomesCadastrados) {
                        JOptionPane.showMessageDialog(null, "Nao ha nomes cadastrados!");
                        break;
                    }
                    for(int i = 0; i < 50; i++) {
                        nota1[i] = Double.parseDouble(JOptionPane.showInputDialog(null, 
                            "Digite a 1ª nota do aluno " + nomes[i] + ":"));
                    }
                    notas1Cadastradas = true;
                    break;
                    
                case "3":
                    if(!nomesCadastrados) {
                        JOptionPane.showMessageDialog(null, "Nao ha nomes cadastrados!");
                        break;
                    }
                    for(int i = 0; i < 50; i++) {
                        nota2[i] = Double.parseDouble(JOptionPane.showInputDialog(null, 
                            "Digite a 2ª nota do aluno " + nomes[i] + ":"));
                    }
                    notas2Cadastradas = true;
                    break;
                    
                case "4":
                    if(!nomesCadastrados || !notas1Cadastradas || !notas2Cadastradas) {
                        JOptionPane.showMessageDialog(null, "Nem todos os dados estao cadastrados!");
                        break;
                    }
                    for(int i = 0; i < 50; i++) {
                        media[i] = (3 * nota1[i] + 7 * nota2[i]) / 10;
                    }
                    JOptionPane.showMessageDialog(null, "Medias calculadas com sucesso!");
                    break;
                    
                case "5":
                    if(!nomesCadastrados || !notas1Cadastradas || !notas2Cadastradas) {
                        JOptionPane.showMessageDialog(null, "Nem todos os dados estao cadastrados!");
                        break;
                    }
                    StringBuilder lista = new StringBuilder("LISTA DE ALUNOS\n\n");
                    for(int i = 0; i < 50; i++) {
                        lista.append(nomes[i]).append("\t")
                            .append(nota1[i]).append("\t")
                            .append(nota2[i]).append("\t")
                            .append(String.format("%.1f", media[i])).append("\n");
                    }
                    JOptionPane.showMessageDialog(null, lista.toString());
                    break;
                    
                case "6":
                    break;
                    
                default:
                    JOptionPane.showMessageDialog(null, "Opcao invalida!");
            }
        } while(!op.equals("6"));
    }
}