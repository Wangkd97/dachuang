package test;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sun.corba.se.spi.orbutil.threadpool.NoSuchWorkQueueException;
import com.tpm.dao.ChooseCardDao;
import com.tpm.dao.DatabaseManger;
import com.tpm.dao.QnaireAndQuestionDao;
import com.tpm.dao.QnaireAndStuDao;
import com.tpm.dao.QuestionDao;
import com.tpm.dao.QuestionnaireDao;
import com.tpm.dao.StudentDao;
import com.tpm.dao.SuoyinDao;
import com.tpm.entity.Question;
import com.tpm.entity.Questionnaire;
import com.tpm.entity.Student;
import com.tpm.entity.Suoyin;



public class test {
	public static void main(String[] args) throws SQLException {
	Connection coon=DatabaseManger.getconnect();
	Statement stmt=coon.createStatement();
	QnaireAndStuDao qnaireAndStuDao=new QnaireAndStuDao();
	//qnaireAndStuDao.addQnaireAndStu(11, "123",  "2019/1/16", "2019/1/17");
	//qnaireAndStuDao.updateQnaireAndStu(11, "123", "30");
	
	
	}
}
