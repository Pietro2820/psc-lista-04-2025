import java.util.Scanner;

public class Exercicio08 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int soma = 0;

        for (int i = 1; i <= 5; i++) {
            System.out.print("Digite o " + i + "º número: ");
            int numero = entrada.nextInt(); // Entrada com Scanner
            soma += numero;
        }

        double media = soma / 5.0;
        System.out.println("Soma: " + soma);
        System.out.println("Média: " + media);
        entrada.close();
    }
}
