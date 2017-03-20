package intra.net.server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.HashSet;
import java.util.Iterator;

public class UserInformer implements Runnable {
HashSet leaders;
Socket s;
String chk;
String msg;
	 public UserInformer(HashSet leaders,String chk,Socket s) {
	this.leaders = leaders;
	this.s = s;
		 this.chk =  chk;
		 // TODO Auto-generated constructor stub
	}
	 
	 public UserInformer(HashSet leaders,String chk,Socket s,String msg) {
			this.leaders = leaders;
			this.s = s;
				 this.chk =  chk;
				this.msg = msg;
			}
			 
	 
	@Override
	public void run() {
		
		Iterator iterator = leaders.iterator();
		while (iterator.hasNext())
		{try
		{
			
			
			Socket ss = (Socket) iterator.next();
			DataOutputStream outputStream = new DataOutputStream(ss.getOutputStream());
		if (chk.equals("userinformer"))
		{
			outputStream.writeUTF("userinfo");
				outputStream.writeUTF(s.getInetAddress().getHostAddress());
		}
		
		if (chk.equals("chat"))
		{
			outputStream.writeUTF("chat");
			outputStream.writeUTF(msg);
		}
		
		
		} catch (IOException e) {
				// TODO Auto-generated catch block
				
			}
			
		}
		
		Thread.currentThread().stop();
		
	}

}
