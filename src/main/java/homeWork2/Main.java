package homeWork2;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.*;
import java.util.Scanner;

public class Main {

    private static final double maxPrice = 1000.00;
    private static Connection connection;
    private static Statement stmt;
    private static ResultSet rs;
    private static PreparedStatement pstmt;


    public static void main(String[] args) {
        try {
            connection();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        try {
            deleteGood();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            createGood();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            clearGood();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            long t = System.currentTimeMillis();
            updateGood();
            System.out.println("Таблица товаров создана");
            System.out.println("Время выполнения: " + (System.currentTimeMillis() - t));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            clearGood();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            long t = System.currentTimeMillis();
            batchupdateGood();
            System.out.println("Таблица товаров создана");
            System.out.println("Время выполнения: " + (System.currentTimeMillis() - t));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            selectGood();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            findOutPrice();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Такого товара нет");
        }

        try {
            changePrice();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            selectGood();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            goodsInРriceRange(99, 134);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            disconnect();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private static void connection() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/mainDB.db");

//        объект для взаимодейсвтия с БД
        stmt = connection.createStatement();
    }

    private static void disconnect() throws SQLException {
        connection.close();
    }

    private static void deleteGood() throws SQLException {
        stmt.execute("DROP TABLE IF EXISTS good");
    }

    private static void createGood() throws SQLException {
        stmt.execute("CREATE TABLE IF NOT EXISTS good (good_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, good_name TEXT NOT NULL, good_price DOUBLE NOT NULL)");
    }

    private static void clearGood() throws SQLException {
        stmt.execute("DELETE FROM good");
    }

    private static void updateGood() throws SQLException {

        for (int i = 0; i < 10000; i++) {
            int cost = (int) (Math.random() * maxPrice);
            BigDecimal result = new BigDecimal(cost);
            result = result.setScale(2, RoundingMode.DOWN);
            stmt.executeUpdate("INSERT INTO good (good_name, good_price) VALUES ('good" + i + "', '" + result + "')");
        }
    }

    private static void batchupdateGood() throws SQLException {
        pstmt = connection.prepareStatement("INSERT INTO good('good_id','good_name', 'good_price')" + "VALUES (?, ?, ?)");
        connection.setAutoCommit(false); //автосинхронизация с базой
        for (int i = 0; i < 10000; i++) {
            pstmt.setInt(1, i);
            pstmt.setString(2, "good" + i);
            pstmt.setInt(3,  (int)(Math.random() * 5000));
            pstmt.addBatch();
        }
        pstmt.executeBatch();
        connection.setAutoCommit(true);
    }

    private static void findOutPrice() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Цену какого товара нужно узнать?");
        String scanString = sc.nextLine();
        pstmt = connection.prepareStatement("SELECT good_price FROM good WHERE good_name = ?;");
        pstmt.setString(1, scanString);
        rs = pstmt.executeQuery();
        System.out.println("Стоимость товара = " + rs.getString(1));
//        sc.close(); //оставляю поток открытым чтобы не бросил ошибку следующий метод
    }

    private static void changePrice() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Цену какого товара нужно изменить?");
        String scanName = sc.nextLine();
        System.out.println("Введите новую цену:");
        int scanPrice = sc.nextInt();
        pstmt = connection.prepareStatement("UPDATE good SET good_price = ?  WHERE good_name = ?");
        pstmt.setInt(1, scanPrice);
        pstmt.setString(2, scanName);
        pstmt.executeUpdate();
        sc.close();
    }

    private static void goodsInРriceRange(double minPrice, double maxPrice) throws SQLException {
        String sqlQuery = "SELECT good_id, good_name, good_price FROM good WHERE good_price >= ? and good_price <= ?;";
        pstmt = connection.prepareStatement(sqlQuery);
        pstmt.setDouble(1, minPrice);
        pstmt.setDouble(2, maxPrice);
        rs = pstmt.executeQuery();
        while (rs.next()){
            System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getDouble(3));
        }

    }

    private static void selectGood() throws SQLException {
        rs = stmt.executeQuery("SELECT * FROM good WHERE good_id BETWEEN 9998 AND 10000");

        while (rs.next()) {
            System.out.printf("id: %5d name: %5s price: %d %n", rs.getInt("good_id"), rs.getString("good_name"), rs.getInt("good_price"));
        }
    }
}
