import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * This class handles all user input and output
 *
 * @author David Ha, Andrew McAvoy
 */
public class Kiosk {
    private boolean kioskSession;

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
        String input;
        Library library = new Library();
        Scanner scan = new Scanner(System.in);
        StringTokenizer tokenizer = new StringTokenizer(input, ",");
        while (kioskSession) {
            input = scan.next();
            String condition = tokenizer.nextToken();
            switch(condition){
                case "PA":
                    //print books with current sequence
                case "PD":
                    //print books by date published
                case "PN":
                    //print books by numbers
                case "A":
                    //add book
                case "R":
                    //remove book
                case "O":
                    //checkout book
                case "I":
                    //return book
                case "Q":
                    kioskSession = false;
                default:
                    System.out.println("Invalid Command!");
            }
        }
    }
}
