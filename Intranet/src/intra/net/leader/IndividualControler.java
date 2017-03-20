package intra.net.leader;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.HashSet;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.Font;

public class IndividualControler extends JFrame {

	
	static HashSet inst = new HashSet<>();

	private JPanel contentPane;
	JList instudent = new JList();
	private final JButton btnNewButton = new JButton("New button");
	static {
		try {
					
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				} catch (Exception e) {
					
				JOptionPane.showMessageDialog(null, "Poor Graphics","Error Message",JOptionPane.ERROR_MESSAGE);
				} 
				
			}
	
	public IndividualControler() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 793, 398);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 23, 264, 352);
		contentPane.add(scrollPane);
		
		
		scrollPane.setViewportView(instudent);
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		btnNewButton.setBounds(752, 21, 41, 23);
		
		contentPane.add(btnNewButton);
		
		JLabel lblInternet = new JLabel("Internet");
		lblInternet.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblInternet.setBounds(390, 70, 62, 23);
		contentPane.add(lblInternet);
		
		JButton btnNewButton_1 = new JButton("Block");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			
				DataOutputStream outputStream;
				try {
					outputStream = new DataOutputStream(TeamLeader.s.getOutputStream());
					
					outputStream.writeUTF("instart");
					outputStream.writeUTF(instudent.getSelectedValue().toString());
					outputStream.writeUTF("internet");
					outputStream.writeUTF("enable");
					outputStream.flush();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			
			}
		});
		btnNewButton_1.setBounds(312, 105, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("UnBlock");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				DataOutputStream outputStream;
				try {
					outputStream = new DataOutputStream(TeamLeader.s.getOutputStream());
					outputStream.writeUTF("instart");
					outputStream.writeUTF(instudent.getSelectedValue().toString());
					outputStream.writeUTF("internet");
					outputStream.writeUTF("disable");
					outputStream.flush();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(424, 105, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblMonitor = new JLabel("Monitor");
		lblMonitor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMonitor.setBounds(390, 188, 62, 23);
		contentPane.add(lblMonitor);
		
		JButton button = new JButton("Block");
		button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			
			
			
				try {
					DataOutputStream outputStream = new DataOutputStream(TeamLeader.s.getOutputStream());
					outputStream.writeUTF("instart");
					outputStream.writeUTF(instudent.getSelectedValue().toString());
					outputStream.writeUTF("display");
					outputStream.writeUTF("disable");
					outputStream.flush();
					
					} catch (IOException e1) {
					
				}	
			}
		});
		button.setBounds(312, 222, 89, 23);
		contentPane.add(button);
		
		JButton btnUnblock = new JButton("UnBlock");
		btnUnblock.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnUnblock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					DataOutputStream outputStream = new DataOutputStream(TeamLeader.s.getOutputStream());
					outputStream.writeUTF("instart");
					outputStream.writeUTF(instudent.getSelectedValue().toString());
					outputStream.writeUTF("display");
					outputStream.writeUTF("enable");
					outputStream.flush();
					
					} catch (IOException e1) {
					
					
				}	
				
			}
		});
		btnUnblock.setBounds(424, 222, 89, 23);
		contentPane.add(btnUnblock);
		
		JLabel lblMouse = new JLabel("Mouse");
		lblMouse.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMouse.setBounds(631, 70, 62, 23);
		contentPane.add(lblMouse);
		
		JButton button_2 = new JButton("Block");
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					DataOutputStream outputStream = new DataOutputStream(TeamLeader.s.getOutputStream());
					outputStream.writeUTF("instart");
					outputStream.writeUTF(instudent.getSelectedValue().toString());
					outputStream.writeUTF("mouse");
					outputStream.writeUTF("disable");
					outputStream.flush();
					
					} catch (IOException e1) {
					
				}

				
			}
		});
		button_2.setBounds(552, 105, 89, 23);
		contentPane.add(button_2);
		
		JButton btnUnblock_3 = new JButton("UnBlock");
		btnUnblock_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnUnblock_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				try {
					DataOutputStream outputStream = new DataOutputStream(TeamLeader.s.getOutputStream());
					outputStream.writeUTF("instart");
					outputStream.writeUTF(instudent.getSelectedValue().toString());
					outputStream.writeUTF("mouse");
					outputStream.writeUTF("enable");
					outputStream.flush();
					
					} catch (IOException e1) {
					
				}
			}
		});
		btnUnblock_3.setBounds(664, 105, 89, 23);
		contentPane.add(btnUnblock_3);
		
		JLabel lblKeyboard = new JLabel("KeyBoard");
		lblKeyboard.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblKeyboard.setBounds(379, 304, 122, 23);
		contentPane.add(lblKeyboard);
		
		JButton button_4 = new JButton("Block");
		button_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					DataOutputStream outputStream = new DataOutputStream(TeamLeader.s.getOutputStream());
					outputStream.writeUTF("instart");
					outputStream.writeUTF(instudent.getSelectedValue().toString());
					outputStream.writeUTF("keyboard");
					outputStream.writeUTF("enable");
					outputStream.flush();
					
					} catch (IOException e1) {
					
				}	
			}
		});
		button_4.setBounds(312, 338, 89, 23);
		contentPane.add(button_4);
		
		JButton btnUnblock_1 = new JButton("UnBlock");
		btnUnblock_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnUnblock_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					DataOutputStream outputStream = new DataOutputStream(TeamLeader.s.getOutputStream());
					outputStream.writeUTF("instart");
					outputStream.writeUTF(instudent.getSelectedValue().toString());
					outputStream.writeUTF("keyboard");
					outputStream.writeUTF("disable");
					outputStream.flush();
					
					} catch (IOException e1) {
					
				}	
			}
		});
		btnUnblock_1.setBounds(424, 338, 89, 23);
		contentPane.add(btnUnblock_1);
		
		JLabel lblUsb = new JLabel("Usb");
		lblUsb.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsb.setBounds(639, 188, 62, 23);
		contentPane.add(lblUsb);
		
		JButton button_6 = new JButton("Block");
		button_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					DataOutputStream outputStream = new DataOutputStream(TeamLeader.s.getOutputStream());
					outputStream.writeUTF("instart");
					outputStream.writeUTF(instudent.getSelectedValue().toString());
					outputStream.writeUTF("usb");
					outputStream.writeUTF("disable");
					outputStream.flush();
					
					} catch (IOException e1) {
					
				}	
			}
		});
		button_6.setBounds(552, 222, 89, 23);
		contentPane.add(button_6);
		
		JButton btnUnblock_2 = new JButton("UnBlock");
		btnUnblock_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnUnblock_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DataOutputStream outputStream = new DataOutputStream(TeamLeader.s.getOutputStream());
					outputStream.writeUTF("instart");
					outputStream.writeUTF(instudent.getSelectedValue().toString());
					outputStream.writeUTF("usb");
					outputStream.writeUTF("enable");
					outputStream.flush();
					
					} catch (IOException e1) {
					
				}	
				
				
				
			}
		});
		btnUnblock_2.setBounds(664, 222, 89, 23);
		contentPane.add(btnUnblock_2);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(284, 58, 1, 95);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(484, 58, 1, 95);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(530, 58, 1, 95);
		contentPane.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setBounds(530, 174, 1, 95);
		contentPane.add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setOrientation(SwingConstants.VERTICAL);
		separator_4.setBounds(284, 174, 1, 95);
		contentPane.add(separator_4);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setOrientation(SwingConstants.VERTICAL);
		separator_5.setBounds(284, 280, 1, 95);
		contentPane.add(separator_5);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setOrientation(SwingConstants.VERTICAL);
		separator_6.setBounds(530, 280, 1, 95);
		contentPane.add(separator_6);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setBackground(SystemColor.activeCaption);
		separator_7.setBounds(284, 57, 245, 2);
		contentPane.add(separator_7);
		
		JSeparator separator_8 = new JSeparator();
		separator_8.setBackground(SystemColor.activeCaption);
		separator_8.setBounds(284, 151, 245, 2);
		contentPane.add(separator_8);
		
		JSeparator separator_9 = new JSeparator();
		separator_9.setBackground(SystemColor.activeCaption);
		separator_9.setBounds(286, 174, 245, 2);
		contentPane.add(separator_9);
		
		JSeparator separator_10 = new JSeparator();
		separator_10.setBackground(SystemColor.activeCaption);
		separator_10.setBounds(286, 267, 245, 2);
		contentPane.add(separator_10);
		
		JSeparator separator_11 = new JSeparator();
		separator_11.setBackground(SystemColor.activeCaption);
		separator_11.setBounds(286, 280, 245, 2);
		contentPane.add(separator_11);
		
		JSeparator separator_12 = new JSeparator();
		separator_12.setBackground(SystemColor.activeCaption);
		separator_12.setBounds(286, 373, 245, 2);
		contentPane.add(separator_12);
		
		JSeparator separator_13 = new JSeparator();
		separator_13.setOrientation(SwingConstants.VERTICAL);
		separator_13.setBounds(541, 57, 1, 95);
		contentPane.add(separator_13);
		
		JSeparator separator_14 = new JSeparator();
		separator_14.setOrientation(SwingConstants.VERTICAL);
		separator_14.setBounds(541, 174, 1, 95);
		contentPane.add(separator_14);
		
		JSeparator separator_15 = new JSeparator();
		separator_15.setOrientation(SwingConstants.VERTICAL);
		separator_15.setBounds(541, 280, 1, 95);
		contentPane.add(separator_15);
		
		JSeparator separator_16 = new JSeparator();
		separator_16.setOrientation(SwingConstants.VERTICAL);
		separator_16.setBounds(763, 174, 1, 95);
		contentPane.add(separator_16);
		
		JSeparator separator_17 = new JSeparator();
		separator_17.setBackground(SystemColor.activeCaption);
		separator_17.setBounds(541, 174, 223, 2);
		contentPane.add(separator_17);
		
		JSeparator separator_18 = new JSeparator();
		separator_18.setBackground(SystemColor.activeCaption);
		separator_18.setBounds(541, 267, 223, 2);
		contentPane.add(separator_18);
		
		JSeparator separator_19 = new JSeparator();
		separator_19.setBackground(SystemColor.activeCaption);
		separator_19.setBounds(541, 151, 223, 2);
		contentPane.add(separator_19);
		
		JSeparator separator_20 = new JSeparator();
		separator_20.setBackground(SystemColor.activeCaption);
		separator_20.setBounds(541, 57, 223, 2);
		contentPane.add(separator_20);
		
		JSeparator separator_21 = new JSeparator();
		separator_21.setBackground(SystemColor.activeCaption);
		separator_21.setBounds(541, 280, 223, 2);
		contentPane.add(separator_21);
		
		JSeparator separator_22 = new JSeparator();
		separator_22.setBackground(SystemColor.activeCaption);
		separator_22.setBounds(541, 373, 223, 2);
		contentPane.add(separator_22);
		
		JSeparator separator_23 = new JSeparator();
		separator_23.setOrientation(SwingConstants.VERTICAL);
		separator_23.setBounds(763, 280, 1, 95);
		contentPane.add(separator_23);
		
		JSeparator separator_24 = new JSeparator();
		separator_24.setOrientation(SwingConstants.VERTICAL);
		separator_24.setBounds(763, 57, 1, 95);
		contentPane.add(separator_24);
		
		JButton btnShutdown = new JButton("Shutdown");
		btnShutdown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			
			
			
			}
		});
		btnShutdown.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnShutdown.setBounds(552, 338, 102, 23);
		contentPane.add(btnShutdown);
		
		JButton btnRestart = new JButton("Restart");
		btnRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnRestart.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRestart.setBounds(664, 338, 89, 23);
		contentPane.add(btnRestart);
		
		JButton btnFile = new JButton("File");
		btnFile.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DataOutputStream outputStream;
				try {
					outputStream = new DataOutputStream(TeamLeader.s.getOutputStream());
					
					JFileChooser fc = new JFileChooser();
					fc.setCurrentDirectory(new File (System.getProperty("user.home") + "\\Desktop"));
					int ret = fc.showOpenDialog(null);
					if (ret == JFileChooser.APPROVE_OPTION)
					{  
					
				int i=0;
					try
					{
						String str =instudent.getSelectedValue().toString();
						System.out.println(str);
					i=1;
					}
					
					catch(Exception e)
					{
					
						JOptionPane.showMessageDialog(null, "Please Select An Correct Ip From List");
					i=0;
					}
				
				
					if (i==1)
					{
					File file = new File(fc.getSelectedFile().getAbsolutePath());
				if (file.isFile())
				{
					Long l = file.length();
		             byte[] data = Files.readAllBytes(file.toPath());
                    String filename = file.getName();
                
                    
                    outputStream.writeUTF("infile");
					outputStream.writeUTF(instudent.getSelectedValue().toString());
		             outputStream.writeInt(l.intValue());
		             outputStream.writeUTF(filename);
		             outputStream.write(data);
				}else
				{
					JOptionPane.showMessageDialog(null, "Please Input a Valid File");
				}
					}
					
					
					
					
					}
						
					
					
			
				
				
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
								
				
				
			}
		});
		btnFile.setBounds(612, 293, 89, 23);
		contentPane.add(btnFile);
	}
}
