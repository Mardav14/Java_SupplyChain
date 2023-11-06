package supplyChainManagement;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.border.TitledBorder;

public class SearchProduct extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtpname;
	private JTextField txtowner;
	private JTextField txtid;
	private JTextField txtqty;
	private JTextField txtprice;
	String company;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchProduct frame = new SearchProduct("company");
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
	public SearchProduct(String company) {
		this.company=company;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 641, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Search Product");
		lblNewLabel.setBounds(220, 10, 193, 34);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Search Product", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(33, 54, 557, 268);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Price:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(19, 208, 123, 37);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Product Name:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(19, 67, 123, 37);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Enter Product ID:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(19, 20, 142, 37);
		panel.add(lblNewLabel_1_2);
		
		txtpname = new JTextField();
		txtpname.setBounds(152, 73, 198, 30);
		panel.add(txtpname);
		txtpname.setColumns(10);
		
		txtowner = new JTextField();
		txtowner.setColumns(10);
		txtowner.setBounds(152, 120, 198, 30);
		panel.add(txtowner);
		
		txtid = new JTextField();
		txtid.setColumns(10);
		txtid.setBounds(151, 26, 198, 30);
		panel.add(txtid);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection connection;
				PreparedStatement pst;
                try {
                	connection = DatabaseConnection.getConnection();
                       String id = txtid.getText();
                       
                           pst = connection.prepareStatement("select product_name,owner,qty,price from product where id = ?");
                           pst.setString(1, id);
                           ResultSet rs = pst.executeQuery();

                       if(rs.next()==true)
                       {
                         
                           String name = rs.getString(1);
                           String owner = rs.getString(2);
                           String qty = rs.getString(3);
                           String price = rs.getString(4);
                           
                           txtpname.setText(name);
                           txtowner.setText(owner);
                           txtqty.setText(qty);
                           txtprice.setText(price);
   
                       }   
                       else
                       {
                           txtpname.setText("");
                           txtowner.setText("");
                           txtqty.setText("");
                           txtprice.setText("");
                            
                       }
                       pst.close();	
//   					connection.close();
                   } 
               
                catch (SQLException ex) {
                      
                   } catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		btnNewButton.setBackground(new Color(0, 128, 192));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(384, 22, 108, 37);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_1_3 = new JLabel("Owner:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_3.setBounds(19, 114, 84, 37);
		panel.add(lblNewLabel_1_3);
		
		txtqty = new JTextField();
		txtqty.setColumns(10);
		txtqty.setBounds(152, 167, 198, 30);
		panel.add(txtqty);
		
		JLabel lblNewLabel_1_4 = new JLabel("Quantity:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_4.setBounds(19, 161, 123, 37);
		panel.add(lblNewLabel_1_4);
		
		txtprice = new JTextField();
		txtprice.setColumns(10);
		txtprice.setBounds(152, 214, 198, 30);
		panel.add(txtprice);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
				Menu s = new Menu(company);
				s.setVisible(true);
			}
		});
		btnBack.setBounds(33, 332, 85, 46);
		contentPane.add(btnBack);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnBack.setBackground(new Color(0, 255, 64));
		
	}
	public void close() {
		WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
	}	
	
}
