package BibliographyManagementSystem;

public interface ItemInputStrategy<BibItem> {
    public abstract BibliographyManagementSystem.Bib.BibItem createBibItemFromInput();
}
