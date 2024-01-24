package ex_popular_story;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.DriverManager;

public class Ex02 {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement pstmt = null;
        String url = "jdbc:postgresql://localhost:5432/student";
        String user = "postgres";
        String password = "postgres";
        String sql = """
                DELETE FROM members WHERE id=1;

                INSERT INTO members(name,birth_day,gender,color_id) VALUES('大野 智','1980-11-26','男',1);
                INSERT INTO members(name,birth_day,gender,color_id) VALUES('櫻井 翔','1982-1-25','男',2);
                INSERT INTO members(name,birth_day,gender,color_id) VALUES('相葉 雅紀','1982-12-24','男',3);
                INSERT INTO members(name,birth_day,gender,color_id) VALUES('二宮 和也','1983-6-17','男',4);
                INSERT INTO members(name,birth_day,gender,color_id) VALUES('松本 潤','1983-8-30','男',5);
                """;
        try{
            con = DriverManager.getConnection(url, user, password);
            pstmt = con.prepareStatement(sql);
            int numOfOutput = pstmt.executeUpdate();
            System.out.println(numOfOutput+"件のデータを操作しました。");
        }catch(SQLException e){
            System.err.println("SQL="+sql);
            e.getStackTrace();
        }finally{
            try{
                if(con != null){
                    con.close();
                }
                if(pstmt != null){
                    pstmt.close();
                }
            }catch(SQLException e){
                e.getStackTrace();
            }
        }
    }
}


