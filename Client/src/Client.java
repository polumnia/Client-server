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
		fromServer.shutdownInput();
		MyFrame frame = new MyFrame(qst, new ObjectOutputStream(fromServer.getOutputStream()));
		frame.setVisible(true);
		while(frame.isReady() != true) {
			continue;
		}
		String st = frame.getStudentInfo();
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fromServer.getOutputStream()));
		out.write(st);
		ObjectOutputStream dataOut = new ObjectOutputStream(fromServer.getOutputStream());
		dataOut.writeObject(frame.getStudentInfo());
		sc.close();
		fromServer.close();
		
		
	}

}
