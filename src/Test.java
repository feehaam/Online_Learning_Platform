import java.sql.*;

public class Test {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/ocms";
        String username = "root";
        String password = "feeham";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);
            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery("Select * from users");
            
            while(result.next()){
                int id = result.getInt(1);
                String name = result.getString(2);
                String email = result.getString(3);
                String pas = result.getString(4);
                int type = result.getInt(5);
                System.out.println(id+" "+name+" "+email+" "+pas+" "+type);
            }
            
            con.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
