import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.net.Socket;

//一个socket包装类，并且定义了基于这个socket的读写操作，带有缓冲的哦

public class SocketWrapper {
	private Socket socket;
	private InputStream inputStream;
	private BufferedReader inputReader;
	private BufferedWriter outputWriter;
	
	public SocketWrapper(Socket socket) throws IOException{
		this.socket = socket;
		this.inputStream = socket.getInputStream();//也就是说这个输入字节流是从socket里面得到的
		this.inputReader = new BufferedReader(
				new InputStreamReader(inputStream, "GBK"));
		this.outputWriter = new BufferedWriter(
				new OutputStreamWriter(socket.getOutputStream(),"GBK"));//注意编码的方式	
	}
	public String readLine() throws IOException{
		return inputReader.readLine();
	}
	public void writeLine(String line) throws IOException{
		outputWriter.write(line + "\n");
		outputWriter.flush();	
	}
	public void close(){
		try{
			this.socket.close();
		}catch(Exception e){
			
		}
	}

}
