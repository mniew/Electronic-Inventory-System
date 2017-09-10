/*
 * Marek Niewiadomski
 */
package a3;

/**
 *
 * @author Niew
 */
public class Book extends Product {

    /**
     *
     * @param type indicates the product, either book or electronic(in this case
     * book)
     * @param productID is the number that identifies the particular product
     * @param name what the product is called
     * @param price how much the product is worth
     * @param year the year the product was made in
     * @param author who wrote the book
     * @param publisher who published the book
     * @throws java.lang.Exception throws exception concerning input error checking
     */
    public Book(String type, String productID, String name, String price, String year, String author, String publisher) throws Exception {
        super(type, productID, name, price, year);

        if (author.equals("")) {
            author = " ";
        }

        if (publisher.equals("")) {
            publisher = " ";
        }

        this.author = author;
        this.publisher = publisher;
    }

    /**
     *checks to see if the object is equivalent to another
     * @param tempObject temporary variable
     * @return returns different things depending on temporary object
     */
    @Override
    public boolean equals(Object tempObject) {
        if (tempObject == null) {
            return false;
        } else if (getClass() != tempObject.getClass()) {
            return false;
        } else {
            Product tempProduct = (Product) tempObject;
            return (((this.productID).equals(tempProduct.productID)) && ((this.name).equals(tempProduct.name)) && ((this.price).equals(tempProduct.price)) && ((this.year).equals(tempProduct.year)));
        }
    }
    
    /**
     * is used to print out the output
     * @return is the respective book output
     */
    @Override
    public String toString() {
        String dataString = super.toString();
        dataString = dataString + (" Author: " + this.author  + " Publisher: " + this.publisher +"\n-------------------------------------------------\n");
        return (dataString);
    }

}
