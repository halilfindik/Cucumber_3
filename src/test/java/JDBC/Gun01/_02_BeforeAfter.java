package JDBC.Gun01;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.*;

public class _02_BeforeAfter {

    private static Connection connection;
    private static Statement statement;

    @BeforeTest
    public void DBConnect() {
        // connect to DB

        String url="jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/sakila"; // hostname, port/db adını
        String username="root"; // username
        String password="'\"-LhCB'.%k[4S]z"; // password

        // Connection connection= null; // bunu kaldırmış oldum private olarak ayırdığım için
        try {
            connection = DriverManager.getConnection(url,username,password);
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterTest
    public void DBDisconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    public void test1() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from language");

        rs.next();
        String dilAdi=rs.getString("name");
        System.out.println("dilAdi = " + dilAdi);

        rs.next();
        dilAdi=rs.getString("name");
        System.out.println("dilAdi = " + dilAdi);

        rs.next();
        dilAdi=rs.getString("name");
        System.out.println("dilAdi = " + dilAdi);
    }

    @Test
    public void test2() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from language");

        rs.next();
        String dilAdi=rs.getString(2);
        System.out.println("dilAdi = " + dilAdi);

        rs.next();
        dilAdi=rs.getString(2);
        System.out.println("dilAdi = " + dilAdi);

        rs.next();
        dilAdi=rs.getString(2);
        System.out.println("dilAdi = " + dilAdi);
    }

    @Test
    public void test3() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from language");

        rs.next();
        String dilAdi=rs.getString(2);
        System.out.println("dilAdi = " + dilAdi);

        rs.next();
        dilAdi=rs.getString(2);
        System.out.println("dilAdi = " + dilAdi);

        rs.previous(); // English
        dilAdi=rs.getString(2);

        System.out.println("dilAdi = " + dilAdi);
    }
}
