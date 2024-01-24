import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class SelectSample {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/student";
        String user = "postgres";
        String password = "postgres";

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = null;

        try {
            con = DriverManager.getConnection(url, user, password);
            sql = "SELECT id,name,age FROM employees ORDER BY age";
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");

                System.out.print("id=" + id);
                System.out.print(" name=" + name);
                System.out.print(" age=" + age);
                System.out.println();
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println("SQL関連の例外が発生しました。");
            System.err.println("発行したSQLは" + sql + "です。");
            e.getStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.getStackTrace();
            }
        }
    }
}