package JDBC.Gun01;

import org.testng.annotations.Test;

import java.sql.*;

public class _01_Intro {

    @Test
    public void test1() throws SQLException {
        String url="jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/sakila"; // hostname, port/db adını
        String username="root"; // username
        String password="'\"-LhCB'.%k[4S]z"; // password

        Connection connection= DriverManager.getConnection(url,username,password); // connection

        Statement statement = connection.createStatement(); // sorguları çalıştırmak için page açıldı

        ResultSet queryResult = statement.executeQuery("select * from actor"); // sorgu sonucu oluştu, db'de bekliyor

        queryResult.next();

        String firstName=queryResult.getString("first_name");
        String lastName=queryResult.getString("last_name");

        System.out.println("firstName = " + firstName);
        System.out.println("lastName = " + lastName);

        // 2.Satır
        queryResult.next();

        firstName=queryResult.getString("first_name");
        lastName=queryResult.getString("last_name");

        System.out.println("firstName = " + firstName);
        System.out.println("lastName = " + lastName);

        connection.close();

    }
}

// 1 - Connection : önce bağlantı ayarlarını yaptık: username, password, url(port, db, bağlantı yolu)
// 2 - Sorgu Çalıştırma Yolu : sorgularımı çalıştırmak için bir sayfa(yol) açtım
// 3 - Sonuçların alınması   : sorgunun çalışması sonucu veritabanından gelen bilgiler