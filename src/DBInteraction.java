import java.sql.*;

public class DBInteraction {

    public static Statement connectToDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/recipes_finalproject", "root", "26062004");
            Statement stmt = con.createStatement();
            return stmt;

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public static void randomFromWinter(){
        try {
            ResultSet rs = connectToDB().executeQuery("SELECT * FROM recipes WHERE winter=true order by rand() limit 1");

            while (rs.next()) {
                System.out.printf("Recipe: %s\n Ingredients:%s\n Cooking time: %s\n Instructions (in the link): %s\n",
                        rs.getString(2), rs.getString(7), rs.getString(8), rs.getString(9));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void randomFromSpring(){
        try {
            ResultSet rs = connectToDB().executeQuery("SELECT * FROM recipes WHERE spring = true order by rand() limit 1");

            while (rs.next()) {
                System.out.printf("Recipe: %s\n Ingredients:%s\n Cooking time: %s\n Instructions (in the link): %s\n",
                        rs.getString(2), rs.getString(7), rs.getString(8), rs.getString(9));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void randomFromSummer(){
        try {
            ResultSet rs = connectToDB().executeQuery("SELECT * FROM recipes WHERE summer = true order by rand() limit 1");

            while (rs.next()) {
                System.out.printf("Recipe: %s\n Ingredients:%s\n Cooking time: %s\n Instructions (in the link): %s\n",
                        rs.getString(2), rs.getString(7), rs.getString(8), rs.getString(9));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void randomFromAutumn(){
        try {
            ResultSet rs = connectToDB().executeQuery("SELECT * FROM recipes WHERE autumn = true order by rand() limit 1");

            while (rs.next()) {
                System.out.printf("Recipe: %s\n Ingredients:%s\n Cooking time: %s\n Instructions (in the link): %s\n",
                        rs.getString(2), rs.getString(7), rs.getString(8), rs.getString(9));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
