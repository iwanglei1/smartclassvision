package intra.net.leader;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JDesktopPane;
import javax.swing.ImageIcon;

public class ChatBox extends JFrame {

	private JPanel contentPane;
	JList list = new JList();
	String soc;
static	JTextArea textArea = new JTextArea();
	private JTextField textField;
	private JScrollPane scrollPane;
	/**
	 * Launch the application.
	 */
	
	

	/**
	 * Create the frame.
	 */
	public ChatBox(final Socket s) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 447, 423);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		list.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		list.setForeground(Color.BLACK);
		list.setFont(new Font("Tahoma", Font.BOLD, 15));
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				soc = list.getSelectedValue().toString();
				DataOutputStream outputStream;
				try {
					outputStream = new DataOutputStream(s.getOutputStream());
					outputStream.writeUTF("filedata");
					outputStream.writeUTF(list.getSelectedValue().toString());
					
			
		
					
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
			}
		});
		
		list.setBounds(0, 0, 171, 423);
		contentPane.add(list);
		
		JButton btnNewButton = new JButton("");
		
		 btnNewButton.setContentAreaFilled(false);
		 btnNewButton.setFocusPainted(false);
		 btnNewButton.setBorderPainted(false);
		 btnNewButton.setToolTipText("Minimize");
			btnNewButton.setOpaque(true);
			btnNewButton.setBorderPainted(false); 
			btnNewButton.setEnabled(true);//disabled the button
			btnNewButton.setOpaque(false);
		btnNewButton.setIcon(new ImageIcon("icons//minimize.png"));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton.setBounds(414, 0, 33, 32);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		textField.setBounds(172, 400, 218, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ChatBox.textArea.enable();
				try
				{
				DataOutputStream outputStream = new DataOutputStream(s.getOutputStream());
				outputStream.writeUTF("messagefromleader");
				outputStream.writeUTF(soc);
				outputStream.writeUTF(textField.getText());
				}catch(Exception e)
				{
					
				}
				
				ChatBox.textArea.setText(ChatBox.textArea.getText()+"\n Me:-"+textField.getText());
				
				ChatBox.textArea.disable();
				textField.setText("");
			}
		});
		btnNewButton_1.setBounds(389, 400, 58, 23);
		contentPane.add(btnNewButton_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(172, 31, 275, 370);
		contentPane.add(scrollPane);
		textArea.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		scrollPane.setViewportView(textArea);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.LIGHT_GRAY);
		desktopPane.setBounds(170, 0, 277, 32);
		contentPane.add(desktopPane);
	}
}
