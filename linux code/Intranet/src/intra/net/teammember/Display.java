package intra.net.teammember;

import java.io.IOException;

public class Display implements Runnable{

	@Override
	public void run() {
int i=0;
		while (i<=10)
		{
			try {
				Process p = Runtime.getRuntime().exec(
					    new String[] { "sh",  "-c", "xset -display :0.0 dpms force off " });	
				p.waitFor();
		i++;
			} catch (Exception e) {
			}
			  
		}
		
	}
	

}
