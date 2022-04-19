package BibliographyManagementSystem;

import BibliographyManagementSystem.Bib.BibItem;

import javax.swing.*;
import java.awt.*;



public class GUIItemInputStrategy extends ConsoleBibManager implements ItemInputStrategy{
    protected BibItem bibItem;

    public GUIItemInputStrategy(){
    }


    @Override
    public BibItem createBibItemFromInput() {
        bibItem = new BibItem();

        bibItem.setAuthor(authorText.getText());
        bibItem.setTitle(titleText.getText());
        try {
            bibItem.setYear(Integer.parseInt(yearText.getText()));
        }catch (Exception e){
            e.printStackTrace();
        }


        return bibItem;
    }

}
