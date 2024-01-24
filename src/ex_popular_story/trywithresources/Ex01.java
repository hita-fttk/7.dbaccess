package ex_popular_story.trywithresources;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ex01 {
    public static void main(String[] args) {
        // Connection con = null;
        // PreparedStatement pstmt = null;
        String sql = """
                BEGIN;
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
                COMMIT;
                    """;
        String url = "jdbc:postgresql://localhost:5432/student";
        String user = "postgres";
        String password = "postgres";

        try(Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement pstmt = con.prepareStatement(sql)) {
            int numOfOutput = pstmt.executeUpdate();
            System.out.println(numOfOutput+"件のデータを操作しました。");
        } catch (SQLException e) {
            // TODO: handle exception
            System.err.println("SQL="+sql);
            e.printStackTrace();
        }
    }
}
