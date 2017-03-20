package intra.net.server;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Socket;
import java.util.HashSet;
import java.util.Iterator;

public class LeaderInputStream implements Runnable {

	Socket s;
	HashSet<Socket> teammember;
	HashSet leaders;
	public LeaderInputStream(Socket s,HashSet<Socket> teammember,HashSet leaders)
	{
		this.s = s;
		this.teammember = teammember;
		this.leaders = leaders;
	}

	
	
	@SuppressWarnings("deprecation")
	@Override
	public void run() {
	
		while (true)
		{
			if (s.isConnected())
			{
			try
			{
			DataInputStream inputStream = new DataInputStream(this.s.getInputStream());
			String chk = inputStream.readUTF();
			if (chk.equals("file"))
			{
			   int len = inputStream.readInt();
			   String filename = inputStream.readUTF();
			   byte[] data = new byte[len];
			   inputStream.readFully(data);
 			LeaderOutputStream outputStream = new LeaderOutputStream(s,teammember,data,len,filename,chk,leaders);
		    Thread t = new Thread(outputStream);
		    t.start();
			}
			
			
			
			if (chk.equals("instart"))
			{
				
				String ip = inputStream.readUTF();
				String con = inputStream.readUTF();
				String what = inputStream.readUTF();
				
				
				Iterator itr = teammember.iterator();
				
				while (itr.hasNext())
				{
					Socket sooc = (Socket) itr.next();
					
					if (sooc.getInetAddress().getHostAddress().equals(ip))
					{
						
						DataOutputStream outputStream = new DataOutputStream(sooc.getOutputStream());
						outputStream.writeUTF(con);
						outputStream.writeUTF(what);
						
						System.out.println(ip+"send"+con+what);
						
					}
					
				}
				
				
			}
			
			
			if (chk.equals("infile"))
			{
				
				String ip = inputStream.readUTF();
				int len = inputStream.readInt();
				String filename = inputStream.readUTF();
				byte[] data = new byte[len];
				inputStream.readFully(data);
				
				
				LeaderOutputStream outputStream = new LeaderOutputStream(s,teammember,data,len,filename,chk,leaders,ip);
			    Thread t = new Thread(outputStream);
			    t.start();
				
				
				
			}
			
			
			if (chk.equals("internet"))
			{
				
				String inout = inputStream.readUTF();
				LeaderOutputStream outputStream = new LeaderOutputStream(s,teammember,chk,inout);
			    Thread t = new Thread(outputStream);
			    t.start();
				
			}
			if (chk.equals("shutdown"))
			{
				
				
				LeaderOutputStream outputStream = new LeaderOutputStream(s,teammember,chk);
			    Thread t = new Thread(outputStream);
			    t.start();
				
			}
			if (chk.equals("restart"))
			{
				
				
				LeaderOutputStream outputStream = new LeaderOutputStream(s,teammember,chk);
			    Thread t = new Thread(outputStream);
			    t.start();
				
			}
			
			
			if (chk.equals("usb"))
			{
				String inout = inputStream.readUTF();
				LeaderOutputStream outputStream = new LeaderOutputStream(s,teammember,chk,inout);
			    Thread t = new Thread(outputStream);
			    t.start();
				
			}
			
			if (chk.equals("keyboard"))
			{
				String inout = inputStream.readUTF();
				LeaderOutputStream outputStream = new LeaderOutputStream(s,teammember,chk,inout);
			    Thread t = new Thread(outputStream);
			    t.start();
				
			}
			if (chk.equals("mouse"))
			{
				String inout = inputStream.readUTF();
				LeaderOutputStream outputStream = new LeaderOutputStream(s,teammember,chk,inout);
			    Thread t = new Thread(outputStream);
			    t.start();
				
			}
			
			if (chk.equals("display"))
			{
				String inout = inputStream.readUTF();
				LeaderOutputStream outputStream = new LeaderOutputStream(s,teammember,chk,inout);
			    Thread t = new Thread(outputStream);
			    t.start();
				
			}
			
			
			if (chk.equals("chat"))
			{
				
				String inout = inputStream.readUTF();
				UserInformer informer = new UserInformer(leaders,chk, s,inout);
				Thread t = new Thread(informer);
				t.start();
				
				FileHandler fileHandler = new FileHandler(s, inout);
				Thread t1 = new Thread(fileHandler);
				t1.start();
			}
			
			
			if (chk.equals("filedata"))
			{
				String name = inputStream.readUTF();
		        MessageSender messageSender = new MessageSender(s,name);
				Thread t = new Thread(messageSender);
				t.start();
				
		}
			if (chk.equals("messagefromleader"))
			{
				String ip = inputStream.readUTF();
		        String msg = inputStream.readUTF();
			StudentMessageSender messageSender = new StudentMessageSender(teammember, ip, msg);
			Thread t = new Thread(messageSender);
			t.start();
		        
			}
			
			}catch(Exception e)
			{
				try {
					s.close();
					Thread.currentThread().stop();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println("connection problem");
			}
			}
			else
			{
				try {
					s.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Thread.currentThread().stop();
				
			}
		}
		
		
		
	
	
	
	
	
	
	}
	
	
	
///**** program by chetan sharma *****
	
}
