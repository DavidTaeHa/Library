import java.util.Scanner;

/**
 * This class handles all user input and output
 *
 * @author David Ha, Andrew McAvoy
 */
public class Kiosk {
    private boolean kioskSession;

    final int FIRST_PARAMETER = 0;
    final int SECOND_PARAMETER = 1;
    final int THIRD_PARAMETER = 2;
    final int LENGTH_REQUIREMENT_THREE = 3;
    final int LENGTH_REQUIREMENT_TWO = 2;
    final int INVALID = -1;

    /**
     * Constructor for kiosk class
     */
    public Kiosk(){
        this.kioskSession = true;
    }

    /**
     * Handles all user input and output
     */
    public void run() {
        Library library = new Library();
        Scanner scan = new Scanner(System.in);
        while (kioskSession) {
            String input = scan.nextLine();
            String[] parameters = input.split(",");
            String command = parameters[FIRST_PARAMETER];
            Book target;
            String number;
            switch(command){
                case "PA":
                    if(library.getNumBooks() == 0){
                        System.out.println("Library Catalog is Empty!");
                        break;
                    }
                    System.out.println("**List of books in the library");
                    library.print();
                    System.out.println("**End of list");
                    break;
                case "PD":
                    //print books by date published
                case "PN":
                    //print books by numbers
                case "A":
                    if(parameters.length != LENGTH_REQUIREMENT_THREE){
                        System.out.println("Invalid Command!");
                        break;
                    }
                    String bookName = parameters[SECOND_PARAMETER];
                    String date = parameters[THIRD_PARAMETER];
                    Date newDate = new Date(date);
                    if(!newDate.isValid()){
                        System.out.println("Invalid Date!");
                        break;
                    }
                    Book newBook = new Book (String.valueOf(Book.getNumberTrack()), bookName, newDate);
                    System.out.println(newBook);
                    library.add(newBook);
                    break;
                case "R":
                    if(parameters.length != LENGTH_REQUIREMENT_TWO){
                        System.out.println("Invalid Command!");
                        break;
                    }
                    number = parameters[SECOND_PARAMETER];
                    target = new Book(number,"Target",new Date());
                    if(!library.remove(target)){
                        System.out.println("Unable to remove, the library does not have this book.");
                    }
                    else{
                        System.out.println("Book# " + number + " removed");
                    }
                    break;
                case "O":
                    if(parameters.length != LENGTH_REQUIREMENT_TWO){
                        System.out.println("Invalid Command!");
                        break;
                    }
                    number = parameters[SECOND_PARAMETER];
                    target = new Book(number,"Target",new Date());
                    if(!library.checkOut(target)){
                        System.out.println("Unable to remove, the library does not have this book.");
                    }
                    else{
                        System.out.println("You've checked out Book#" + number + " Enjoy!");
                    }
                    break;
                case "I":
                    //return book
                case "Q":
                    kioskSession = false;
                    break;
                default:
                    System.out.println("Invalid Command!");
            }
        }
        System.out.println("Kiosk session ended.");
    }
}
