/**
 * This class represents a book in a library
 *
 * @author David Ha, Andrew McAvoy
 */
public class Book {
    private String number; //a 5-digit serial number unique to the book
    private String name;
    private boolean checkedOut;
    private Date datePublished;

    private static int numberTrack = 10001;//static variable to aid in numbering books

    /**
     * Constructor for Book
     *
     * @param number        Serial number of book
     * @param name          Name of the book
     * @param datePublished Publishing date of book
     */
    public Book(String number, String name, Date datePublished) {
        this.number = number;
        this.name = name;
        this.checkedOut = false;
        this.datePublished = datePublished;
    }

    /**
     * Compares two books to see if they are equal
     *
     * @param obj represents another book to compare
     * @return boolean value true if the serial numbers for two books are the same false if otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Book) {
            Book temp = (Book) obj;
            return (number.equals(temp.number));
        }
        return false;
    }

    /**
     * Setter method for checkedOut variable
     *
     * @param input status of book
     */
    public void setCheckedOut(boolean input) {
        checkedOut = input;
    }

    /**
     * Getter method for checkedOut variable
     * @return value of checkedOut
     */
    public boolean getCheckedOut() {
        return checkedOut;
    }

    /**
     * Setter method to increment number tracker
     */
    public static void incrementNumberTrack() {
        numberTrack++;
    }

    /**
     * Getter method for number
     *
     * @return value of number
     */
    public String getNumber() {
        return number;
    }

    /**
     * Getter method for number tracker
     *
     * @return value of numberTrack
     */
    public static int getNumberTrack() {
        return numberTrack;
    }

    /**
     * Getter Method for date published
     *
     * @return value of datePublished
     */
    public Date getDatePublished() {
        return datePublished;
    }

    /**
     * Prints out a textual representation of a book in this format:
     * Book Number::Book Name::Date Published::Availability.
     *
     * @return text representation of book
     */
    @Override
    public String toString() {
        String availability;
        if (!checkedOut) {
            availability = "is available";
        } else {
            availability = "is checked out";
        }
        return "Book#" + number + "::" + name + "::" + datePublished + "::" + availability;
    }
}
