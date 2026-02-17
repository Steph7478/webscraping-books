package scraper.app.ui;

import org.jsoup.nodes.Element;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ConsoleInterface {

    public static final String RESET = "\u001B[0m";
    public static final String BOLD = "\u001B[1m";
    public static final String DEEP_BLUE = "\u001B[38;5;18m";
    public static final String DARK_PURPLE = "\u001B[38;5;54m";
    public static final String TRUE_GREEN = "\u001B[38;5;34m";
    public static final String TEXT_OCHRE = "\u001B[38;5;130m";
    public static final String DEEP_RED = "\u001B[38;5;88m";
    public static final String DARK_GOLD = "\u001B[38;5;94m";
    public static final String CATEGORY_BLUE = "\u001B[38;5;67m";
    public static final String PROMPT_CYAN = "\u001B[38;5;30m";

    public void imprimirMenu(List<Element> categorias) {
        System.out.println(DEEP_BLUE + "\n" + "=".repeat(45) + RESET);
        System.out.println(BOLD + DARK_PURPLE + "           MENU DE CATEGORIAS" + RESET);
        System.out.println(DEEP_BLUE + "=".repeat(45) + RESET);

        IntStream.range(0, categorias.size()).forEach(i -> {
            System.out.printf(DARK_GOLD + "[%2d] " + RESET + CATEGORY_BLUE + "%-18s", i, categorias.get(i).text());
            if ((i + 1) % 2 == 0)
                System.out.println();
        });

        System.out.print(BOLD + DARK_PURPLE + "\n\nEscolha uma categoria " + DEEP_RED + "(ou -1 para sair)" + RESET
                + BOLD + DARK_PURPLE + ": " + RESET);
    }

    public void mostrarCabecalhoBusca(int estrelas, String categoria) {
        String texto = " BUSCANDO LIVROS COM " + estrelas + "+ ESTRELAS EM: " + categoria.toUpperCase() + " ";
        int tam = texto.length();

        System.out.println("\n" + DEEP_BLUE + "-".repeat(tam + 6) + RESET);
        System.out.println(DEEP_BLUE + "---" + RESET + BOLD + TEXT_OCHRE + texto + RESET + DEEP_BLUE + "---" + RESET);
        System.out.println(DEEP_BLUE + "-".repeat(tam + 6) + RESET);
    }

    public int lerEstrelas(Scanner sc) {
        while (true) {
            try {
                System.out.print(TEXT_OCHRE + "Filtrar por qual nota mínima? (1 a 5 estrelas): " + RESET);
                int estrelas = Integer.parseInt(sc.nextLine());
                if (estrelas >= 1 && estrelas <= 5)
                    return estrelas;
                System.out.println(DEEP_RED + ">>> Digite um valor entre 1 e 5." + RESET);
            } catch (Exception e) {
                System.out.println(DEEP_RED + ">>> Entrada inválida. Digite um número." + RESET);
            }
        }
    }

    public int lerEscolha(Scanner sc, int max) {
        try {
            int n = Integer.parseInt(sc.nextLine());
            if (n >= -1 && n < max)
                return n;
            System.out.println(DEEP_RED + ">>> Opção inválida!" + RESET);
        } catch (Exception e) {
            System.out.println(DEEP_RED + ">>> Digite apenas números." + RESET);
        }
        return -2;
    }

    public void mostrarAviso(String mensagem) {
        String cor = mensagem.toUpperCase().contains("ERRO") ? DEEP_RED : DEEP_BLUE;
        System.out.println("\n" + cor + BOLD + "!!! " + mensagem.toUpperCase() + " !!!" + RESET);
    }

    public void limparTerminal() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("\n".repeat(50));
        }
    }

    public boolean querContinuar(Scanner sc) {
        System.out.println(DEEP_BLUE + "\n" + "-".repeat(45) + RESET);
        System.out.print(PROMPT_CYAN + BOLD + "Deseja realizar outra busca? (S/N): " + RESET);
        String resposta = sc.nextLine().trim().toUpperCase();
        return resposta.startsWith("S");
    }
}