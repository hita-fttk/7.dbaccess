//各らいぶらりーを取得する
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class SelectSample2 {
    public static void main(String[] args) {
        //PostgreSQLに接続する
        try (Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/student", "postgres", "postgres")) {
            //SQL文を準備する
            String sql = "SELECT id,name,age FROM employees ORDER BY age";
            PreparedStatement pstmt = con.prepareStatement(sql);
            //SQLを実行する
            ResultSet rs = pstmt.executeQuery();
            //結果行をループして取得する
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
    }
}
}
