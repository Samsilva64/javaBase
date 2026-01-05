import java.util.Scanner;
import java.util.Random;
import java.io.File; // nao conheço
import java.io.FileWriter; // nao conheço
import java.io.BufferedReader; // nao conheço
import java.io.FileReader; // nao conheço
import java.io.IOException; // nao conheço
import java.time.LocalDateTime; // nao conheço
import java.time.format.DateTimeFormatter; // nao conheço
import java.util.ArrayList;
import java.util.Collections; // nao conheço
import java.util.Comparator; // nao conheço

// Jogo: Adivinhe o Número — agora com modo personalizado, salvar/visualizar pontuações e cores
// Mantido em estilo procedural (apenas conceitos básicos de Java)
public class Main {
    // Cores ANSI (funcionam em terminais modernos)
    static final String RESET = "\u001B[0m";
    static final String RED = "\u001B[31m";
    static final String GREEN = "\u001B[32m";
    static final String YELLOW = "\u001B[33m";
    static final String CYAN = "\u001B[36m";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        boolean executando = true;
        while (executando) {
            System.out.println("\n" + CYAN + "=== Jogo: Adivinhe o Número ===" + RESET);
            System.out.println("1) Jogar (níveis rápidos)");
            System.out.println("2) Modo personalizado (escolha intervalo e tentativas)");
            System.out.println("3) Ver pontuações salvas");
            System.out.println("4) Como jogar");
            System.out.println("5) Sair");
            System.out.print("Escolha uma opção (1-5): ");

            String opcao = scanner.nextLine().trim();

            if (opcao.equals("1")) {
                // modo padrão com níveis
                int maxNumero = 100;
                int maxTentativas = 0; // 0 = ilimitado

                // Seleção de dificuldade
                boolean diffOk = false;
                while (!diffOk) {
                    System.out.println("\nSelecione a dificuldade:");
                    System.out.println("1) Fácil (10 tentativas)");
                    System.out.println("2) Médio (7 tentativas)");
                    System.out.println("3) Difícil (5 tentativas)");
                    System.out.print("Opção (1-3): ");
                    String d = scanner.nextLine().trim();

                    if (d.equals("1")) { maxTentativas = 10; diffOk = true; }
                    else if (d.equals("2")) { maxTentativas = 7; diffOk = true; }
                    else if (d.equals("3")) { maxTentativas = 5; diffOk = true; }
                    else { System.out.println(RED + "Opção inválida. Tente novamente." + RESET); }
                }

                playGame(scanner, rand, maxNumero, maxTentativas, "Padrão");

            } else if (opcao.equals("2")) {
                // modo personalizado
                System.out.println("\nModo personalizado:");
                int maxNumero = 100;
                int maxTentativas = 0;

                while (true) {
                    System.out.print("Digite o número máximo (ex: 50, 100, 1000) [min 10]: ");
                    String m = scanner.nextLine().trim();
                    try {
                        maxNumero = Integer.parseInt(m);
                        if (maxNumero < 10) { System.out.println(RED + "Valor muito pequeno. Tente >= 10." + RESET); continue; }
                        break;
                    } catch (NumberFormatException e) { System.out.println(RED + "Entrada inválida." + RESET); }
                }

                while (true) {
                    System.out.print("Digite o máximo de tentativas (0 = ilimitado): ");
                    String t = scanner.nextLine().trim();
                    try {
                        maxTentativas = Integer.parseInt(t);
                        if (maxTentativas < 0) { System.out.println(RED + "Digite 0 ou um número positivo." + RESET); continue; }
                        break;
                    } catch (NumberFormatException e) { System.out.println(RED + "Entrada inválida." + RESET); }
                }

                playGame(scanner, rand, maxNumero, maxTentativas, "Personalizado");

            } else if (opcao.equals("3")) {
                // visualizar pontuações
                System.out.println("\n" + CYAN + "Pontuações salvas:" + RESET);
                showScores();
                System.out.println("Pressione Enter para voltar ao menu...");
                scanner.nextLine();

            } else if (opcao.equals("4")) {
                System.out.println("\nComo jogar:");
                System.out.println("- O computador escolhe um número entre 1 e N (definido pelo modo)." );
                System.out.println("- Você informa palpites; o jogo dirá se está muito alto ou muito baixo.");
                System.out.println("- Se existir um limite de tentativas, você precisa acertar antes de acabar.");
                System.out.println("- Ao final da partida, você pode salvar sua pontuação (nome, tentativas e modo)." );
                System.out.println("Pressione Enter para voltar ao menu...");
                scanner.nextLine();

            } else if (opcao.equals("5")) {
                System.out.println(GREEN + "Obrigado por jogar! Até a próxima." + RESET);
                executando = false;
            } else {
                System.out.println(RED + "Opção inválida. Tente novamente." + RESET);
            }
        }

        scanner.close();
    }

    // Função de jogo para reutilizar código
    static void playGame(Scanner scanner, Random rand, int maxNumero, int maxTentativas, String modo) {
        int alvo = rand.nextInt(maxNumero) + 1;
        int tentativas = 0;
        boolean acertou = false;

        System.out.println(YELLOW + "\nIniciando partida (1-" + maxNumero + ") - Modo: " + modo + RESET);

        while (!acertou && (maxTentativas == 0 || tentativas < maxTentativas)) {
            System.out.print("Digite seu palpite (1-" + maxNumero + "): ");
            String entrada = scanner.nextLine().trim();
            int palpite;


            
            try {
                palpite = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println(RED + "Entrada inválida: '" + entrada + "'. Digite um número inteiro." + RESET);
                continue;
            }

            tentativas++;

            if (palpite < 1 || palpite > maxNumero) {
                System.out.println(RED + "Fora do intervalo. Tente um número entre 1 e " + maxNumero + "." + RESET);
                continue;
            }

            if (palpite == alvo) {
                System.out.println(GREEN + "\nParabéns! Você acertou em " + tentativas + " tentativas." + RESET);
                acertou = true;
            } else if (palpite < alvo) {
                System.out.println(YELLOW + "Muito baixo. Tente um número maior." + RESET);
            } else {
                System.out.println(YELLOW + "Muito alto. Tente um número menor." + RESET);
            }

            if (!acertou && maxTentativas > 0) {
                System.out.println(CYAN + "Tentativas restantes: " + (maxTentativas - tentativas) + RESET);
            }

            if (!acertou && maxTentativas > 0 && tentativas >= maxTentativas) {
                System.out.println(RED + "Suas tentativas acabaram! O número era: " + alvo + RESET);
            }
        }

        // Pergunta sobre salvar pontuação
        boolean valido = false;
        while (!valido) {
            System.out.print("Deseja salvar sua pontuação? (s/n): ");
            String resp = scanner.nextLine().trim();
            if (resp.length() > 0 && (resp.charAt(0) == 's' || resp.charAt(0) == 'S')) {
                System.out.print("Digite seu nome (até 20 caracteres): ");
                String nome = scanner.nextLine().trim();
                if (nome.length() == 0) nome = "Anonimo";
                if (nome.length() > 20) nome = nome.substring(0, 20);
                saveScore(nome, modo, tentativas, acertou ? "VITORIA" : "DERROTA", maxNumero);
                System.out.println(GREEN + "Pontuação salva!" + RESET);
                valido = true;
            } else if (resp.length() > 0 && (resp.charAt(0) == 'n' || resp.charAt(0) == 'N')) {
                valido = true;
            } else {
                System.out.println(RED + "Resposta inválida. Digite 's' ou 'n'." + RESET);
            }
        }
    }

    // Salva pontuação em arquivo simples 'scores.txt' na pasta do projeto (um nível acima de src)
    static void saveScore(String nome, String modo, int tentativas, String resultado, int maxNumero) {
        String arquivo = ".." + File.separator + "scores.txt";
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String linha = nome + "|" + LocalDateTime.now().format(fmt) + "|" + modo + "|" + tentativas + "|" + resultado + "|" + maxNumero + System.lineSeparator();
        try (FileWriter fw = new FileWriter(arquivo, true)) {
            fw.write(linha);
        } catch (IOException e) {
            System.out.println(RED + "Erro ao salvar pontuação: " + e.getMessage() + RESET);
        }
    }

    // Lê e exibe pontuações; tenta ordenar por tentativas (asc) e mostra últimas 20
    static void showScores() {
        String arquivo = ".." + File.separator + "scores.txt";
        File f = new File(arquivo);
        if (!f.exists()) { System.out.println(YELLOW + "Nenhuma pontuação salva ainda." + RESET); return; }

        ArrayList<String[]> linhas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String l;
            while ((l = br.readLine()) != null) {
                String[] parts = l.split("\\|", -1);
                if (parts.length >= 6) linhas.add(parts);
            }
        } catch (IOException e) {
            System.out.println(RED + "Erro ao ler pontuações: " + e.getMessage() + RESET);
            return;
        }

        // Ordenar por tentativas (campo index 3) apenas quando for número
        Collections.sort(linhas, new Comparator<String[]>() {
            public int compare(String[] a, String[] b) {
                try {
                    int ta = Integer.parseInt(a[3]);
                    int tb = Integer.parseInt(b[3]);
                    return Integer.compare(ta, tb);
                } catch (Exception e) {
                    return 0;
                }
            }
        });

        System.out.println(CYAN + "--- TOP Pontuações (menores tentativas primeiro) ---" + RESET);
        int limit = Math.min(20, linhas.size());
        for (int i = 0; i < limit; i++) {
            String[] p = linhas.get(i);
            System.out.println((i+1) + ") " + p[0] + " — " + p[2] + " — " + p[3] + " tentativas — " + p[4] + " — " + p[1]);
        }
    }
}
