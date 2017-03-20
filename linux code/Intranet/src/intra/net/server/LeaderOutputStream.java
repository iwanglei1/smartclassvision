package intra.net.server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.HashSet;
import java.util.Iterator;

public class LeaderOutputStream implements Runnable{
	Socket s;
   HashSet<Socket> teammember;
   byte[]  data;
   String filename;
   int len;
   String chk;
   String inout;
   HashSet leaders;
   public LeaderOutputStream(Socket s,HashSet<Socket> team,String chk,String inout)
   {
	  this.s =s;
	  this.teammember = team;
	  this.chk = chk;
	  this.inout = inout;
   }
   
   public LeaderOutputStream(Socket s,HashSet<Socket> team,String chk)
   {
	  this.s =s;
	  this.teammember = team;
	  this.chk = chk;
	  
   }
   public LeaderOutputStream(Socket s,HashSet<Socket> teammember,byte[] data,int len, String filename,String chk,HashSet leader)
   {
	   this.s = s;
	   this.teammember = teammember;
	   this.data = data;
	   this.len = len;
	 this.filename = filename;
	 this.chk = chk;
   this.leaders = leader;
   }

   
   public void run()
   {
	   Iterator<Socket> itr = teammember.iterator();
	   
	   while (itr.hasNext())
	   {
		   try {
			   Socket soc = itr.next();
			  
			   
			   if (soc.isConnected())
			   {
				   if (chk.equals("file"))
				   {
			DataOutputStream outputStream = new DataOutputStream(soc.getOutputStream());
			try
			{
		    outputStream.writeUTF("file");
			outputStream.writeInt(len);
            outputStream.writeUTF(filename);
            outputStream.write(data);
           outputStream.flush();
           System.out.println("file send to student");
           Iterator<Socket> itr12 = leaders.iterator();
        		while (itr12.hasNext())
        		{
        			Socket s1 = (Socket) itr12.next();
        			System.out.println(s);
        	DataOutputStream	outputStream1 = new DataOutputStream(s1.getOutputStream());
        		outputStream1.writeUTF("filesuccesfullyresived");
        		System.out.println("succedfulle send to teacher");
        		
        		
        		} 
            
			}catch(Exception e)
			{
				
			}
			
		     }

				   if (chk.equals("internet"))
				   {
					   DataOutputStream outputStream = new DataOutputStream(soc.getOutputStream());
					   outputStream.writeUTF("internet");
					   outputStream.writeUTF(inout);
					   
				   }
				   
				   if (chk.equals("usb"))
				   {
					   DataOutputStream outputStream = new DataOutputStream(soc.getOutputStream());
					   outputStream.writeUTF("usb");
					   outputStream.writeUTF(inout);
					   
				   }
				   if (chk.equals("mouse"))
				   {
					   DataOutputStream outputStream = new DataOutputStream(soc.getOutputStream());
					   outputStream.writeUTF("mouse");
					   outputStream.writeUTF(inout);
					   
				   }
				   if (chk.equals("keyboard"))
				   {
					   DataOutputStream outputStream = new DataOutputStream(soc.getOutputStream());
					   outputStream.writeUTF("keyboard");
					   outputStream.writeUTF(inout);
					   
				   }
				   
				   if (chk.equals("display"))
				   {
					   DataOutputStream outputStream = new DataOutputStream(soc.getOutputStream());
					   outputStream.writeUTF("display");
					   outputStream.writeUTF(inout);
					   
				   }
				   
				   if (chk.equals("shutdown"))
				   {
					   DataOutputStream outputStream = new DataOutputStream(soc.getOutputStream());
					   outputStream.writeUTF("shutdown");
					   
				   }
				   
				   if (chk.equals("restart"))
				   {
					   DataOutputStream outputStream = new DataOutputStream(soc.getOutputStream());
					   outputStream.writeUTF("restart");
					   
				   }
				   
			}
			   
			   else
			   {
				   itr.remove();
			   }
			   
			} catch (IOException e) {
			// TODO Auto-generated catch block
			
			Thread.currentThread().stop();
		}
		   
	   }
	
	   
	   Thread.currentThread().stop();
	   
   }
}
