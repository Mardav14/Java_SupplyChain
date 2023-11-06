package supplyChainManagement;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Register extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCompany;
	private JTextField txtName;
	private JTextField txtUsername;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Register() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 641, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Register");
		lblNewLabel.setBounds(236, 10, 150, 34);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Register", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(33, 54, 557, 263);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Company Role:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(86, 114, 142, 37);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Full Name:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(86, 20, 123, 37);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Company:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(86, 67, 123, 37);
		panel.add(lblNewLabel_1_2);
		
		txtCompany = new JTextField();
		txtCompany.setBounds(271, 73, 198, 30);
		panel.add(txtCompany);
		txtCompany.setColumns(10);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(271, 26, 198, 30);
		panel.add(txtName);
		
		JLabel lblNewLabel_1_3 = new JLabel("Username:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_3.setBounds(86, 160, 142, 37);
		panel.add(lblNewLabel_1_3);
		
		txtUsername = new JTextField();
		txtUsername.setColumns(10);
		txtUsername.setBounds(271, 166, 198, 30);
		panel.add(txtUsername);
		
		JLabel lblNewLabel_1_4 = new JLabel("Password:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_4.setBounds(86, 207, 142, 37);
		panel.add(lblNewLabel_1_4);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(271, 213, 198, 30);
		panel.add(txtPassword);
		
		JComboBox txtRole = new JComboBox();
		txtRole.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtRole.setModel(new DefaultComboBoxModel(new String[] {"Manufacturer", "Supplier", "Transporter", "Retailer"}));
		txtRole.setBounds(271, 121, 198, 30);
		panel.add(txtRole);
		
		JButton btnBack = new JButton("Back to login");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
				Login s = new Login();
				s.setVisible(true);
			}
		});
		btnBack.setBounds(33, 324, 184, 46);
		contentPane.add(btnBack);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnBack.setBackground(new Color(0, 255, 64));
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String name, company, role, userName, password;
				name = txtName.getText();
				company = txtCompany.getText();
				role = txtRole.getSelectedItem().toString();
				userName = txtUsername.getText();
				
				char[] passwordChars = txtPassword.getPassword();
				password = String.valueOf(passwordChars);
				
				Connection connection;
				PreparedStatement pst, pst1;
				try {
					connection = DatabaseConnection.getConnection();
					
			        pst = connection.prepareStatement("insert into user_data (name,company,role,username)values(?,?,?,?)");
			        pst1 = connection.prepareStatement("insert into login values(?,?)");
			        pst.setString(1, name);
			        pst.setString(2, company);
			        pst.setString(3, role);
			        pst.setString(4, userName);
			        pst1.setString(1, userName);
			        pst1.setString(2, password);
			       
			        pst.executeUpdate();
			        pst1.executeUpdate();
			        JOptionPane.showMessageDialog(null, "Regestration Successful");
//			        table_load();
			                       
			        txtName.setText("");
			        txtCompany.setText("");
//			        txtRole.setText("");
			        txtUsername.setText("");
			        txtPassword.setText("");
			        txtName.requestFocus();
			        pst.close();
			        pst1.close();
//					connection.close();
			       }
			    catch (SQLException e1) 
			        {            
			       e1.printStackTrace();
			        
			    } catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(458, 324, 132, 46);
		contentPane.add(btnNewButton);
		btnNewButton.setBackground(new Color(0, 128, 192));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
	}
	public void close() {
		WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
	}
}
