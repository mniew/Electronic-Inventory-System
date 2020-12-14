/*
 * Marek Niewiadomski
 */
package a3;


/**
 *
 * @author Niew
 */
public class Electronics extends Product {

    /**
     *
     * @param type indicates the product, either book or electronic(in this case
     * electronics)
     * @param productID is the number that identifies the particular product
     * @param name what the product is called
     * @param price how much the product is worth
     * @param year the year the product was made in
     * @param maker company that made the product
     * @throws java.lang.Exception throws exceptions when errors are encountered with the input values
     */
    public Electronics(String type, String productID, String name, String price, String year, String maker) throws Exception {
        super(type, productID, name, price, year);

        if (maker.equals("")) {
            maker = " ";
        }

        this.maker = maker;
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
        }else {
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
        dataString = dataString + (" Maker: " + this.maker  + "\n-------------------------------------------------\n");
        return (dataString);
    }
}
