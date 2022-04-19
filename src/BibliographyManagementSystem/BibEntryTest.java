package BibliographyManagementSystem;

import BibliographyManagementSystem.Bib.BibItem;
import BibliographyManagementSystem.Bib.Book;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BibEntryTest {
    BibEntry bibEntry=BibEntry.getInstance();
    Book book;
    void readFromFile(String fileName) {
        book=new Book();
        book.setAuthor("Hawking, Stephen");
        book.setTitle("A Brief History of Time: From the Big Bang to Black Holes");
        book.setYear(1988);
        book.setPublisher("Bantam");
        book.setCiteKey();
        bibEntry.addBibItem(book);
    }

    @Test
    public void read(){
        readFromFile("fileName");
        assertEquals(bibEntry.getBibItem(book.getCiteKey()),book);
    }


}