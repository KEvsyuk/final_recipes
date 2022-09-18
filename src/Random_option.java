import java.sql.*;
import java.util.Scanner;


public class Random_option {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("What do you want to do? (r,t,n,s)");
        System.out.println("r - find the recipe by random choice");
        System.out.println("t - find a random recipe fallowing by season");
        System.out.println("n - add a new recipe");
        System.out.println("s - stop the program");
        String choice = scanner.nextLine().toLowerCase();


        if (choice.equals("r")){

            try{

                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java31", "root", "26062004");
                Statement stmt= con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM recipes order by rand() limit 1;");

                while (rs.next()){
                    System.out.printf("Recipe: %s\n Ingredients:%s\n Cooking time: %s\n Instructions (in the link): %s\n",
                            rs.getString(2), rs.getString(7), rs.getString(8), rs.getString(9));
                }

            } catch (Exception e){

            }
        }else {
            System.out.println("Something went wrong");
        }

    }
}
/* if (choice.equals("r")) {

                    try {
                        Statement stmt = con.createStatement();


                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }*/