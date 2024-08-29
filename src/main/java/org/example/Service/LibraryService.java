package org.example.Service;

import com.google.gson.Gson;
import org.example.Entity.Books;

import java.io.*;
import java.util.Scanner;

public class LibraryService {
    Books[] books;

    FileReader fileReader;
    Gson gson;
    FileWriter fileWriter;

    String file;

    int counter;

    public LibraryService(Books[] books, Gson gson,String file) {
        this.books = books;
        this.gson = gson;
        this.file = file;
        try {
            this.fileReader = new FileReader(file);
            this.fileWriter = new FileWriter(file,true);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        fillFileLibrary();
    }

    public void fillFileLibrary(){
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Books book = gson.fromJson(line, Books.class);
                book.setId(counter);
                books[counter] = book;
                counter++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showAllBooks(){
        for (int i = 0; i < counter; i++) {
            System.out.println("------------------------");
            System.out.println(books[i].id);
            System.out.println("Title: " + books[i].getTitle());
            System.out.println("Author: " + books[i].getAuthor());
            System.out.println("Date: " + books[i].getDate());
            System.out.println("Price: " + books[i].getPrice());
            System.out.println("------------------------");
        }
    }

    public void addBooks(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please fill out everything in this order: \n" +
                "title,author,date,page,price");
        Books book = new Books();
        String title = scanner.nextLine();
        book.setTitle(title);
        String author = scanner.nextLine();
        book.setAuthor(author);
        int date = scanner.nextInt();
        book.setDate(date);
        int page = scanner.nextInt();
        book.setPages(page);
        float price = scanner.nextFloat();
        book.setPrice(price);
        book.setId(counter);

        books[counter] = book;
        counter++;

        writeBooksToFile(book);
    }
    private void writeBooksToFile(Books b){
        try {
            fileWriter.write(gson.toJson(b)+"\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void getById() {
        try {
            Scanner scanner = new Scanner(System.in);
            showAllBooks();
            int i = scanner.nextInt();
            System.out.println("------------------------");
            System.out.println(books[i].id);
            System.out.println("Title: " + books[i].getTitle());
            System.out.println("Author: " + books[i].getAuthor());
            System.out.println("Date: " + books[i].getDate());
            System.out.println("Price: " + books[i].getPrice());
            System.out.println("------------------------");
        }catch (RuntimeException e){
            System.out.println("Book not Found!");
        }
    }

    public void deleteBookFromLibrary() {
        Scanner scanner = new Scanner(System.in);
        showAllBooks();
        System.out.println("insert Id");
        int id = scanner.nextInt();
        for (int i = id; i < counter; i++) {
            books[i] = books[i+1];
        }
        books[counter] = null;
        counter--;
        updateFile();
        uploadWholeFile();
    }

    private void updateFile(){
        try (FileWriter writer = new FileWriter(file, false)) {
            writer.write("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void uploadWholeFile(){
        for (int i = 0; i < counter; i++) {
            try {
                FileWriter writer = new FileWriter(file, true);
                writer.write(gson.toJson(books[i]) + "\n");
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
