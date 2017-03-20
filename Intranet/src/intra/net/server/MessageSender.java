package intra.net.server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.net.Socket;
import java.util.HashSet;
import java.util.Iterator;

public class MessageSender  implements Runnable{
Socket s;
String name;

	public MessageSender(Socket s,String name) {
this.s = s;
this.name = name;
	}
	@Override
	public void run() {
		try
		{
		
	
			
		DataOutputStream outputStream = new DataOutputStream(s.getOutputStream());
		
			outputStream.writeUTF("filedata");
			
			BufferedReader bf = new BufferedReader(new FileReader(name));
			while (bf.ready())
			{
outputStream.writeUTF(bf.readLine());
			}
			
			outputStream.writeUTF("@#$%^&(Q");
		
			
	
		}catch(Exception e)
		{
			Thread.currentThread().stop();
		}
Thread.currentThread().stop();		
	}
	

}
