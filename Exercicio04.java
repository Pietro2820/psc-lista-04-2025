public class Exercicio04 {
    public static void main(String[] args) {
        Double cidade1 = 80000.0;
        Double cidade2 = 200000.0;
        int anos = 0;

        while (cidade1 < cidade2) {
            cidade1 *= 1.03;
            cidade2 *= 1.015;
            anos++;
            System.out.println("Ano " + anos + ":");
            System.out.println("Cidade 1: " + cidade1);
            System.out.println("Cidade 2: " + cidade2);
            System.out.println();
        }
        System.out.println("Cidade 1 ultrapassou ou igualou a Cidade 2 em " + anos + " anos.");
    }
}