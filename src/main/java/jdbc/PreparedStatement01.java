package jdbc;

import java.sql.*;

public class PreparedStatement01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed", "postgres", "%MavericK117%");
        Statement st = con.createStatement();

        //1. Örnek: Prepared statement kullanarak company adı IBM olan number_of_employees değerini 9999 olarak güncelleyin.

        //1.adim: Prepared Statement Query'sini olustur
        String sql1 = "update companies\n" +
                "set number_of_employees = ?\n" +
                "where company =?";
        // ? degistirilebilir degerlerimiz olacak, surekli duzenleyebilmek icin, reusable code yaptik
        //buna prepared statement diyoruz, hazir kalip gibi

        //2.adim: Prepared Statement objesini olustur
        PreparedStatement pst1 = con.prepareStatement(sql1);

        //3.adim: ? isareti kismina int ise setInt String ise setString gibi set methodlarini kullan
        pst1.setInt(1, 9999);
        pst1.setString(2, "IBM");

        //4.adim: Execute Query yap
        int updateRowSayisi = pst1.executeUpdate();
        System.out.println("updateRowSayisi = " + updateRowSayisi);

        String sql2 = "SELECT * FROM companies";
        ResultSet result1 = st.executeQuery(sql2);

        while (result1.next()) {

            System.out.println(result1.getInt(1) + "--" + result1.getString(2) + "--" + result1.getInt(3));
        }

        // Google icin degisiklik
        pst1.setInt(1, 15000);
        pst1.setString(2, "GOOGLE");


        int updateRowSayisi2 = pst1.executeUpdate();
        System.out.println(updateRowSayisi + " satır güncellendi.");

        String sql3 = "SELECT * FROM companies";
        ResultSet result2 = st.executeQuery(sql3);

        while (result2.next()) {

            System.out.println(result2.getInt(1) + "--" + result2.getString(2) + "--" + result2.getInt(3));
        }


        //2. Örnek: "SELECT * FROM <table name>" query'sini prepared statement ile kullan.

        read_data(con,"companies");
    }
        //Bir tablonun istenilen datasini prepared statement ile cagirmak icin kullanilan method yapiyoruz
        public static void read_data(Connection con, String tableName){

        try {
            String query=String.format("select * from %s",tableName); //format methodu String'i dinamik yapmak icin kullanilir
            //sql query calistir
            Statement statement= con.createStatement();
            ResultSet rs=statement.executeQuery(query);//datayi cagirip resultset konteynerine koyduk

            while (rs.next()){
                System.out.println(rs.getInt(1) + "--" + rs.getString(2) + "--" + rs.getInt(3));
            }
        }catch(Exception e){
            System.out.println(e);
        }

    }
}
