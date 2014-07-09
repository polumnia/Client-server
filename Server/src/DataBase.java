import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Работа с базой данных. Создание, модификация таблиц. 
 */
public class DataBase {
	Connection c = null;
	/**
	 * Создание базы данных.
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
	 * Создание таблицы в б/д.
	 * Таблица содержит вопросы, варианты ответов к ним и указание правильных ответов.
	 */
	public void CreateTestTable() throws SQLException
	{
		 Statement stmt = c.createStatement();
	      String sql = "CREATE TABLE IF NOT EXISTS TEST" + //таблица создаётся только в том случае, если ещё не существует таблиц с таким названием
                 "(ID INT PRIMARY KEY     NOT NULL," +
                 " QUESTION       TEXT    NOT NULL, " + 
                 " ANSWER1        TEXT    NOT NULL, " + 
                 " ANSWER2        TEXT    NOT NULL, " + 
                 " ANSWER3        TEXT    NOT NULL, " + 
                 " ANSWER4        TEXT    NOT NULL, " + 
                 " NANSWER        TEXT    NOT NULL)";
    
	      stmt.executeUpdate(sql); //внесение данных в б/д
	      stmt.close();
	}
	
	/**
	 * Заполнение таблицы исходными данными (вопросами).	  
	 * @throws SQLException 
	 */
	public void FiLLTestTable() throws SQLException {//throws SQLException {
		Statement stmt = null;
		stmt = c.createStatement();
		c.setAutoCommit(false);
		String sqlDel = "DELETE FROM TEST;"; //удаление данных из таблицы
	    stmt.executeUpdate(sqlDel);
	    c.commit();
		String sql = "INSERT INTO TEST (ID,QUESTION,ANSWER1,ANSWER2,ANSWER3,ANSWER4,NANSWER) " +
	    		         "VALUES (1, 'Для построения окружности достаточно сгенерировать:', 'одну вторую её часть', 'одну четвёртую её часть', 'одну восьмую её часть', 'одну шестнадцатую её часть', '3' );";
	    stmt.executeUpdate(sql);
	
	    sql = "INSERT INTO TEST (ID,QUESTION,ANSWER1,ANSWER2,ANSWER3,ANSWER4,NANSWER) " +
	    		 "VALUES (2, 'Свет, содержащий все длины волн в приблизительно равных количествах, называется:', 'хроматическим', 'когерентным', 'теплым ламповым', 'ахроматическим', '4' );"; 
	    stmt.executeUpdate(sql);
	
	    sql = "INSERT INTO TEST (ID,QUESTION,ANSWER1,ANSWER2,ANSWER3,ANSWER4,NANSWER) " +
	    		 "VALUES (3, 'Свет, содержащий длины волн в неравных пропорциях, называется:', 'хроматическим', 'когерентным', 'теплым ламповым', 'ахроматическим', '1');"; 
	    stmt.executeUpdate(sql);  
	     
	    sql = "INSERT INTO TEST (ID,QUESTION,ANSWER1,ANSWER2,ANSWER3,ANSWER4,NANSWER) " +
	    		 "VALUES (4, 'Ахроматеческий цвет при максимальной интенсивности воспринимается как:', 'белый', 'черный', 'синий', 'красный', '1' );"; 
	    stmt.executeUpdate(sql); 
	     
	    sql = "INSERT INTO TEST (ID,QUESTION,ANSWER1,ANSWER2,ANSWER3,ANSWER4,NANSWER) " +
	    		 "VALUES (5, 'Аддитивная цветовая модель предполагает, что любой цвет можно рассматривать как:', 'взвешенную сумму трёх дополнительных цветов', 'взвешенную сумму трёх основных цветов', 'комбинацию яркости и цветояркости', 'комбинацию тона, насыщенности и количества света', '2' );"; 
	    stmt.executeUpdate(sql); 
	     
	    sql = "INSERT INTO TEST (ID,QUESTION,ANSWER1,ANSWER2,ANSWER3,ANSWER4,NANSWER) " +
	    		 "VALUES (6, 'При растеризации эллипса методом Брезенхема выбор приращения по х или по у:', 'выбирается случайно', 'выбирается противоположным предыдущему выбранному приращению', 'совпадает с предыдущим выбранным приращением', 'определяется углом вектора нормали касательной и горизонтальной оси', '4' );"; 
	    stmt.executeUpdate(sql); 
	     
	    sql = "INSERT INTO TEST (ID,QUESTION,ANSWER1,ANSWER2,ANSWER3,ANSWER4,NANSWER) " +
	    		 "VALUES (7, 'Основная идея модифицированного алгоритма Брезенхема состоит в:', 'том, что яркость пикселей постоянна', 'том, что яркость пикселя пропорциональна площад пикселя, попавшей внутрь многоугольника', 'создании двух массивов пикселей', 'вычислении яркости пикселя по градиенту нормали к кривой', '2' );";
	    stmt.executeUpdate(sql); 
	     
	    sql = "INSERT INTO TEST (ID,QUESTION,ANSWER1,ANSWER2,ANSWER3,ANSWER4,NANSWER) " +
			      "VALUES (8, 'В алгоритме Сазерленда-Коэна для каждой области, на которые разбивают плоскость прямые, ставится в соответствие:', '4-битный код', '6-битный код', '8-битный код', 'код Грея', '1' );"; 
	    stmt.executeUpdate(sql); 
	     
	    sql = "INSERT INTO TEST (ID,QUESTION,ANSWER1,ANSWER2,ANSWER3,ANSWER4,NANSWER) " +
	    		 "VALUES (9, 'Алгоритм Лианга-Барского является более эффективной модификацией алгоритма:', 'Цируса-Бека', 'Сазерленд-Коэна', 'Сазерленд-Ходжмана', 'средней точки', '1' );"; 
	    stmt.executeUpdate(sql); 
	     
	    sql = "INSERT INTO TEST (ID,QUESTION,ANSWER1,ANSWER2,ANSWER3,ANSWER4,NANSWER) " +
	    		 "VALUES (10, 'Касательная в начале кривой по направлению:', 'не совпадает с первой стороной многоугольника', 'совпадает с первой стороной многоугольника', 'совпадает с последней стороной многоугольника', 'не совпадает ни с одной из сторон многоугольника', '2' );"; 
	    stmt.executeUpdate(sql); 

	    stmt.close();
	    c.commit();
	}
	
	/**
	 * Получение из таблицы с исходнымми данными массива вопросов. 
	 * @return массив содержащий номера вопросов, сами вопросы, варианты ответов к ним и правильные ответы.	 
	 * @throws  
	 */
	public Question[] GetQuestions() {
		Question[] questions = new Question[10];
		Statement stmt = null;
		try {
			stmt = c.createStatement();
		} catch (SQLException e) {
			System.out.println("Не может создать stmt");
			System.exit(-1);
		}
	      ResultSet rs;
		try {
			rs = stmt.executeQuery( "SELECT * FROM TEST;" );
		 //выбор данных из таблицы 
	      for (int i = 0; i < 10; i++) {
	         int id = rs.getInt("ID");
		     String  question = rs.getString("QUESTION");
		     String  answer1 = rs.getString("ANSWER1");
		     String  answer2 = rs.getString("ANSWER2");
		     String  answer3 = rs.getString("ANSWER3");
		     String  answer4 = rs.getString("ANSWER4");
		     String  nanswer = rs.getString("NANSWER");
		     String[] answ = {answer1, answer2, answer3, answer4}; //массив ответов
		     questions[i] = new Question(id, question, answ, nanswer); //массив вопросов
		     rs.next();
	      }
	      rs.close();
		} catch (SQLException e) {
			System.out.println("Проблема с запросом");
			System.exit(-1);
		}
	      try {
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Не может закрыть");
			System.exit(-1);
		}
		return questions;
	}
	
	/**
	 * Внесение в таблицу результатов тестирования студента.
	 * @param name - имя студента
	 * @param group - номер группы студента
	 * @param questions - вопросы на которые отвечал студент
	 * @param marks - проверка правильности ответов
	 * @param total - конечная оценка, полученная студентом
	 * @param time - время, затраченное студентом на ответы
	 */
	public void studentAnsw(String name, String group, String[] questions, String[] marks, int total, int time) {
	    Statement stmt = null;
	    try {
	      int key = 0;
	      stmt = c.createStatement();
	      String sql = "CREATE TABLE IF NOT EXISTS LOG" + //создание таблицы с результатами
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
	      sql = "INSERT INTO LOG (ID,STNAME,GR,ANSWER1,RIGHT_ANSW1,ANSWER2,RIGHT_ANSW2,ANSWER3,RIGHT_ANSW3,ANSWER4,RIGHT_ANSW4,ANSWER5,RIGHT_ANSW5,MARK,TIME_ANS) " + //добавление в таблицу данных
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
	 * Разсоединение с б/д.	 
	 */
	public void close() throws SQLException {
		c.close();
	}
}