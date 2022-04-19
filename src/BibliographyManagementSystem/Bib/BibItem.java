package BibliographyManagementSystem.Bib;

public class BibItem{
    private String publicationType;
    private String author;
    private String title;
    private int year;
    private String format;
    private String citeKey;

    public String getPublicationType() {
        return publicationType;
    }

    public void setPublicationType(String publicationType) {
        this.publicationType = publicationType;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public void setCiteKey() {
        this.citeKey = citeKey;
    }

    public String getCiteKey() {
        return citeKey;
    }

    @Override
    public String toString() {
        return "BibItem{" +
                "publicationType='" + publicationType + '\'' +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", format='" + format + '\'' +
                ", citeKey='" + citeKey + '\'' +
                '}';
    }
}
