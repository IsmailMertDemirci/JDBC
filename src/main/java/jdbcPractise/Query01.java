package jdbcPractise;

import java.sql.*;

public class Query01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1) Driver yukle
        Class.forName("org.postgresql.Driver");
        //2) Baglanti olustur
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed","postgres","%MavericK117%");
        //3) Statement olustur
        Statement st=con.createStatement();

        //4) Resultset
        ResultSet veri= st.executeQuery("select * from ogrenciler");
        while (veri.next()){
           //sonuclari index ya da string icinde kullanarak gorebiliriz
            //System.out.println(veri.getInt(1)+" "+veri.getString(2)+" "+
                    //veri.getString(3)+" "+veri.getString(4));

            //System.out.println(veri.getInt("okul_no")+" "+veri.getString("ogrenci_ismi")+" "+
                    //veri.getString("sinif")+" "+veri.getString("cinsiyet"));
            System.out.printf("%-6d %-15.15s %-8s %-8s\n", veri.getInt(1), veri.getString(2), veri.getString(3), veri.getString(4));
        st.close();
        con.close();
        veri.close();
        }
    }
}
