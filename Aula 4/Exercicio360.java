import javax.swing.JOptionPane;

public class Exercicio360 {
    public static void main(String[] args) {
        int[] ultDia = {20, 19, 20, 20, 20, 20, 21, 22, 22, 22, 21, 21};
        String[] signo = {"Capricornio", "Aquario", "Peixes", "Aries", "Touro", 
        "Gemeos", "Cancer", "Leao", "Virgem", "Libra", 
        "Escorpiao", "Sagitario"};
        
        int data;
        do {
            String input = JOptionPane.showInputDialog(null, 
                "Digite a data no formato DDMM (ou 9999 para terminar):");
            data = Integer.parseInt(input);
            
            if(data != 9999) {
                int dia = data / 100;
                int mes = (data % 100) - 1;
                
                if(mes < 0) mes = 11;
                if(dia > ultDia[mes]) {
                    mes = (mes + 1) % 12;
                }
                
                JOptionPane.showMessageDialog(null, "Signo: " + signo[mes]);
            }
        } while(data != 9999);
    }
}