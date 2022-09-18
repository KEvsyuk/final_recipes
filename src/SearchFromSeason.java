import java.util.Scanner;

//subclass, the values are read and shown to the user from the DBInteraction class
public class SearchFromSeason {
    public static void main(String[] args) {

        randomRecipe();

    }

    public static void randomRecipe() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the season (w - winter, sp - spring, sum - summer, a - autumn): ");

        String season = scanner.nextLine();

        DBInteraction dbInteraction = new DBInteraction();

        if (season.equals("w")){
            dbInteraction.randomFromWinter();
        } else if (season.equals("sp")){
            dbInteraction.randomFromSpring();
        } else if (season.equals("sum")) {
            dbInteraction.randomFromSummer();
        } else if (season.equals("a")) {
            dbInteraction.randomFromAutumn();
        }
    }
}
