import java.sql.*;
public class setup {
    public static void main(String[] args) throws Exception {
        insertRecords();
        readRecords();
    }

    public static void insertRecords() throws Exception{
       
        String url="jdbc:mysql://localhost:3306/jdbcdemo";
        Connection con= DriverManager.getConnection(url, "root", "Veni@123");
        
        int id=107;
        String name ="monisha";
        String location="madurai";

        String sql="insert into Students values (?,?,?);";
        PreparedStatement pst= con.prepareStatement(sql);
        pst.setInt(1, id);
        pst.setString(2, name);
        pst.setString(3, location);
        int rows = pst.executeUpdate();
        System.out.println("no of rows affected :"+rows);
       }
       
     public static void readRecords() throws Exception{
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

