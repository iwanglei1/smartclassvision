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
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JCheckBox;
import java.awt.SystemColor;
import javax.swing.JInternalFrame;

public class TeamLeader extends JFrame {
	static TeamLeader frame = new TeamLeader();
	private JPanel contentPane;
	static Socket s;
	JLabel lblNewLabel = new JLabel("");
	JLabel lblNewLabel_1 = new JLabel("");
	static Uploader uploader = new Uploader();
	IndividualControler in = new IndividualControler();
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
					            	
					                evt.acceptDrop(DnDConstants.ACTION_COPY);
					                List<File> droppedFiles = (List<File>) evt
					                        .getTransferable().getTransferData(
					                                DataFlavor.javaFileListFlavor);
					                for (File file : droppedFiles) {
					           
					                	if (file.isFile())
					                	{
					                		//frame.setVisible(false);
					                	Long l = file.length();
					             byte[] data = Files.readAllBytes(file.toPath());
                                 String filename = file.getName();
					             DataOutputStream dataOutputStream = new DataOutputStream(s.getOutputStream());
					             dataOutputStream.writeUTF("file");
					             dataOutputStream.writeInt(l.intValue());
					             dataOutputStream.writeUTF(filename);
					             dataOutputStream.write(data);
					            
					              uploader.setVisible(true);
					                	}
					                	else
					                	{
					                		JOptionPane.showMessageDialog(null, "Please Input a Valid File");
					                	}
					               
					                }
					            } catch (Exception ex) {

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
		setIconImage(Toolkit.getDefaultToolkit().getImage("icons\\msg.png"));
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 903,580);
		
	setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JInternalFrame internalFrame_6 = new JInternalFrame("Other Utilities");
		internalFrame_6.getContentPane().setBackground(Color.WHITE);
		internalFrame_6.setBounds(634, 270, 253, 250);
		contentPane.add(internalFrame_6);
		internalFrame_6.getContentPane().setLayout(null);
		
		JButton btnChatting = new JButton("");
		btnChatting.setBounds(10, 11, 99, 100);
		internalFrame_6.getContentPane().add(btnChatting);
		
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
		btnChatting.setIcon(new ImageIcon("icons\\msg.png"));
		
		JButton button_7 = new JButton("");
		button_7.setBounds(120, 120, 131, 68);
		internalFrame_6.getContentPane().add(button_7);
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
		button_7.setIcon(new ImageIcon("icons\\shutdown.png"));
		
		JButton button_6 = new JButton("");
		button_6.setBounds(0, 122, 123, 66);
		internalFrame_6.getContentPane().add(button_6);
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
		button_6.setIcon(new ImageIcon("icons\\restart.png"));
		
		JButton btnIndivual = new JButton("");
		btnIndivual.setIcon(new ImageIcon("icons\\i.png"));
		btnIndivual.setBounds(119, 11, 108, 87);
		internalFrame_6.getContentPane().add(btnIndivual);
		
		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon("icons\\backi.jpg"));
		label_8.setBounds(0, 0, 243, 218);
		internalFrame_6.getContentPane().add(label_8);
		
		btnIndivual.setContentAreaFilled(false);
		btnIndivual.setFocusPainted(false);
		btnIndivual.setBorderPainted(false);
		btnIndivual.setToolTipText("Individual Controller");
		btnIndivual.setOpaque(true);
		btnIndivual.setBorderPainted(false); 
		btnIndivual.setEnabled(true);//disabled the button
		btnIndivual.setOpaque(false);
	btnIndivual.setBorderPainted(false);
		btnIndivual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
in.setVisible(true);
in.instudent.setModel(new AbstractListModel() {
	String[] values = (String[]) IndividualControler.inst.toArray(new String[IndividualControler.inst.size()]);
	public int getSize() {
		return values.length;
	}
	public Object getElementAt(int index) {
		return values[index];
	}
});
in.instudent.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			
			JOptionPane.showMessageDialog(null, "Please Select An Ip From List");
			}
	
		
		});
		btnChatting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				
				boxHandler.b.setVisible(true);
			}
		});
		internalFrame_6.setVisible(true);
		
		JInternalFrame internalFrame_5 = new JInternalFrame("Usb");
		internalFrame_5.getContentPane().setBackground(Color.WHITE);
		internalFrame_5.setBounds(328, 269, 259, 251);
		contentPane.add(internalFrame_5);
		internalFrame_5.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("\r\n");
		lblNewLabel_5.setBounds(20, 11, 243, 144);
		internalFrame_5.getContentPane().add(lblNewLabel_5);
		lblNewLabel_5.setIcon(new ImageIcon("icons\\usb.png"));
		
		JButton btnBlock_1 = new JButton("");
		btnBlock_1.setBounds(15, 187, 95, 23);
		internalFrame_5.getContentPane().add(btnBlock_1);
		btnBlock_1.setContentAreaFilled(false);
		btnBlock_1.setFocusPainted(false);
		btnBlock_1.setBorderPainted(false);
		btnBlock_1.setToolTipText("Block");
		btnBlock_1.setOpaque(true);
		btnBlock_1.setBorderPainted(false); 
		btnBlock_1.setEnabled(true);//disabled the button
		btnBlock_1.setOpaque(false);
		btnBlock_1.setIcon(new ImageIcon("icons//block.png"));
		
		JButton btnUnblock_1 = new JButton("");
		btnUnblock_1.setBounds(138, 187, 95, 23);
		internalFrame_5.getContentPane().add(btnUnblock_1);
		
				btnUnblock_1.setContentAreaFilled(false);
				
						btnUnblock_1.setFocusPainted(false);
						
								btnUnblock_1.setBorderPainted(false);
								
										btnUnblock_1.setToolTipText("UnBlock");
										
												btnUnblock_1.setOpaque(true);
												
														btnUnblock_1.setBorderPainted(false); 
														
																btnUnblock_1.setEnabled(true);//disabled the button
																
																		btnUnblock_1.setOpaque(false);
																		btnUnblock_1.setIcon(new ImageIcon("icons//unblock.png"));
																		
																		JLabel label_7 = new JLabel("");
																		label_7.setIcon(new ImageIcon("icons\\backi.jpg"));
																		label_7.setBounds(0, 0, 243, 218);
																		internalFrame_5.getContentPane().add(label_7);
																		btnUnblock_1.addActionListener(new ActionListener() {
																			public void actionPerformed(ActionEvent e) {
																				try {
																					DataOutputStream outputStream = new DataOutputStream(s.getOutputStream());
																					outputStream.writeUTF("usb");
																					outputStream.writeUTF("enable");
																					outputStream.flush();
																					btnBlock_1.setEnabled(true);
																					btnUnblock_1.setEnabled(false);
																					} catch (IOException e1) {
																					
																				}	
																			}
																		});
		btnBlock_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DataOutputStream outputStream = new DataOutputStream(s.getOutputStream());
					outputStream.writeUTF("usb");
					outputStream.writeUTF("disable");
					outputStream.flush();
					btnBlock_1.setEnabled(false);
					btnUnblock_1.setEnabled(true);
					
					} catch (IOException e1) {
					
				}	
			}
		});
		internalFrame_5.setVisible(true);
		
		JInternalFrame internalFrame_4 = new JInternalFrame("KeyBoard");
		internalFrame_4.getContentPane().setBackground(Color.WHITE);
		internalFrame_4.setBounds(10, 270, 253, 250);
		contentPane.add(internalFrame_4);
		internalFrame_4.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(10, 29, 217, 130);
		internalFrame_4.getContentPane().add(lblNewLabel_3);
		lblNewLabel_3.setIcon(new ImageIcon("icons\\image01.png"));
		
		JButton button_3 = new JButton("");
		button_3.setBounds(6, 186, 113, 23);
		internalFrame_4.getContentPane().add(button_3);
		button_3.setContentAreaFilled(false);
		button_3.setFocusPainted(false);
		button_3.setBorderPainted(false);
		button_3.setToolTipText("Block");
		button_3.setOpaque(true);
		button_3.setBorderPainted(false); 
		button_3.setEnabled(true);//disabled the button
		button_3.setOpaque(false);
		button_3.setIcon(new ImageIcon("icons//block.png"));
		
		JButton button_4 = new JButton("");
		button_4.setBounds(129, 184, 98, 25);
		internalFrame_4.getContentPane().add(button_4);
		button_4.setIcon(new ImageIcon("icons//unblock.png"));
		button_4.setContentAreaFilled(false);
		button_4.setFocusPainted(false);
		button_4.setBorderPainted(false);
		button_4.setToolTipText("UnBlock");
		button_4.setOpaque(true);
		button_4.setBorderPainted(false); 
		button_4.setEnabled(true);//disabled the button
		button_4.setOpaque(false);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon("icons\\backi.jpg"));
		label_6.setBounds(0, 0, 243, 218);
		internalFrame_4.getContentPane().add(label_6);
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					DataOutputStream outputStream = new DataOutputStream(s.getOutputStream());
					outputStream.writeUTF("keyboard");
					outputStream.writeUTF("disable");
					outputStream.flush();
					button_3.setEnabled(true);
					button_4.setEnabled(false);
					} catch (IOException e1) {
					
				}	
			}
		});
		button_3.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					DataOutputStream outputStream = new DataOutputStream(s.getOutputStream());
					outputStream.writeUTF("keyboard");
					outputStream.writeUTF("enable");
					outputStream.flush();
					button_3.setEnabled(false);
					button_4.setEnabled(true);
					} catch (IOException e1) {
					
				}	
			}
		});
		internalFrame_4.setVisible(true);
		
		JInternalFrame internalFrame_2 = new JInternalFrame("Mouse");
		internalFrame_2.setBounds(634, 11, 253, 250);
		contentPane.add(internalFrame_2);
		internalFrame_2.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setBounds(10, 11, 217, 141);
		internalFrame_2.getContentPane().add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon("icons\\mose.png"));
		
		JButton btnBlock = new JButton("");
		btnBlock.setBounds(10, 186, 95, 23);
		internalFrame_2.getContentPane().add(btnBlock);
		btnBlock.setContentAreaFilled(false);
		btnBlock.setFocusPainted(false);
		btnBlock.setBorderPainted(false);
		btnBlock.setToolTipText("UnBlock");
		btnBlock.setOpaque(true);
		btnBlock.setBorderPainted(false); 
		btnBlock.setEnabled(true);//disabled the button
		btnBlock.setOpaque(false);
		btnBlock.setIcon(new ImageIcon("icons//block.png"));
		
		JButton btnUnblock = new JButton("");
		btnUnblock.setBounds(130, 184, 113, 25);
		internalFrame_2.getContentPane().add(btnUnblock);
		
				
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
				
				JLabel label_5 = new JLabel("");
				label_5.setIcon(new ImageIcon("icons\\backi.jpg"));
				label_5.setBounds(0, 0, 243, 218);
				internalFrame_2.getContentPane().add(label_5);
				btnUnblock.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						

						try {
							DataOutputStream outputStream = new DataOutputStream(s.getOutputStream());
							outputStream.writeUTF("mouse");
							outputStream.writeUTF("enable");
							outputStream.flush();
							btnBlock.setEnabled(true);
							btnUnblock.setEnabled(false);
							} catch (IOException e) {
							
						}
						
					}
				});
		btnBlock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			

				try {
					DataOutputStream outputStream = new DataOutputStream(s.getOutputStream());
					outputStream.writeUTF("mouse");
					outputStream.writeUTF("disable");
					outputStream.flush();
					btnBlock.setEnabled(false);
					btnUnblock.setEnabled(true);
					} catch (IOException e1) {
					
				}
				
				
			}
		});
		internalFrame_2.setVisible(true);
		
		JInternalFrame internalFrame_1 = new JInternalFrame("Display");
		internalFrame_1.getContentPane().setBackground(Color.WHITE);
		internalFrame_1.setBounds(328, 11, 259, 247);
		contentPane.add(internalFrame_1);
		internalFrame_1.getContentPane().setLayout(null);
		lblNewLabel_1.setBounds(20, 14, 195, 140);
		internalFrame_1.getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon("icons\\tv_set.jpg"));
		
		JButton button_1 = new JButton("");
		button_1.setBounds(10, 183, 104, 23);
		internalFrame_1.getContentPane().add(button_1);
		button_1.setContentAreaFilled(false);
		button_1.setFocusPainted(false);
		button_1.setBorderPainted(false);
		button_1.setToolTipText("Block");
		button_1.setOpaque(true);
		button_1.setBorderPainted(false); 
		button_1.setEnabled(true);//disabled the button
		button_1.setOpaque(false);
		button_1.setIcon(new ImageIcon("icons//block.png"));
		
		JButton button_2 = new JButton("");
		button_2.setBounds(139, 183, 104, 23);
		internalFrame_1.getContentPane().add(button_2);
		button_2.setContentAreaFilled(false);
		button_2.setFocusPainted(false);
		button_2.setBorderPainted(false);
		button_2.setToolTipText("UnBlock");
		button_2.setOpaque(true);
		button_2.setBorderPainted(false); 
		button_2.setEnabled(true);//disabled the button
		button_2.setOpaque(false);
		button_2.setIcon(new ImageIcon("icons//unblock.png"));
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon("icons\\backi.jpg"));
		label_4.setBounds(0, 0, 243, 218);
		internalFrame_1.getContentPane().add(label_4);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//lblNewLabel_1.setIcon(new ImageIcon("icons//monitoron.gif"));
				try {
					DataOutputStream outputStream = new DataOutputStream(s.getOutputStream());
					outputStream.writeUTF("display");
					outputStream.writeUTF("enable");
					outputStream.flush();
					button_1.setEnabled(true);
					button_2.setEnabled(false);
					} catch (IOException e1) {
					
					
				}	
				
			}
		});
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			//	lblNewLabel_1.setIcon(new ImageIcon("icons//monitoroff.gif"));
				try {
					DataOutputStream outputStream = new DataOutputStream(s.getOutputStream());
					outputStream.writeUTF("display");
					outputStream.writeUTF("disable");
					outputStream.flush();
					button_1.setEnabled(false);
					button_2.setEnabled(true);
					} catch (IOException e1) {
					
				}	
				
				
				
			}
		});
		internalFrame_1.setVisible(true);
		
		JInternalFrame internalFrame = new JInternalFrame("Internet");
		internalFrame.getContentPane().setBackground(Color.WHITE);
		internalFrame.setBounds(10, 11, 253, 248);
		contentPane.add(internalFrame);
		internalFrame.getContentPane().setLayout(null);
		lblNewLabel.setBounds(10, 11, 188, 165);
		internalFrame.getContentPane().add(lblNewLabel);
		
		
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("icons\\web.png"));
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBounds(10, 187, 113, 23);
		internalFrame.getContentPane().add(btnNewButton);
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
		btnNewButton.setIcon(new ImageIcon("icons\\block.png"));
		
		JButton button = new JButton("");
		button.setBounds(133, 187, 101, 23);
		internalFrame.getContentPane().add(button);
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
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("icons\\backi.jpg"));
		label_3.setBounds(0, 0, 237, 218);
		internalFrame.getContentPane().add(label_3);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//lblNewLabel.setIcon(new ImageIcon("icons//green.gif"));
				try {
					DataOutputStream outputStream = new DataOutputStream(s.getOutputStream());
					outputStream.writeUTF("internet");
					outputStream.writeUTF("disable");
					outputStream.flush();
					btnNewButton.setEnabled(true);
					button.setEnabled(false);
					} catch (IOException e) {
					// TODO Auto-generated catch block
				}
				
				
				
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//lblNewLabel.setIcon(new ImageIcon("icons//red.gif"));
				try {
					
					DataOutputStream outputStream = new DataOutputStream(s.getOutputStream());
					outputStream.writeUTF("internet");
					outputStream.writeUTF("enable");
					outputStream.flush();
					btnNewButton.setEnabled(false);
					button.setEnabled(true);
					} catch (IOException e) {
					// TODO Auto-generated catch block
				
				}
				
				
			}
		});
		internalFrame.setVisible(true);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("icons//keybaord4.gif"));
		label_1.setBounds(138, 352, 51, 66);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("icons\\tech_general - Copy.jpg"));
		label_2.setBounds(0, 0, 913, 551);
		contentPane.add(label_2);
		
		JInternalFrame internalFrame_3 = new JInternalFrame("New JInternalFrame");
		internalFrame_3.setBounds(20, 281, 55, 34);
		contentPane.add(internalFrame_3);
		internalFrame_3.setVisible(true);
		
///**** program by chetan sharma *****
	
		
	}
}
