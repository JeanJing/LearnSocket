import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class SocketClient {
	public static void main(String args[]) throws IOException{
		Scanner scanner = new Scanner(System.in);
		SocketWrapper socket = 
				new SocketWrapper(new Socket("localhost",8888));
		try{
			System.out.println("�Ѿ����Ϸ������ˣ����ڿ����������ݿ�ʼͨ����");
			String sendMsg = scanner.nextLine();
			socket.writeLine(sendMsg);
			String recivedMsg = socket.readLine();
			while(!"close".equals(recivedMsg)){
				System.out.println("===�����������ء�===>" + recivedMsg);
				sendMsg = scanner.nextLine();
				socket.writeLine(sendMsg);
				recivedMsg = socket.readLine();
			}
		}finally{
			if(socket == null)
				socket.close();
		}
	
	}
}
