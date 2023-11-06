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
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class Update_Delete extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtpname;
	private JTextField txtid;
	private JTextField txtqty;
	private JTextField txtprice;
	String company, owner;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update_Delete frame = new Update_Delete("company");
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
	public Update_Delete(String company) {
		this.company=company;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 641, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Update / Delete");
		lblNewLabel.setBounds(211, 10, 209, 34);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "The product you entered is", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(33, 138, 557, 184);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Price:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(20, 127, 123, 37);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Product Name:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(20, 31, 123, 37);
		panel.add(lblNewLabel_1_1);
		
		txtpname = new JTextField();
		txtpname.setBounds(153, 37, 198, 30);
		panel.add(txtpname);
		txtpname.setColumns(10);
		
		txtqty = new JTextField();
		txtqty.setColumns(10);
		txtqty.setBounds(153, 86, 198, 30);
		panel.add(txtqty);
		
		JLabel lblNewLabel_1_4 = new JLabel("Quantity:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_4.setBounds(20, 80, 123, 37);
		panel.add(lblNewLabel_1_4);
		
		txtprice = new JTextField();
		txtprice.setColumns(10);
		txtprice.setBounds(153, 133, 198, 30);
		panel.add(txtprice);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id;
				id = txtid.getText();
				
				if(owner.equals(company)) {
					Connection connection;
					PreparedStatement pst;
					try {
						connection = DatabaseConnection.getConnection();
						
				        pst = connection.prepareStatement("Delete from product where id = ? ");
				        
				        pst.setString(1, id);
				        pst.executeUpdate();
				        JOptionPane.showMessageDialog(null, "Record Deleted");
//				        table_load();
				                       
				        txtpname.setText("");
				        txtqty.setText("");
				        txtprice.setText("");
				        txtpname.requestFocus();
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
				}
				else {
					JOptionPane.showMessageDialog(null, "This product is not owned by your company");
//			        table_load();
			                       
			        txtpname.setText("");
			        txtqty.setText("");
			        txtprice.setText("");
			        txtpname.requestFocus();
				}
				
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDelete.setBackground(new Color(255, 0, 0));
		btnDelete.setBounds(388, 110, 108, 37);
		panel.add(btnDelete);
		
		JButton btnNewButton_1_1 = new JButton("Update");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id, pName, qty, price;
				id = txtid.getText();
				pName = txtpname.getText();
				
				qty = txtqty.getText();
				price = txtprice.getText();
				if(owner.equals(company)) {
					Connection connection;
					PreparedStatement pst;
					try {
						connection = DatabaseConnection.getConnection();
						
				        pst = connection.prepareStatement("Update product set product_name = ?, qty = ?,price = ? where id = ? ");
				        pst.setString(1, pName);
				        
				        pst.setString(2, qty);
				        pst.setString(3, price);
				        pst.setString(4, id);
				        pst.executeUpdate();
				        JOptionPane.showMessageDialog(null, "Record Updated");
//				        table_load();
				                       
				        txtpname.setText("");
				        txtqty.setText("");
				        txtprice.setText("");
				        txtpname.requestFocus();
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
				}
				else {
					JOptionPane.showMessageDialog(null, "This product is not owned by your company");
//			        table_load();
			                       
			        txtpname.setText("");
			        txtqty.setText("");
			        txtprice.setText("");
			        txtpname.requestFocus();
				}
				
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1_1.setBackground(new Color(0, 128, 192));
		btnNewButton_1_1.setBounds(388, 49, 108, 37);
		panel.add(btnNewButton_1_1);
		
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
		
		JLabel lblNewLabel_1_2 = new JLabel("Enter Product ID:");
		lblNewLabel_1_2.setBounds(54, 91, 142, 37);
		contentPane.add(lblNewLabel_1_2);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		txtid = new JTextField();
		txtid.setBounds(186, 97, 198, 30);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setBounds(419, 93, 108, 37);
		contentPane.add(btnNewButton);
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
                           owner = rs.getString(2);
                           String qty = rs.getString(3);
                           String price = rs.getString(4);
                           
                           txtpname.setText(name);
                           
                           txtqty.setText(qty);
                           txtprice.setText(price);
   
                       }   
                       else
                       {
                           txtpname.setText("");
                           
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
		
		btnNewButton.setBackground(new Color(0, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblNewLabel_2 = new JLabel("*You can only Update or Delete Products of Your Company.");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(46, 54, 544, 33);
		contentPane.add(lblNewLabel_2);
		
	}
	public void close() {
		WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
	}	
	
}
