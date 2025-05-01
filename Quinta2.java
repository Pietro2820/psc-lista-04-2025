import java.util.Scanner;
import java.util.Random;

public class Quinta2 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Random random = new Random();
        int anos = 0;

        // Entrada de dados
        System.out.print("Escreva a população da Cidade 1: ");
        double cidade1 = entrada.nextDouble();

        System.out.print("Escreva a população da Cidade 2: ");
        double cidade2 = entrada.nextDouble();

        System.out.print("Escreva a taxa de crescimento da Cidade 1 (em %): ");
        double taxa1 = entrada.nextDouble();

        System.out.print("Escreva a taxa de crescimento da Cidade 2 (em %): ");
        double taxa2 = entrada.nextDouble();

        // Crescimentos como fator multiplicativo
        double crescimento1 = 1 + (taxa1 / 100);
        double crescimento2 = 1 + (taxa2 / 100);

        // Lista de interferências
        String[] interferencias = {
                "Gripe comum (-0.5%)", "COVID-19 (-1%)", "Guerra civil (-3%)", "Apocalipse zumbi (-10%)", "Queda econômica (-1%)",
                "Fome generalizada (-2%)", "Inflação descontrolada (-1.5%)", "Desastres naturais (-2%)", "Protestos violentos (-1%)",
                "Colapso da saúde (-2.5%)", "Invasão alienígena (-5%)", "Crise de energia (-1%)", "Colapso ambiental (-2%)",
                "Aumento da criminalidade (-1%)", "Doença misteriosa (-1.5%)", "Peste bubônica 2.0 (-2%)", "Radiação nuclear (-4%)",
                "Congelamento econômico (-1.2%)", "Terremoto de grande escala (-3%)", "Tsunami catastrófico (-2.5%)",
                "Furacão devastador (-2%)", "Erupção vulcânica (-2%)", "Praga de gafanhotos (-1%)", "Envenenamento em massa (-3%)",
                "Problemas no saneamento (-1%)", "Epidemia de dengue (-1%)", "Desnutrição infantil (-1%)", "Febre hemorrágica (-1.5%)",
                "Desabastecimento (-1%)", "Crise hídrica (-1.2%)", "Migração em massa (-1.5%)", "Vírus digital que paralisa tudo (-0.8%)",
                "Colapso bancário (-1.5%)", "Depressão populacional (-2%)", "Desemprego extremo (-1%)", "Doença respiratória (-0.5%)",
                "Febre macaco (-0.5%)", "Mosquitos mutantes (-1%)", "Vazamento tóxico (-1.3%)", "Doença mental em massa (-1%)",
                "Manipulação genética falha (-1%)", "Guerra de drones (-2%)", "Ciberataque massivo (-1.2%)", "Ataque biológico (-3%)",
                "Revolta dos robôs (-4%)", "Crise climática aguda (-1.7%)", "Fuga em massa das cidades (-2%)", "Medo coletivo (-0.5%)",
                "Infecção desconhecida (-1%)", "Colapso no transporte (-1%)"
        };

        double taxaAtual2 = taxa2;
        double crescimentoAtual2 = crescimento2;

        // Se já for possível Cidade 1 ultrapassar, simula normalmente
        if (cidade1 >= cidade2 || taxa1 > taxaAtual2) {
            while (cidade1 < cidade2) {
                cidade1 *= crescimento1;
                cidade2 *= crescimentoAtual2;
                anos++;

                System.out.println("Ano " + anos + ":");
                System.out.printf("Cidade 1: %.2f\n", cidade1);
                System.out.printf("Cidade 2: %.2f\n\n", cidade2);
            }
            System.out.println("Cidade 1 ultrapassou ou igualou a Cidade 2 em " + anos + " anos.");
        } else {
            // Aplica interferências até que a cidade 1 consiga alcançar a cidade 2
            System.out.println("\nAs taxas iniciais não permitem que Cidade 1 ultrapasse Cidade 2.");
            System.out.println("Aplicando interferências populacionais na Cidade 2...");

            while (cidade1 < cidade2) {
                // Se ainda não é possível ultrapassar, aplica interferência
                if (taxaAtual2 <= taxa1) {
                    crescimentoAtual2 = 1 + (taxaAtual2 / 100);
                    continue;
                }

                int sorteio = random.nextInt(interferencias.length);
                String evento = interferencias[sorteio];

                // Extrai o valor da redução entre parênteses
                double reducao = Double.parseDouble(
                        evento.substring(evento.indexOf("(-") + 2, evento.indexOf("%)"))
                );

                taxaAtual2 -= reducao;

                if (taxaAtual2 < 0) taxaAtual2 = 0;

                crescimentoAtual2 = 1 + (taxaAtual2 / 100);

                System.out.println("Interferência sorteada: " + evento);
                System.out.printf("Nova taxa da Cidade 2: %.2f%%\n\n", taxaAtual2);

                // Agora simula o crescimento após essa interferência
                cidade1 *= crescimento1;
                cidade2 *= crescimentoAtual2;
                anos++;

                System.out.println("Ano " + anos + ":");
                System.out.printf("Cidade 1: %.2f\n", cidade1);
                System.out.printf("Cidade 2: %.2f\n\n", cidade2);
            }

            System.out.println("Cidade 1 conseguiu ultrapassar ou igualar a Cidade 2 em " + anos + " anos após interferências.");
        }

        entrada.close();
    }
}
