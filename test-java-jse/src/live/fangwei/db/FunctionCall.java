package live.fangwei.db;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;

public class FunctionCall {

    Connection conn;
    Statement cmd;
    PreparedStatement pCmd;
    CallableStatement call;
    ResultSet rs;

    public void initConn() {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test_fw";
        String user = "dev_write";
        String pass = "dev_write";
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, pass);

            String sql = "{call sp1(?, ?)}";
            call = conn.prepareCall(sql);
            call.setInt(1, 1);
            call.registerOutParameter(2, Types.VARCHAR);
            call.execute();

            System.out.println("\nout=" + call.getString(2));
            
            rs = call.getResultSet();
            System.out.println("\nRS 1:");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2));
            }
            
            if (call.getMoreResults()) {
                rs = call.getResultSet();
                if (rs != null) {
                    System.out.println("\nRS 2:");
                    while (rs.next()) {
                        System.out.println(rs.getInt(1) + " " + rs.getString(2));
                    }
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        FunctionCall call = new FunctionCall();
        call.initConn();
    }
}
