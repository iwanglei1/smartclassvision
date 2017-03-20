package intra.net.teammember;

import java.io.IOException;

public class Display implements Runnable{

	@Override
	public void run() {
int i=0;
		while (i<=10)
		{
			 Process f;
			try {
				f = Runtime.getRuntime().exec("cmd /c"+"C:\\Test\\PsExec.exe -u "+MemberInputStream.usr+" -p "+MemberInputStream.password+ " cmd /c C:\\Test\\nircmd monitor off");
				f.waitFor();
		i++;
			} catch (Exception e) {
				// TODO Auto-generated catch block
			}
			  
		}
		
	}
	

}
