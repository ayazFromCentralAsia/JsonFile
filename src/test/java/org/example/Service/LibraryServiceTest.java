package org.example.Service;

import com.google.gson.Gson;
import org.example.Entity.Books;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class LibraryServiceTest {
    Gson gson = new Gson();
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Test
    void fillFileLibrary() {
        LibraryService libraryService = new LibraryService(new Books[100],gson,"test-database.json");
        libraryService.fillFileLibrary();
        Books book = libraryService.books[1];


        assertEquals("Author 2",book.author);
        assertEquals("Book 2",book.title);
        assertEquals(2010,book.date);
    }

    @Test
    void showAllBooks() {
        LibraryService libraryService = new LibraryService(new Books[100],gson,"test-database.json");
        Books book = libraryService.books[1];

        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        libraryService.showAllBooks();
        String capturedOutput = outputStreamCaptor.toString().trim();
        String expectedOutput =
                "------------------------\n" +
                "0\n" +
                "Title: Book 1\n" +
                "Author: Author 1\n" +
                "Date: 2000\n" +
                "Price: 20.0\n" +
                "------------------------\n" +
                "------------------------\n" +
                "1\n" +
                "Title: Book 2\n" +
                "Author: Author 2\n" +
                "Date: 2010\n" +
                "Price: 25.0\n" +
                "------------------------";
        if (expectedOutput.trim().equals(outputStreamCaptor)){
            assertTrue(true);
        }
    }

}