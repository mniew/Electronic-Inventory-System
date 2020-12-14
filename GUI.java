/*
 * Marek Niewiadomski
 */
package a3;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.*;
import javax.swing.JButton;

/**
 *
 * @author Niew
 */
public class GUI extends JFrame {

    ArrayList<Product> productList = new ArrayList<>();

    eStoreSearch searchObj = new eStoreSearch();

    JFrame frame = new JFrame("eStore Search");
    JLabel welcome = new JLabel("Welcome eStoreSearch, choose what you would like to do by clicking one of the buttons below.");
    JPanel panelCont = new JPanel();
    ////menu panels////
    JPanel panelMenu = new JPanel();
    JPanel panelTitle = new JPanel();
    JPanel buttonPanel = new JPanel();
    ///////////ADD BOOK////////
    JPanel panelAddBook = new JPanel();
    JPanel textPanel = new JPanel();
    JTextArea textOutput = new JTextArea();
    JPanel addPanel = new JPanel();
    JPanel optionPanel = new JPanel();
    JPanel labelPanel = new JPanel();
    JPanel boxPanel = new JPanel();
    JPanel cmdPanel = new JPanel();
    JLabel type1 = new JLabel("Type:");
    JLabel productID1 = new JLabel("ProductID:");
    JLabel name1 = new JLabel("Name:");
    JLabel price1 = new JLabel("Price:");
    JLabel year1 = new JLabel("Year:");
    JLabel authors1 = new JLabel("Authors:");
    JLabel publishers1 = new JLabel("Publisher:");
    private final String[] typeString = {"Add Electronic", "Add Book"};
    JComboBox prodList = new JComboBox(typeString);
    JTextField prodIDBox1 = new JTextField("");
    JTextField nameBox1 = new JTextField("");
    JTextField priceBox1 = new JTextField("");
    JTextField yearBox1 = new JTextField("");
    JTextField authorsBox1 = new JTextField("");
    JTextField publishersBox1 = new JTextField("");
    JButton resetB1 = new JButton("Reset");
    JButton addB1 = new JButton("Add");

    ///////////////////electronic.///////////////////////////////////////////
    JPanel panelAddElec = new JPanel();
    JPanel textPanel2 = new JPanel();
    JTextArea textOutput2 = new JTextArea();
    JPanel addPanel2 = new JPanel();
    JPanel optionPanel2 = new JPanel();
    JPanel labelPanel2 = new JPanel();
    JPanel boxPanel2 = new JPanel();
    JPanel cmdPanel2 = new JPanel();
    JLabel type2 = new JLabel("Type:");
    JLabel productID2 = new JLabel("ProductID:");
    JLabel name2 = new JLabel("Name:");
    JLabel price2 = new JLabel("Price:");
    JLabel year2 = new JLabel("Year:");
    JLabel maker2 = new JLabel("Maker:");
    private final String[] typeString2 = {"Add Electronic", "Add Book"};
    JComboBox prodList2 = new JComboBox(typeString);
    JTextField prodIDBox2 = new JTextField("");
    JTextField nameBox2 = new JTextField("");
    JTextField priceBox2 = new JTextField("");
    JTextField yearBox2 = new JTextField("");
    JTextField makerBox2 = new JTextField("");
    JButton resetB2 = new JButton("Reset");
    JButton addB2 = new JButton("Add");

    //////////////////////////SERCH//////////////////////////////////////////
    JPanel panelSearch = new JPanel();
    JPanel textPanel3 = new JPanel();
    JTextArea textOutput3 = new JTextArea();
    JPanel addPanel3 = new JPanel();
    JPanel optionPanel3 = new JPanel();
    JPanel labelPanel3 = new JPanel();
    JPanel boxPanel3 = new JPanel();
    JPanel cmdPanel3 = new JPanel();
    JLabel productID3 = new JLabel("ProductID:");
    JLabel name3 = new JLabel("Name:");
    JLabel startYear3 = new JLabel("Start Year:");
    JLabel endYear3 = new JLabel("End Year:");
    JTextField prodIDBox3 = new JTextField("");
    JTextField nameBox3 = new JTextField("");
    JTextField startYearBox3 = new JTextField("");
    JTextField endYearBox3 = new JTextField("");
    JButton resetB3 = new JButton("Reset");
    JButton searchB3 = new JButton("Search");

    ///////////////////
    JButton buttonBook = new JButton("Add a Book");
    JButton buttonElec = new JButton("Add a Electronic");
    JButton buttonSearch = new JButton("Search Inventory");
    JButton buttonMenu1 = new JButton("Menu");
    JButton buttonMenu2 = new JButton("Menu");
    JButton buttonMenu3 = new JButton("Menu");
    CardLayout cl = new CardLayout(); //enables you to show or hide panels
    /**
     * calls the before run program that reads the file provided
     * @param newFile the file sent in through the command line
     */
    void beforeRun(String newFile) {
        try{
        searchObj.startUp(newFile, productList);
        }catch (Exception ex) {
            textOutput2.append("Error: " + ex.getMessage() + "\n");
            textOutput2.append("-------------------------------------------------\n");
            textOutput.append("Error: " + ex.getMessage() + "\n");
            textOutput.append("-------------------------------------------------\n");
            textOutput3.append("Error: " + ex.getMessage() + "\n");
            textOutput3.append("-------------------------------------------------\n");
        }
    }
    /**
     * 
     */
    public GUI() {

        panelCont.setLayout(cl);  //uses card laayout to cwitch between windows
        ///////////////////////MENU/////////////////////////////////////////////
        panelMenu.setLayout(new BorderLayout());
        panelTitle.add(welcome);              //adding welcome message to the title panel as a label
        panelMenu.add(panelTitle, BorderLayout.NORTH);  //add the title to the menu

        buttonPanel.add(buttonBook); //add the buttons to menu the button panel
        buttonPanel.add(buttonElec);
        buttonPanel.add(buttonSearch);
//        buttonPanel.add();
        panelMenu.add(buttonPanel, BorderLayout.CENTER);  //buttonPanel added to the menu panel    
        /////////////////////Add Book Panel///////////////////////////////////////////
        panelAddBook.setLayout(new GridLayout(2, 1)); //sets the layout using gridpanel
        addPanel.setLayout(new GridLayout(1, 2));  //sets layout
        optionPanel.setLayout(new GridLayout(1, 2)); //sets layout
        labelPanel.setLayout(new GridLayout(7, 1)); //sets the layout of the label panel
        labelPanel.add(type1);          //adds type label
        labelPanel.add(productID1);     //adds the product ID label
        labelPanel.add(name1);          // adds the name label
        labelPanel.add(price1);         //adds the price label
        labelPanel.add(year1);      //adds the year label
        labelPanel.add(authors1);       //adds the author label
        labelPanel.add(publishers1);    //adds the publisher label
        optionPanel.add(labelPanel);        //adds the label panel to the opton panel
        boxPanel.setLayout(new GridLayout(7, 1)); //sets the grid layout t
        prodList.setSelectedIndex(1);  //ensures the combobox displays the appropriate message
        boxPanel.add(prodList);     //adds the appropriate j text fields
        boxPanel.add(prodIDBox1);
        boxPanel.add(nameBox1);
        boxPanel.add(priceBox1);
        boxPanel.add(yearBox1);
        boxPanel.add(authorsBox1);
        boxPanel.add(publishersBox1);
        optionPanel.add(boxPanel);    //adds the option panel to the box panel
        addPanel.add(optionPanel);    //option panel to the add Panel
        cmdPanel.setLayout(new GridLayout(3, 1));   //sets grid layout
        cmdPanel.add(buttonMenu1);  //adds menu button
        cmdPanel.add(resetB1);  //adds rest button
        cmdPanel.add(addB1); //adds the 'add' button
        addPanel.add(cmdPanel);
        panelAddBook.add(addPanel);
        textOutput = new JTextArea();				//TextArea to be displayed 
        JScrollPane scrollText = new JScrollPane(textOutput);        //if the line is too long a scroll bar will be used
        textOutput.setEditable(false);					//will  not be able to edit the output
        scrollText.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); //sets the scroll bars
        scrollText.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);		
        panelAddBook.add(scrollText);
        /////////////////////////////Add Elec///////////////////////////////////
        //Almost identicle steps are repeated in integreating the the add Electronic Panel
        panelAddElec.setLayout(new GridLayout(2, 1));
        addPanel2.setLayout(new GridLayout(1, 2));
        optionPanel2.setLayout(new GridLayout(1, 2));
        labelPanel2.setLayout(new GridLayout(6, 1));
        labelPanel2.add(type2);
        labelPanel2.add(productID2);
        labelPanel2.add(name2);
        labelPanel2.add(price2);
        labelPanel2.add(year2);
        labelPanel2.add(maker2);
        optionPanel2.add(labelPanel2);
        boxPanel2.setLayout(new GridLayout(6, 1));
        prodList2.setSelectedIndex(0);
        boxPanel2.add(prodList2);
        boxPanel2.add(prodIDBox2);
        boxPanel2.add(nameBox2);
        boxPanel2.add(priceBox2);
        boxPanel2.add(yearBox2);
        boxPanel2.add(makerBox2);
        optionPanel2.add(boxPanel2);
        addPanel2.add(optionPanel2);
        cmdPanel2.setLayout(new GridLayout(3, 1));
        cmdPanel2.add(buttonMenu2);
        cmdPanel2.add(resetB2);
        cmdPanel2.add(addB2);
        addPanel2.add(cmdPanel2);
        panelAddElec.add(addPanel2);
        textOutput2 = new JTextArea();				
        textOutput2.setEditable(false);
        JScrollPane scrollText2 = new JScrollPane(textOutput2);
        scrollText2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);	
        scrollText2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);		
        panelAddElec.add(scrollText2);
        /////////////////////////SEARCH/////////////////////////////////////////
        //same logic used in creating the Search panel
        panelSearch.setLayout(new GridLayout(2, 1));
        addPanel3.setLayout(new GridLayout(1, 2));
        optionPanel3.setLayout(new GridLayout(1, 2));
        labelPanel3.setLayout(new GridLayout(4, 1));
        labelPanel3.add(productID3);
        labelPanel3.add(name3);
        labelPanel3.add(startYear3);
        labelPanel3.add(endYear3);
        optionPanel3.add(labelPanel3);
        boxPanel3.setLayout(new GridLayout(4, 1));
        boxPanel3.add(prodIDBox3);
        boxPanel3.add(nameBox3);
        boxPanel3.add(startYearBox3);
        boxPanel3.add(endYearBox3);
        optionPanel3.add(boxPanel3);
        addPanel3.add(optionPanel3);
        cmdPanel3.setLayout(new GridLayout(3, 1));
        cmdPanel3.add(buttonMenu3);
        cmdPanel3.add(resetB3);
        cmdPanel3.add(searchB3);
        addPanel3.add(cmdPanel3);
        panelSearch.add(addPanel3);
        textOutput3 = new JTextArea(15, 50);				//Our TextArea that will display our messages and user output. Code for the text area was derived from an example posted by a CIS 2430 TA Irenaeus Chan. Source : https://github.com/IrenaeusChan/LabAssignment5Example 
        textOutput3.setEditable(false);					//We don't want them to be able to edit our direct output
        JScrollPane scrollText3 = new JScrollPane(textOutput3);		//Allows the user to scroll on the TextArea
        scrollText3.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);	//Scroll
        scrollText3.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);		//Scroll Vertical
        panelSearch.add(scrollText3);
        ////////////////////////////////////////////////////////////////////////
        panelCont.add(panelMenu, "menu"); //add 1st and second panels and third on container panels
        panelCont.add(panelAddBook, "book"); 
        panelCont.add(panelAddElec, "elec");
        panelCont.add(panelSearch, "search");
        cl.show(panelCont, "menu");  //this will determine which panel will be displayed on startup given by the identifier string

        toBookPanel bookPanel = new toBookPanel();  //declares the classes that contain action that implement action listeners with action performed methods
        toElecPanel elecPanel = new toElecPanel();
        toSearchPanel searchPanel = new toSearchPanel();
        toMainMenu mainMenu = new toMainMenu();
        toReset reset = new toReset();
        toAddBook addBook = new toAddBook();
        toAddElec addElec = new toAddElec();
        toSearch search = new toSearch();
        toSwitchPanel switchPanel = new toSwitchPanel();

        buttonBook.addActionListener(bookPanel); //links an action to thier respective classes
        buttonElec.addActionListener(elecPanel);
        buttonSearch.addActionListener(searchPanel);
        buttonMenu1.addActionListener(mainMenu);
        buttonMenu2.addActionListener(mainMenu);
        buttonMenu3.addActionListener(mainMenu);
        resetB1.addActionListener(reset);
        resetB2.addActionListener(reset);
        resetB3.addActionListener(reset);
        addB1.addActionListener(addBook);
        addB2.addActionListener(addElec);
        searchB3.addActionListener(search);
        prodList2.addActionListener(switchPanel);
        prodList.addActionListener(switchPanel);

        frame.add(panelCont);  //adds the content panel
        
        frame.addWindowListener(new java.awt.event.WindowAdapter() {                         //ensures that when the window is closedthe program writes to the file before exiting the system
            @Override                                                                        //code derived from an example given on stackoverflow source: http://stackoverflow.com/questions/9093448/do-something-when-the-close-button-is-clicked-on-a-jframe
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                try{
                    searchObj.writetoFile(productList);
                }catch(Exception ex)
                {
                    System.out.println("Error: " + ex.getMessage() + "\n"); //displays message to the terminal
                    System.out.println("-------------------------------------------------\n");
                }
                System.exit(0);
            }
        });

        frame.setSize(700, 700);  //sets frame size 
        frame.setVisible(true);  //makes the frame visible

    }

    private class toSwitchPanel implements ActionListener {
        /**
         * switches the panels
         * @param e an event
         */
        @Override
        public void actionPerformed(ActionEvent e) {

            JComboBox cBox = (JComboBox) e.getSource();
            String comboBox = (String) cBox.getSelectedItem();

            if (comboBox.equalsIgnoreCase("Add Electronic")) { //when the text in the comboBox is 'add electronic' switch the panel
                cl.show(panelCont, "elec");  //switches panel
                prodList2.setSelectedIndex(0);  //sets the correct text to be displayed in the combo box
            } else if (comboBox.equalsIgnoreCase("Add Book")) {  //when the text in the comboBox is 'add book' switch the panel
                cl.show(panelCont, "book");  //switches panel
                prodList.setSelectedIndex(1); //sets the correct text to be displayed in the combo box

            }

        }
    }

    private class toAddElec implements ActionListener {
        /**
         * adds to the electronic list
         * @param e an event
         */
        @Override
        public void actionPerformed(ActionEvent e) {

            String productID;
            String name;
            String price;
            String year;  //variables declared in this scope are discarded after 
            String authors = " ";
            String publishers = " ";
            String maker;
            String type = "electronics";

            productID = prodIDBox2.getText();   //takes the strings form the text area
            name = nameBox2.getText();
            price = priceBox2.getText();
            year = yearBox2.getText();
            maker = makerBox2.getText();
            
                try {
                    productList.add(new Electronics(type, productID, name, price, year, maker));    //adds to the electronics list
                    int p = productList.size() - 1;
                    textOutput2.append(productList.get(p).toString());
                } catch (Exception ex) {    //if adding it fails prints out the exception

                    textOutput2.append("Error: " + ex.getMessage() + "\n");
                    textOutput2.append("Check to make sure ProductID, Name, and Year have appropriate values.\n");
                    textOutput2.append("-------------------------------------------------\n");
                }
            }
        }
  

    private class toSearch implements ActionListener {
        /**
         * searches through the array list for the respective stuff
         * @param e event
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            String productID = "";
            String name = "";
            String startYear = "";
            String endYear = "";

            productID = prodIDBox3.getText();
            name = nameBox3.getText();
            startYear = startYearBox3.getText();
            endYear = endYearBox3.getText();

            if (name.equalsIgnoreCase("") && productID.equalsIgnoreCase("") && startYear.equalsIgnoreCase("") && endYear.equalsIgnoreCase("")) {    //if all the fields are left open print out all the print out the list
                for (int p = 0; p < productList.size(); p++) {
                    textOutput3.append(productList.get(p).toString());
                }
            }
            if (!name.equals("")) {  // if the name is entered search for it
                String delimiters = ",.;: ";

                String search = name;

                search = search.replace(",", ""); //filters the key word/ word to be searched replacing any accidental characters with nothing...
                search = search.replace(".", "");
                search = search.replace(";", "");
                search = search.replace(":", "");

                for (int p = 0; p < productList.size(); p++) {  //itterates through the entire list

                    String split = productList.get(p).getName();  //assignes the string in get name to split, as the string to be split up

                    StringTokenizer nextWord = new StringTokenizer(split, delimiters); //splits using delimiters and assignes to nexword

                    String[] result = productList.get(p).getName().split("\\s"); //counts the number of words. works assuming each word is sperated by a space

                    for (int w = 0; w < result.length; w++) {  //uses the result string array for the length and uses that to go through nextWord without going out of bounds
                        String word = nextWord.nextToken();

                        if (word.equalsIgnoreCase(search)) { //prints the item matched if found
                            textOutput3.append(productList.get(p).toString());
                        }

                    }
                }
            }

            if (!productID.equals("")) {  //if there is a string in productID

                int searchNum = Integer.parseInt(productID);  //coverts it to an integer
                int num;
                for (int p = 0; p < productList.size(); p++) {
                    num = Integer.parseInt(productList.get(p).getProductID());
                    if (Integer.compare(num, searchNum) == 0) { //compares the numbers if a match is found it will print out that index in the array 
                        textOutput3.append(productList.get(p).toString());
                    }
                }
            }

            if (!startYear.equals("") && endYear.equalsIgnoreCase("")) { //if only the start year is entered
                int sYear = Integer.parseInt(startYear);
                for (int p = 0; p < productList.size(); p++) {          
                    if (Integer.parseInt(productList.get(p).getYear()) >= sYear) {  //prints out any years that are greater
                        textOutput3.append(productList.get(p).toString());
                    }
                }
            }

            if (!endYear.equals("") && startYear.equalsIgnoreCase("")) { //if only the end year is entered
                int eYear = Integer.parseInt(endYear);
                for (int p = 0; p < productList.size(); p++) {
                    if (Integer.parseInt(productList.get(p).getYear()) <= eYear) {  //prints out any years that are less then
                        textOutput3.append(productList.get(p).toString());
                    }
                }
            }

            if (!startYear.equals("") && !endYear.equals("")) { //if both start year and end year are entered
                int eYear = Integer.parseInt(endYear);
                int sYear = Integer.parseInt(startYear);
                for (int p = 0; p < productList.size(); p++) {
                    if ((Integer.parseInt(productList.get(p).getYear()) >= sYear && (Integer.parseInt(productList.get(p).getYear()) <= eYear))) { //prints out any vlues inbetween the two
                       textOutput3.append(productList.get(p).toString());
                    }
                }
            }

        }
    }

    private class toAddBook implements ActionListener {
        /**
         * adds to the book array list
         * @param e is an exception
         */
        @Override
        public void actionPerformed(ActionEvent e) {

            String productID;
            String name;
            String price;
            String year;
            String authors;
            String publishers;
            String maker = " ";
            String type = "book";

            productID = prodIDBox1.getText();
            name = nameBox1.getText();
            price = priceBox1.getText();
            year = yearBox1.getText();
            authors = authorsBox1.getText();
            publishers = publishersBox1.getText();

                try {
                    productList.add(new Book(type, productID, name, price, year, authors, publishers));
                    int p = productList.size() - 1;
                    textOutput.append(productList.get(p).toString());
                } catch (Exception ex) {
                    textOutput.append("Error: " + ex.getMessage() + "\n");
                    textOutput.append("Check to make sure ProductID, Name, and Year have appropriate values.\n");
                    textOutput.append("-------------------------------------------------\n");
                }

        }
    }

    private class toReset implements ActionListener {
        /**
         * resets all the text boxes
         * @param e actions
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            yearBox1.setText("");
            prodIDBox1.setText("");
            nameBox1.setText("");
            priceBox1.setText("");
            authorsBox1.setText("");
            publishersBox1.setText("");

            yearBox2.setText("");
            prodIDBox2.setText("");
            nameBox2.setText("");
            priceBox2.setText("");
            makerBox2.setText("");

            prodIDBox3.setText("");
            nameBox3.setText("");
            startYearBox3.setText("");
            endYearBox3.setText("");

            textOutput.setText("");
            textOutput2.setText("");
            textOutput3.setText("");
        }
    }

    private class toBookPanel implements ActionListener {
        /**
         * Switches to the book panels
         * @param e in an action
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            cl.show(panelCont, "book");
            prodList.setSelectedIndex(1);
        }
    }

    private class toElecPanel implements ActionListener {
        /**
         * switches to the elect panel
         * @param e the action
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            cl.show(panelCont, "elec");
            prodList.setSelectedIndex(0);
        }
    }

    private class toSearchPanel implements ActionListener {
        /**
         * switches to the search panel
         * @param e the action
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            cl.show(panelCont, "search");
        }
    }

    private class toMainMenu implements ActionListener {
        /**
         * switches to the menu panel
         * @param e 
         */
        @Override
        public void actionPerformed(ActionEvent e) {

            cl.show(panelCont, "menu");
        }
    }

}
