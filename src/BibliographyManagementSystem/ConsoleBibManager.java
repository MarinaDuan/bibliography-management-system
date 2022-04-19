package BibliographyManagementSystem;

import BibliographyManagementSystem.Bib.Article;
import BibliographyManagementSystem.Bib.BibItem;
import BibliographyManagementSystem.Bib.Book;
import BibliographyManagementSystem.Bib.TechReport;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ConsoleBibManager extends JFrame{

    JFrame frame;
    JButton loadButton,saveButton,addButton,deleteButton,viewButton,quitButton;
    JPanel buttonPanel;

    static BookGUIInputStrategy bookGUIInputStrategy;
    static ArticleGUIInputStrategy articleGUIInputStrategy;
    static TechReportGUIInputStrategy techReportGUIInputStrategy;
    static ConcreteBibItemFactory bibItemFactory;
    static BibEntry entries;
    JTextField authorText,titleText, yearText, publisherText,journalText,doiText,institutionText;
    JTextArea viewArea;
    BibItem bibItem;
    Book book;
    Article article;
    TechReport techReport;


    public static void main(String[] args){
        entries=BibEntry.getInstance();
        bookGUIInputStrategy = new BookGUIInputStrategy();
        articleGUIInputStrategy = new ArticleGUIInputStrategy();
        techReportGUIInputStrategy = new TechReportGUIInputStrategy();
        bibItemFactory=new ConcreteBibItemFactory(bookGUIInputStrategy,
                articleGUIInputStrategy,techReportGUIInputStrategy);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ConsoleBibManager consoleBibManager=new ConsoleBibManager();
            }
        });


    }

    public ConsoleBibManager(){
        frame = new JFrame("Bibliography Management System");
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,700);
        frame.setResizable(true);
        frame.setVisible(true);



        buttonPanel= new JPanel();

        //Load a BibTeX file to the bibliography
        loadButton = new JButton("Load");
        JLabel readFile=new JLabel("Enter the filename to read");
        JTextField readName=new JTextField(10);
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                entries.readFromFile(readName.getText());
            }
        });

        buttonPanel.add(readFile);
        buttonPanel.add(readName);
        buttonPanel.add(loadButton);

        //Save your bibliography to a file
        JLabel fileNameL=new JLabel("FileName");
        JTextField fileNameText=new JTextField(10);

        saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fileName = fileNameText.getText();
                BufferedWriter bufferedWriter = null;
                FileWriter fileWriter = null;
                try {
                    fileWriter = new FileWriter(fileName + ".bib");
                    bufferedWriter = new BufferedWriter(fileWriter);
                    for (BibItem i : entries.getEntries().values()) {
                        i.setFormat("BibTex");
                        bufferedWriter.write(i.toString());
                        bufferedWriter.newLine();
                        bufferedWriter.flush();
                    }
                    System.out.println("Save as file: " + fileName + ".bib successfully.");
                } catch (IOException ee) {
                    ee.printStackTrace();
                    System.out.println("Exceptions!");
                } finally {
                    try {
                        bufferedWriter.close();
                        fileWriter.close();
                    } catch (IOException ee) {
                        ee.printStackTrace();
                    }
                }
            }
        });

        buttonPanel.add(fileNameL);
        buttonPanel.add(fileNameText);
        buttonPanel.add(saveButton);

        //Add an entry to the bibliography
        addButton = new JButton("Add an entry to the bibliography");
        buttonPanel.add(addButton);
        Label authorL=new Label("Author");
        authorText=new JTextField(20);
        buttonPanel.add(authorL);
        buttonPanel.add(authorText);
        Label titleL=new Label("Title");
        titleText=new JTextField(20);
        Label yearL=new Label("Year");
        yearText=new JTextField(20);

        buttonPanel.add(yearL);
        buttonPanel.add(yearText);
        buttonPanel.add(titleL);
        buttonPanel.add(titleText);

        JLabel publisherL=new JLabel("publisher");
        publisherText=new JTextField(20);
        buttonPanel.add(publisherL);
        buttonPanel.add(publisherText);

        JLabel journalL=new JLabel("Journal");
        journalText=new JTextField(20);

        JLabel doiL=new JLabel("DOI");
        doiText=new JTextField(20);


        buttonPanel.add(journalL);
        buttonPanel.add(journalText);
        buttonPanel.add(doiL);
        buttonPanel.add(doiText);

        JLabel institutionL=new JLabel("Institution");
        institutionText=new JTextField(20);
        buttonPanel.add(institutionL);
        buttonPanel.add(institutionText);

        JButton addItem=new JButton("Add input Item");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] options = {"book",
                        "article",
                        "techReport"};
                int n = JOptionPane.showOptionDialog(frame,
                        "Which type of publications would you like to add?",
                        "Publications",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[2]);

                if(n==JOptionPane.YES_OPTION){
                    book= bookGUIInputStrategy.createBibItemFromInput();
                    viewArea.setText(book.toString());
                    entries.addBibItem(bibItem);
                }else if (n == JOptionPane.NO_OPTION) {
                    article= articleGUIInputStrategy.createBibItemFromInput();
                    viewArea.setText(article.toString());
                    entries.addBibItem(article);
                }else if (n == JOptionPane.CANCEL_OPTION) {
                    techReport= techReportGUIInputStrategy.createBibItemFromInput();
                    viewArea.setText(techReport.toString());
                    entries.addBibItem(techReport);
                }
            }
        });


        //Delete an entry from the bibliography"
        deleteButton = new JButton("Delete");
        JLabel deleteLabel=new JLabel("CiteKey");
        JTextField deleteField=new JTextField(10);
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String itemToRemove=deleteField.getText();
                viewArea.setText(entries.getBibItem(itemToRemove).toString());
                entries.delete(itemToRemove);
            }
        });
        buttonPanel.add(deleteLabel);
        buttonPanel.add(deleteField);
        buttonPanel.add(deleteButton);

        //View the bibliography entries
        viewButton = new JButton("View");
        viewArea=new JTextArea(20,20);
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewArea.setText(entries.viewBibEntries().toString());
            }
        });
        buttonPanel.add(viewArea);
        buttonPanel.add(viewButton);


        quitButton = new JButton("Quit");
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        buttonPanel.add(quitButton);


        frame.add(buttonPanel,BorderLayout.PAGE_START);

    }
}
