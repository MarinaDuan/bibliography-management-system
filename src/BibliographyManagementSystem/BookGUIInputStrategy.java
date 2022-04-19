package BibliographyManagementSystem;

import BibliographyManagementSystem.Bib.BibItem;
import BibliographyManagementSystem.Bib.Book;

import javax.swing.*;


public class BookGUIInputStrategy extends GUIItemInputStrategy {

    public BookGUIInputStrategy() {

    }

    @Override
    public Book createBibItemFromInput() {
        Book bibItem= new Book();
        bibItem.setAuthor(authorText.getText());
        bibItem.setTitle(titleText.getText());
        try {
            bibItem.setYear(Integer.parseInt(yearText.getText()));
        }catch (Exception e){
            e.printStackTrace();
        }
        bibItem.setCiteKey();
        bibItem.setPublisher(publisherText.getText());

        return bibItem;
    }

}
