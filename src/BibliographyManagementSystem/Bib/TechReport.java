package BibliographyManagementSystem.Bib;


public class TechReport extends BibItem {

    private String institution;

    public TechReport() {
        this.setPublicationType("techReport");
        this.institution = institution;
    }

    public void setCiteKey() {
        String name = this.getAuthor();
        String year = String.valueOf(this.getYear());

        if (name.contains(",")){
            name=name.substring(0,name.indexOf(","));
        }
        String citeKey=name+":"+year;
        citeKey = citeKey.toLowerCase();
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getInstitution() {
        return getInstitution();
    }

    @Override
    public String toString() {
        return this.getFormat()=="Harvard"? getAuthor()+". ("+getYear()+"). "+getTitle()+". "+institution+".":
                "@"+getPublicationType()+"{" + getCiteKey() + '\'' +", "+
                        "author='" + getAuthor() + '\'' +", "+
                        "title='" + getTitle() + '\'' +", "+
                        "year=" + getYear() + '\'' +", "+
                        "institution='" + institution + '\'' +
                        '}';
    }
}
