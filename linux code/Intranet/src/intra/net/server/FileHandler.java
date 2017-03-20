package intra.net.server;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Socket;

public class FileHandler  implements Runnable {

	Socket s;
	String msg;
	public FileHandler(Socket s, String msg) {
		// TODO Auto-generated constructor stub
	this.s = s;
	this.msg = msg;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try 
		{
			String string = s.getInetAddress().getHostAddress();
			BufferedWriter bw = new BufferedWriter(new FileWriter(string, true));
			//bw.newLine();
			bw.write(msg);
			bw.newLine();
			bw.flush();
			bw.close();
Thread.currentThread().stop();



		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Thread.currentThread().stop();
		}
		Thread.currentThread().stop();
	}

	
}
