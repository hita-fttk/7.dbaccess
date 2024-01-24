import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Ex01 {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String url = "jdbc:postgresql://localhost:5432/student";
        String user = "postgres";
        String password = "postgres";
        String sql = """
                SELECT * FROM departments;
                """;
        try {
            con = DriverManager.getConnection(url, user, password);
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.println("id="+id+" name="+name);
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
