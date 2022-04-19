package BibliographyManagementSystem;

import BibliographyManagementSystem.Bib.BibItem;

import java.util.*;

public class BibEntry implements BibFileReader{
    private Map<String, BibItem> entries;
    private static BibEntry bib;
    private Map.Entry entry;

    protected BibEntry(){
        this.entries=new HashMap<>();
    }
    public static BibEntry getInstance(){
        if(bib==null) bib=new BibEntry();
        return bib;
    }
    public BibItem getBibItem(String citeKey){
        return entries.get(citeKey);
    }

    public void addBibItem(BibItem item){
        entries.put(item.getCiteKey(),item);
        System.out.println("Add new entry with cite-key "+item.getCiteKey()+": "+item.toString());
        ArrayList<BibItem> BibItemList=new ArrayList<>(entries.values());
        Collections.sort(BibItemList, Collections.reverseOrder());
    }



    public Map<String, BibItem> getEntries() {
        return entries;
    }

    public BibItem delete(String citeKey){
        BibItem removal = null;
        if(entries.containsKey(citeKey)){
        removal=entries.get(citeKey);
        removal.setFormat("BibTex");
        entries.remove(citeKey);
        }
        return removal==null? null :entries.get(citeKey);
    }

    public BibItem viewBibEntries() {
        //convert the hashmap to treemap to use the comparator to compare the year
        Map<BibItem,String> sorted = new TreeMap<BibItem,String>(
                new Comparator<BibItem>() {
                    @Override
                    public int compare(BibItem o1, BibItem o2) {
                        return o1.getYear() - o2.getYear();
                    }
                }
        );
        for (BibItem item : sorted.keySet()) {
            item.setFormat("Harvard");
            sorted.put(item,item.getCiteKey());
        }
        return (BibItem) sorted.keySet();
    }

    @Override
    public void readFromFile(String fileName) {
        System.out.println("File"+fileName+" import successfully");
    }
}
