import java.sql.*;
public class App {
    public static void main(String[] args) throws Exception {

        //step 2:load and register the drive
        Class.forName("com.mysql.cj.jdbc.Driver");

        //step 3: establish a connection
        String url="jdbc:mysql://localhost:3306/jdbcdemo";
        Connection con= DriverManager.getConnection(url, "root", "Veni@123");

        //step4:create a statement (normal statement, prepares statement, callable statments)
        Statement st= con.createStatement();

        //step 4:execute the query
        String sql="select * from Students";
        
        //process the result
        ResultSet rs=st.executeQuery(sql);
       while( rs.next()){
        //skipping the header
        System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
        
    }
}
}
