# 📚 Books to Scrape - Intelligence Scraper

A modular, high-performance web scraping system built with **Java 21** and **Jsoup**. This project demonstrates a clean architecture approach to data extraction, featuring a decoupled UI, centralized configuration, and a star-rating filtration engine.

> **Status:** ✅ Version 1.0 (Stable)

## 🏗 System Architecture

The project follows a **Layered Architecture** with a focus on the **Single Responsibility Principle**. Every component, from the parser to the terminal interface, operates independently through a centralized configuration hub.



---

## 🛠 Project Roadmap

### Phase 1: The Foundation (Client & Configuration)
Establishing a resilient connection layer and a single source of truth.
* **Jsoup Client:** A robust HTTP wrapper to handle connections and document fetching.
* **AppConfig:** Centralized repository for CSS selectors (Product, Category, Stars) and scraping delays to ensure easy maintenance if the target site changes.

### Phase 2: The UI (ANSI Terminal Interface)
Crafting a sophisticated, "white-free" terminal experience.
* **Saturated Palette:** Custom ANSI 256-color integration featuring Deep Blue, Dark Purple, and Ocre tones.
* **User Flow:** A recursive menu system allowing for category selection, star-rating filtering, and terminal clearing for a professional CLI feel.

### Phase 3: The Setup (Discovery Service)
The "intel" phase where the system understands the target environment.
* **Category Service:** Automatically crawls the sidebar to map all available book categories via `CategorySetup`.
* **Dynamic Loading:** Pre-fetching categories before the main loop to ensure zero-latency navigation.

### Phase 4: The Engine (Paginated Processing)
The core logic for deep-crawling multiple pages.
* **Category Processor:** Handles the `while` loop for pagination, detecting the "Next" button and navigating until the end of the category.
* **Politeness Policy:** Implements a configurable `SCRAPE_DELAY_MS` to respect the target server's resources.

### Phase 5: The Parser (Extraction & Validation)
The surgical extraction of data points from HTML elements.
* **Star Mapping:** Converts literal CSS classes (e.g., "Three") into integer values for mathematical filtering.
* **Price Cleaning:** Regex-based cleaning to transform currency strings (e.g., `£51.77`) into `double` values.
* **Book Entity:** Uses Java **Records** for immutable, lightweight data representation.

### Phase 6: Orchestration (Use Case Logic)
Bringing all individual gears into a single resilient machine.
* **BooksSearch Case:** The master controller that orchestrates the flow between UI inputs, Setup services, and the Processor engine.
* **Decoupling:** Zero logic leakage—the UI doesn't know about Jsoup, and the Parser doesn't know about the terminal.

---

## 🚀 Technical Stack

| Category | Technology |
| :--- | :--- |
| **Language** | Java 21+ |
| **Library** | Jsoup (HTML Parsing & Connection) |
| **Architecture** | Clean Architecture / Service Layer Pattern |
| **Interface** | CLI (ANSI 256-Color Palette) |
| **Data Model** | Java Records (Immutable Entities) |
| **Build Tool** | Maven / OpenJDK |

---

## 🎨 Visual Identity (ANSI Palette)

| Element | Color Tone | Hex/ANSI Code |
| :--- | :--- | :--- |
| **Borders** | Deep Blue | `\u001B[38;5;18m` |
| **Titles** | Dark Purple | `\u001B[38;5;54m` |
| **Prices** | True Green | `\u001B[38;5;34m` |
| **Search Info** | Text Ocre | `\u001B[38;5;130m` |
| **Categories** | Steel Blue | `\u001B[38;5;67m` |
| **Error/Exit** | Deep Red | `\u001B[38;5;88m` |

---

## 📂 Project Structure

```text
src/main/java/scraper/app/
├── client/          # Connection logic (Jsoup)
├── config/          # Centralized selectors & URLs (AppConfig)
├── entities/        # Domain models (Book Record)
├── ui/              # Terminal formatting & ANSI colors
└── usecases/        # Orchestration (BooksSearch)
    └── services/    # Parsing & Scraping engines
