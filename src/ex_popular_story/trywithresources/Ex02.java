package ex_popular_story.trywithresources;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;


public class Ex02 {
    public static void main(String[] args) {
        String sql = """
                BEGIN;
                INSERT INTO colors(id,name) VALUES(1,'blue');
                INSERT INTO colors(id,name) VALUES(2,'red');
                INSERT INTO colors(id,name) VALUES(3,'green');
                INSERT INTO colors(id,name) VALUES(4,'yellow');
                INSERT INTO colors(id,name) VALUES(5,'purple');
                INSERT INTO colors(id,name) VALUES(6,'orange');
                COMMIT;
                """;
        String url = "jdbc:postgresql://localhost:5432/student";
        String user = "postgres";
        String password = "postgres";
        try(Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement pstmt = con.prepareStatement(sql);) {
            int numOfOutput = pstmt.executeUpdate();
            System.out.println(numOfOutput+"件のデータを更新しました。");
        } catch (SQLException ex) {
            // TODO: handle exception
            System.err.println("SQL="+sql);
            ex.printStackTrace();
        }
    }
}
