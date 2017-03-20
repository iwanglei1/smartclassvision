package intra.net.teammember;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.SystemColor;
import javax.swing.ScrollPaneConstants;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TeamMember extends JFrame {


	static JPanel contentPane;
	private JTextField textField;
	static Socket s;
	static int i,j,k,l;
	
static	JLabel label = new JLabel("");
static	public JLabel lblNewLabel[] = new JLabel[100];
static int change = 0;
static  JPanel panel;
private JScrollPane scrollPane;
private JLabel lblNewLabel_1;
	/**
	 * Launch the application.
	 */
	static 
	{
try {
			
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			
		JOptionPane.showMessageDialog(null, "Poor Graphics","Error Message",JOptionPane.ERROR_MESSAGE);
		} 
	
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					try {
						 s = new Socket("localhost",10);
						DataOutputStream outputStream= new DataOutputStream(s.getOutputStream());
						outputStream.writeUTF("calfa");
						TeamMember frame = new TeamMember();
						frame.setType(Type.UTILITY);
						frame.setVisible(true);
						MemberInputStream memberInputStream = new MemberInputStream(s);
						Thread t = new Thread(memberInputStream);
						t.start();
						
						
						
					} catch (Exception e) {
					//	JOptionPane.showMessageDialog(null, "Server Not Ready", "Connection Refused", JOptionPane.WARNING_MESSAGE);
//				       System.exit(0);
					}
					
					
					
					
					
					
					
					
					
				} catch (Exception e) {
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TeamMember() {
		
		i=10; 
				j=11; 
				k=46; 
				l=14;
		try
		{
		setUndecorated(true);
		}catch(Exception e)
		{
			
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Toolkit tk = Toolkit.getDefaultToolkit();
		int width = tk.getScreenSize().width;
		int height = tk.getScreenSize().height;
		
		setBounds(width-(width/3), height-350, 277, 302);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				
			
				if (arg0.getKeyCode()==KeyEvent.VK_ENTER)
				{
					if (!textField.getText().equals(""))
					{
					
					try {
						DataOutputStream outputStream = new DataOutputStream(s.getOutputStream());
						outputStream.writeUTF("chat");
						outputStream.writeUTF(textField.getText().toString());
						//TeamMember.textArea.enable();
						//TeamMember.textArea.setText(TeamMember.textArea.getText()+"\n"+" Me:-"+textField.getText().toString());
						//TeamMember.textArea.disable();
						//textField.setText("");
						
						 String text = " " + textField.getText();
							
						lblNewLabel[change] =  new JLabel();
						lblNewLabel[change].setText(text);
					lblNewLabel[change].setOpaque(true);
					lblNewLabel[change].setBackground(Color.WHITE);
						
						j=j+30;
						lblNewLabel[change].setBounds(i,j,textField.getText().length()*7, 20);
						 panel.add(lblNewLabel[change]);
						
						  panel.add(label);
						 
						contentPane.repaint();
						 textField.setText("");
					    change++;
					  
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
					}
				}else
				{
					JOptionPane.showMessageDialog(null,"Pleaser Input An Valid Message");
				}
					
				}
				
			}
		});
		textField.setBackground(SystemColor.menu);
		textField.setForeground(SystemColor.desktop);
		textField.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		textField.setBounds(0, 277, 184, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton();
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setToolTipText("Send");
		btnNewButton.setOpaque(true);
		btnNewButton.setBorderPainted(false); 
		btnNewButton.setEnabled(true);//disabled the button
		btnNewButton.setOpaque(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setOpaque(false);
		btnNewButton.setIcon(new ImageIcon("icons\\sendbt.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (!textField.getText().equals(""))
				{
				
				
				try {
					DataOutputStream outputStream = new DataOutputStream(s.getOutputStream());
					outputStream.writeUTF("chat");
					outputStream.writeUTF(textField.getText().toString());
					//TeamMember.textArea.enable();
					//TeamMember.textArea.setText(TeamMember.textArea.getText()+"\n"+" Me:-"+textField.getText().toString());
					//TeamMember.textArea.disable();
					//textField.setText("");
					
					 String text = " " + textField.getText();
						
					lblNewLabel[change] =  new JLabel();
					lblNewLabel[change].setText(text);
				lblNewLabel[change].setOpaque(true);
				lblNewLabel[change].setBackground(Color.WHITE);
					
					j=j+30;
					lblNewLabel[change].setBounds(i,j,textField.getText().length()*7, 20);
					 panel.add(lblNewLabel[change]);
					
					  panel.add(label);
					 
					contentPane.repaint();
					 textField.setText("");
				    change++;
				  
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
				}
			
				}else
				{
					JOptionPane.showMessageDialog(null,"Pleaser Input An Valid Message");
				}
				
				}
		});
		btnNewButton.setBounds(184, 277, 93, 23);
		contentPane.add(btnNewButton);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 277, 276);
		contentPane.add(scrollPane);
		
		panel = new JPanel();
		scrollPane.setViewportView(panel);
				panel.setLayout(new BorderLayout(0, 0));
		
		
		
		
	
				label.setIcon(new ImageIcon("icons\\FB6.jpg"));
				  panel.add(label);
				  
				 
				  
				  
		
///**** program by chetan sharma *****
		
		
	}
}
