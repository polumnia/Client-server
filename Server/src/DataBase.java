import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ������ � ����� ������. ��������, ����������� ������. 
 */
public class DataBase {
	Connection c = null;
	/**
	 * �������� ���� ������.
	 */
	public void CreateDataBase() {		
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:test1.db");
	    } 
	    catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    System.out.println("Created database successfully");
	}
	
	/**
	 * �������� ������� � �/�.
	 * ������� �������� �������, �������� ������� � ��� � �������� ���������� �������.
	 */
	public void CreateTestTable() throws SQLException
	{
		 Statement stmt = c.createStatement();
	      String sql = "CREATE TABLE IF NOT EXISTS TEST" + //������� �������� ������ � ��� ������, ���� ��� �� ���������� ������ � ����� ���������
                 "(ID INT PRIMARY KEY     NOT NULL," +
                 " QUESTION       TEXT    NOT NULL, " + 
                 " ANSWER1        TEXT    NOT NULL, " + 
                 " ANSWER2        TEXT    NOT NULL, " + 
                 " ANSWER3        TEXT    NOT NULL, " + 
                 " ANSWER4        TEXT    NOT NULL, " + 
                 " NANSWER        TEXT    NOT NULL)";
    
	      stmt.executeUpdate(sql); //�������� ������ � �/�
	      stmt.close();
	}
	
	/**
	 * ���������� ������� ��������� ������� (���������).	  
	 * @throws SQLException 
	 */
	public void FiLLTestTable() throws SQLException {//throws SQLException {
		Statement stmt = null;
		stmt = c.createStatement();
		c.setAutoCommit(false);
		String sqlDel = "DELETE FROM TEST;"; //�������� ������ �� �������
	    stmt.executeUpdate(sqlDel);
	    c.commit();
		String sql = "INSERT INTO TEST (ID,QUESTION,ANSWER1,ANSWER2,ANSWER3,ANSWER4,NANSWER) " +
	    		         "VALUES (1, '��� ���������� ���������� ���������� �������������:', '���� ������ � �����', '���� �������� � �����', '���� ������� � �����', '���� ������������ � �����', '3' );";
	    stmt.executeUpdate(sql);
	
	    sql = "INSERT INTO TEST (ID,QUESTION,ANSWER1,ANSWER2,ANSWER3,ANSWER4,NANSWER) " +
	    		 "VALUES (2, '����, ���������� ��� ����� ���� � �������������� ������ �����������, ����������:', '�������������', '�����������', '������ ��������', '��������������', '4' );"; 
	    stmt.executeUpdate(sql);
	
	    sql = "INSERT INTO TEST (ID,QUESTION,ANSWER1,ANSWER2,ANSWER3,ANSWER4,NANSWER) " +
	    		 "VALUES (3, '����, ���������� ����� ���� � �������� ����������, ����������:', '�������������', '�����������', '������ ��������', '��������������', '1');"; 
	    stmt.executeUpdate(sql);  
	     
	    sql = "INSERT INTO TEST (ID,QUESTION,ANSWER1,ANSWER2,ANSWER3,ANSWER4,NANSWER) " +
	    		 "VALUES (4, '�������������� ���� ��� ������������ ������������� �������������� ���:', '�����', '������', '�����', '�������', '1' );"; 
	    stmt.executeUpdate(sql); 
	     
	    sql = "INSERT INTO TEST (ID,QUESTION,ANSWER1,ANSWER2,ANSWER3,ANSWER4,NANSWER) " +
	    		 "VALUES (5, '���������� �������� ������ ������������, ��� ����� ���� ����� ������������� ���:', '���������� ����� ��� �������������� ������', '���������� ����� ��� �������� ������', '���������� ������� � ������������', '���������� ����, ������������ � ���������� �����', '2' );"; 
	    stmt.executeUpdate(sql); 
	     
	    sql = "INSERT INTO TEST (ID,QUESTION,ANSWER1,ANSWER2,ANSWER3,ANSWER4,NANSWER) " +
	    		 "VALUES (6, '��� ������������ ������� ������� ���������� ����� ���������� �� � ��� �� �:', '���������� ��������', '���������� ��������������� ����������� ���������� ����������', '��������� � ���������� ��������� �����������', '������������ ����� ������� ������� ����������� � �������������� ���', '4' );"; 
	    stmt.executeUpdate(sql); 
	     
	    sql = "INSERT INTO TEST (ID,QUESTION,ANSWER1,ANSWER2,ANSWER3,ANSWER4,NANSWER) " +
	    		 "VALUES (7, '�������� ���� ����������������� ��������� ���������� ������� �:', '���, ��� ������� �������� ���������', '���, ��� ������� ������� ��������������� ������ �������, �������� ������ ��������������', '�������� ���� �������� ��������', '���������� ������� ������� �� ��������� ������� � ������', '2' );";
	    stmt.executeUpdate(sql); 
	     
	    sql = "INSERT INTO TEST (ID,QUESTION,ANSWER1,ANSWER2,ANSWER3,ANSWER4,NANSWER) " +
			      "VALUES (8, '� ��������� ����������-����� ��� ������ �������, �� ������� ��������� ��������� ������, �������� � ������������:', '4-������ ���', '6-������ ���', '8-������ ���', '��� ����', '1' );"; 
	    stmt.executeUpdate(sql); 
	     
	    sql = "INSERT INTO TEST (ID,QUESTION,ANSWER1,ANSWER2,ANSWER3,ANSWER4,NANSWER) " +
	    		 "VALUES (9, '�������� ������-�������� �������� ����� ����������� ������������ ���������:', '������-����', '���������-�����', '���������-��������', '������� �����', '1' );"; 
	    stmt.executeUpdate(sql); 
	     
	    sql = "INSERT INTO TEST (ID,QUESTION,ANSWER1,ANSWER2,ANSWER3,ANSWER4,NANSWER) " +
	    		 "VALUES (10, '����������� � ������ ������ �� �����������:', '�� ��������� � ������ �������� ��������������', '��������� � ������ �������� ��������������', '��������� � ��������� �������� ��������������', '�� ��������� �� � ����� �� ������ ��������������', '2' );"; 
	    stmt.executeUpdate(sql); 

	    stmt.close();
	    c.commit();
	}
	
	/**
	 * ��������� �� ������� � ���������� ������� ������� ��������. 
	 * @return ������ ���������� ������ ��������, ���� �������, �������� ������� � ��� � ���������� ������.	 
	 * @throws  
	 */
	public Question[] GetQuestions() {
		Question[] questions = new Question[10];
		Statement stmt = null;
		try {
			stmt = c.createStatement();
		} catch (SQLException e) {
			System.out.println("�� ����� ������� stmt");
			System.exit(-1);
		}
	      ResultSet rs;
		try {
			rs = stmt.executeQuery( "SELECT * FROM TEST;" );
		 //����� ������ �� ������� 
	      for (int i = 0; i < 10; i++) {
	         int id = rs.getInt("ID");
		     String  question = rs.getString("QUESTION");
		     String  answer1 = rs.getString("ANSWER1");
		     String  answer2 = rs.getString("ANSWER2");
		     String  answer3 = rs.getString("ANSWER3");
		     String  answer4 = rs.getString("ANSWER4");
		     String  nanswer = rs.getString("NANSWER");
		     String[] answ = {answer1, answer2, answer3, answer4}; //������ �������
		     questions[i] = new Question(id, question, answ, nanswer); //������ ��������
		     rs.next();
	      }
	      rs.close();
		} catch (SQLException e) {
			System.out.println("�������� � ��������");
			System.exit(-1);
		}
	      try {
			stmt.close();
		} catch (SQLException e) {
			System.out.println("�� ����� �������");
			System.exit(-1);
		}
		return questions;
	}
	
	/**
	 * �������� � ������� ����������� ������������ ��������.
	 * @param name - ��� ��������
	 * @param group - ����� ������ ��������
	 * @param questions - ������� �� ������� ������� �������
	 * @param marks - �������� ������������ �������
	 * @param total - �������� ������, ���������� ���������
	 * @param time - �����, ����������� ��������� �� ������
	 */
	public void studentAnsw(String name, String group, String[] questions, String[] marks, int total, int time) {
	    Statement stmt = null;
	    try {
	      int key = 0;
	      stmt = c.createStatement();
	      String sql = "CREATE TABLE IF NOT EXISTS LOG" + //�������� ������� � ������������
                  "(ID INT PRIMARY KEY ," + 
                  " STNAME      TEXT    NOT NULL, " + 
                  " GR          TEXT    NOT NULL, " + 
                  " ANSWER1     TEXT    NOT NULL, " + 
                  " RIGHT_ANSW1 TEXT    NOT NULL, " + 
                  " ANSWER2     TEXT    NOT NULL, " + 
                  " RIGHT_ANSW2 TEXT    NOT NULL, " + 
                  " ANSWER3     TEXT    NOT NULL, " + 
                  " RIGHT_ANSW3 TEXT    NOT NULL, " + 
                  " ANSWER4     TEXT    NOT NULL, " + 
                  " RIGHT_ANSW4 TEXT    NOT NULL, " + 
                  " ANSWER5     TEXT    NOT NULL, " + 
                  " RIGHT_ANSW5 TEXT    NOT NULL, " + 
                  " MARK        INT     NOT NULL, " +
                  " TIME_ANS    INT     NOT NULL)";
	      stmt.executeUpdate(sql);
	      ResultSet rs = stmt.executeQuery("SELECT * FROM LOG"); 
	      while(rs.next())
	    	  key++;
	      rs.close();
	      sql = "INSERT INTO LOG (ID,STNAME,GR,ANSWER1,RIGHT_ANSW1,ANSWER2,RIGHT_ANSW2,ANSWER3,RIGHT_ANSW3,ANSWER4,RIGHT_ANSW4,ANSWER5,RIGHT_ANSW5,MARK,TIME_ANS) " + //���������� � ������� ������
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	      PreparedStatement pst = c.prepareStatement(sql);
	      pst.setInt(1, key);
	      pst.setString(2, name);
	      pst.setString(3, group);
	      pst.setString(4, questions[0]);
	      pst.setString(5, marks[0]);
	      pst.setString(6, questions[1]);
	      pst.setString(7, marks[1]);
	      pst.setString(8, questions[2]);
	      pst.setString(9, marks[2]);
	      pst.setString(10, questions[3]);
	      pst.setString(11, marks[3]);
	      pst.setString(12, questions[4]);
	      pst.setString(13, marks[4]);
	      pst.setInt(14, total);
	      pst.setInt(15, time);
	      pst.executeUpdate();
	      pst.close();
	      stmt.close();
	      c.commit();
	    } 
	    catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	}
	
	/**
	 * ������������� � �/�.	 
	 */
	public void close() throws SQLException {
		c.close();
	}
}