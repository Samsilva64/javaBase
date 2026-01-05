import java.util.Scanner;
public class somar {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a, b;
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o primeiro numero: ");
        a = sc.nextInt();
        System.out.print("Digite o segundo numero: ");
        b = sc.nextInt();
        sc.close();
        int soma = a + b;
        System.out.println("A soma de " + a + " + " + b + " = " + soma);


    }
}
