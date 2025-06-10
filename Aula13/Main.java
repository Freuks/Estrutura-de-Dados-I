import java.util.Random;

public class Main {

    public static void main(String[] args) {
        final int VETOR_SIZE = 1000;
        final int MAX_VALUE = 9999;
        int[] vector = new int[VETOR_SIZE];
        Random random = new Random();

        for (int i = 0; i < VETOR_SIZE; i++) {
            vector[i] = random.nextInt(2 * MAX_VALUE + 1) - MAX_VALUE;
        }
        
        System.out.println("Vetor Original:");
        printVetor(vector);

        ListaDupla orderedList = new ListaDupla();
        for (int number : vector) {
            orderedList.insertInOrder(number);
        }

        System.out.println("\nLista em ordem crescente:");
        orderedList.printAscending();

        System.out.println("\nLista em ordem decrescente:");
        orderedList.printDescending();
        
        System.out.println("\nRemovendo numeros primos da lista...");
        orderedList.removePrimes();
        
        System.out.println("\nLista Final em ordem crescente (Apos Remover Primos):");
        orderedList.printAscending();
    }
    
    public static void printVetor(int[] vector) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < vector.length; i++) {
            sb.append(vector[i]);
            if (i < vector.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        System.out.println(sb.toString());
    }
}