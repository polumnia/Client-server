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
				System.out.println("Waiting for a client....");
				Socket clientSoc = serverSoc.accept();
				System.out.println("Connected!");
				ObjectOutputStream dataOut = new ObjectOutputStream(new BufferedOutputStream(clientSoc.getOutputStream()));
				 //dataIn;
				for( int i = 0; i < 10; i++)
				{
					//System.out.println("Here!");
					dataOut.writeObject(qst[i]);
					dataOut.flush();
				}
				clientSoc.shutdownOutput();
				ObjectInputStream dataIn = new ObjectInputStream(clientSoc.getInputStream());
				Student to_DB;
				to_DB = (Student) dataIn.readObject();
				clientSoc.shutdownInput();
				//System.out.println("Here");
				db.studentAnsw(to_DB.getName(), to_DB.getGroup(), to_DB.getAnswers(), to_DB.getMark(), to_DB.getTotal(), to_DB.getTime());
				db.close();
				dataIn.close();
				clientSoc.close();
			//}
				serverSoc.close();
	}
}
