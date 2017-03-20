package intra.net.leader;

import java.io.DataInputStream;
import java.net.Socket;

public class MessageReader implements Runnable {
	Socket s;
	
public MessageReader(Socket s) {
	// TODO Auto-generated constructor stub
this.s = s;
}

	@Override
	public void run() {
		try
		{
			System.out.println("thread start");
		// TODO Auto-generated method stub
		DataInputStream dataInputStream =new DataInputStream(s.getInputStream());
		System.out.println(s);
		String str = dataInputStream.readUTF();
		System.out.println(str);
		}catch(Exception e)
		{
			System.out.println(e);
		}
		Thread.currentThread().stop();
		}

///**** program by chetan sharma *****

}
