package intra.net.teammember;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.SystemColor;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.file.Files;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import intra.net.leader.TeamLeader;

public class MemberInputStream  implements Runnable{

	Socket s;
	static String usr="JProgramer";
static	String password="@22442065075473@";
static int mchk=0;
static int mochk=0;
Display m =  new Display();
Thread tm =  new Thread(m);

Mouse mou =  new Mouse();
Thread mo =  new Thread(mou);
	
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
		  FileOutputStream outputStream = new FileOutputStream(System.getProperty("user.home")+"//Desktop//"+filename);
		  outputStream.write(data);
		  outputStream.flush();
		  outputStream.close();
		  try
		  {
			  File  f = new File(System.getProperty("user.home")+"//Desktop//"+filename);
		 Desktop.getDesktop().open(f);
			  
		  }catch(Exception e)
		  {
			  
		  }
		  }
			if (chk.equals("internet"))
			{
				
				String in = dataInputStream.readUTF();
			
			
		   if (in.equalsIgnoreCase("enable"))
		   {
			   
			  
			// Process e = Runtime.getRuntime().exec("cmd /c"+"C:\\Test\\PsExec.exe -u JProgramer -p @22442065075473@ cmd /c C:\\Test\\RuleAdder.exe");
		  //e.waitFor();
		      Process e = Runtime.getRuntime().exec("cmd /c"+"C:\\Test\\PsExec.exe -u "+usr+" -p "+password+" cmd /c C:\\Test\\RuleAddercmd.vbs");
		  e.waitFor();
		  
		
		  
		   }
		   if (in.equalsIgnoreCase("disable"))
		   {  
			 Process f = Runtime.getRuntime().exec("cmd /c"+"C:\\Test\\PsExec.exe -u "+usr+" -p "+password+ " cmd /c C:\\Test\\RuleDeletercmd.vbs");
			  f.waitFor();
				 
				  //C:\Users\JProgramer\Desktop\PsExec.exe -u JProgramer -p @22442065075473@ cmd /c C:\Users\JProgramer\Desktop\RuleDeleter.exe
		   }
			}	
			
			
			
			
			
			
			
			if (chk.equals("usb"))
			{
				
				String in = dataInputStream.readUTF();
				 if (in.equalsIgnoreCase("enable"))
				   {
					 Process p = Runtime.getRuntime().exec(
							    new String[] { "sh",  "-c", "echo "+password+" | sudo -S chmod 777 //media//" });	
						p.waitFor();
						
					 
					 
					 
					 
				   }
				 if (in.equalsIgnoreCase("disable"))
				   {
					
					 
					 Process p = Runtime.getRuntime().exec(
							    new String[] { "sh",  "-c", "echo "+password+" | sudo -S chmod 444 //media//" });	
						p.waitFor();
						 
					  
					  
				   }
			}
			
			if (chk.equals("keyboard"))
			{
				
				String in = dataInputStream.readUTF();
				 if (in.equalsIgnoreCase("enable"))
				   {
					
					 
					 Process p = Runtime.getRuntime().exec(
							    new String[] { "sh",  "-c", "xinput --list" });	
						p.waitFor();
						BufferedReader reader=new BufferedReader(new InputStreamReader(p.getInputStream())); 
						String line=reader.readLine(); 
						while(line!=null) 
						{
							if (line.contains("keyboard"))
							{
							Pattern p1 = Pattern.compile("[0-9]+");
							Matcher m = p1.matcher(line);
							while (m.find())
							{
								Process m1 = Runtime.getRuntime().exec(
									    new String[] { "sh",  "-c", "xinput disable "+m.group() });	
								m1.waitFor();
								
							}
							}
							
						line=reader.readLine(); 
				}
				   
				   
				   
					 
					 
					 
					 
					 
					 
					 
				   }
				 if (in.equalsIgnoreCase("disable"))
				   {
					
					 
					 Process p = Runtime.getRuntime().exec(
							    new String[] { "sh",  "-c", "xinput --list" });	
						p.waitFor();
						BufferedReader reader=new BufferedReader(new InputStreamReader(p.getInputStream())); 
						String line=reader.readLine(); 
						while(line!=null) 
						{
							if (line.contains("keyboard"))
							{
							Pattern p1 = Pattern.compile("[0-9]+");
							Matcher m = p1.matcher(line);
							while (m.find())
							{
								Process m1 = Runtime.getRuntime().exec(
									    new String[] { "sh",  "-c", "xinput enable "+m.group() });	
								m1.waitFor();
								
							}
							}
							
						line=reader.readLine(); 
				}
				   
				   
				   }
			}
			
			
			
			
			if (chk.equals("mouse"))
			{
				if (mochk==0)
				{
					
				}
				else
				{
				 mou =  new Mouse();
				 mo =  new Thread(mou);
				} 
				String in = dataInputStream.readUTF();
				 if (in.equalsIgnoreCase("enable"))
				   {
					 mochk=1;
					 mo.stop();
					
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
									    new String[] { "sh",  "-c", "xinput enable "+m.group() });	
								m1.waitFor();
								
							}
							}
							
						line=reader.readLine(); 
				
				
				} 
						
						
						
						
				
					 
					 
					
				   }
				 if (in.equalsIgnoreCase("disable"))
				   {  
					 
					 mochk=0;
					 mo.start();
				   }
				
			/*String in = dataInputStream.readUTF();
					if (in.equalsIgnoreCase("enable"))
				   {
					
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
								    new String[] { "sh",  "-c", "xinput enable "+m.group() });	
							m1.waitFor();
							
						}
						}
						
					line=reader.readLine(); 
			
			
			} 
	if (in.equalsIgnoreCase("disable"))
				   {
					 
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
					 
					 
					 
					 
					 
					 
				   }
			
			*/
			
			
			
			
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
					
					 try {
						Process p1 = Runtime.getRuntime().exec(
								    new String[] { "sh",  "-c", "xset -display :0.0 dpms force on " });	
							p1.waitFor();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
					}
						
						 try {
							Process p2 = Runtime.getRuntime()
									.exec(new String[] { "sh", "-c", "xset -display :0.0 dpms force on " });
							p2.waitFor();
						} catch (Exception e) {
							// TODO: handle exception
						}
					
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
			TeamMember.lblNewLabel[TeamMember.change].setBounds(TeamMember.i+100,TeamMember.j,msg.length()*12,20);
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
	
	
}
