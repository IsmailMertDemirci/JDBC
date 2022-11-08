package jdbc;

import java.sql.*;

public class C {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed","postgres","%MavericK117%");
        Statement st=con.createStatement();

        String sql4 = "SELECT * FROM ?";
        PreparedStatement pst2 = con.prepareStatement(sql4);
        pst2.setString(1, "companies");//String kullandik cunku table adi string
        ResultSet result3 = pst2.executeQuery(sql4);
        while (result3.next()) {
            System.out.println(result3.getInt(1) + "--" + result3.getString(2) + "--" + result3.getInt(3));
        }
    }
}
