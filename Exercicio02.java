import java.util.Scanner;

public class Exercicio02 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        while (true) {
            System.out.println("Cadastro.");
            System.out.println("e-mail: ");
            String email = entrada.next();
            System.out.println("Senha: ");
            String senha = entrada.next();

            if (email.equals(senha)) {
                System.err.println("O e-mail e senha não podem ser a mesma.");
            }else {
                break;
            }
        }
        System.out.println("Seja bem-vindo!!");
        entrada.close();
    }
}

