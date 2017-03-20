package intra.net.teammember;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.SystemColor;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.Socket;
import java.nio.file.Files;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import intra.net.leader.TeamLeader;

public class MemberInputStream  implements Runnable{

	Socket s;
	static String usr="DENIM";
static	String password="FUTUREismine123";
static int mchk=0;
Display m =  new Display();
Thread tm =  new Thread(m);
	
	public MemberInputStream(Socket s)
	{
		this.s = s;
	}


	@Override
	public void run() {

		while (true)
		{
			try
			{
			DataInputStream dataInputStream = new DataInputStream(s.getInputStream());
			String chk = dataInputStream.readUTF();
			
			if (chk.equals("file"))
			{
			int len = dataInputStream.readInt();
			byte[] data = new byte[len];
			String filename = dataInputStream.readUTF();
		  dataInputStream.readFully(data);
		  FileOutputStream outputStream = new FileOutputStream(System.getProperty("user.home")+"\\Desktop\\"+filename);
		  outputStream.write(data);
		  outputStream.flush();
		  outputStream.close();
		  try
		  {
			  File  f = new File(System.getProperty("user.home")+"\\Desktop\\"+filename);
		 Desktop.getDesktop().open(f);
			  
		  }catch(Exception e)
		  {
			  
		  }
		  }
			if (chk.equals("internet"))
			{
				
				String in = dataInputStream.readUTF();
			
			String os = System.getProperty("os.name");
			if (os.contains("windows") || os.contains("Windows"))
			{
		   if (in.equalsIgnoreCase("enable"))
		   {
			   
			  
			// Process e = Runtime.getRuntime().exec("cmd /c"+"C:\\Test\\PsExec.exe -u JProgramer -p @22442065075473@ cmd /c C:\\Test\\RuleAdder.exe");
		  //e.waitFor();
		      Process e = Runtime.getRuntime().exec("cmd /c"+"C:\\Test\\PsExec.exe -u "+usr+" -p "+password+" cmd /c C:\\Test\\RuleAdder.exe");
		  e.waitFor();
		  
		
		  
		   }
		   if (in.equalsIgnoreCase("disable"))
		   {  
			 Process f = Runtime.getRuntime().exec("cmd /c"+"C:\\Test\\PsExec.exe -u "+usr+" -p "+password+ " cmd /c C:\\Test\\RuleDeleter.exe");
			  f.waitFor();
				 
				  //C:\Users\JProgramer\Desktop\PsExec.exe -u JProgramer -p @22442065075473@ cmd /c C:\Users\JProgramer\Desktop\RuleDeleter.exe
		   }
			}	
			
			
			
			}
			
			
			
			if (chk.equals("usb"))
			{
				
				String in = dataInputStream.readUTF();
				 if (in.equalsIgnoreCase("enable"))
				   { int i=0;
					 while (i<=20)
					 {
					 Process f = Runtime.getRuntime().exec("cmd /c"+"C:\\Test\\PsExec.exe -u "+usr+" -p "+password+" cmd /c C:\\Test\\devcon enable *Usb*");
					  f.waitFor();
					 i++;
					 }
					 }
				 if (in.equalsIgnoreCase("disable"))
				   {
					 Process f = Runtime.getRuntime().exec("cmd /c"+"C:\\Test\\PsExec.exe -u "+usr+" -p "+password+" cmd /c C:\\Test\\devcon disable *Usb*");
					  f.waitFor();
					  
					  
				   }
			}
			
			if (chk.equals("keyboard"))
			{
				
				String in = dataInputStream.readUTF();
				 if (in.equalsIgnoreCase("enable"))
				   {
					 File  f = new File("C:\\Test\\KeyBoardLocker.exe");
					 Desktop.getDesktop().open(f);
					// Process f = Runtime.getRuntime().exec(" cmd /c C:\\Test\\KeyBoardLocker.exe");
					  //f.waitFor();
					  int i=0;
					  while (i<=4)
					  {
						  Process f1 = Runtime.getRuntime().exec("cmd /c"+"C:\\Test\\PsExec.exe -u "+usr+" -p "+password+ " cmd /c C:\\Test\\nircmd sendkeypress ctrl+alt+l");
					  f1.waitFor();
					 i++;
					  }
					  Process f2 = Runtime.getRuntime().exec("cmd /c"+"C:\\Test\\PsExec.exe -u "+usr+" -p "+password+ " cmd /c  C:\\Test\\nircmd killprocess \"cmd.exe\" ");
					  f2.waitFor();
				
					  
				   }
				 if (in.equalsIgnoreCase("disable"))
				   {
					 Process f1 = Runtime.getRuntime().exec("cmd /c"+"C:\\Test\\PsExec.exe -u "+usr+" -p "+password+ " cmd /c  C:\\Test\\nircmd sendkeypress U+N+L+O+C+k");
					  f1.waitFor();
					  Process f2 = Runtime.getRuntime().exec("cmd /c"+"C:\\Test\\PsExec.exe -u "+usr+" -p "+password+ " cmd /c  C:\\Test\\nircmd killprocess \"c:\\test\\keyboardLocker.exe\" ");
					  f2.waitFor();
				   }
			}
			
			if (chk.equals("mouse"))
			{
				
				String in = dataInputStream.readUTF();
				 if (in.equalsIgnoreCase("enable"))
				   {
					 Process f = Runtime.getRuntime().exec("cmd /c"+"C:\\Test\\PsExec.exe -u "+usr+" -p "+password+" cmd /c C:\\Test\\devcon enable HID_DEVICE_SYSTEM_MOUSE");
					  f.waitFor();
				   }
				 if (in.equalsIgnoreCase("disable"))
				   {
					 Process f = Runtime.getRuntime().exec("cmd /c"+"C:\\Test\\PsExec.exe -u "+usr+" -p "+password+" cmd /c C:\\Test\\devcon disable HID_DEVICE_SYSTEM_MOUSE");
					  f.waitFor();
					 
				   }
			}
			
			if (chk.equals("display"))
			{
				if (mchk==0)
				{
					
				}
				else
				{
				 m =  new Display();
				 tm =  new Thread(m);
				} 
				String in = dataInputStream.readUTF();
				 if (in.equalsIgnoreCase("enable"))
				   {
					 mchk=1;
					 tm.stop();
					 Process f = Runtime.getRuntime().exec("cmd /c"+"C:\\Test\\PsExec.exe -u "+usr+" -p "+password+ " cmd /c  C:\\Test\\nircmd monitor on");
					  f.waitFor();
					  Process f1 = Runtime.getRuntime().exec("cmd /c"+"C:\\Test\\PsExec.exe -u "+usr+" -p "+password+ " cmd /c  C:\\Test\\nircmd sendkeypress ctrl+shift");
					  f1.waitFor();
					
				   }
				 if (in.equalsIgnoreCase("disable"))
				   {  mchk=0;
					 tm.start();
					 //Process f = Runtime.getRuntime().exec("cmd /c"+"C:\\Test\\PsExec.exe -u "+usr+" -p "+password+ " cmd /c C:\\Test\\nircmd monitor off");
					  //f.waitFor();
				   }
			}
			
			if (chk.equals("messagefomleader"))
			{
				
			String msg = 	dataInputStream.readUTF();
			//TeamMember.textArea.enable();
			//	TeamMember.textArea.setText(TeamMember.textArea.getText()+"\n"+" Teacher:-"+msg);
			//	TeamMember.textArea.disable();
			TeamMember.change++;
		
			TeamMember.lblNewLabel[TeamMember.change] =  new JLabel();
			TeamMember.lblNewLabel[TeamMember.change].setText(msg);
			TeamMember.lblNewLabel[TeamMember.change].setOpaque(true);
			TeamMember.lblNewLabel[TeamMember.change].setBackground(SystemColor.info);
			
		TeamMember.j = TeamMember.j+30;
			TeamMember.lblNewLabel[TeamMember.change].setBounds(TeamMember.i+100,TeamMember.j,msg.length()*7,20);
			TeamMember.panel.add(TeamMember.lblNewLabel[TeamMember.change]);
			  TeamMember.panel.add(TeamMember.label);
			TeamMember.contentPane.revalidate();
			TeamMember.contentPane.repaint();
			
			
			}
			if (chk.equals("shutdown"))
			{
				System.out.println("shut");
				 Process f = Runtime.getRuntime().exec("cmd /c"+"C:\\Test\\PsExec.exe -u "+usr+" -p "+password+ " cmd /c \"shutdown -s\"");
				  f.waitFor();
				}
			if (chk.equals("restart"))
			{System.out.println("res");
				 Process f = Runtime.getRuntime().exec("cmd /c"+"C:\\Test\\PsExec.exe -u "+usr+" -p "+password+ " cmd /c \"shutdown -r\"");
				  f.waitFor();
				}
			
			
			}catch(Exception e){}
			
		}
		
	}
	

///**** program by chetan sharma *****
	
}
