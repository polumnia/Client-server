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
		System.out.println("Waiting for a client....");
		Socket clientSoc = serverSoc.accept();
		System.out.println("Connected!");
		ObjectOutputStream dataOut = new ObjectOutputStream(new BufferedOutputStream(clientSoc.getOutputStream()));
		for( int i = 0; i < 10; i++)
		{
		//System.out.println("Here!");
			dataOut.writeObject(qst[i]);
			dataOut.flush();
		}
		clientSoc.shutdownOutput();
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSoc.getInputStream()));
        String input = in.readLine();
        String[] parts = input.split(";");
        String name = parts[0].substring(11), group = parts[1];
        //System.out.println(name);
        String[] answ = new String[5];
        String[] isRight = new String[5];
        int j = 0;
         //System.out.println(parts[0].substring(11));
        for(int i = 2; i < parts.length - 2; i++) {
        	answ[j] = parts[i];
            i++;
            isRight[j] = parts[i];
          	j++;
        }
               // System.out.println(Integer.valueOf(parts[parts.length-2]));
        db.studentAnsw(name, group, answ, isRight, Integer.valueOf(parts[parts.length-2]), Integer.valueOf(parts[parts.length-1]));
		db.close();
		clientSoc.close();
		serverSoc.close();
	}
}
