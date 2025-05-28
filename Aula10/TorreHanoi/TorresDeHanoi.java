import java.time.Duration;
import java.time.LocalTime;

public class TorresDeHanoi {

    private static long movimentos = 0;

    public static void hanoi(int n, char origem, char destino, char auxiliar) {
        if (n == 0) {
            return;
        }

        hanoi(n - 1, origem, auxiliar, destino);

        movimentos++;

        hanoi(n - 1, auxiliar, destino, origem);
    }

    public static void main(String[] args) {
        int[] numDiscos = {1, 10, 20, 30, 40, 41};

        System.out.println("--- Execução das Torres de Hanói ---");

        for (int discos : numDiscos) {
            System.out.println("\n-------------------------------------");
            System.out.println("Executando para " + discos + " discos:");

            movimentos = 0;
            LocalTime inicio = LocalTime.now();

            hanoi(discos, 'A', 'C', 'B');

            LocalTime fim = LocalTime.now();
            Duration duracao = Duration.between(inicio, fim);

            long horas = duracao.toHours();
            long minutos = duracao.toMinutesPart();
            long segundos = duracao.toSecondsPart();
            long milissegundos = duracao.toMillisPart();

            String tempoFormatado = String.format("%02d:%02d:%02d:%03d", horas, minutos, segundos, milissegundos);

            System.out.println("Tempo gasto: " + tempoFormatado);
            System.out.println("Quantidade de movimentos: " + movimentos);

            long expectedMoves = (1L << discos) - 1;
            System.out.println("Movimentos esperados (2^n - 1): " + expectedMoves);
        }

        System.out.println("\n--- Fim da execução ---");
    }
}