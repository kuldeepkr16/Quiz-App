/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Student.dao;

import Student.pojo.Exam;
import Student.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author lenovo
 */
public class ExamDAO {
    public static String getExamID() throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps= conn.prepareStatement("select count(*) as examID from exam");
        ResultSet ans = ps.executeQuery();
        int rowCount = 0 ;
        if(ans.next())
            rowCount = ans.getInt("examID");
            return "EX-" + (ans.getInt("examID") + 1);
    }
 public static void addExam(Exam newExam) throws SQLException{
     Connection conn = DBConnection.getConnection();
     PreparedStatement ps= conn.prepareStatement("insert into exam values(?,?,?)");
     ps.setString(1, newExam.getExamID());
     ps.setString(2, newExam.getLanguage());
     ps.setInt(3, newExam.getTotalQues());
     ps.executeUpdate();
 }   
 public static ArrayList<String> getExamIdBySubject(String subject) throws SQLException{
     Connection conn = DBConnection.getConnection();
     PreparedStatement ps = conn.prepareStatement("select examno from exam where language = ?");
     ArrayList<String> examList = new ArrayList<String>();
     ps.setString(1, subject);
     ResultSet rs = ps.executeQuery(); 
     while(rs.next()){
         examList.add(rs.getString(1));
     }
     return examList;
 }
 public static int getQuesCountByExam(String examId) throws SQLException{
     Connection conn = DBConnection.getConnection();
     PreparedStatement ps = conn.prepareStatement("select total_ques from exam where examno = ?");
     ps.setString(1, examId);
     ResultSet rs = ps.executeQuery();
     rs.next();
     int rowCount = rs.getInt(1);
     return rowCount;
 }
}
