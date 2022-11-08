package jdbcPractise;

import java.sql.*;

public class Query03 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1) Driver yukle
        Class.forName("org.postgresql.Driver");
        //2) Baglanti olustur
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed","postgres","%MavericK117%");
        //3) Statement olustur
        PreparedStatement ps=con.prepareStatement("select * from ogrenciler");

        ResultSet rs=ps.executeQuery();
        ResultSetMetaData rsmd=rs.getMetaData();
        System.out.println(rsmd.getColumnCount());

        System.out.println(rsmd.getColumnName(1));
        System.out.println(rsmd.getColumnName(2));
        System.out.println(rsmd.getColumnName(3));
        System.out.println(rsmd.getColumnName(4));

        System.out.println(rsmd.getColumnTypeName(1)); //sutunlarin data turunu getirir
        System.out.println(rsmd.getTableName(2));//tablo ismini getirir
        rs.close();
        ps.close();


    }
}
