import java.util.Scanner;

public class Exercicio10 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite o primeiro número: ");
        int num1 = entrada.nextInt(); // Scanner lê o primeiro número

        System.out.print("Digite o segundo número: ");
        int num2 = entrada.nextInt(); // Scanner lê o segundo número

        System.out.println("Números entre " + num1 + " e " + num2 + ":");

        if (num1 < num2) {
            for (int i = num1 + 1; i < num2; i++) {
                System.out.println(i);
            }
        } else {
            for (int i = num2 + 1; i < num1; i++) {
                System.out.println(i);
            }
        }

        entrada.close();
    }
}
