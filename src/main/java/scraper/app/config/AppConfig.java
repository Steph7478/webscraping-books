package scraper.app.config;

public class AppConfig {
    public static final String BASE_URL = "https://books.toscrape.com/index.html";

    public static final String CATEGORY_SELECTOR = ".side_categories ul li a";
    public static final String PRODUCT_SELECTOR = ".product_pod";
    public static final String NEXT_PAGE_SELECTOR = "li.next a";

    public static final String BOOK_TITLE_SELECTOR = "h3 a";
    public static final String BOOK_PRICE_SELECTOR = ".product_price";
    public static final String STAR_RATING_PREFIX = "star-rating ";

    public static final int SCRAPE_DELAY_MS = 1000;
}