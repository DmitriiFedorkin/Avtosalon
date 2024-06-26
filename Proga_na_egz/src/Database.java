import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private static final String URL = "jdbc:sqlite:car.db";

    static {
        try (Connection conn = DriverManager.getConnection(URL)) {
            String sql = "CREATE TABLE IF NOT EXISTS car ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "name TEXT NOT NULL,"
                    + "age INTEGER NOT NULL,"
                    + "carbrand TEXT NOT NULL)";
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addPCar(String carbrand, int age, String body) {
        String sql = "INSERT INTO cars(carbrand, age, body) VALUES(?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, carbrand);
            pstmt.setInt(2, age);
            pstmt.setString(3, body);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<car> getCarByBody(String body) {
        List<car> cars = new ArrayList<>();
        String sql = "SELECT * FROM cars WHERE body = ?";
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                cars.add(new car(
                        rs.getInt("id"),
                        rs.getString("carbrand"),
                        rs.getInt("age"),
                        rs.getString("body")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }

    public static List<Object> getAllCars() {
        List<Object> cars = new ArrayList<>().reversed();
        String sql = "SELECT * FROM cars";
        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                cars.add(new car(
                        rs.getInt("id"),
                        rs.getString("car brand"),
                        rs.getInt("age"),
                        rs.getString("body")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }
}