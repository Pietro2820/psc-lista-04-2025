import java.util.Scanner;

public class Exercicio01 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Escreva uma nota para a roupa que está vestindo nesse momento de 0 a 10: ");
                int nota = entrada.nextInt();

                if (nota >= 0 && nota <= 10) {
                    break;
                } else {
                    System.err.println("Valor inválido.\n");
                }
            } catch (Exception e) {
                System.err.println("Valor inválido.");
                entrada.next();
            }
        }
        System.out.println("Parabéns");
    }
}
