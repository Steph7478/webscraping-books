package scraper.app.usecases.services;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import scraper.app.client.JsoupClient;
import scraper.app.config.AppConfig;
import scraper.app.ui.ConsoleInterface;

import java.util.List;

public class CategorySetup {

    public List<Element> prepararCategorias(ConsoleInterface ui) {
        ui.mostrarAviso("[Aguarde] Carregando categorias...");

        List<Element> lista = buscarNoSite();

        if (lista.isEmpty()) {
            ui.mostrarAviso("[ERRO] Falha ao conectar ou site vazio.");
        }

        return lista;
    }

    private List<Element> buscarNoSite() {
        Document home = JsoupClient.httpConnect(AppConfig.BASE_URL);

        return home.select(AppConfig.CATEGORY_SELECTOR).stream()
                .filter(cat -> !cat.text().equalsIgnoreCase("Books"))
                .toList();
    }
}