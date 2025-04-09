import javax.swing.JOptionPane;

public class Exercicio400 {
    public static void main(String[] args) {
        int[] leitos = new int[50];
        int[] nd = new int[50];
        String[] sit = new String[50];
        String[] din = new String[50];
        String[] dout = new String[50];
        String[] nome = new String[50];
        String[] tel = new String[50];
        double[] precos = new double[50];
        double[] despesas = new double[50];
        boolean chave = false;
        
        int op;
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Hotel-Fazenda Sucesso\n\n" +
                "1. Cadastra quartos\n" +
                "2. Lista todos os quartos\n" +
                "3. Lista quartos ocupados\n" +
                "4. Aluguel/reserva quarto\n" +
                "5. Entra despesas extras\n" +
                "6. Calcula despesa do quarto\n" +
                "7. Sai\n\n" +
                "Opcao:"));
            
            switch(op) {
                case 1:
                    if(chave) {
                        JOptionPane.showMessageDialog(null, "Atencao. Dados ja cadastrados");
                    } else {
                        for(int i = 0; i < 50; i++) {
                            leitos[i] = Integer.parseInt(JOptionPane.showInputDialog(null, 
                                "Quantidade de leitos para o quarto " + (i+1) + ":"));
                            precos[i] = Double.parseDouble(JOptionPane.showInputDialog(null, 
                                "Preco do quarto " + (i+1) + ":"));
                            sit[i] = "L";
                            nd[i] = 0;
                            despesas[i] = 0;
                            din[i] = "XXXX";
                            dout[i] = "XXXX";
                            nome[i] = "";
                            tel[i] = "";
                        }
                        chave = true;
                    }
                    break;
                    
                case 2:
                    if(!chave) {
                        JOptionPane.showMessageDialog(null, "Escolha a opcao 1 primeiro");
                    } else {
                        StringBuilder lista = new StringBuilder();
                        for(int i = 0; i < 50; i++) {
                            lista.append("\nQuarto: ").append(i+1)
                                .append("\nSituacao: ").append(sit[i].equals("L") ? "Livre" : 
                                    sit[i].equals("A") ? "Alugado" : "Reservado");
                            
                            if(sit[i].equals("A") || sit[i].equals("R")) {
                                lista.append("\nNome: ").append(nome[i])
                                    .append("\nTelefone: ").append(tel[i])
                                    .append("\nLeitos: ").append(leitos[i])
                                    .append("\nPreco: R$").append(precos[i])
                                    .append("\nDespesas: R$").append(despesas[i])
                                    .append("\nEntrada: ").append(din[i])
                                    .append("\nSaida: ").append(dout[i])
                                    .append("\nDias: ").append(nd[i]);
                            }
                            lista.append("\n-------------------");
                        }
                        JOptionPane.showMessageDialog(null, lista.toString());
                    }
                    break;
                    
                case 3:
                    if(!chave) {
                        JOptionPane.showMessageDialog(null, "Escolha a opcao 1 primeiro");
                    } else {
                        StringBuilder ocupados = new StringBuilder("Quartos Ocupados:\n");
                        for(int i = 0; i < 50; i++) {
                            if(sit[i].equals("A")) {
                                ocupados.append("\nQuarto: ").append(i+1)
                                    .append("\nDespesas: R$").append(despesas[i])
                                    .append("\nEntrada: ").append(din[i])
                                    .append("\nSaida: ").append(dout[i])
                                    .append("\nDias: ").append(nd[i])
                                    .append("\n-------------------");
                            }
                        }
                        JOptionPane.showMessageDialog(null, ocupados.toString());
                    }
                    break;
                    
                case 4:
                    if(!chave) {
                        JOptionPane.showMessageDialog(null, "Escolha a opcao 1 primeiro");
                    } else {
                        String resp = JOptionPane.showInputDialog(null, 
                            "Digite A (aluguel) ou R (reserva):").toUpperCase();
                        
                        while(!resp.equals("A") && !resp.equals("R")) {
                            resp = JOptionPane.showInputDialog(null, 
                                "Resposta invalida. Digite A (aluguel) ou R (reserva):").toUpperCase();
                        }
                        
                        if(resp.equals("A")) {
                            String resp1 = JOptionPane.showInputDialog(null, 
                                "Tinha reserva? (S/N)").toUpperCase();
                            
                            if(resp1.equals("S")) {
                                String nonep = JOptionPane.showInputDialog(null, "Entre com nome:");
                                int i = 0;
                                while(i < 49 && !nonep.equals(nome[i])) {
                                    i++;
                                }
                                
                                if(nonep.equals(nome[i])) {
                                    sit[i] = "A";
                                    despesas[i] = 0;
                                    din[i] = JOptionPane.showInputDialog(null, "Data de entrada:");
                                    dout[i] = JOptionPane.showInputDialog(null, "Data de saida:");
                                    nd[i] = Integer.parseInt(JOptionPane.showInputDialog(null, "Numero de dias:"));
                                } else {
                                    JOptionPane.showMessageDialog(null, "Reserva nao encontrada");
                                }
                            }
                        }
                        
                        StringBuilder disponiveis = new StringBuilder("Quartos Livres:\n");
                        for(int i = 0; i < 50; i++) {
                            if(sit[i].equals("L")) {
                                disponiveis.append("\nQuarto: ").append(i+1)
                                    .append("\nLeitos: ").append(leitos[i])
                                    .append("\nPreco: R$").append(precos[i])
                                    .append("\n-------------------");
                            }
                        }
                        
                        int quarto = Integer.parseInt(JOptionPane.showInputDialog(null, 
                            disponiveis.toString() + "\nDigite o numero do quarto:"));
                        
                        while(quarto < 1 || quarto > 50 || !sit[quarto-1].equals("L")) {
                            quarto = Integer.parseInt(JOptionPane.showInputDialog(null, 
                                "Quarto invalido ou ocupado. Digite novamente:"));
                        }
                        
                        sit[quarto-1] = resp.equals("A") ? "A" : "R";
                        nome[quarto-1] = JOptionPane.showInputDialog(null, "Digite nome:");
                        tel[quarto-1] = JOptionPane.showInputDialog(null, "Digite telefone:");
                        din[quarto-1] = JOptionPane.showInputDialog(null, "Data de entrada:");
                        dout[quarto-1] = JOptionPane.showInputDialog(null, "Data de saida:");
                        nd[quarto-1] = Integer.parseInt(JOptionPane.showInputDialog(null, "Numero de dias:"));
                    }
                    break;
                    
                case 5:
                    if(!chave) {
                        JOptionPane.showMessageDialog(null, "Escolha a opcao 1 primeiro");
                    } else {
                        int quarto = Integer.parseInt(JOptionPane.showInputDialog(null, 
                            "Entre com numero do quarto:"));
                        
                        while(quarto < 1 || quarto > 50) {
                            quarto = Integer.parseInt(JOptionPane.showInputDialog(null, 
                                "Numero invalido. Digite novamente:"));
                        }
                        
                        double valor = Double.parseDouble(JOptionPane.showInputDialog(null, 
                            "Valor das despesas extras:"));
                        despesas[quarto-1] += valor;
                    }
                    break;
                    
                case 6:
                    if(!chave) {
                        JOptionPane.showMessageDialog(null, "Escolha a opcao 1 primeiro");
                    } else {
                        int quarto = Integer.parseInt(JOptionPane.showInputDialog(null, 
                            "Entre com numero do quarto:"));
                        
                        while(quarto < 1 || quarto > 50) {
                            quarto = Integer.parseInt(JOptionPane.showInputDialog(null, 
                                "Numero invalido. Digite novamente:"));
                        }
                        
                        double total = despesas[quarto-1] + (precos[quarto-1] * nd[quarto-1]);
                        JOptionPane.showMessageDialog(null, 
                            "Total a pagar: R$" + String.format("%.2f", total));
                        
                        sit[quarto-1] = "L";
                        despesas[quarto-1] = 0;
                        din[quarto-1] = "XXXX";
                        dout[quarto-1] = "XXXX";
                        nd[quarto-1] = 0;
                        nome[quarto-1] = "";
                        tel[quarto-1] = "";
                    }
                    break;
                    
                case 7:
                    JOptionPane.showMessageDialog(null, "Saindo do sistema");
                    break;
                    
                default:
                    JOptionPane.showMessageDialog(null, "Opcao nao disponivel");
            }
        } while(op != 7);
    }
}