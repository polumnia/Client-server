import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		Socket fromServer = null;
		//String hostName = sc.nextLine();
		String hostName = "localhost";
		System.out.println("Connecting to  " + hostName);
		Question[] qst = new Question[10];
		fromServer = new Socket(hostName,4444);
		ObjectInputStream dataIn = new ObjectInputStream(fromServer.getInputStream());
		for (int i = 0; i < qst.length /*&& dataIn.readObject() != null*/; i++) {
			qst[i] = (Question) dataIn.readObject();
		}
		dataIn.close();
		MyFrame frame = new MyFrame(qst);
		frame.setVisible(true);
		Student s = frame.getStudentInfo();
		if(frame.isActive() != true)
			s = frame.getStudentInfo();
		ObjectOutputStream dataOut = new ObjectOutputStream(fromServer.getOutputStream());
		dataOut.writeObject(s);
		dataOut.flush();
		dataOut.close();
		sc.close();
		fromServer.close();
		
		
	}

}
