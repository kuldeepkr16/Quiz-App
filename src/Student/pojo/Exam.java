/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Student.pojo;

/**
 *
 * @author lenovo
 */
public class Exam {

    private static String ExamID;
    private static String Language;
    private static int TotalQues;
    public Exam(String ExamID, String Language, int TotalQues){
        this.ExamID = ExamID;
        this.Language = Language;
        this.TotalQues = TotalQues;
    }
    
    public static String getExamID() {
        return ExamID;
    }

    public static void setExamID(String ExamID) {
        Exam.ExamID = ExamID;
    }

    public static String getLanguage() {
        return Language;
    }

    public static void setLanguage(String Language) {
        Exam.Language = Language;
    }

    public static int getTotalQues() {
        return TotalQues;
    }

    public static void setTotalQues(int TotalQues) {
        Exam.TotalQues = TotalQues;
    }

   
}
