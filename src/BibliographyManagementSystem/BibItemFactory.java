package BibliographyManagementSystem;

import BibliographyManagementSystem.Bib.BibItem;

public interface BibItemFactory {
    public BibItem createBibItem(String bibItem);
}
