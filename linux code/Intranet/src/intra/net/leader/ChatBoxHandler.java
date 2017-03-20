package intra.net.leader;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.HashSet;

import javax.swing.AbstractListModel;

public class ChatBoxHandler implements Runnable {
	ChatBox b;
	HashSet<String> usrList = new HashSet<>();
	Socket s;
 public ChatBoxHandler(Socket s) {
		// TODO Auto-generated constructor stub
	this.s = s; 
	 
	}
	
	
	
	@Override
	public void run() {
		b = new ChatBox(s);
		while (true)
		{
			try {
				if (s.isConnected())
				{

					String newusr;
					try {
						DataInputStream inputStream = new DataInputStream(s.getInputStream());
String chk = inputStream.readUTF();
if (chk.equals("userinfo"))
{
newusr = inputStream.readUTF();
usrList.add(newusr);
}

if (chk.equals("filesuccesfullyresived"))
{
	//TeamLeader.f.dispose();
	TeamLeader.frame.setVisible(true);
	TeamLeader.frame.revalidate();
}
if (chk.equals("chat"))
{
	System.out.println(inputStream.readUTF());
}

if (chk.equals("filedata"))
	{ ChatBox.textArea.enable();
	ChatBox.textArea.setText("");
	String str = inputStream.readUTF();
	while (!str.equals("@#$%^&(Q"))
	{
		ChatBox.textArea.setText(ChatBox.textArea.getText()+"\n"+" Student:-"+str);
		
		str = inputStream.readUTF();
		
		
		
	}
	
	ChatBox.textArea.disable();
	
}

} catch (Exception e) {
						// TODO Auto-generated catch block
						Thread.currentThread().stop();
					}
				
				b.list.setModel(new AbstractListModel() {
					String[] values = usrList.toArray(new String[usrList.size()]);
					public int getSize() {
						return values.length;
					}
					public Object getElementAt(int index) {
						return values[index];
					}
				});
				}
				else
				{
					Thread.currentThread().stop();
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		
	}

	
	
	
}
