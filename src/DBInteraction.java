import java.sql.*;

public class DBInteraction {

    public static Connection connectToDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/recipes_finalproject", "root", "AaaBbbCcc");
            Statement stmt = con.createStatement();
            return con;

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public static Statement createStatement() {
        try {
            Statement stmt = connectToDB().createStatement();
            return stmt;

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }


    public static void randomFromWinter(){
        try {
            ResultSet rs = createStatement().executeQuery("SELECT * FROM recipes WHERE winter=true order by rand() limit 1");

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
            ResultSet rs = createStatement().executeQuery("SELECT * FROM recipes WHERE spring = true order by rand() limit 1");

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
            ResultSet rs = createStatement().executeQuery("SELECT * FROM recipes WHERE summer = true order by rand() limit 1");

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
            ResultSet rs = createStatement().executeQuery("SELECT * FROM recipes WHERE autumn = true order by rand() limit 1");

            while (rs.next()) {
                System.out.printf("Recipe: %s\n Ingredients:%s\n Cooking time: %s\n Instructions (in the link): %s\n",
                        rs.getString(2), rs.getString(7), rs.getString(8), rs.getString(9));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    public static void random(){

        try {
            ResultSet rs = createStatement().executeQuery("SELECT * FROM recipes order by rand() limit 1;");

            while (rs.next()) {
                System.out.printf("Recipe: %s\n Ingredients:%s\n Cooking time: %s\n Instructions (in the link): %s\n",
                        rs.getString(2), rs.getString(7), rs.getString(8), rs.getString(9));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void insertData(String RecipeName, Integer winter, Integer spring, Integer summer, Integer autumn, String Ingredients, String CookingTime, String Instructions) throws SQLException {


        String sql = "INSERT INTO recipes (RecipeName, winter, spring, summer, autumn, Ingredients, CookingTime, Instructions) VALUE (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connectToDB().prepareStatement(sql);
        //replace question marks
        statement.setString(1, RecipeName);
        statement.setInt(2, winter);
        statement.setInt(3, spring);
        statement.setInt(4, summer);
        statement.setInt(5, autumn);
        statement.setString(6, Ingredients);
        statement.setString(7, CookingTime);
        statement.setString(8, Instructions);



        int rowsInserted = statement.executeUpdate();

        if (rowsInserted > 0){
            System.out.println("A new recipe was inserted successfully");
        } else{
            System.out.println("Something was wrong");
        }

    }
}
