package jdbcPractise;

import java.sql.*;

public class Query02 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1) Driver yukle
        Class.forName("org.postgresql.Driver");
        //2) Baglanti olustur
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed","postgres","%MavericK117%");
        //3) Statement olustur
        Statement st=con.createStatement();
        //4) Resultset
        ResultSet data= st.executeQuery("select * from ogrenciler where cinsiyet = 'E'");
        //SORU : Ogrenciler tablosundaki erkek ogrencileri listeleyiniz
        while (data.next()){
            System.out.println(data.getInt(1)+" "+data.getString(2)+" "+
                    data.getString(3)+" "+data.getString(4));
        }
        st.close();
        con.close();
        data.close();
    }
}
