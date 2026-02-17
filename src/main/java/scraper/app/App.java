package scraper.app;

import scraper.app.usecases.BooksSearch;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            BooksSearch searcher = new BooksSearch();
            searcher.execute(scanner);

        } catch (Exception e) {
            System.err.println("Erro crítico no sistema: " + e.getMessage());
        }

        System.out.println("\n=== PROGRAMA ENCERRADO. ATÉ LOGO! ===");
    }
}