import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.DriverManager;

public class InsertSample {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement pstmt = null;
        String url = "jdbc:postgresql://localhost:5432/student";
        String user = "postgres";
        String password = "postgres";
        String sql = "INSERT INTO employees(name,age) VALUES('テスト太郎',19)";
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
