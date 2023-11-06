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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	public String company;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 641, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setBounds(269, 10, 66, 34);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Login", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(33, 70, 557, 201);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Username:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(86, 20, 123, 37);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Password:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(86, 67, 123, 37);
		panel.add(lblNewLabel_1_2);
		
		txtUsername = new JTextField();
		txtUsername.setColumns(10);
		txtUsername.setBounds(271, 26, 198, 30);
		panel.add(txtUsername);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String username, password;
				
				username = txtUsername.getText();
				char[] passwordChars = txtPassword.getPassword();
				password = String.valueOf(passwordChars);
				
				
				Connection connection;
				PreparedStatement pst, pst1;
				ResultSet rs, rs1;
				String correct_password = "";
				try {
					connection = DatabaseConnection.getConnection();
					
			        pst = connection.prepareStatement("SELECT password FROM login where username = ?");
			        pst1 = connection.prepareStatement("SELECT company FROM user_data where username = ?");
			        pst.setString(1, username);
			        pst1.setString(1, username);
			       
			        rs = pst.executeQuery();
			        rs1 = pst1.executeQuery();
			        while (rs.next()) {
			            correct_password = rs.getString("password");
			           }
			        while (rs1.next()) {
			            company = rs1.getString("company");
			           }
			        rs.close();
			        pst.close();
//			        connection.close();
			        if(username.equals("") || password.equals("")) {
			        	JOptionPane.showMessageDialog(null, "Username and Password field are required");

	                    txtUsername.setText("");
				        txtPassword.setText("");
				        txtUsername.requestFocus();
			        }
			        else if(password.equals(correct_password)) {
			        	close();
			        	
						Menu s = new Menu(company);
						s.setVisible(true);
			        }
			        
			        else {
			        	JOptionPane.showMessageDialog(null, "Incorrect login credentials");

				                       
				        txtUsername.setText("");
				        txtPassword.setText("");
				        txtUsername.requestFocus();
			        }

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
		btnNewButton.setBackground(new Color(0, 128, 192));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(229, 132, 109, 46);
		panel.add(btnNewButton);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(271, 75, 198, 29);
		panel.add(txtPassword);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
				Register s = new Register();
				s.setVisible(true);
			}
		});
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnRegister.setBackground(new Color(0, 255, 64));
		btnRegister.setBounds(348, 308, 154, 46);
		contentPane.add(btnRegister);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Register first to login...");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(150, 311, 233, 44);
		contentPane.add(lblNewLabel_1_1_1);
	}
	public void close() {
		WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
	}
}
