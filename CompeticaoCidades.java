import java.util.Random;
import java.util.Scanner;

public class CompeticaoCidades {
    // Função para aplicar interferência ou glória
    private static void aplicarEvento(double[] taxaCidade, Random random, String[] eventos, boolean isInterferencia) {
        String evento = eventos[random.nextInt(eventos.length)];
        double impacto = (random.nextDouble() * 1.0 + 0.5);  // Impacto entre 0.5% e 1.5%

        if (isInterferencia) {
            taxaCidade[0] -= impacto;
            System.out.printf("⚠ Interferência aplicada: %s (-%.2f%%)\n", evento, impacto);
        } else {
            taxaCidade[0] += impacto;
            System.out.printf("✨ Glória recebida: %s (+%.2f%%)\n", evento, impacto);
        }
    }

    // Função para validar entradas de números positivos
    private static double obterEntradaPositiva(Scanner entrada, String mensagem) {
        double valor;
        do {
            System.out.print(mensagem);
            while (!entrada.hasNextDouble()) {
                System.out.println("Por favor, insira um número válido.");
                entrada.next(); // descarta a entrada inválida
            }
            valor = entrada.nextDouble();
            if (valor <= 0) {
                System.out.println("Por favor, insira um número positivo.");
            }
        } while (valor <= 0);
        return valor;
    }

    // Função para realizar a pergunta de conhecimentos gerais
    private static boolean realizarPergunta(Scanner entrada, Random random) {
        String[] perguntas = {
                "Qual a capital da França?", "Quem descobriu o Brasil?", "Qual o maior planeta do sistema solar?",
                "Em que ano foi a independência dos EUA?", "Quem pintou a Mona Lisa?"
        };
        String[] respostas = {
                "Paris", "Pedro Álvares Cabral", "Júpiter", "1776", "Leonardo Da Vinci"
        };

        int perguntaIndex = random.nextInt(perguntas.length);
        System.out.println(perguntas[perguntaIndex]);
        String respostaUsuario = entrada.nextLine().trim();

        return respostaUsuario.equalsIgnoreCase(respostas[perguntaIndex]);
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Random random = new Random();

        // Definir o número de rodadas
        System.out.print("Quantas rodadas a competição terá? ");
        int rodadas = entrada.nextInt();
        entrada.nextLine(); // Limpar buffer após nextInt()

        // População das cidades
        double cidade1 = obterEntradaPositiva(entrada, "Escreva a população da Cidade 1: ");
        double cidade2 = obterEntradaPositiva(entrada, "Escreva a população da Cidade 2: ");

        // Inicializar taxa de crescimento como 0%
        double taxa1 = 0;  // Taxa de crescimento Cidade 1
        double taxa2 = 0;  // Taxa de crescimento Cidade 2

        // Conversão das taxas para multiplicação
        double crescimento1;
        double crescimento2;

        // Eventos de interferência e glória
        String[] interferencias = {
                "Crise econômica", "Pandemia mundial", "Aumento da criminalidade", "Falta de infraestrutura",
                "Crise política", "Apocalipse zumbi", "Desastre natural", "Aumento da corrupção", "Escassez de recursos"
        };
        String[] glorias = {
                "Investimento em tecnologia", "Recebimento de ajuda externa", "Desenvolvimento de infraestrutura",
                "Aumento do turismo", "Novas indústrias", "Avanços educacionais", "Aumento da produtividade agrícola",
                "Fortalecimento da segurança", "Revolução verde", "Avanços médicos"
        };

        // Laço de rodadas
        for (int rodada = 1; rodada <= rodadas; rodada++) {
            System.out.println("\nRodada " + rodada + " - Começando o crescimento das cidades:");

            // Perguntas e ajustes nas taxas de crescimento
            if (realizarPergunta(entrada, random)) {
                taxa1 += 2; // Aumento de 2% para a cidade 1 se acertar
                System.out.println("Cidade 1 acertou a pergunta! A taxa de crescimento aumentou para " + taxa1 + "%.");
            } else {
                taxa1 -= 1; // Diminuição de 1% se errar
                System.out.println("Cidade 1 errou a pergunta! A taxa de crescimento diminuiu para " + taxa1 + "%.");
            }

            if (realizarPergunta(entrada, random)) {
                taxa2 += 2; // Aumento de 2% para a cidade 2 se acertar
                System.out.println("Cidade 2 acertou a pergunta! A taxa de crescimento aumentou para " + taxa2 + "%.");
            } else {
                taxa2 -= 1; // Diminuição de 1% se errar
                System.out.println("Cidade 2 errou a pergunta! A taxa de crescimento diminuiu para " + taxa2 + "%.");
            }

            // Aplica interferências ou glórias com base nas taxas
            if (random.nextBoolean()) {
                aplicarEvento(new double[]{taxa1}, random, interferencias, true);  // Interferência para cidade 1
            } else {
                aplicarEvento(new double[]{taxa1}, random, glorias, false);  // Glória para cidade 1
            }

            if (random.nextBoolean()) {
                aplicarEvento(new double[]{taxa2}, random, interferencias, true);  // Interferência para cidade 2
            } else {
                aplicarEvento(new double[]{taxa2}, random, glorias, false);  // Glória para cidade 2
            }

            // Calcula o crescimento das cidades
            crescimento1 = 1 + (taxa1 / 100);
            crescimento2 = 1 + (taxa2 / 100);

            cidade1 *= crescimento1;
            cidade2 *= crescimento2;

            // Mostrar as populações após a rodada
            System.out.printf("Ano %d - Cidade 1: %.2f | Cidade 2: %.2f\n", rodada, cidade1, cidade2);

            // A cada 5 rodadas, permitir uma pergunta adicional para mandar interferência
            if (rodada % 5 == 0) {
                System.out.println("Pergunta adicional: (Você pode tentar interferir na outra cidade!)");
                // Aqui você pode adicionar a lógica para perguntas de conhecimentos gerais
                // Caso o jogador acerte, ele pode aplicar uma interferência na outra cidade
            }
        }

        // Determinar o vencedor
        if (cidade1 > cidade2) {
            System.out.printf("\nCidade 1 venceu com %.2f de população! 🎉\n", cidade1);
        } else if (cidade2 > cidade1) {
            System.out.printf("\nCidade 2 venceu com %.2f de população! 🎉\n", cidade2);
        } else {
            System.out.println("\nAs cidades empataram com a mesma população! 🤝");
        }

        entrada.close();
    }
}
