package intra.net.server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.HashSet;

import javax.swing.text.html.HTMLDocument.Iterator;

public class StudentMessageSender implements Runnable{
	HashSet teammeber;
	String ip;
	String msg;
public StudentMessageSender(HashSet teammeber,String ip,String msg) {
	
	
	this.ip = ip;
	this.teammeber = teammeber;
	this.msg = msg;

}
	@Override
	public void run() {
	
java.util.Iterator iterator = teammeber.iterator();

while (iterator.hasNext())
{
	
	Socket s = (Socket)iterator.next();
	if (s.getInetAddress().getHostAddress().equals(ip))
	{
		try {
			DataOutputStream outputStream = new DataOutputStream(s.getOutputStream());
			outputStream.writeUTF("messagefomleader");
			outputStream.writeUTF(msg);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
		
		}
		
	}
	
}
Thread.currentThread().stop();
		
	}

///**** program by chetan sharma *****

}
