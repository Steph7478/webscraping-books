package scraper.app.entities;

import scraper.app.ui.ConsoleInterface;

public record Book(String title, double price, String category) {

    @Override
    public String toString() {
        return String.format(
                ConsoleInterface.DEEP_BLUE + "[achado] " +
                        ConsoleInterface.DARK_PURPLE + "%s " +
                        ConsoleInterface.TRUE_GREEN + "£%.2f" +
                        ConsoleInterface.RESET,
                title,
                price);
    }
}