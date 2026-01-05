// Jogo: Pedra, Papel e Tesoura (sem imports, apenas recursos básicos do Java)
// Uso de System.in/System.out e Math.random() (parte de java.lang, sem importações)
public class JogoRPS {
    public static void main(String[] args) {
        println("=== Pedra, Papel e Tesoura ===");
        boolean rodando = true;
        while (rodando) {
            println("\n1) Jogar");
            println("2) Regras");
            println("3) Sair");
            print("Escolha (1-3): ");
            String op = readLine().trim();
            if (op.equals("1")) {
                play();
            } else if (op.equals("2")) {
                println("\nRegras:");
                println("- Pedra vence Tesoura");
                println("- Tesoura vence Papel");
                println("- Papel vence Pedra");
                println("Pressione Enter para voltar ao menu...");
                readLine();
            } else if (op.equals("3")) {
                println("Obrigado por jogar! Até mais.");
                rodando = false;
            } else {
                println("Opção inválida. Tente novamente.");
            }
        }
    }

    static void play() {
        println("\nQuantas rodadas? (1-99)");
        print("N: ");
        int n = toInt(readLine(), 3);
        if (n < 1) n = 1;
        if (n > 99) n = 99;
        int userScore = 0;
        int compScore = 0;
        for (int i = 1; i <= n; i++) {
            println("\n--- Rodada " + i + " de " + n + " ---");
            println("Escolha: 1) Pedra  2) Papel  3) Tesoura");
            print("Sua escolha (1-3): ");
            int user = toInt(readLine(), 1);
            if (user < 1 || user > 3) { println("Entrada inválida, conta como Pedra."); user = 1; }
            int userMove = user - 1; // 0=Pedra,1=Papel,2=Tesoura
            int compMove = (int)(Math.random() * 3);
            println("Você: " + moveName(userMove) + "  |  Computador: " + moveName(compMove));
            int result = (userMove - compMove + 3) % 3;
            if (result == 0) {
                println("Empate!");
            } else if (result == 1) {
                println("Você ganhou esta rodada!");
                userScore++;
            } else {
                println("Computador ganhou esta rodada!");
                compScore++;
            }
            println("Placar: Você " + userScore + " x " + compScore + " Computador");
        }
        println("\n-- Resultado final --");
        if (userScore > compScore) println("Parabéns! Você venceu a partida: " + userScore + " x " + compScore);
        else if (compScore > userScore) println("Computador venceu: " + compScore + " x " + userScore);
        else println("A partida terminou empatada: " + userScore + " x " + compScore);
        println("Pressione Enter para voltar ao menu...");
        readLine();
    }

    // Auxiliares mínimos sem usar classes externas
    static String readLine() {
        StringBuilder sb = new StringBuilder();
        try {
            int ch;
            while ((ch = System.in.read()) != -1) {
                if (ch == '\r') continue;
                if (ch == '\n') break;
                sb.append((char) ch);
            }
        } catch (Exception e) {
            // ignorar
        }
        return sb.toString();
    }

    static int toInt(String s, int def) {
        try { return Integer.parseInt(s.trim()); } catch (Exception e) { return def; }
    }

    static String moveName(int m) {
        if (m == 0) return "Pedra";
        if (m == 1) return "Papel";
        return "Tesoura";
    }

    static void println(String s) { System.out.println(s); }
    static void print(String s) { System.out.print(s); }
}
