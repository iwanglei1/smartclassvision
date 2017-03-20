package intra.net.leader;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDropEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.nio.file.Files;
import java.util.HashSet;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;
import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JCheckBox;

public class TeamLeader extends JFrame {
	static TeamLeader frame = new TeamLeader();
	private JPanel contentPane;
	static Socket s;
	JLabel lblNewLabel = new JLabel("");
	JLabel lblNewLabel_1 = new JLabel("");
	static ChatBoxHandler boxHandler;
	static {
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
					
					
					frame.setVisible(true);
			                s =  new Socket("localhost",10);
					DataOutputStream outputStream= new DataOutputStream(s.getOutputStream());
					outputStream.writeUTF("@#8)($%");
					boxHandler = new ChatBoxHandler(s);
					Thread t = new Thread(boxHandler);
					t.start();
					 frame.setDropTarget(new DropTarget() {
					        public synchronized void drop(DropTargetDropEvent evt) {
					            try {
					            	frame.setVisible(false);
					                evt.acceptDrop(DnDConstants.ACTION_COPY);
					                List<File> droppedFiles = (List<File>) evt
					                        .getTransferable().getTransferData(
					                                DataFlavor.javaFileListFlavor);
					                for (File file : droppedFiles) {
					             Long l = file.length();
					             byte[] data = Files.readAllBytes(file.toPath());
                                 String filename = file.getName();
					             DataOutputStream dataOutputStream = new DataOutputStream(s.getOutputStream());
					             dataOutputStream.writeUTF("file");
					             dataOutputStream.writeInt(l.intValue());
					             dataOutputStream.writeUTF(filename);
					             dataOutputStream.write(data);
					            
					              
					              
					               
					                }
					            } catch (Exception ex) {
					                ex.printStackTrace();
					            }
					        }
					    });

					} catch (Exception e) {
					   
						JOptionPane.showMessageDialog(null, "Server Not Ready", "Connection Refused", JOptionPane.WARNING_MESSAGE);
				        System.exit(0);
					}
				
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TeamLeader() {
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 903,580);
		
	setResizable(false);
	lblNewLabel_1.setIcon(new ImageIcon("icons//monitoron.gif"));
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setToolTipText("UnBlock");
		btnNewButton.setOpaque(true);
		btnNewButton.setBorderPainted(false); 
		btnNewButton.setEnabled(true);//disabled the button
		btnNewButton.setOpaque(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setOpaque(false);
		btnNewButton.setIcon(new ImageIcon("icons//block.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblNewLabel.setIcon(new ImageIcon("icons//red.gif"));
				try {
					DataOutputStream outputStream = new DataOutputStream(s.getOutputStream());
					outputStream.writeUTF("internet");
					outputStream.writeUTF("enable");
					outputStream.flush();
					
					} catch (IOException e) {
					// TODO Auto-generated catch block
				
				}
				
				
			}
		});
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("icons//keybaord3.gif"));
		lblNewLabel_4.setBounds(54, 352, 48, 66);
		contentPane.add(lblNewLabel_4);
		btnNewButton.setBounds(10, 214, 113, 23);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("");
		button.setContentAreaFilled(false);
		button.setFocusPainted(false);
		button.setBorderPainted(false);
		button.setToolTipText("UnBlock");
		button.setOpaque(true);
		button.setBorderPainted(false); 
		button.setEnabled(true);//disabled the button
		button.setOpaque(false);
		button.setBorderPainted(false);
		button.setOpaque(false);
		button.setIcon(new ImageIcon("icons//unblock.png"));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblNewLabel.setIcon(new ImageIcon("icons//green.gif"));
				try {
					DataOutputStream outputStream = new DataOutputStream(s.getOutputStream());
					outputStream.writeUTF("internet");
					outputStream.writeUTF("disable");
					outputStream.flush();
					
					} catch (IOException e) {
					// TODO Auto-generated catch block
				}
				
				
				
			}
		});
		button.setBounds(138, 214, 101, 23);
		contentPane.add(button);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 239, 229, 10);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 11, 229, 10);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(237, 11, 16, 229);
		contentPane.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setBounds(10, 11, 16, 229);
		contentPane.add(separator_3);
		
		JButton btnUnblock = new JButton("");

		
		btnUnblock.setIcon(new ImageIcon("icons//unblock.png"));
		btnUnblock.setContentAreaFilled(false);
		btnUnblock.setFocusPainted(false);
		btnUnblock.setBorderPainted(false);
		btnUnblock.setToolTipText("UnBlock");
		btnUnblock.setOpaque(true);
		btnUnblock.setBorderPainted(false); 
		btnUnblock.setEnabled(true);//disabled the button
		btnUnblock.setOpaque(false);
		btnUnblock.setBorderPainted(false);
		btnUnblock.setOpaque(false);
		btnUnblock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				

				try {
					DataOutputStream outputStream = new DataOutputStream(s.getOutputStream());
					outputStream.writeUTF("mouse");
					outputStream.writeUTF("enable");
					outputStream.flush();
					
					} catch (IOException e) {
					
				}
				
			}
		});
		btnUnblock.setBounds(750, 212, 113, 25);
		contentPane.add(btnUnblock);
		
		JButton btnBlock = new JButton("");
		btnBlock.setContentAreaFilled(false);
		btnBlock.setFocusPainted(false);
		btnBlock.setBorderPainted(false);
		btnBlock.setToolTipText("UnBlock");
		btnBlock.setOpaque(true);
		btnBlock.setBorderPainted(false); 
		btnBlock.setEnabled(true);//disabled the button
		btnBlock.setOpaque(false);
		btnBlock.setIcon(new ImageIcon("icons//block.png"));
		btnBlock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			

				try {
					DataOutputStream outputStream = new DataOutputStream(s.getOutputStream());
					outputStream.writeUTF("mouse");
					outputStream.writeUTF("disable");
					outputStream.flush();
					
					} catch (IOException e1) {
					
				}
				
				
			}
		});
		btnBlock.setBounds(645, 214, 95, 23);
		contentPane.add(btnBlock);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(634, 239, 229, 10);
		contentPane.add(separator_4);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setOrientation(SwingConstants.VERTICAL);
		separator_5.setBounds(861, 11, 16, 229);
		contentPane.add(separator_5);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(634, 11, 229, 10);
		contentPane.add(separator_6);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setOrientation(SwingConstants.VERTICAL);
		separator_7.setBounds(634, 11, 16, 229);
		contentPane.add(separator_7);
		
		JButton button_3 = new JButton("");
		button_3.setContentAreaFilled(false);
		button_3.setFocusPainted(false);
		button_3.setBorderPainted(false);
		button_3.setToolTipText("Block");
		button_3.setOpaque(true);
		button_3.setBorderPainted(false); 
		button_3.setEnabled(true);//disabled the button
		button_3.setOpaque(false);
		button_3.setIcon(new ImageIcon("icons//block.png"));
		button_3.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					DataOutputStream outputStream = new DataOutputStream(s.getOutputStream());
					outputStream.writeUTF("keyboard");
					outputStream.writeUTF("enable");
					outputStream.flush();
					
					} catch (IOException e1) {
					
				}	
			}
		});
		button_3.setBounds(10, 474, 113, 23);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("");
		button_4.setIcon(new ImageIcon("icons//unblock.png"));
		button_4.setContentAreaFilled(false);
		button_4.setFocusPainted(false);
		button_4.setBorderPainted(false);
		button_4.setToolTipText("UnBlock");
		button_4.setOpaque(true);
		button_4.setBorderPainted(false); 
		button_4.setEnabled(true);//disabled the button
		button_4.setOpaque(false);
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					DataOutputStream outputStream = new DataOutputStream(s.getOutputStream());
					outputStream.writeUTF("keyboard");
					outputStream.writeUTF("disable");
					outputStream.flush();
					
					} catch (IOException e1) {
					
				}	
			}
		});
		button_4.setBounds(138, 474, 98, 25);
		contentPane.add(button_4);
		
		JSeparator separator_8 = new JSeparator();
		separator_8.setBounds(10, 498, 229, 10);
		contentPane.add(separator_8);
		
		JSeparator separator_9 = new JSeparator();
		separator_9.setOrientation(SwingConstants.VERTICAL);
		separator_9.setBounds(328, 270, 16, 229);
		contentPane.add(separator_9);
		
		JSeparator separator_10 = new JSeparator();
		separator_10.setBounds(10, 270, 229, 10);
		contentPane.add(separator_10);
		
		JSeparator separator_11 = new JSeparator();
		separator_11.setOrientation(SwingConstants.VERTICAL);
		separator_11.setBounds(10, 270, 16, 229);
		contentPane.add(separator_11);
		
		JButton btnUnblock_1 = new JButton("");

		btnUnblock_1.setContentAreaFilled(false);

		btnUnblock_1.setFocusPainted(false);

		btnUnblock_1.setBorderPainted(false);

		btnUnblock_1.setToolTipText("UnBlock");

		btnUnblock_1.setOpaque(true);

		btnUnblock_1.setBorderPainted(false); 

		btnUnblock_1.setEnabled(true);//disabled the button

		btnUnblock_1.setOpaque(false);
		btnUnblock_1.setIcon(new ImageIcon("icons//unblock.png"));
		btnUnblock_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DataOutputStream outputStream = new DataOutputStream(s.getOutputStream());
					outputStream.writeUTF("usb");
					outputStream.writeUTF("enable");
					outputStream.flush();
					
					} catch (IOException e1) {
					
				}	
			}
		});
		btnUnblock_1.setBounds(453, 474, 95, 23);
		contentPane.add(btnUnblock_1);
		
		JButton btnBlock_1 = new JButton("");
		btnBlock_1.setContentAreaFilled(false);
		btnBlock_1.setFocusPainted(false);
		btnBlock_1.setBorderPainted(false);
		btnBlock_1.setToolTipText("Block");
		btnBlock_1.setOpaque(true);
		btnBlock_1.setBorderPainted(false); 
		btnBlock_1.setEnabled(true);//disabled the button
		btnBlock_1.setOpaque(false);
		btnBlock_1.setIcon(new ImageIcon("icons//block.png"));
		btnBlock_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DataOutputStream outputStream = new DataOutputStream(s.getOutputStream());
					outputStream.writeUTF("usb");
					outputStream.writeUTF("disable");
					outputStream.flush();
					
					} catch (IOException e1) {
					
				}	
			}
		});
		btnBlock_1.setBounds(328, 474, 95, 23);
		contentPane.add(btnBlock_1);
		
		JSeparator separator_12 = new JSeparator();
		separator_12.setBounds(328, 498, 229, 10);
		contentPane.add(separator_12);
		
		JSeparator separator_13 = new JSeparator();
		separator_13.setOrientation(SwingConstants.VERTICAL);
		separator_13.setBounds(555, 270, 16, 229);
		contentPane.add(separator_13);
		
		JSeparator separator_14 = new JSeparator();
		separator_14.setBounds(328, 270, 229, 10);
		contentPane.add(separator_14);
		
		JSeparator separator_15 = new JSeparator();
		separator_15.setOrientation(SwingConstants.VERTICAL);
		separator_15.setBounds(237, 270, 16, 229);
		contentPane.add(separator_15);
		
		
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("icons//green.gif"));
		lblNewLabel.setBounds(47, 21, 145, 152);
		contentPane.add(lblNewLabel);
		
		JSeparator separator_16 = new JSeparator();
		separator_16.setBounds(328, 11, 229, 10);
		contentPane.add(separator_16);
		
		JSeparator separator_17 = new JSeparator();
		separator_17.setOrientation(SwingConstants.VERTICAL);
		separator_17.setBounds(328, 11, 16, 229);
		contentPane.add(separator_17);
		
		JSeparator separator_18 = new JSeparator();
		separator_18.setOrientation(SwingConstants.VERTICAL);
		separator_18.setBounds(555, 11, 16, 229);
		contentPane.add(separator_18);
		
		JSeparator separator_19 = new JSeparator();
		separator_19.setBounds(328, 239, 229, 10);
		contentPane.add(separator_19);
		
		JButton button_1 = new JButton("");
		button_1.setContentAreaFilled(false);
		button_1.setFocusPainted(false);
		button_1.setBorderPainted(false);
		button_1.setToolTipText("Block");
		button_1.setOpaque(true);
		button_1.setBorderPainted(false); 
		button_1.setEnabled(true);//disabled the button
		button_1.setOpaque(false);
		button_1.setIcon(new ImageIcon("icons//block.png"));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				lblNewLabel_1.setIcon(new ImageIcon("icons//monitoroff.gif"));
				try {
					DataOutputStream outputStream = new DataOutputStream(s.getOutputStream());
					outputStream.writeUTF("display");
					outputStream.writeUTF("disable");
					outputStream.flush();
					
					} catch (IOException e1) {
					
				}	
				
				
				
			}
		});
		button_1.setBounds(330, 214, 104, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.setContentAreaFilled(false);
		button_2.setFocusPainted(false);
		button_2.setBorderPainted(false);
		button_2.setToolTipText("UnBlock");
		button_2.setOpaque(true);
		button_2.setBorderPainted(false); 
		button_2.setEnabled(true);//disabled the button
		button_2.setOpaque(false);
		button_2.setIcon(new ImageIcon("icons//unblock.png"));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblNewLabel_1.setIcon(new ImageIcon("icons//monitoron.gif"));
				try {
					DataOutputStream outputStream = new DataOutputStream(s.getOutputStream());
					outputStream.writeUTF("display");
					outputStream.writeUTF("enable");
					outputStream.flush();
					
					} catch (IOException e1) {
					
					
				}	
				
			}
		});
		button_2.setBounds(453, 214, 104, 23);
		contentPane.add(button_2);
		
		JSeparator separator_20 = new JSeparator();
		separator_20.setBounds(634, 268, 229, 10);
		contentPane.add(separator_20);
		
		JSeparator separator_21 = new JSeparator();
		separator_21.setOrientation(SwingConstants.VERTICAL);
		separator_21.setBounds(634, 268, 16, 65);
		contentPane.add(separator_21);
		
		JSeparator separator_22 = new JSeparator();
		separator_22.setOrientation(SwingConstants.VERTICAL);
		separator_22.setBounds(861, 268, 16, 65);
		contentPane.add(separator_22);
		
		JSeparator separator_23 = new JSeparator();
		separator_23.setBounds(634, 422, 229, -89);
		contentPane.add(separator_23);
		
		JButton btnChatting = new JButton("");
		
		btnChatting.setContentAreaFilled(false);
		btnChatting.setFocusPainted(false);
		btnChatting.setBorderPainted(false);
		btnChatting.setToolTipText("Chatting");
		btnChatting.setOpaque(true);
		btnChatting.setBorderPainted(false); 
		btnChatting.setEnabled(true);//disabled the button
		btnChatting.setOpaque(false);
		btnChatting.setBorderPainted(false);
		btnChatting.setOpaque(false);
		btnChatting.setIcon(new ImageIcon("icons//chatt.png"));
		btnChatting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				
				boxHandler.b.setVisible(true);
			}
		});
		btnChatting.setBounds(674, 292, 155, 23);
		contentPane.add(btnChatting);
		
		JButton button_7 = new JButton("");
		button_7.setContentAreaFilled(false);
		button_7.setFocusPainted(false);
		button_7.setBorderPainted(false);
		button_7.setToolTipText("Chatting");
		button_7.setOpaque(true);
		button_7.setBorderPainted(false); 
		button_7.setEnabled(true);//disabled the button
		button_7.setOpaque(false);
		button_7.setBorderPainted(false);
		button_7.setOpaque(false);
		button_7.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					DataOutputStream outputStream = new DataOutputStream(s.getOutputStream());
					outputStream.writeUTF("shutdown");
										outputStream.flush();
					
					} catch (IOException e1) {
					
					
				}	
				
			}
		});
		button_7.setIcon(new ImageIcon("icons//shutdown.png"));
		button_7.setBounds(674, 372, 131, 23);
		contentPane.add(button_7);
		
		JButton button_6 = new JButton("");
		button_6.setContentAreaFilled(false);
		button_6.setFocusPainted(false);
		button_6.setBorderPainted(false);
		button_6.setToolTipText("Chatting");
		button_6.setOpaque(true);
		button_6.setBorderPainted(false); 
		button_6.setEnabled(true);//disabled the button
		button_6.setOpaque(false);
		button_6.setBorderPainted(false);
		button_6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					DataOutputStream outputStream = new DataOutputStream(s.getOutputStream());
					outputStream.writeUTF("restart");
										outputStream.flush();
					
					} catch (IOException e1) {
					
					
				}	
				
			}
		});
		button_6.setOpaque(false);
		button_6.setIcon(new ImageIcon("icons//restart.png"));
		button_6.setBounds(674, 406, 131, 23);
		
		contentPane.add(button_6);
		
		
	
		lblNewLabel_1.setBounds(378, 43, 131, 140);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(662, 53, 177, 120);
		lblNewLabel_2.setIcon(new ImageIcon("icons//mouse.gif"));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(54, 291, 48, 66);
		lblNewLabel_3.setIcon(new ImageIcon("icons//keyboard.gif"));
		contentPane.add(lblNewLabel_3);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("icons//keyboard2.gif"));
		label.setBounds(138, 291, 48, 66);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("icons//keybaord4.gif"));
		label_1.setBounds(138, 352, 51, 66);
		contentPane.add(label_1);
		
		JLabel lblNewLabel_5 = new JLabel("\r\n");
		lblNewLabel_5.setIcon(new ImageIcon("icons//usb.gif"));
		lblNewLabel_5.setBounds(403, 314, 145, 134);
		contentPane.add(lblNewLabel_5);
		
		JSeparator separator_24 = new JSeparator();
		separator_24.setOrientation(SwingConstants.VERTICAL);
		separator_24.setBounds(644, 353, -8, 95);
		contentPane.add(separator_24);
		
		JSeparator separator_25 = new JSeparator();
		separator_25.setBounds(634, 331, 229, 2);
		contentPane.add(separator_25);
		
		JSeparator separator_26 = new JSeparator();
		separator_26.setBounds(634, 348, 229, 17);
		contentPane.add(separator_26);
		
		JSeparator separator_27 = new JSeparator();
		separator_27.setOrientation(SwingConstants.VERTICAL);
		separator_27.setBounds(861, 352, 16, 104);
		contentPane.add(separator_27);
		
		JSeparator separator_28 = new JSeparator();
		separator_28.setOrientation(SwingConstants.VERTICAL);
		separator_28.setBounds(634, 346, 16, 110);
		contentPane.add(separator_28);
		
		JSeparator separator_29 = new JSeparator();
		separator_29.setBounds(634, 452, 229, 16);
		contentPane.add(separator_29);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\JProgramer\\Desktop\\background.jpg"));
		lblNewLabel_6.setBounds(0, 0, 897, 551);
		contentPane.add(lblNewLabel_6);
		
	
		
	}
}
