package org.example.Entity;

public class Books {
    public int id;
    public String title;
    public String author;
    public int date;
    public int pages;
    public float price;


    public Books() {
    }

    public Books(String title, String author, int date, int pages, float price){
        this.title = title;
        this.author = author;
        this.date = date;
        this.pages = pages;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }


    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Books{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", date=" + date +
                ", pages=" + pages +
                ", price=" + price +
                '}';
    }
}
