/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Student.dao;

import Student.pojo.Student;
import Student.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author lenovo
 */
public class LoginDAO {
    public static boolean ChkUser(Student s) throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps= conn.prepareStatement("select * from users where userid = ? and password = ? and user_type = ?");
        ps.setString(1,s.getUname());
        ps.setString(2, s.getPassword());
        ps.setString(3, s.getUser_type());
        ResultSet ans = ps.executeQuery();
        if(ans.next()){
            return true;
        }else{
            return false;
        }
    }
}
