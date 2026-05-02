package model;

public class Book {
    private int id;
    private String bookCode;
    private String title;
    private String author;
    private double price;
    private String category;
    private int stock;

    public Book(int id, String bookCode, String title, String author,
                double price, String category, int stock) {
        this.id = id;
        this.bookCode = bookCode;
        this.title = title;
        this.author = author;
        this.price = price;
        this.category = category;
        this.stock = stock;
    }

    public int getId() { return id; }
    public String getBookCode() { return bookCode; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public double getPrice() { return price; }
    public String getCategory() { return category; }
    public int getStock() { return stock; }

    public String getFormattedPrice() {
        return String.format("%,.0f VND", price);
    }

    @Override
    public String toString() {
        return String.format("[%s] %s - %s | %s | Kho: %d",
                bookCode, title, author, getFormattedPrice(), stock);
    }
}
