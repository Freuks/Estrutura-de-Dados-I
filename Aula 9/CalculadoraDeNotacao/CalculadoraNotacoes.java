import java.util.*;

public class CalculadoraNotacoes {

    public static void main(String[] args) {
        // Método principal - onde tudo começa
        // Aqui usamos Scanner para ler a notação escolhida e a expressão digitada pelo usuário.
        // Usamos um switch para decidir o tipo de notação e como converter/avaliar a expressão.

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o tipo de notação (infixa, posfixa, prefixa):");
        String tipo = scanner.nextLine();

        System.out.println("Digite a expressão:");
        String expressao = scanner.nextLine();

        String infixa = "";
        String posfixa = "";
        String prefixa = "";
        int resultado = 0;

        switch (tipo.toLowerCase()) {
            case "infixa":
                infixa = expressao;
                posfixa = converterParaPosfixa(infixa);
                prefixa = converterParaPrefixa(infixa);
                resultado = avaliarPosfixa(posfixa);
                break;
            case "posfixa":
                posfixa = expressao;
                infixa = converterPosfixaParaInfixa(posfixa);
                prefixa = converterParaPrefixa(infixa);
                resultado = avaliarPosfixa(posfixa);
                break;
            case "prefixa":
                prefixa = expressao;
                infixa = converterPrefixaParaInfixa(prefixa);
                posfixa = converterParaPosfixa(infixa);
                resultado = avaliarPosfixa(posfixa);
                break;
            default:
                System.out.println("Tipo de notação inválido!");
                return;
        }

        System.out.println("Expressão Infixa: " + infixa);
        System.out.println("Expressão Posfixa: " + posfixa);
        System.out.println("Expressão Prefixa: " + prefixa);
        System.out.println("Resultado: " + resultado);
    }

    // Método avaliarPosfixa
    // Avalia uma expressão pós-fixa (notação polonesa reversa).
    // Utiliza uma pilha para armazenar números.
    // Ao encontrar um operador, aplica a operação nos dois últimos números da pilha.
    // O valor final da pilha é o resultado da expressão.
    public static int avaliarPosfixa(String expressao) {
        Stack<Integer> pilha = new Stack<>();
        String[] tokens = expressao.split(" ");

        for (String token : tokens) {
            if (token.matches("\\d+")) {
                pilha.push(Integer.parseInt(token));
            } else {
                int b = pilha.pop();
                int a = pilha.pop();
                switch (token) {
                    case "+": pilha.push(a + b); break;
                    case "-": pilha.push(a - b); break;
                    case "*": pilha.push(a * b); break;
                    case "/": pilha.push(a / b); break;
                }
            }
        }
        return pilha.pop();
    }

    // Método converterParaPosfixa
    // Converte uma expressão da forma normal (infixa) para pós-fixa.
    // Usa uma pilha para tratar a ordem de precedência dos operadores.
    // Exemplo: 2 + 3 * 4 vira 2 3 4 * +
    public static String converterParaPosfixa(String expressao) {
        StringBuilder resultado = new StringBuilder();
        Stack<Character> pilha = new Stack<>();

        for (char c : expressao.toCharArray()) {
            if (Character.isDigit(c)) {
                resultado.append(c).append(' ');
            } else if (c == '(') {
                pilha.push(c);
            } else if (c == ')') {
                while (!pilha.isEmpty() && pilha.peek() != '(') {
                    resultado.append(pilha.pop()).append(' ');
                }
                pilha.pop();
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                while (!pilha.isEmpty() && precedencia(pilha.peek()) >= precedencia(c)) {
                    resultado.append(pilha.pop()).append(' ');
                }
                pilha.push(c);
            }
        }

        while (!pilha.isEmpty()) {
            resultado.append(pilha.pop()).append(' ');
        }

        return resultado.toString().trim();
    }

    // Método converterParaPrefixa
    // Converte uma expressão infixa para prefixa.
    // Inverte a expressão, troca parênteses, e converte como se fosse pós-fixa.
    // Depois inverte novamente o resultado.
    public static String converterParaPrefixa(String expressao) {
        StringBuilder sb = new StringBuilder();
        for (int i = expressao.length() - 1; i >= 0; i--) {
            char c = expressao.charAt(i);
            if (c == '(') c = ')';
            else if (c == ')') c = '(';
            sb.append(c);
        }
        String reversa = converterParaPosfixa(sb.toString());
        String[] tokens = reversa.split(" ");
        Collections.reverse(Arrays.asList(tokens));
        return String.join(" ", tokens);
    }

    // Método converterPosfixaParaInfixa
    // Converte uma expressão pós-fixa para infixa.
    // Usa uma pilha para montar subexpressões com parênteses e preservar a ordem correta.
    public static String converterPosfixaParaInfixa(String expressao) {
        Stack<String> pilha = new Stack<>();
        String[] tokens = expressao.split(" ");

        for (String token : tokens) {
            if (token.matches("\\d+")) {
                pilha.push(token);
            } else {
                String b = pilha.pop();
                String a = pilha.pop();
                pilha.push("(" + a + " " + token + " " + b + ")");
            }
        }
        return pilha.pop();
    }

    // Método converterPrefixaParaInfixa
    // Converte uma expressão prefixa para infixa.
    // Percorre os termos de trás para frente e usa uma pilha para montar as subexpressões.
    public static String converterPrefixaParaInfixa(String expressao) {
        Stack<String> pilha = new Stack<>();
        String[] tokens = expressao.split(" ");

        for (int i = tokens.length - 1; i >= 0; i--) {
            String token = tokens[i];
            if (token.matches("\\d+")) {
                pilha.push(token);
            } else {
                String a = pilha.pop();
                String b = pilha.pop();
                pilha.push("(" + a + " " + token + " " + b + ")");
            }
        }
        return pilha.pop();
    }

    // Função de precedência
    // Define a prioridade dos operadores.
    // Multiplicação e divisão têm precedência maior que soma e subtração.
    // Usada na conversão de infixa para pós-fixa.
    public static int precedencia(char operador) {
        switch (operador) {
            case '+':
            case '-': return 1;
            case '*':
            case '/': return 2;
        }
        return -1;
    }
}
