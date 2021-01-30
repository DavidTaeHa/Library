/**
 * This class represents a library which will contain instances of the Book class
 *
 * @author David Ha, Andrew McAvoy
 */
public class Library {
    private Book[] books; // array-based implementation of the bag data structure
    private int numBooks; // the number of books currently in the bag

    /**
     * Default constructor for Library class
     */
    public Library() {
    }

    /**
     * Helper method used to help find a book within the library
     *
     * @param book book to be found within the library
     * @return index number of the book
     */
    private int find(Book book) {
    }

    /**
     * Helper method used to grow capacity of library by 4
     */
    private void grow() {
    }

    /**
     * Method used to add book to library
     *
     * @param book book to be added to library
     */
    public void add(Book book) {
    }

    /**
     * Removes book from library
     *
     * @param book book to be removed from library
     * @return
     */
    public boolean remove(Book book) {
    }

    /** Book is checked out from the library and is no longer available
     *
     * @param book book to be checked out from library
     * @return
     */
    public boolean checkOut(Book book) {
    }

    /**
     * Book is returned to the library and available again
     *
     * @param book book to be returned to the library
     * @return
     */
    public boolean returns(Book book) {
    }

    /**
     * Prints list of books in the library
     */
    public void print() {
    }

    /**
     * Print list of books by date published in ascending order
     */
    public void printByDate() {
    }

    /**
     * Print list of books by book number in ascending order
     */
    public void printByNumber() {
    }
}
