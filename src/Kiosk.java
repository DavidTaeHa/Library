import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * This class handles all user input and output
 *
 * @author David Ha, Andrew McAvoy
 */
public class Kiosk {
    private boolean kioskSession = true;

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

            }
        }
    }
}
