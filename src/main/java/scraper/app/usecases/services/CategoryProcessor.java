package scraper.app.usecases.services;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import scraper.app.client.JsoupClient;
import scraper.app.config.AppConfig;

public class CategoryProcessor {

    public void process(String url, String name, int minStars) {
        String currentUrl = url;

        while (currentUrl != null) {
            Document doc = JsoupClient.httpConnect(currentUrl);
            if (doc == null)
                break;

            doc.select(AppConfig.PRODUCT_SELECTOR).stream()
                    .filter(el -> BookParser.hasMinStars(el, minStars))
                    .filter(el -> BookParser.parsePrice(el) > 0)
                    .map(el -> BookParser.createBook(el, name))
                    .forEach(System.out::println);

            currentUrl = getNextPageUrl(doc);
            if (currentUrl != null)
                delay();
        }
    }

    private String getNextPageUrl(Document doc) {
        Element next = doc.select(AppConfig.NEXT_PAGE_SELECTOR).first();
        return (next != null) ? next.absUrl("href") : null;
    }

    private void delay() {
        try {
            Thread.sleep(AppConfig.SCRAPE_DELAY_MS);
        } catch (InterruptedException ignored) {
            Thread.currentThread().interrupt();
        }
    }
}