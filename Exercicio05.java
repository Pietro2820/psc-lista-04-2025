import java.util.Scanner;

public class Exercicio05 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int anos = 0;

        // População cidade
        System.out.print("Escreva a população da Cidade 1: ");
        double cidade1 = entrada.nextDouble();

        System.out.print("Escreva a população da Cidade 2: ");
        double cidade2 = entrada.nextDouble();

        // Porcentagem
        System.out.print("Escreva a taxa de crescimento da Cidade 1 (em %): ");
        double taxa1 = entrada.nextDouble();

        System.out.print("Escreva a taxa de crescimento da Cidade 2 (em %): ");
        double taxa2 = entrada.nextDouble();

        // Conversão
        double crescimento1 = 1 + (taxa1 / 100);
        double crescimento2 = 1 + (taxa2 / 100);

        /*
         Verifica os cenários possíveis:
         - Se as cidades têm a mesma população e mesma taxa de crescimento, crescerão juntas.
         - Se Cidade 1 tem menor população mas maior taxa de crescimento, simula até ela ultrapassar ou igualar Cidade 2.
         - Se Cidade 2 tem menor população mas maior taxa de crescimento, simula até ela ultrapassar ou igualar Cidade 1.
         - Caso contrário, nenhuma ultrapassará a outra com essas taxas.
        */

        if (cidade1 == cidade2 && taxa1 == taxa2) {
            System.out.println("As cidades têm a mesma população e taxa de crescimento. Elas vão crescer juntas.");
        }
        else if (cidade1 < cidade2 && taxa1 > taxa2) {
            while (cidade1 < cidade2) {
                cidade1 *= crescimento1;
                cidade2 *= crescimento2;
                anos++;

                System.out.println("Ano " + anos + ":");
                System.out.printf("Cidade 1: %.2f\n", cidade1);
                System.out.printf("Cidade 2: %.2f\n\n", cidade2);
            }
            System.out.println("Cidade 1 ultrapassou ou igualou a Cidade 2 em " + anos + " anos.");
        }
        else if (cidade2 < cidade1 && taxa2 > taxa1) {
            while (cidade2 < cidade1) {
                cidade1 *= crescimento1;
                cidade2 *= crescimento2;
                anos++;

                System.out.println("Ano " + anos + ":");
                System.out.printf("Cidade 1: %.2f\n", cidade1);
                System.out.printf("Cidade 2: %.2f\n\n", cidade2);
            }
            System.out.println("Cidade 2 ultrapassou ou igualou a Cidade 1 em " + anos + " anos.");
        }
        else {
            System.out.println("Nenhuma cidade irá ultrapassar a outra com essas taxas.");
        }

        entrada.close();
    }
}
