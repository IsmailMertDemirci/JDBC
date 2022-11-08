package jdbcPractise;

import java.sql.*;

public class Query04 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        /*//1) Driver yukle
        Class.forName("org.postgresql.Driver");
        //2) Baglanti olustur
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed","postgres","%MavericK117%");
        //3) Statement olustur
        PreparedStatement ps=con.prepareStatement("insert into ogrenciler values(?, ?, ?, ?");
        //statement'de ? isaretli kod kalibi yok
        //hafizada az yer kaplar, daha dinamiktir, daha avantajlidir, ondan prepared kullandik, statement kullanmadik

        ps.setInt(1,200);
        ps.setString(2,"Veli Canan");
        ps.setString(3,"12");
        ps.setString(4,"E");

        ps.executeUpdate();

        System.out.println("Veri girisi yapildi");*/
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed",
                "postgres",
                "%MavericK117%");
// Statement st = con.createStatement();
        PreparedStatement ps = con.prepareStatement("insert into ogrenciler values(?,?,?,?) ");
        ps.setInt(1, 200);
        ps.setString(2, "Veli Can");
        ps.setString(3, "12");
        ps.setString(4, "E");
        ps.executeUpdate();
        System.out.println("Veri girisi yapildi");


        con.close();
        ps.close();




    }
}
