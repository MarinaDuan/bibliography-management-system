package BibliographyManagementSystem;

import BibliographyManagementSystem.Bib.BibItem;

public class ConcreteBibItemFactory implements BibItemFactory{
    BookGUIInputStrategy bookGUIInputStrategy;
    ArticleGUIInputStrategy articleGUIInputStrategy;
    TechReportGUIInputStrategy techReportGUIInputStrategy;

  public ConcreteBibItemFactory(BookGUIInputStrategy bookGUIInputStrategy,
                                ArticleGUIInputStrategy articleGUIInputStrategy,
                                TechReportGUIInputStrategy techReportGUIInputStrategy){
        this.bookGUIInputStrategy=bookGUIInputStrategy;
        this.articleGUIInputStrategy=articleGUIInputStrategy;
        this.techReportGUIInputStrategy=techReportGUIInputStrategy;
    }

    @Override
    public BibItem createBibItem(String publicationType) {
        BibItem bibItem=null;
        if(publicationType.equals("book")){
            bibItem=createBibItemUsingStrategy(this.bookGUIInputStrategy);
        }else if(publicationType.equals("article")) {
            bibItem = createBibItemUsingStrategy(this.articleGUIInputStrategy);
        }else if (publicationType.equals("techReport")){
            bibItem = createBibItemUsingStrategy(this.techReportGUIInputStrategy);
        }else{
            System.out.println("Other publication type");
        }
        return bibItem;
    }


    public BibItem createBibItemUsingStrategy(GUIItemInputStrategy itemInputStrategy) {
        return itemInputStrategy.createBibItemFromInput();
    }

}
