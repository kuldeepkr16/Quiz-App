/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Student.util;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author lenovo
 */
public class DBConnection {
    private static Connection conn;
    static{
        try{
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@//LAPTOP-BB2OAAHM:1521/xe","project","java");
        }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Database Error","error",JOptionPane.ERROR_MESSAGE);
        }}
        public static Connection getConnection(){
        return conn;
        }
        public static void closeConnection(){
            if(conn!=null){
                try{
                conn.close();
            }catch(Exception e){
            JOptionPane.showMessageDialog(null, "error in db connection", "error", JOptionPane.ERROR_MESSAGE);
            }}
        }
}
