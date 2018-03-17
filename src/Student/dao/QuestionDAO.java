/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Student.dao;

import Student.pojo.QuestionStore;
import Student.pojo.Questions;
import Student.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class QuestionDAO {
    public static void addQuestion(QuestionStore qStore)throws SQLException{
        Connection conn = DBConnection.getConnection();
        ArrayList<Questions> quesList = qStore.getAllQuestions();
        PreparedStatement ps= conn.prepareStatement("insert into questions values(?,?,?,?,?,?,?,?,?)");
        for(Questions q: quesList){
            ps.setString(1,q.getExamId());
            ps.setInt(2,q.getQno());
            ps.setString(3,q.getQuestion());
            ps.setString(4,q.getAnswer1());
            ps.setString(5,q.getAnswer2());
            ps.setString(6,q.getAnswer3());
            ps.setString(7,q.getAnswer4());
            ps.setString(8,q.getCorrectAnswer());
            ps.setString(9,q.getLanguage());
            ps.executeUpdate();
        }
    }
    public static ArrayList<Questions> getQuestionsByExamId(String examId) throws SQLException{
        Connection conn = DBConnection.getConnection();
        ArrayList<Questions> quesList = new ArrayList<Questions>();
        PreparedStatement ps= conn.prepareStatement("select * from questions where examid =? order by qno");
        ps.setString(1, examId);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Questions q = new Questions(rs.getString(1), rs.getInt(2),rs.getString(3),rs.getString(4), rs.getString(5),
                    rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
            quesList.add(q);
        }
        return quesList;
    }
    
    public static void removeQuestion(String examId) throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("delete from questions where examid = ?");
        ps.setString(1, examId);
        ps.executeUpdate();
    }
    
}