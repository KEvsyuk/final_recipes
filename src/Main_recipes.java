import java.sql.*;
import java.util.Scanner;

public class Main_recipes {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Scanner scanner = new Scanner(System.in);

            System.out.println("Do you want to start? (y/n)");
            String again = scanner.nextLine().toLowerCase().trim();
            while (again.equals("y")) {
                System.out.println("What do you want to do? (r,t,n,s)");
                System.out.println("r - find the recipe by random choice");
                System.out.println("t - find a random recipe by desired season");
                System.out.println("n - add a new recipe");
                System.out.println("s - stop the program");
                String choice = scanner.nextLine().trim().toLowerCase();

                //random choice
                if (choice.equals("r")) {
                        DBInteraction.random();
                } else

                // random by season
                if (choice.equals("t")) {
                    randomRecipe();

                }else

                //add a new recipe
                if (choice.equals("n")) {
                    addRecipe();
                } else if (choice.equals("s")){
                    System.exit(0);
                }else {
                    System.out.println("Please, choose an option from the list");
                    choice = scanner.nextLine().trim().toLowerCase();
                }

            }
    }

    public static void addRecipe() throws SQLException {

        Scanner scanner = new Scanner(System.in);
        //smaller while loop for question
        String RecipeName = "";
        while (RecipeName.length() < 3) {
            System.out.println("Enter Recipe name with more or equals to 3 characters: ");//at least 3 symbols
            RecipeName = scanner.nextLine();
        }

        System.out.println("Please enter a season/seasons - winter, spring, summer, autumn -  for the dish. You can add one or more seasons!");
        String season = scanner.nextLine().trim().toLowerCase();
        Integer winter = 0;
        Integer spring = 0;
        Integer summer = 0;
        Integer autumn = 0;

        //?maybe change if-statements to switch?
        if (season.equals("winter")) {
            winter = 1;
        }else if (season.equals("spring")) {
            spring = 1;
        }else if (season.equals("summer")) {
            summer = 1;
        }else if (season.equals("autumn")) {
            autumn = 1;
        }else {
            System.out.println("You need to type 'winter', 'spring', 'summer' or 'autumn'");
            season = scanner.nextLine().trim().toLowerCase();
        }

        System.out.println("Enter the ingredients, for example: flour, milk, chicken, etc.");
        String Ingredients = scanner.nextLine();

        //limitation 0-59
        //minutes in while loop
        //reg expression
        //2 variables to put in one and then send to database
        System.out.println("Enter cooking hours (in digits)");
        int hours = scanner.nextInt();
        int min;
        do {
            System.out.println("Enter cooking minutes");
            min = scanner.nextInt();
        } while (min > 60);

        String CookingTime = Integer.toString(hours) + " hr " + Integer.toString(min) + " mins ";

        //doubles line?
        System.out.println("Enter a valid link for instructions (starting from https://)");
        scanner.nextLine();
        String Instructions = scanner.nextLine();
        if (Instructions.contains("https")){
            DBInteraction.insertData(RecipeName, winter, spring, summer, autumn, Ingredients, CookingTime, Instructions);
        }else{
            System.out.println("A valid link should contain 'https://'");
            Instructions = scanner.nextLine();
        }

        //DBInteraction.insertData(RecipeName, winter, spring, summer, autumn, Ingredients, CookingTime, Instructions);
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


