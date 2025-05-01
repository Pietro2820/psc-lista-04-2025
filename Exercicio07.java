import java.util.Scanner;

public class Exercicio07 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Escreva 5 números: ");
        int n1 = entrada.nextInt();
        int n2 = entrada.nextInt();
        int n3 = entrada.nextInt();
        int n4 = entrada.nextInt();
        int n5 = entrada.nextInt();

        int maior = Math.max(n1, n2);
        maior = Math.max(maior, n3);
        maior = Math.max(maior, n4);
        maior = Math.max(maior, n5);

        System.out.print("O maior número da lista é: " + maior);
    }
}
