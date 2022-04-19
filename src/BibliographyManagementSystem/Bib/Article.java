package BibliographyManagementSystem.Bib;

public class Article extends BibItem {
    private String doi;
    private String journal;


    public Article(){
        this.setPublicationType("article");
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public String getDoi() {
        return doi;
    }

    public void setCiteKey() {
        String name = this.getAuthor();
        String year= String.valueOf(this.getYear()).substring(2);
        String journalTitle= this.getJournal();

        if (name.contains(",")){
            name=name.substring(0,name.indexOf(","));
        }

        if(journalTitle.contains(",")){
            journalTitle=journalTitle.substring(0,journalTitle.indexOf(","));
        }

        String citeKey=name+year+journalTitle;
        citeKey=citeKey.toLowerCase();
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public String getJournal() {
        return journal;
    }


    @Override
    public String toString() {
        return this.getFormat()=="Harvard"?
                getAuthor()+". ("+getYear()+"). "+getTitle()+". "+journal+". "+doi+".":
                "@"+getPublicationType()+"{" + getCiteKey() + '\'' +", "+
                        "author='" + getAuthor() + '\'' +", "+
                        "title='" + getTitle() + '\'' +", "+
                        "year=" + getYear() + '\'' +", "+
                        "journal='" + journal + '\'' +", "+
                        "doi='"+ doi + '\''+
                        '}';
    }


}
