import java.sql.*;
import java.util.Scanner;

public class Main_recipes {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Scanner scanner = new Scanner(System.in);

        String again = "y";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/recipes_finalproject", "root", "26062004");
            Statement stmt = con.createStatement();
            System.out.println("Connected to database");

        } catch {


















            























        }




            /* while (again.equals("y")) {
                System.out.println("What do you want to do? (r,t,n,s)");
                System.out.println("r - find the recipe by random choice");
                System.out.println("t - find a random recipe by desired season");
                System.out.println("n - add a new recipe");
                System.out.println("s - stop the program");
                String choice = scanner.nextLine().toLowerCase();

                if (choice.equals("r")){

                    try{
                        ResultSet rs = stmt.executeQuery("SELECT * FROM recipes order by rand() limit 1;");

                        while (rs.next()){
                            System.out.printf("Recipe: %s\n Ingredients:%s\n Cooking time: %s\n Instructions (in the link): %s\n",
                                    rs.getString(2), rs.getString(7), rs.getString(8), rs.getString(9));
                        }

                    } catch (Exception e){
                        System.out.println(e);
                    }
                }else {
                    System.out.println("Something went wrong");
                }
                
            }

        }catch (Exception e){
            System.out.println(e);
        }
    }
    }/*