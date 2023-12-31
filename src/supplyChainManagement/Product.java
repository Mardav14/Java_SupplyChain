package supplyChainManagement;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.border.TitledBorder;
import net.proteanit.sql.DbUtils;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.EtchedBorder;

public class Product extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtProductName;
	private JTextField txtQty;
	private JTextField txtPrice;
	String company;
	
//	Connection con;
//	PreparedStatement pst;
//	ResultSet rs;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Product frame = new Product("company");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Product(String company) {
		this.company=company;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 641, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Product");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel.setBounds(225, 26, 159, 46);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Add Product", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(55, 92, 515, 227);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Product Name:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(71, 29, 128, 32);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Price");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1.setBounds(71, 113, 128, 32);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Qty");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_2.setBounds(71, 71, 128, 32);
		panel.add(lblNewLabel_1_1_2);
		
		txtProductName = new JTextField();
		txtProductName.setBounds(229, 35, 177, 25);
		panel.add(txtProductName);
		txtProductName.setColumns(10);
		
		txtQty = new JTextField();
		txtQty.setColumns(10);
		txtQty.setBounds(229, 77, 177, 25);
		panel.add(txtQty);
		
		txtPrice = new JTextField();
		txtPrice.setColumns(10);
		txtPrice.setBounds(229, 119, 177, 25);
		panel.add(txtPrice);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.setBounds(180, 156, 104, 46);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				
				String pName, owner, qty, price;
				pName = txtProductName.getText();
				
				qty = txtQty.getText();
				price = txtPrice.getText();
				
				Connection connection;
				PreparedStatement pst;
				try {
					connection = DatabaseConnection.getConnection();
					
			        pst = connection.prepareStatement("insert into product (product_name,owner,qty,price)values(?,?,?,?)");
			        pst.setString(1, pName);
			        pst.setString(2, company);
			        pst.setString(3, qty);
			        pst.setString(4, price);
			        pst.executeUpdate();
			        JOptionPane.showMessageDialog(null, "Record Added");
//			        table_load();
			                       
			        txtProductName.setText("");
			        
			        txtQty.setText("");
			        txtPrice.setText("");
			        txtProductName.requestFocus();
			        pst.close();	
//					connection.close();
			       }
			    catch (SQLException e1) 
			        {            
			       e1.printStackTrace();
			        
			    } catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			
//			
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
				Menu s = new Menu(company);
				s.setVisible(true);
			}
		});
		btnExit.setBackground(new Color(0, 255, 64));
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnExit.setBounds(55, 329, 104, 46);
		contentPane.add(btnExit);

	}
	
	
	

	public void close() {
		WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
	}	
	
}
