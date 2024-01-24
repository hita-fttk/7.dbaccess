package ex_popular_story;

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
                    SELECT * FROM members;
                    """;
            try {
                con = DriverManager.getConnection(url, user, password);
                pstmt = con.prepareStatement(sql);
                rs = pstmt.executeQuery();
                System.out.println("name\tbirth_day\tgender\tcolor_id");
                while(rs.next()){
                    String name = rs.getString("name");
                    Date date = rs.getDate("birth_day");
                    String gender = rs.getString("gender");
                    int colorId = rs.getInt("color_id");
                    
                    System.out.println(name+"\t"+date+"\t"+gender+"\t"+colorId);
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
