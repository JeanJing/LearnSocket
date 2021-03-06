import java.net.ServerSocket;
import java.io.IOException;
public class SocketServer {
	public  static void main(String args[]) throws IOException{
		ServerSocket serSocket = new ServerSocket(8888);
		System.out.println("端口已经打开为8888，开始准备接受数据");
		SocketWrapper socket = null;
		try{
			//一个serversocket的accept返回的是一个socket类型
			socket = new SocketWrapper(serSocket.accept());
			String line = socket.readLine();
			while(!"bye".equals(line)){
				System.out.println("客户端传来数据：" + line);
				socket.writeLine("我接收到你的数据：" + line);
				line = socket.readLine();
			}
			socket.writeLine("close");
		}finally{
			if(socket != null)
				socket.close();
		}
	}
}
