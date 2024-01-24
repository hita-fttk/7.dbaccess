package ex_popular_story.high;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;


public class Ex03 {
    public static void main(String[] args) {
            Connection con = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            String url = "jdbc:postgresql://localhost:5432/student";
            String user = "postgres";
            String password = "postgres";
            String sql = """
                    SELECT m.name,m.birth_day,m.gender,c.name AS "color_name"
                    FROM members AS m
                    LEFT JOIN colors AS c
                    ON m.color_id = c.id
                    ORDER BY m.id;
                    """;
            try {
                con = DriverManager.getConnection(url, user, password);
                pstmt = con.prepareStatement(sql);
                rs = pstmt.executeQuery();
                System.out.println("name\tbirth_day\tgender\tcolor_name");
                while(rs.next()){
                    String name = rs.getString("name");
                    Date date = rs.getDate("birth_day");
                    String gender = rs.getString("gender");
                    String colorName = rs.getString("color_name");
                    
                    System.out.println(name+"\t"+date+"\t"+gender+"\t"+colorName);
                }
            } catch (SQLException ex) {
                // TODO: handle exception
                System.err.println("SQL="+sql);
                ex.printStackTrace();
            }finally{
                try {
                    if(con != null){
                        con.close();
                    }
                    if (pstmt != null) {
                        pstmt.close();
                    }
                    if(rs != null){
                        rs.close();
                    }
                } catch (SQLException e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
            }
        }
    }
