 package Student.dao;

import Student.pojo.UserProfile;
import Student.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RegisterDAO {
    public static boolean registerStudent(String uID, String password) throws SQLException{
    Connection conn = DBConnection.getConnection();
    PreparedStatement ps = conn.prepareStatement("select userid from users where userid = ?");
    ps.setString(1, uID);
    ResultSet rs = ps.executeQuery();
    if(rs.next()){
        return false;
    }else{
    PreparedStatement newps = conn.prepareStatement("insert into users values( ? , ? , ? )");
    newps.setString(1, uID);
    newps.setString(2, password);
    newps.setString(3, "Student");
    newps.executeUpdate();
    return true;
    }}
    
    public static void updatePassword(String password) throws SQLException {
    Connection conn = DBConnection.getConnection();
    PreparedStatement ps = conn.prepareStatement("update users set password = ? where userid = ? and user_type = ?");
    ps.setString(1, password);
    ps.setString(2, UserProfile.getUsername());
    ps.setString(3, UserProfile.getUsertype());
    ps.executeUpdate();
    }
}