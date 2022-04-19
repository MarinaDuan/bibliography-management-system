package BibliographyManagementSystem;

import BibliographyManagementSystem.Bib.Article;
import BibliographyManagementSystem.Bib.BibItem;

import javax.swing.*;

public class ArticleGUIInputStrategy extends GUIItemInputStrategy{

    public boolean ValidDoi(String doi){
        if(doi.isEmpty()||doi.length()<25){
            return false;
        }
        String prefix=doi.substring(0,25);
        String regex="https://doi.org/\\d{1,2}\\.\\d{1,4}/.*";
        if(prefix.matches(regex)){
            return true;
        }

        return false;
    }

    @Override
    public Article createBibItemFromInput() {

        article.setCiteKey();
        article.setJournal(journalText.getText());
        article.setDoi(doiText.getText());
        String doi=article.getDoi();

        if(!articleGUIInputStrategy.ValidDoi(doi)) System.out.println("DOI is invalid.");

        return article;
    }
}
