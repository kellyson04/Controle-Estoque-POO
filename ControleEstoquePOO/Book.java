package ControleEstoquePOO;

public class Book extends Produto {
    private String author;
    private String genre;
    private String publisher;
    private int pages;

    public Book(String author, String genre, String publisher, int pages, String productName, String productCategory, double productPrice, int productQuantity, String userCpf) {
        super(productName,productCategory,productPrice,productQuantity,userCpf);
        this.author = author;
        this.genre = genre;
        this.publisher = publisher;
        this.pages = pages;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getGenre() {
        return this.genre;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public int getPages() {
        return this.pages;
    }

    @Override
    public String toString() {
        return " Author: " +getAuthor() + " Genre: " +getGenre() + " Publisher: " +getPublisher() + " Pages: " + getPages() + " " + super.toString();
    }

}
