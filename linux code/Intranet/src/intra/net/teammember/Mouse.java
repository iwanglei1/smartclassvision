package intra.net.teammember;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Mouse  implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		
		

		while (true)
		{
			 
			try {
				
				Process p = Runtime.getRuntime().exec(
					    new String[] { "sh",  "-c", "xinput --list" });	
				p.waitFor();
				BufferedReader reader=new BufferedReader(new InputStreamReader(p.getInputStream())); 
				String line=reader.readLine(); 
				while(line!=null) 
				{
					if (line.contains("MOUSE"))
					{
					Pattern p1 = Pattern.compile("[0-9]+");
					Matcher m = p1.matcher(line);
					while (m.find())
					{
						Process m1 = Runtime.getRuntime().exec(
							    new String[] { "sh",  "-c", "xinput disable "+m.group()});	
						m1.waitFor();
						
					}
					}
					
				line=reader.readLine(); 
				}
			 
			 
			 
			 
			 
			 
		   
	
	
				
			
		
			
			
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
			}
			  
		}
		
		
		
		
		
		
	}

	
	
	
}
