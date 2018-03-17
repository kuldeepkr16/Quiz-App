/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Student.dao;

import Student.pojo.Performance;
import Student.pojo.StudentScore;
import Student.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author lenovo
 */
public class PerformanceDAO {
    public static ArrayList<String> getAllStudentId() throws SQLException{
        Connection conn = DBConnection.getConnection();
        Statement st = conn.createStatement();
        ArrayList<String> idList = new ArrayList<String>();
        ResultSet rs = st.executeQuery("select DISTINCT userid from performance");
        while(rs.next()){
            idList.add(rs.getString(1));
        }
        return idList;
    }
    
 public static ArrayList<String> getAllExamID(String userid) throws SQLException{
     Connection conn = DBConnection.getConnection();
     PreparedStatement ps = conn.prepareStatement("select examid from performance where userid = ?");
     ArrayList<String> examIdList = new ArrayList<String>();
     ps.setString(1, userid);
     ResultSet rs = ps.executeQuery();
     while(rs.next()){
         examIdList.add(rs.getString(1));
     }
     return examIdList;
 }
 
 public static StudentScore getResult(String userId,String examId) throws SQLException{
     Connection conn = DBConnection.getConnection();
     PreparedStatement ps = conn.prepareStatement("select per,language from performance where userid = ? and examid = ?");
     ps.setString(1, userId);
     ps.setString(2, examId);
     StudentScore ss = new StudentScore();
     ResultSet rs = ps.executeQuery();
     rs.next();
     ss.setPercentage(rs.getDouble(1));
     ss.setLanguage(rs.getString(2));
     return ss;
 }
 
 public static ArrayList<Performance> getAllData() throws SQLException{
     Connection conn = DBConnection.getConnection();
     Statement st = conn.createStatement();
     ResultSet rs = st.executeQuery("select * from performance");
     ArrayList<Performance> perf = new ArrayList<Performance>();
     while(rs.next()){
         String userid = rs.getString("userid");
         String examid = rs.getString("examid");
         int right = rs.getInt("right");
         int wrong = rs.getInt("wrong");
         int unattempted = rs.getInt("unattempted");
         double per = rs.getDouble("per");
         String language = rs.getString("language");
         Performance perform = new Performance(userid, examid, right, wrong, unattempted, per, language);
         perf.add(perform);
     }
     return perf;
 }
 
 public static void addPerformance(Performance perf) throws SQLException{
     Connection conn = DBConnection.getConnection();
     PreparedStatement ps = conn.prepareStatement("insert into performance values(?,?,?,?,?,?,?)");
     ps.setString(1, perf.getUserId());
     ps.setString(2, perf.getExamId());
     ps.setInt(3, perf.getRight());
     ps.setInt(4, perf.getWrong());
     ps.setInt(5, perf.getUnattempted());
     ps.setDouble(6, perf.getPer());
     ps.setString(7, perf.getLanguage());
     ps.executeUpdate();
 }
 
 public static boolean getStatus(String uname, String examId) throws SQLException{
    Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("select * performance where userid = ? and examid=?");
        ps.setString(1,uname);
        ps.setString(2, examId);
        ResultSet rs = ps.executeQuery(); 
        if(rs.next()){
            return true;
        }
        else{
            return false;
        }
    }
 
}