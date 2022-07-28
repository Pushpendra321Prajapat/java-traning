import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import models.Movie;
import models.Store;

public class Main {
    static Store store = new Store();

    public static void main(String[] args) {
        System.out.println("\n********************JAVA VIDEO STORE********************\n");

        try {
            loadMovies("movies.txt");
            System.out.print("MOVIES LOADED\n\n");
            System.out.print(store);
            manageMovies();
        } catch (Exception e) {
            System.out.print(e.getMessage());
        } finally {
            System.out.println("Process Complete");
        }

        // Movie movie = new Movie("The Shawshank Redemption", "Blue-Ray", 9.2);
        // System.out.print(movie);

        /*
         * Store store = new Store();
         * 
         * Movie movie1 = new Movie("The Shawshank Redemption", "Blue-Ray", 9.2);
         * Movie movie2 = new Movie("The Godfather", "Blue-Ray", 9.1);
         * Movie movie3 = new Movie("The Godfather: Part II", "DVD", 9.0);
         * 
         * store.addMovie(movie1);
         * store.addMovie(movie2);
         * store.addMovie(movie3);
         * 
         * store.action("The Godfather", "sell");
         * store.action("The Shawshank Redemption", "rent");
         * store.action("The Shawshank Redemption", "return");
         * 
         * System.out.print(store);
         */
    }

    public static void manageMovies() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Enter the name of the movie: ");
            String movieName = sc.nextLine();

            if (store.getMovie(movieName) == null) {
                System.out.println("\n\nThe input you provided is not valid. Please try again\n");
                continue;
            }

            System.out.println("\nWould you like to \n\ta) purchase\n\tb) rent \n\tc) return.");
            String ans = sc.nextLine();

            if (!(ans.equals("a") || ans.equals("b") || ans.equals("c"))) {
                sc.close();
                break;
            }

            switch (ans) {
                case "a":
                    store.action(movieName, "sell");
                    break;

                case "b":
                    store.action(movieName, "rent");
                    break;

                case "c":
                    store.action(movieName, "return");
                    break;
            }
            System.out.println("\n\nUPDATED MOVIES\n\n" + store);
        }
    }

    /**
     * Name: manageMovies
     * Inside the function:
     * • 1. Starts a new instance of Scanner;
     * • 2. In an infinite loop, the user can choose to a) purchase b) rent c)
     * return d) exit.
     * • case a: ask for the name and sell.
     * • case b: ask for the name and rent.
     * • case c: ask for the name and return.
     * • 3. call close() from the Scanner object.
     */

    public static void loadMovies(String fileName) throws FileNotFoundException {
        FileInputStream fin = new FileInputStream(fileName);
        Scanner sc = new Scanner(fin);
        while (sc.hasNextLine()) {
            String[] splitWords = sc.nextLine().split("--");
            double rating = Double.parseDouble(splitWords[2]);

            store.addMovie(new Movie(splitWords[0], splitWords[1], rating));
        }
        sc.close();
    }

    /**
     * Name: loadMovies
     * 
     * @param fileName (String)
     * @throws FileNotFoundException
     *
     *                               Inside the function:
     *                               • 1. loads movies from <fileName>.txt.
     *                               • 2. adds all movies to the store object's
     *                               movie field.
     *                               Hint: You will need to 'split' a String into
     *                               three Strings.
     */

}
