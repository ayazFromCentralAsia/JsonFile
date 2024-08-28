package org.example;

import com.google.gson.Gson;
import org.example.Entity.Books;
import org.example.Service.LibraryService;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Gson gson = new Gson();
        LibraryService libraryService = new LibraryService(new Books[100],gson,"database.json");
        boolean exit = false;
        while (exit == false){
            System.out.println("What do you want to do ?" +
                    "\n1 Add Book: add" +
                    "\n2 Get Book: id" +
                    "\n3 Buy Book: buy" +
                    "\n4 Show all Book: show" +
                    "\n5 Exit from App: exit");
            String s = scanner.nextLine().toLowerCase();
            switch (s){
                case "add":
                    libraryService.addBooks();
                    break;
                case "id":
                    libraryService.getById();
                    break;
                case "buy":
                    libraryService.deleteBookFromLibrary();
                    break;
                case "show":
                    libraryService.showAllBooks();
                    break;
                case "exit":
                    exit = true;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + s);
            }
        }
    }
}

//
//Gson gson = new Gson();
//Books firstBooks = new Books(1,"Sword art online","Wiliam",2005,true,200, 50.2F);
//String str = gson.toJson(firstBooks);
//Books books = gson.fromJson(str, Books.class);
//        System.out.println(str);
//String s = str;
//        try {
//BufferedReader bufferedReader = new BufferedReader(new FileReader("database.json"));
//s = bufferedReader.readLine();
//        } catch (IOException e) {
//        throw new RuntimeException(e);
//        }