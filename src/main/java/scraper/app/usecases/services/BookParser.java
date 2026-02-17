package scraper.app.usecases.services;

import org.jsoup.nodes.Element;
import scraper.app.entities.Book;
import scraper.app.config.AppConfig;
import java.util.Map;

public class BookParser {

    private static final Map<String, Integer> STAR_VALUE_MAP = Map.of(
            "One", 1, "Two", 2, "Three", 3, "Four", 4, "Five", 5);

    public static boolean hasMinStars(Element bookElement, int minStars) {
        Element ratingElement = bookElement.select("[class^='" + AppConfig.STAR_RATING_PREFIX + "']").first();

        if (ratingElement == null)
            return false;

        String starClass = ratingElement.className().replace(AppConfig.STAR_RATING_PREFIX, "").trim();
        int starsFound = STAR_VALUE_MAP.getOrDefault(starClass, 0);

        return starsFound >= minStars;
    }

    public static double parsePrice(Element bookElement) {
        String priceText = bookElement.select(AppConfig.BOOK_PRICE_SELECTOR).text();
        if (priceText.isEmpty())
            return 0.0;

        return Double.parseDouble(priceText.replaceAll("[^0-9.]", ""));
    }

    public static Book createBook(Element bookElement, String category) {
        String title = bookElement.select(AppConfig.BOOK_TITLE_SELECTOR).attr("title");
        double price = parsePrice(bookElement);

        return new Book(title, price, category);
    }
}