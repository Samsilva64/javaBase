import java.util.Scanner;
public class lernome {
    // ler 5 nomes e mostrar todos os nomes lidos
    public static void main(String[] args) {
        Scanner sc = new java.util.Scanner(System.in);
        String[] nomes = new String[5];
        for (int i = 0; i < 5; i++) {
            System.out.print("Digite o nome " + (i + 1) + ": ");
            nomes[i] = sc.nextLine();
        }
        sc.close();
        System.out.println("Nomes lidos:");
        for (String nome : nomes) {
            System.out.println(nome);
        }
    }
}
