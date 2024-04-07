package GUI;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

import Data.FileIO;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisplayList extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static DefaultListModel<String> arr = new DefaultListModel<String>();
	private JPanel contentPane;

	
	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ })
	public DisplayList() {
		setTitle("Account List");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 649, 474);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAccountList = new JLabel("Account List");
		lblAccountList.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAccountList.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccountList.setBounds(0, 11, 623, 31);
		contentPane.add(lblAccountList);

	
		


			


		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 66, 613, 358);
		contentPane.add(scrollPane);
		
		arr=FileIO.bank.display();
		JList<String> list = new JList<String>(arr);
		scrollPane.setViewportView(list);
		
	    Icon img = new ImageIcon(getClass().getResource("/GUI/icons8-delete-30.png"));
				CircleButton btnDepositToAccount = new CircleButton(img);
				btnDepositToAccount.setBounds(0, 11, 60, 31);
				btnDepositToAccount.setBorderPainted(false);
				btnDepositToAccount.setFocusPainted(false);
				btnDepositToAccount.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						FileIO.deleteFile();
						FileIO.Write();
						arr=FileIO.bank.display();
						JList<String> list = new JList<String>(arr);
						scrollPane.setViewportView(list);
					}
				});
				contentPane.add(btnDepositToAccount);
	

	}
}
