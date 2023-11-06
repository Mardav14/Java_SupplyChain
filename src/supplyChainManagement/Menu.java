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
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	String company;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu("company");
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
	public Menu(String company) {
		this.company = company;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 641, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Menu");
		lblNewLabel.setBounds(279, 10, 68, 34);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(33, 54, 557, 265);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Buy Product");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
				BuyProduct s = new BuyProduct(company);
				s.setVisible(true);
			}
		});
		btnNewButton.setBackground(new Color(0, 128, 192));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(299, 24, 201, 53);
		panel.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Add Product");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
				Product s = new Product(company);
				s.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_2.setBackground(new Color(0, 128, 192));
		btnNewButton_2.setBounds(48, 24, 201, 53);
		panel.add(btnNewButton_2);
		
		JButton btnSearchdeleteProduct = new JButton("Search Product");
		btnSearchdeleteProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
				SearchProduct s = new SearchProduct(company);
				s.setVisible(true);;
			}
		});
		btnSearchdeleteProduct.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSearchdeleteProduct.setBackground(new Color(0, 128, 192));
		btnSearchdeleteProduct.setBounds(48, 109, 201, 53);
		panel.add(btnSearchdeleteProduct);
		
		JButton btnNewButton_3_1 = new JButton("All Products");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
				AllProducts s = new AllProducts(company);
				s.setVisible(true);
			}
		});
		btnNewButton_3_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_3_1.setBackground(new Color(0, 128, 192));
		btnNewButton_3_1.setBounds(48, 190, 201, 53);
		panel.add(btnNewButton_3_1);
		
		JButton btnUpdatedelete = new JButton("Update/Delete");
		btnUpdatedelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
				Update_Delete s = new Update_Delete(company);
				s.setVisible(true);
				
			}
		});
		btnUpdatedelete.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnUpdatedelete.setBackground(new Color(0, 128, 192));
		btnUpdatedelete.setBounds(299, 109, 201, 53);
		panel.add(btnUpdatedelete);
		
		JButton btnNewButton_1_1 = new JButton("Transactions");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
				Transactions s = new Transactions(company);
				s.setVisible(true);
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1_1.setBackground(new Color(0, 128, 192));
		btnNewButton_1_1.setBounds(299, 190, 201, 53);
		panel.add(btnNewButton_1_1);
		
		JButton btnBack = new JButton("Back To Login");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
				Login s = new Login();
				s.setVisible(true);
			}
		});
		btnBack.setBounds(33, 329, 186, 46);
		contentPane.add(btnBack);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnBack.setBackground(new Color(0, 255, 64));
	}
	public void close() {
		WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
	}
}
