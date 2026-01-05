# Jogo Básico: Adivinhe o Número ✅

Jogo simples feito usando apenas conceitos básicos de Java (procedural, sem orientação a objetos além da `class` e `main` obrigatórios).

## Novidades

- Adicionado **menu principal** (Jogar / Modo personalizado / Ver pontuações / Como jogar / Sair).
- Adicionado **modo personalizado** (escolha o número máximo e o limite de tentativas).
- Adicionado **salvar e visualizar pontuações** em `scores.txt` (arquivo simples).
- Melhorias de UX: mensagens coloridas e instruções mais claras.
- Scripts para facilitar: `build.bat` (compila) e `run.bat` (compila se necessário e executa).

## Como compilar e executar (Windows - PowerShell)

Opção 1 — manual (como antes):

1. Abra o PowerShell e navegue até a pasta do projeto:

   cd C:\Users\Injai\Documents\javaBasico\JogoBasico\src

2. Compile o arquivo `Main.java` (ou o novo `JogoRPS.java`):

   javac Main.java
   javac JogoRPS.java

3. Execute o jogo desejado:

   java Main
   java JogoRPS

Opção 2 — usando os scripts (mais simples):

1. Na pasta do projeto (onde estão `build.bat` e `run.bat`), rode:

   .\build.bat   (ou)   .\run.bat

`build.bat` compila o código. `run.bat` compila automaticamente se necessário e executa.

> Dica: se aparecer erro de comando não encontrado, verifique se o Java (JDK) está instalado e as variáveis de ambiente (`java` e `javac`) estão no PATH.

## Como jogar

- O computador escolhe um número entre 1 e 100.
- Você escolhe um nível de dificuldade que determina o número de tentativas.
- Informe palpites; o jogo dirá se está "muito alto" ou "muito baixo".
- Ao finalizar uma partida você pode voltar ao menu ou jogar novamente com a mesma dificuldade.

Feito para aprender estruturas básicas: leitura com `Scanner`, laços (`while`), condicionais (`if/else`) e geração de números aleatórios (`Random`).
