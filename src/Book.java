/**
 * This class represents a book in a library
 * @author David Ha, Andrew McAvoy
 *
 */
public class Book {
    private String number; //a 5-digit serial number unique to the book
    private String name;
    private boolean checkedOut;
    private Date datePublished;


    public Book(String number, String name, Date datePublished){
        this.number = number;
        this.name = name;
        this.checkedOut = false;
        this.datePublished = datePublished;
    }

    /**
     * Compares two books to see if they are equal
     * @param obj represents another book to compare
     * @return boolean value true if the serial numbers for two books are the same
     */
    @Override
    public boolean equals(Object obj){
        Book temp = (Book) obj;
        if(number == temp.number){
            return true;
        }
        return false;
    }

    /**
     * Prints out a textual representation of a book in this format:
     * Book Number::Book Name::Date Published::Availability.
     * @return text representation of book
     */
    @Override
    public String toString() {
        String availability;
        if(checkedOut == true){
            availability = "is available";
        }
        else{
            availability = "is checked out";
        }
        return "Book#" + number + "::" + name + "::" + datePublished + "::" + availability;
    }
}
