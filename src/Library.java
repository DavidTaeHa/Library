/**
 * This class represents a library which will contain instances of the Book class
 *
 * @author David Ha, Andrew McAvoy
 */
public class Library {
    private Book[] books; // array-based implementation of the bag data structure
    private int numBooks; // the number of books currently in the bag

    final int LIBRARY_INCREMENT_VALUE = 4;
    final int INVALID = -1;

    /**
     * Default constructor for Library class
     */
    public Library() {
        books = new Book[0];
        numBooks = 0;
    }

    /**
     * Helper method used to help find a book within the library
     *
     * @param book book to be found within the library
     * @return index number of the book
     */
    private int find(Book book) {
        for (int index = 0; index < books.length; index++) {
            if (books[index].equals(book)) {
                return index;
            }
        }
        return INVALID;//Book is not within library
    }

    /**
     * Helper method used to grow capacity of library by 4
     */
    private void grow() {
        Book[] temp = new Book[books.length + LIBRARY_INCREMENT_VALUE];
        for (int i = 0; i < books.length; i++) {
            temp[i] = books[i];
        }
        books = temp;
    }

    /**
     * Helper method used to determine if the bag is full
     */
    private boolean isFull() {
        for (Book book : books) {
            if (book == null) {
                return false;
            }
        }
        return true;
    }

    /**
     * Method used to add book to library
     *
     * @param book book to be added to library
     */
    public void add(Book book) {
        if (isFull()) {
            grow();
        }
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                books[i] = book;
                numBooks++;
            }
        }
    }

    /**
     * Removes book from library
     *
     * @param book book to be removed from library
     * @return boolean value for whether or not book was found in the library
     */
    public boolean remove(Book book) {
        int index = find(book);
        if (index == INVALID) {
            return false;
        }
        books[index] = null;
        //May need to implement method to shift values in array after removal
        return true;
    }

    /**
     * Book is checked out from the library and is no longer available
     *
     * @param book book to be checked out from library
     * @return boolean value for whether or not book was found in the library
     */
    public boolean checkOut(Book book) {
        int index = find(book);
        if (index == INVALID) {
            return false;
        }
        books[index].setCheckedOut(true);
        return true;
    }

    /**
     * Book is returned to the library and available again
     *
     * @param book book to be returned to the library
     * @return boolean value for whether or not book was found in the library
     */
    public boolean returns(Book book) {
        int index = find(book);
        if (index == INVALID) {
            return false;
        }
        books[index].setCheckedOut(false);
        return true;
    }

    /**
     * Prints list of books in the library
     */
    public void print() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    /**
     * Print list of books by date published in ascending order
     */
    public void printByDate() {
        int min = INVALID;
        for (int i = 0; i < books.length; i++) {
            for (int j = i; j < books.length; j++) {
                if (min == INVALID) {
                    min = j;
                    continue;
                }
                if ((min != INVALID) &&
                        (books[j].getDatePublished().getYear() < books[min].getDatePublished().getYear())) {
                    min = j;
                } else if (books[j].getDatePublished().getYear() == books[min].getDatePublished().getYear()) {
                    if (books[j].getDatePublished().getMonth() < books[min].getDatePublished().getMonth()) {
                        min = j;
                    } else if (books[j].getDatePublished().getMonth() == books[min].getDatePublished().getMonth()) {
                        if (books[j].getDatePublished().getDay() < books[min].getDatePublished().getDay()) {
                            min = j;
                        }
                    }
                }
            }
            Book temp = books[i];
            books[i] = books[min];
            books[min] = temp;
            min = INVALID;
        }
        print();
    }

    /**
     * Print list of books by book number in ascending order
     */
    public void printByNumber() {
        int min = INVALID;
        for (int i = 0; i < books.length; i++) {
            for (int j = i; j < books.length; j++) {
                if (min == INVALID) {
                    min = j;
                }
                if ((min != INVALID) &&
                        (Integer.parseInt(books[j].getNumber()) < Integer.parseInt(books[min].getNumber()))) {
                    min = j;
                }
            }
            Book temp = books[i];
            books[i] = books[min];
            books[min] = temp;
            min = INVALID;
        }
        print();
    }
}
