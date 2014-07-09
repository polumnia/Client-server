import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
public class Server {
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
		DataBase db = new DataBase();
		db.CreateDataBase();
		db.CreateTestTable();
		db.FiLLTestTable();
		ServerSocket serverSoc = null;
		Question[] qst = db.GetQuestions();
		try {
			serverSoc = new ServerSocket(4444);
		}
		catch (IOException e) {
			System.out.println("Couldn't listen to port 4444");
			System.exit(-1);
		}
		// dataIn;
		ObjectOutputStream dataOut;
		
				System.out.println("Waiting for a client....");
				Socket clientSoc = serverSoc.accept();
				System.out.println("Connected!");
				dataOut = new ObjectOutputStream(clientSoc.getOutputStream());
				ObjectInputStream dataIn;
				for( int i = 0; i < 10; i++)
				{
					//System.out.println("Here!");
					dataOut.writeObject(qst[i]);
					dataOut.flush();
				}
				dataOut.close();
				dataIn = new ObjectInputStream(clientSoc.getInputStream());
				Student to_DB = (Student) dataIn.readObject();
				db.studentAnsw(to_DB.getName(), to_DB.getGroup(), to_DB.getAnswers(), to_DB.getMark(), to_DB.getTotal(), to_DB.getTime());
				db.close();
				dataIn.close();
				clientSoc.close();
			//}
				serverSoc.close();
	}
}

