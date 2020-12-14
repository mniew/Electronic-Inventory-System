/*
 * Marek Niewiadomski
 */
package a3;


/**
 *
 * @author Niew
 */
public abstract class Product {

    protected String maker;
    protected String author;
    protected String publisher;
    protected String type;
    protected String productID;
    protected String name;
    protected String price;
    protected String year;

    /**
     * constructor for product
     *
     * @param type is the type of product wither book or electronic
     * @param productID in number that identifies the product
     * @param name name of the product
     * @param price how much the product costs
     * @param year when it was made
     * @throws java.lang.Exception throws exceptions concerning bad inputs
     */
    public Product(String type, String productID, String name, String price, String year) throws Exception {

        if (productID.equals("")) {
            throw new Exception("ProductID cannot be an empty field.");
        }
        if (name.equals("")) {
            throw new Exception("Name cannot be an empty field.");
        }
        if (year.equals("")) {
            throw new Exception("Year cannot be an empty field.");
        }

        productID = productID.replace(" ", "");  //filters input
        productID = productID.replace(".", "");
        productID = productID.replace(",", "");
        productID = productID.replace(";", "");

        int ID = 0;

        try {
            ID = Integer.parseInt(productID);
            productID = Integer.toString(ID);
            if (ID > 999999 || ID < 1) {
            throw new Exception("ID is not a valid input.");
        }
        } catch (Exception ex) {
            throw new Exception(ex);
        }       

        price = price.replace(" ", "");  //filters input
        price = price.replace(":", "");
        price = price.replace(",", "");
        price = price.replace(";", "");

        if (!price.equals("")) {
            double price1;

            try {
                price1 = Double.parseDouble(price);

            } catch (Exception ex) {
                throw new Exception(ex);
            }
        }

        year = year.replace(" ", "");  //filters input
        year = year.replace(".", "");
        year = year.replace(",", "");
        year = year.replace(";", "");

        int year1;

        try {
            year1 = Integer.parseInt(year);
        } catch (Exception ex) {
            throw new Exception(ex);
        }

        if (year1 < 1000 || year1 > 9999) { //makes sure id is between 1000 and 9999
            throw new Exception("Year is not a valid input.");
        }

        this.type = type;
        this.productID = productID;
        this.name = name;
        this.price = price;
        this.year = year;
    }

    /**
     * gets product
     *
     * @return returns the ID of the product
     */
    public String getProductID() {
        return productID;
    }

    /**
     * sets product ID
     *
     * @param productID sets product ID
     */
    public void setProductID(String productID) {
        this.productID = productID;
    }

    /**
     * gets Name
     *
     * @return gets you the name
     */
    public String getName() {
        return name;
    }

    /**
     * setName
     *
     * @param name takes in the name and makes sets it to this.name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * gets Price
     *
     * @return gets you the price of a product
     */
    public String getPrice() {
        return price;
    }

    /**
     * setsPrice
     *
     * @param price takes in the price and makes it equal to this.price
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * gets Year
     *
     * @return gets you the year
     */
    public String getYear() {
        return year;
    }

    /**
     * sets year
     *
     * @param year takes in year and make sit equal to this.year
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * gets author
     *
     * @return gets you the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * sets author
     *
     * @param author takes in the author and make sit equal to this.author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * gets the publisher
     *
     * @return gets you the publisher
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * gets the publisher
     *
     * @param publisher takes in the publisher and make sit equal to
     * this.publisher
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * gets the maker
     *
     * @return gets you the maker
     */
    public String getMaker() {
        return maker;
    }

    /**
     * sets the maker
     *
     * @param maker takes in the maker and makes it equal to this.maker
     */
    public void setMaker(String maker) {
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
        return ("-------------------Stored---------------------\n" + " ID: " + this.productID + " Name: " + this.name + " Price: " + this.price + " Year: " + this.year);
    }
}
