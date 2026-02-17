package scraper.app.usecases;

import org.jsoup.nodes.Element;
import scraper.app.ui.ConsoleInterface;
import scraper.app.usecases.services.CategoryProcessor;
import scraper.app.usecases.services.CategorySetup;

import java.util.List;
import java.util.Scanner;

public class BooksSearch {
    private final ConsoleInterface ui = new ConsoleInterface();
    private final CategoryProcessor processor = new CategoryProcessor();
    protected final List<Element> categorias = new CategorySetup().prepararCategorias(ui);

    public void execute(Scanner scanner) {
        if (categorias.isEmpty())
            return;

        while (true) {
            ui.limparTerminal();
            ui.imprimirMenu(categorias);

            int escolha = ui.lerEscolha(scanner, categorias.size());
            if (escolha == -1)
                break;
            if (escolha == -2)
                continue;

            Element cat = categorias.get(escolha);
            int estrelas = ui.lerEstrelas(scanner);

            ui.mostrarCabecalhoBusca(estrelas, cat.text());
            processor.process(cat.absUrl("href"), cat.text(), estrelas);

            if (!ui.querContinuar(scanner))
                break;
        }

        ui.mostrarAviso("Saindo... Até logo!");
    }
}