import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBInteraction {


    public static Statement connectToDB(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/recipes_finalproject", "root", "AaaBbbCcc");
            Statement stmt = con.createStatement();
            return stmt;

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static void randomFromWinter(){
        try {
            ResultSet rs = connectToDB().executeQuery("SELECT * FROM recipes WHERE winter='TRUE' order by rand() limit 1");

            while (rs.next()) {
                System.out.printf("Recipe name: %s, Winter: %s, Ingredients: %s, Cooking time: %s, Instructions: %s\n",
                        rs.getString(2), rs.getString(3), rs.getString(7), rs.getString(8),rs.getString(9));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void randomFromSpring(){
        try {
            ResultSet rs = connectToDB().executeQuery("SELECT * FROM recipes WHERE spring = 'TRUE' order by rand() limit 1");

            while (rs.next()) {
                System.out.printf("Recipe name: %s, Spring: %s, Ingredients: %s, Cooking time: %s, Instructions: %s\n",
                        rs.getString(2), rs.getString(3), rs.getString(7), rs.getString(8),rs.getString(9));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void randomFromSummer(){
        try {
            ResultSet rs = connectToDB().executeQuery("SELECT * FROM recipes WHERE summer = 'TRUE' order by rand() limit 1");

            while (rs.next()) {
                System.out.printf("Recipe name: %s, Summer: %s, Ingredients: %s, Cooking time: %s, Instructions: %s\n",
                        rs.getString(2), rs.getString(3), rs.getString(7), rs.getString(8),rs.getString(9));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void randomFromAutumn(){
        try {
            ResultSet rs = connectToDB().executeQuery("SELECT * FROM recipes WHERE autumn = 'TRUE' order by rand() limit 1");

            while (rs.next()) {
                System.out.printf("Recipe name: %s, Autumn: %s, Ingredients: %s, Cooking time: %s, Instructions: %s\n",
                        rs.getString(2), rs.getString(3), rs.getString(7), rs.getString(8),rs.getString(9));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
