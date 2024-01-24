package ex_popular_story.high;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ex01 {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement pstmt = null;
        String sql = """
                    DROP TABLE IF EXISTS colors;
                    CREATE TABLE colors(
                        id integer primary key,
                        name text
                    );
                    CREATE TABLE members(
                        id serial primary key,
                        name text not null,
                        birth_day date,
                        gender varchar(1),
                        color_id integer REFERENCES colors(id)
                    );
                    """;
        String url = "jdbc:postgresql://localhost:5432/student";
        String user = "postgres";
        String password = "postgres";

        try {
            con = DriverManager.getConnection(url, user, password);
            pstmt = con.prepareStatement(sql);
            int numOfOutput = pstmt.executeUpdate();
            System.out.println(numOfOutput+"件のデータを操作しました。");
        } catch (SQLException e) {
            // TODO: handle exception
            System.err.println("SQL="+sql);
            e.printStackTrace();
        }finally{
            try {
                if (con!=null) {
                    con.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
}
