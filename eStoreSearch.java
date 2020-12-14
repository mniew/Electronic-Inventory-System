/*
 * Marek Niewiadomski
 */
package a3;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Niew
 */
public class eStoreSearch {

    private int count = 0;
    private int i = 0;
    int added = 0;

    /**
     *runs when the program starts. reads the input file adding it to the list.
     *
     * @param file takes a file as input through the command line
     * @param productList adds to the product list as it parses the input file.
     * @throws Exception if the start up file cannot be found
     */
    void startUp(String file, ArrayList<Product> productList) throws Exception {

        String sLine = "";
        try { //if there is an error in opening the file catch it and display the message
            Scanner fromFile = null;
            // Scanner fromFile = new Scanner(file);   //takes input from the file instead of from the keyboard
            fromFile = new Scanner(new FileInputStream(file));
            while (fromFile.hasNextLine()) {  //ensures there is a next line
                count++;
                sLine = fromFile.nextLine();
                sLine = sLine.replace("\"", "");    //removes quotations and replaces them with empty spaces

                String delimiters = " ";
                String[] typeTok = sLine.split(delimiters);  //slipts the string at the spaces

                if (typeTok[0].equalsIgnoreCase("type") && typeTok[2].equalsIgnoreCase("book")) {       //if the first string is type and the second string is book than there is tha start of data for that particular object
////////////////////////get the id number
                    sLine = fromFile.nextLine();
                    count++; // counts the number of lines
                    sLine = sLine.replace("\"", "");
                    String[] idTok = sLine.split(delimiters); //again slpits at the delimiters and saves the third string
                    String id = idTok[2];
/////////////////////////gets the name from the file
                    sLine = fromFile.nextLine();
                    count++;
                    sLine = sLine.replace("\"", "");
                    String[] nameTok = sLine.split(delimiters); // slipts lines at the delimiters
                    String name = "";
                    for (int n = 2; n < nameTok.length; n++) {              //takes into account all the words that can be in the name, adds them together skipping the 'name' and '=' words
                        if (n < nameTok.length - 1) {
                            name = name + nameTok[n] + " ";                 //this is repeated for the rest of the identifiers ex. price, year, author...
                        } else if (n < nameTok.length) {
                            name = name + nameTok[n];
                        }
                    }
///////////////////////////gets the price from the file
                    sLine = fromFile.nextLine();
                    count++;
                    sLine = sLine.replace("\"", "");
                    String[] priceTok = sLine.split(delimiters);
                    String price = priceTok[2];
////////////////////gets the year from the file
                    sLine = fromFile.nextLine();
                    count++;
                    sLine = sLine.replace("\"", "");
                    String[] yearTok = sLine.split(delimiters);
                    String year = yearTok[2];
////////////////////////////gets the author from the file
                    sLine = fromFile.nextLine();
                    count++;
                    sLine = sLine.replace("\"", "");
                    String[] authorTok = sLine.split(delimiters);
                    String author = "";
                    for (int n = 2; n < authorTok.length; n++) {
                        if (n < authorTok.length - 1) {
                            author = author + authorTok[n] + " ";
                        } else if (n < authorTok.length) {
                            author = author + authorTok[n];
                        }
                    }
/////////////////////////////gets the publisher from the file
                    sLine = fromFile.nextLine();
                    count++;
                    sLine = sLine.replace("\"", "");
                    String[] publisherTok = sLine.split(delimiters);
                    String publisher = "";
                    for (int n = 2; n < publisherTok.length; n++) {
                        if (n < publisherTok.length - 1) {
                            publisher = publisher + publisherTok[n] + " ";
                        } else if (n < publisherTok.length) {
                            publisher = publisher + publisherTok[n];
                        }
                    }

                    fromFile.nextLine();//goes through the blank space
                    count++;
                    try {
                        productList.add(new Book(typeTok[2], id, name, price, year, author, publisher));
                    } catch (Exception ex) {
                        System.out.println("No files loaded: " + ex.getMessage() + "\n");
                    }
                    i++;
                    added++;
                } else if (typeTok[0].equalsIgnoreCase("type") && typeTok[2].equalsIgnoreCase("Electronics")) { //if the item is and electronic this is the code that should be run
////////////////////////gets the id from the file
                    sLine = fromFile.nextLine();                            //insearts the items in the arraylist in the same way that book identifiers are
                    count++;
                    sLine = sLine.replace("\"", "");
                    String[] idTok = sLine.split(delimiters);
                    String id = idTok[2];
/////////////////////////////gets the name from the file
                    sLine = fromFile.nextLine();
                    count++;
                    sLine = sLine.replace("\"", "");
                    String[] nameTok = sLine.split(delimiters);
                    String name = "";
                    for (int n = 2; n < nameTok.length; n++) {
                        if (n < nameTok.length - 1) {
                            name = name + nameTok[n] + " ";
                        } else if (n < nameTok.length) {
                            name = name + nameTok[n];
                        }
                    }
////////////////////////gets the price from the file
                    sLine = fromFile.nextLine();
                    count++;
                    sLine = sLine.replace("\"", "");
                    String[] priceTok = sLine.split(delimiters);
                    String price = priceTok[2];
/////////////////////////gets the year from the file
                    sLine = fromFile.nextLine();
                    count++;
                    sLine = sLine.replace("\"", "");
                    String[] yearTok = sLine.split(delimiters);
                    String year = yearTok[2];
//////////////////////////gets the line maker from the file
                    sLine = fromFile.nextLine();
                    count++;
                    sLine = sLine.replace("\"", "");
                    String[] makerTok = sLine.split(delimiters);
                    String maker = "";
                    for (int n = 2; n < makerTok.length; n++) {
                        if (n < makerTok.length - 1) {
                            maker = maker + makerTok[n] + " ";
                        } else if (n < makerTok.length) {
                            maker = maker + makerTok[n];
                        }
                    }
                    try {
                        productList.add(new Electronics(typeTok[2], id, name, price, year, maker));
                    } catch (Exception ex) {
                        System.out.println("No files loaded: " + ex.getMessage() + "\n");
                    }
                    i++;
                    added++;

                }

            }
        } catch (FileNotFoundException ex) {
            throw new Exception(ex);

        }

    }

    /**
     *
     * @param productList takes in the array list and uses it to write back to the file
     * @throws Exception if a there is a problem writing to the file
     */
    void writetoFile(ArrayList<Product> productList) throws Exception {

        File file = new File("Data.txt");

        try {
            PrintWriter output = new PrintWriter(file);
            //prints the data back to the file, in the required order as the program ends
            for (int i = 0; i < productList.size(); i++) {
                if (productList.get(i).type.equalsIgnoreCase("book")) {  //prints different number of products if it is a book
                    output.println("type = \"" + productList.get(i).type + "\"");
                    output.println("productID = \"" + productList.get(i).getProductID() + "\"");
                    output.println("name = \"" + productList.get(i).getName() + "\"");
                    output.println("price = \"" + productList.get(i).getPrice() + "\"");
                    output.println("year = \"" + productList.get(i).getYear() + "\"");
                    output.println("authors = \"" + productList.get(i).getAuthor() + "\"");
                    output.println("publisher = \"" + productList.get(i).getPublisher() + "\"");
                    output.println("");
                } else if (productList.get(i).type.equalsIgnoreCase("Electronics")) { //prints different number of products if it is a electronics
                    output.println("type = \"" + productList.get(i).type + "\"");
                    output.println("productID = \"" + productList.get(i).getProductID() + "\"");
                    output.println("name = \"" + productList.get(i).getName() + "\"");
                    output.println("price = \"" + productList.get(i).getPrice() + "\"");
                    output.println("year = \"" + productList.get(i).getYear() + "\"");
                    output.println("maker = \"" + productList.get(i).getMaker() + "\"");
                    output.println("");
                }
            }
            output.close();
        } catch (IOException ex) {
            throw new Exception(ex);
        }

    }
}
