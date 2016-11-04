import java.net.ServerSocket;
import java.io.IOException;
public class SocketServer {
	public  static void main(String args[]) throws IOException{
		ServerSocket serSocket = new ServerSocket(8888);
		System.out.println("�˿��Ѿ���Ϊ8888����ʼ׼����������");
		SocketWrapper socket = null;
		try{
			//һ��serversocket��accept���ص���һ��socket����
			socket = new SocketWrapper(serSocket.accept());
			String line = socket.readLine();
			while(!"bye".equals(line)){
				System.out.println("�ͻ��˴������ݣ�" + line);
				socket.writeLine("�ҽ��յ�������ݣ�" + line);
				line = socket.readLine();
			}
			socket.writeLine("close");
		}finally{
			if(socket != null)
				socket.close();
		}
	}
}
