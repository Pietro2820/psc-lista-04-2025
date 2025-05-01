import java.util.ArrayList;
import java.util.Scanner;

public class Exercicio03 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ArrayList<String> banco = new ArrayList<>();
        String nome;

        // Nome
        while (true) {
            System.out.println("Nome: ");
            nome = entrada.next();
            if (nome.length() >= 3) {
                banco.add("Nome: " + nome);
                break;
            } else {
                System.err.println("Mínimo de caracteres não atingido.");
            }
        }

        // Idade
        while (true) {
            System.out.println("Idade: ");
            int idade = entrada.nextInt();
            if (idade >= 0 && idade <= 150) {
                banco.add("Idade: " + idade);
                break;
            } else {
                System.err.println("Idade inválida.");
            }
        }

        // Salário
        while (true) {
            System.out.println("Salário: ");
            double salario = entrada.nextDouble();
            if (salario >= 0) {
                banco.add("Salário: " + salario);
                break;
            } else {
                System.err.println("Valor inválido.");
            }
        }

        // Sexo
        while (true) {
            System.out.println("Sexo (F ou M): ");
            String sexo = entrada.next();
            if (sexo.length() == 1 && (sexo.equalsIgnoreCase("F") || sexo.equalsIgnoreCase("M"))) {
                banco.add("Sexo: " + sexo.toUpperCase());
                break;
            } else {
                System.err.println("Sexo inválido.");
            }
        }

        // Estado civil
        while (true) {
            System.out.println("Estado Civil (S, C, V ou D): ");
            String estado = entrada.next();
            if (estado.length() == 1 &&
                    (estado.equalsIgnoreCase("S") ||
                            estado.equalsIgnoreCase("C") ||
                            estado.equalsIgnoreCase("V") ||
                            estado.equalsIgnoreCase("D"))) {
                banco.add("Estado Civil: " + estado.toUpperCase());
                break;
            } else {
                System.err.println("Estado Civil inválido.");
            }
        }

        // Mostra os dados
        System.out.println("\nDados Coletados:");
        for (String dado : banco) {
            System.out.println(dado);
        }

        entrada.close();
    }
}
