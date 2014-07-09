import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
public class Client {

/**
* Реализация клиентского приложения.
*/
	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		Socket fromServer = null;
		//String hostName = sc.nextLine();
		String hostName = "localhost"; //задание хоста
		System.out.println("Connecting to  " + hostName);
		Question[] qst = new Question[10];
		fromServer = new Socket(hostName,4444); //подключение к сокету сервера
		ObjectInputStream dataIn = new ObjectInputStream(fromServer.getInputStream());
		for (int i = 0; i < qst.length; i++) { //получение от сервера вопросов
			qst[i] = (Question) dataIn.readObject();
		}
		fromServer.shutdownInput(); //закрыть поток 
		MyFrame frame = new MyFrame(qst, new ObjectOutputStream(fromServer.getOutputStream())); //проведение тестирования
		frame.setVisible(true);
		while(frame.isReady() != true) {
			continue;
		}
		String st = frame.getStudentInfo(); //получение результата тестирования
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fromServer.getOutputStream()));
		out.write(st);
		ObjectOutputStream dataOut = new ObjectOutputStream(fromServer.getOutputStream());
		dataOut.writeObject(frame.getStudentInfo()); //передать результат серверу
		sc.close();
		fromServer.close();	
	}
}
