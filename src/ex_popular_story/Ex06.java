package ex_popular_story;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ex06 {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement pstmt = null;
        String url = "jdbc:postgresql://localhost:5432/student";
        String user = "postgres";
        String password = "postgres";
        String sql = """
                DROP TABLE IF EXISTS members;
                """;
        try{
            con = DriverManager.getConnection(url, user, password);
            pstmt = con.prepareStatement(sql);
            int numOfOutput = pstmt.executeUpdate();
            System.out.println(numOfOutput+"件のデータを操作しました。");
        }catch(SQLException e){
            System.err.println("SQL="+sql);
            e.printStackTrace();
        }finally{
            try{
                if(con != null){
                    con.close();
                }
                if(pstmt != null){
                    pstmt.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
}
