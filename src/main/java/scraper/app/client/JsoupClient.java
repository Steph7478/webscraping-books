package scraper.app.client;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;
import java.util.Random;

public class JsoupClient {

    public static Document httpConnect(String url) {
        try {
            return Jsoup.connect(url)
                    .userAgent(randomUA())
                    .header("Accept-Language", "pt-BR,pt;q=0.9")
                    .timeout(20000)
                    .get();
        } catch (IOException e) {
            System.err.println("Erro ao conectar na URL: " + e.getMessage());
            return null;
        }
    }

    public static String randomUA() {
        String[] userAgents = {
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36",
                "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/119.0.0.0 Safari/537.36",
                "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36",
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:109.0) Gecko/20100101 Firefox/121.0"
        };

        Random random = new Random();
        return userAgents[random.nextInt(userAgents.length)];
    }
}