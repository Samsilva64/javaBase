import java.util.Random;
import java.util.Scanner;
public class EntradaDado {
    public static void main(String[] args){
        String nome;
        int stadoCivil;
        int idade;
        double pesso;

        Scanner sc = new Scanner(System.in);
        System.out.print("Digite seu nome: ");
        nome = sc.nextLine();
        System.out.print("Digite sua idade: ");
        idade = sc.nextInt();
        System.out.print("Digite seu pesso: ");
        pesso = sc.nextDouble();
        System.out.print("Digite seu estado cicil (1-Solteiro, 2-Casado, 3-Divorciado, 4-Viuvo): ");
        stadoCivil = sc.nextInt();

        String[] produtos = {"Calsa", "Camisa", "Tenis", "Meia"};
        String[] imoveis = {"Casa", "Apartamento", "Chacara", "Sítio"};

        
        if (idade >= 18) {
            System.out.println("Nome: " + nome + ", Idade: " + idade + ", Pesso: " + pesso +
             " - Maior de idade ");
        
        } else if (idade < 18) {
            System.out.println("Nome: " + nome + ", Idade: " + idade + ", Pesso: " + pesso +
             " - Menor de idade ");
        } else {
            System.out.println("Dados incorretos");
        }

        switch (stadoCivil) {
            case 1:
                System.out.println("Estado Civil: Solteiro");
                break;
            case 2:
                System.out.println("Estado Civil: Casado");
                break;
            case 3:
                System.out.println("Estado Civil: Divorciado");
                break;
            case 4:
                System.out.println("Estado Civil: Viuvo");
                break;
        
            default:
                System.out.println("Estado Civil: Invalido");
                break;
        }
        sc.close();

        System.out.println("Produtos disponiveis:");
        for (int i = 0; i < produtos.length; i++) {
        System.out.println("- " + produtos[i]);
        }

        int cont = imoveis.length;
        System.out.println("Imoveis disponiveis:");
        while(cont > 0) {
            System.out.println("- " + imoveis[cont - 1]);
            cont--;
        }

            metodoExemplo("La Burguer");
    
    }

    // Metodos
    
        static void metodoExemplo(String nomeRestaurante) {
            System.out.println("Nome da loja: " + nomeRestaurante);
            String[] pratos = {"Lasanha", "Strogonoff", "Feijoada", "Churrasco"};
            // Este é um método de exemplo adicional
            System.out.println("Pratos disponiveis (do-while):");
            int i = 0;
            do{
                System.out.println(pratos[i]);
                i++;
            }while(i < pratos.length);
        }

        static int gerador(){
            Random rand = new Random();
            int num1 = rand.nextInt(100);
            return num1;
        }
}

   

    

