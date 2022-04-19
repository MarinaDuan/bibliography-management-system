package BibliographyManagementSystem.Bib;

public class Book extends BibItem {
    private String publisher;
    private String citeKey;

    public Book() {
        this.setPublicationType("book");
        this.publisher = publisher;
    }

    public void setCiteKey() {
        String name = this.getAuthor();
        String year = String.valueOf(this.getYear());

        if (name.contains(",")){
            name=name.substring(0,name.indexOf(","));
        }
        String citeKey=name+year;
        citeKey=citeKey.toLowerCase();
    }
    public String getCiteKey() {
        return this.citeKey=citeKey;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublisher() {
        return getPublisher();
    }

    @Override
    public String toString() {
        return this.getFormat()=="Harvard"? getAuthor()+". ("+getYear()+"). "+getTitle()+". "+publisher+".":
                "@"+getPublicationType()+"{" + getCiteKey() + '\'' +", "+
                        "author='" + getAuthor() + '\'' +", "+
                        "title='" + getTitle() + '\'' +", "+
                        "year=" + getYear() + '\'' +", "+
                        "publisher='" + publisher + '\'' +
                        '}';
    }


}
