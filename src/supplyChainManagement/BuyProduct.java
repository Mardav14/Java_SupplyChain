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
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;


public class BuyProduct extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtProdName;
	private JTextField txtQty;
	private JTextField txtid;
	private JTextField txtOwner;
	private JTextField txtTotal;
	private JTextField txtPrice;
	private JTextField txtQtyBill;
	private JTextField txtCompany;
	String company, oldQty;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuyProduct frame = new BuyProduct("company");
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
	public BuyProduct(String company) {
		
		this.company=company;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 641, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Buy Product");
		lblNewLabel.setBounds(236, 10, 150, 34);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 121, 607, 194);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Bill:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_2.setBounds(10, 10, 102, 37);
		panel.add(lblNewLabel_2);
		
		txtProdName = new JTextField();
		txtProdName.setEditable(false);
		txtProdName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtProdName.setHorizontalAlignment(SwingConstants.CENTER);
		txtProdName.setBounds(10, 89, 135, 37);
		panel.add(txtProdName);
		txtProdName.setColumns(10);
		
		JLabel lblNewLabel_1_2 = new JLabel("Product Name");
		lblNewLabel_1_2.setBounds(10, 45, 135, 46);
		panel.add(lblNewLabel_1_2);
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setBackground(new Color(128, 255, 255));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Owner");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_1.setBackground(new Color(128, 255, 255));
		lblNewLabel_1_2_1.setBounds(149, 45, 142, 46);
		panel.add(lblNewLabel_1_2_1);
		
		txtOwner = new JTextField();
		txtOwner.setEditable(false);
		txtOwner.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtOwner.setHorizontalAlignment(SwingConstants.CENTER);
		txtOwner.setColumns(10);
		txtOwner.setBounds(155, 89, 135, 37);
		panel.add(txtOwner);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Quantity");
		lblNewLabel_1_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_1_1.setBackground(new Color(128, 255, 255));
		lblNewLabel_1_2_1_1.setBounds(301, 45, 142, 46);
		panel.add(lblNewLabel_1_2_1_1);
		
		txtTotal = new JTextField();
		txtTotal.setEditable(false);
		txtTotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTotal.setHorizontalAlignment(SwingConstants.CENTER);
		txtTotal.setColumns(10);
		txtTotal.setBounds(458, 136, 142, 37);
		panel.add(txtTotal);
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("Price");
		lblNewLabel_1_2_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_1_1_1.setBackground(new Color(128, 255, 255));
		lblNewLabel_1_2_1_1_1.setBounds(458, 45, 142, 46);
		panel.add(lblNewLabel_1_2_1_1_1);
		
		txtPrice = new JTextField();
		txtPrice.setEditable(false);
		txtPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPrice.setHorizontalAlignment(SwingConstants.CENTER);
		txtPrice.setColumns(10);
		txtPrice.setBounds(458, 89, 142, 37);
		panel.add(txtPrice);
		
		JLabel lblNewLabel_1_2_1_1_2 = new JLabel("Total:");
		lblNewLabel_1_2_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2_1_1_2.setBackground(new Color(128, 255, 255));
		lblNewLabel_1_2_1_1_2.setBounds(391, 134, 67, 37);
		panel.add(lblNewLabel_1_2_1_1_2);
		
		txtQtyBill = new JTextField();
		txtQtyBill.setEditable(false);
		txtQtyBill.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtQtyBill.setHorizontalAlignment(SwingConstants.CENTER);
		txtQtyBill.setColumns(10);
		txtQtyBill.setBounds(301, 89, 142, 37);
		panel.add(txtQtyBill);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Order by:");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_2.setBounds(347, 13, 96, 37);
		panel.add(lblNewLabel_1_1_2);
		
		txtCompany = new JTextField();
		txtCompany.setEditable(false);
		txtCompany.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCompany.setColumns(10);
		txtCompany.setBounds(432, 16, 168, 30);
		panel.add(txtCompany);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
				Menu s = new Menu(company);
				s.setVisible(true);
			}
		});
		btnBack.setBounds(10, 325, 85, 46);
		contentPane.add(btnBack);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnBack.setBackground(new Color(0, 255, 64));
		
		JLabel lblNewLabel_1_1 = new JLabel("Product  ID:");
		lblNewLabel_1_1.setBounds(10, 62, 123, 37);
		contentPane.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		txtid = new JTextField();
		txtid.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtid.setBounds(105, 68, 96, 30);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Quantity:");
		lblNewLabel_1_1_1.setBounds(229, 61, 72, 37);
		contentPane.add(lblNewLabel_1_1_1);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		txtQty = new JTextField();
		txtQty.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtQty.setBounds(307, 68, 116, 30);
		contentPane.add(txtQty);
		txtQty.setColumns(10);
		
		JButton btnNewButton = new JButton("Place Order");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id, pName, owner, qty, price, total;
				id = txtid.getText();
				pName = txtProdName.getText();
				owner = txtOwner.getText();
				qty = txtQtyBill.getText();
				price = txtPrice.getText();
				total = txtTotal.getText();
				
					Connection connection;
					PreparedStatement pst, pst1, pst2;
					try {
						connection = DatabaseConnection.getConnection();
						
				        pst = connection.prepareStatement("insert into transactions (seller_company, buyer_company,product_name,qty,price,total)values(?,?,?,?,?,?)");
				        pst.setString(1, owner);
				        pst.setString(2, company);
				        pst.setString(3, pName);
				        pst.setString(4, qty);
				        pst.setString(5, price);
				        pst.setString(6, total);
				        
				        pst1 = connection.prepareStatement("update product set qty = ? where id = ?");
				        pst1.setString(1, Integer.toString(Integer.parseInt(oldQty) - Integer.parseInt(qty)));
				        pst1.setString(2, id);
				        
				        pst2 = connection.prepareStatement("insert into product (product_name,owner,qty,price)values(?,?,?,?)");
				        pst2.setString(1, pName);
				        pst2.setString(2, company);
				        pst2.setString(3, qty);
				        pst2.setString(4, price);
				      
				        pst.executeUpdate();
				        pst1.executeUpdate();
				        pst2.executeUpdate();
				        
				        
				        
				        JOptionPane.showMessageDialog(null, "Order Placed");
//				        table_load();
				                       
				        
				        pst.close();	
//						connection.close();
				       }
				    catch (SQLException e1) 
				        {            
				       e1.printStackTrace();
				        
				    } catch (Exception e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				
				
				txtProdName.setText("");
		        
		        txtQtyBill.setText("");
		        txtPrice.setText("");
		        txtOwner.setText("");
		        txtTotal.setText("");
		        txtProdName.requestFocus();
				
			}
		});
		btnNewButton.setBounds(211, 325, 160, 46);
		contentPane.add(btnNewButton);
		btnNewButton.setBackground(new Color(0, 128, 192));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection connection;
				PreparedStatement pst;
                try {
                	connection = DatabaseConnection.getConnection();
                       String id = txtid.getText();
                       String qty = txtQty.getText();
                       String name= "";
                       String owner = "";
                       String price = "";
                       String total_str = "";
                       int price_int =0, qty_int= 0, total= 0;
                       
                           pst = connection.prepareStatement("select product_name,owner,qty,price from product where id = ?");
                           pst.setString(1, id);
                           ResultSet rs = pst.executeQuery();

                       if(rs.next()==true)
                       {
                         
                           name = rs.getString(1);
                           owner = rs.getString(2);
                           oldQty = rs.getString(3);
                           price = rs.getString(4);
                           price_int = Integer.parseInt(price);
                           qty_int = Integer.parseInt(qty);
                           total = price_int * qty_int;
                           total_str = Integer.toString(total);
                           
                           
                       }
                       if(qty_int<= Integer.parseInt(oldQty)) {
                    	   
                    	   txtProdName.setText(name);
                           txtCompany.setText(company);
                           txtOwner.setText(owner);
                           txtQtyBill.setText(qty);
                           txtPrice.setText(price);
                           txtTotal.setText(total_str);
                       }
                       else {
       					JOptionPane.showMessageDialog(null, "Only " + oldQty + " pieces are in stock");
       					txtProdName.setText("");
           		        
           		        txtQtyBill.setText("");
           		        txtPrice.setText("");
           		        txtOwner.setText("");
           		        txtTotal.setText("");
           		        txtid.requestFocus();
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
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnAdd.setBackground(new Color(0, 128, 192));
		btnAdd.setBounds(459, 63, 104, 37);
		contentPane.add(btnAdd);
	}
	

	public void close() {
		WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
	}
}
