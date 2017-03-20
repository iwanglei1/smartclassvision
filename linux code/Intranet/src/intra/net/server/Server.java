package intra.net.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.FilterWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Iterator;

public class Server {

	
	public static void main(String[] args) {
		
		System.out.println("*********Server Start*******");
		HashSet<Socket> teammember = new HashSet<>();
		HashSet<Socket> leaders = new HashSet<>();
 	try {
		ServerSocket sc = new ServerSocket(10);
	    Socket s;
	
	    while (true)
	    {
	    	try
	    	{
	    	s = sc.accept();
	    	DataInputStream inputStream = new DataInputStream(s.getInputStream());
	    	String priority  = inputStream.readUTF();
	    	if (priority.equals("@#8)($%"))
	    	{
	    		leaders.add(s);
	    		LeaderInputStream serverInputStream = new LeaderInputStream(s,teammember,leaders);
	    		Thread t = new Thread(serverInputStream);
	    		t.start();
	    	}
	    	else
	    	{
	    		teammember.add(s);
	    		UserInformer informer = new UserInformer(leaders,"userinformer",s);
	    		Thread t1 = new Thread(informer);
	    		t1.start();
	    		LeaderInputStream serverInputStream = new LeaderInputStream(s,teammember,leaders);
	    		Thread t = new Thread(serverInputStream);
	    		t.start();
	    		
	    		
	    		
	    				
	    		
	    	}
	    	}catch(Exception e)
	    	{
	    		
	    	}
	    	
	    }
	
	    
	    
	
	} catch (IOException e) {
		// TODO Auto-generated catch block
		
	}
		

	}

}
