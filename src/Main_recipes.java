import java.sql.*;
import java.util.Scanner;

public class Main_recipes {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Scanner scanner = new Scanner(System.in);

        try {

            //connection to DB
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/recipes_finalproject", "root", "26062004");
            Statement stmt = con.createStatement();
            // ?do we need line 16?
            System.out.println("Connected to database");

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
                        ResultSet rs = stmt.executeQuery("SELECT * FROM recipes order by rand() limit 1;");

                        while (rs.next()) {
                            System.out.printf("Recipe: %s\n Ingredients:%s\n Cooking time: %s\n Instructions (in the link): %s\n",
                                    rs.getString(2), rs.getString(7), rs.getString(8), rs.getString(9));
                        }
                        break;
                } else

                // random by season
                if (choice.equals("t")) {
                    SearchFromSeason.randomRecipe();
                    System.out.println("Enter the season (w - winter, sp - spring, sum - summer, a - autumn): ");
                    String season = scanner.nextLine().trim().toLowerCase();

                    DBInteraction dbInteraction = new DBInteraction();

                    if (season.equals("w")) {
                        dbInteraction.randomFromWinter();
                    } else if (season.equals("sp")) {
                        dbInteraction.randomFromSpring();
                    } else if (season.equals("sum")) {
                        dbInteraction.randomFromSummer();
                    } else if (season.equals("a")) {
                        dbInteraction.randomFromAutumn();
                    } else {
                    System.out.println("Enter the correct season");
                }
                    break;
                }else

                //add a new recipe
                if (choice.equals("n")) {
                    //smaller while loop for question
                    String RecipeName = "";
                    while (RecipeName.length() < 3) {
                        System.out.println("Enter Recipe name with more or equals to 3 characters: ");//at least 3 symbols
                        RecipeName = scanner.nextLine();
                    }

                    System.out.println("Please enter a season/seasons - winter, spring, summer, autumn -  for the dish. You can add one or more seasons!");
                    String season = scanner.nextLine().trim().toLowerCase();
                    boolean winter = false;
                    boolean spring = false;
                    boolean summer = false;
                    boolean autumn = false;

                    //?maybe change if-statements to switch?
                    if (season.equals("winter")) {
                        winter = true;
                    }else if (season.equals("spring")) {
                        spring = true;
                    }else if (season.equals("summer")) {
                        summer = true;
                    }else if (season.equals("autumn")) {
                        autumn = true;
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
                    System.out.println("Enter cooking hours");
                    int hours = scanner.nextInt();
                    int min;
                    do {
                        System.out.println("Enter cooking minutes");
                        min = scanner.nextInt();
                    } while (min > 60);

                    String CookingTime = Integer.toString(hours) + " hr " + Integer.toString(min) + " mins ";

                    //doubles line?
                    System.out.println("Enter a valid link for instructions (starting from https://)");
                    String Instructions = scanner.nextLine();
                    while (!Instructions.contains("https")){
                        System.out.println("Something went wrong");
                        Instructions = scanner.nextLine();
                    }

                    RecipeInsertValues.insertData(con, RecipeName, winter, spring, summer, autumn, Ingredients, CookingTime, Instructions);

        String sql = "INSERT INTO recipes (RecipeName, winter, spring, summer, autumn, Ingredients, CookingTime, Instructions) VALUE (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = con.prepareStatement(sql);
        //replace question marks
        statement.setString(1, RecipeName);
        statement.setString(2, String.valueOf(winter));
        statement.setString(3, String.valueOf(spring));
        statement.setString(4, String.valueOf(summer));
        statement.setString(5, String.valueOf(autumn));
        statement.setString(6, Ingredients);
        statement.setString(7, CookingTime);
        statement.setString(8, Instructions);


        int rowsInserted = statement.executeUpdate();

        if (rowsInserted > 0) {
            System.out.println("A new recipe was inserted successfully");
        } else {
            System.out.println("Something was wrong");
        }
                break;
                }

                //stop the program
                 else{
                    System.out.println("Please, choose an option from the list");
                    choice = scanner.nextLine().trim().toLowerCase();
                }
                System.out.println("Do you want to do anything else? (y/n)");
                again = scanner.nextLine().toLowerCase().trim();
                /*if (choice.equals("s")){
                    System.exit(0);
                }*/
            }



            // main try-catch block
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
