package product;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ProductsOnSaleTab extends JFrame {

	private JPanel contentPane;
	private JTextField tf;

	
	public ProductsOnSaleTab() {
		setTitle("�ǸŰ���");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		// �ǸŰ��� - �Ǹ��� ��ǰ Label 
		JLabel poslb1 = new JLabel("�Ǹ��� ��ǰ");
		poslb1.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		poslb1.setBounds(70, 35, 61, 16);
		contentPane.add(poslb1);
		
		tf = new JTextField();
		tf.setBounds(140, 30, 250, 30);
		contentPane.add(tf);
		tf.setColumns(10);
		
		
		JButton posbtn1 = new JButton("�˻�");
		posbtn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		posbtn1.setBounds(390, 30, 50, 30);
		contentPane.add(posbtn1);
		
		
		
		
		
		// �ǸŰ��� - �Ǹ��� ��ǰ �г��� �ڷΰ��� ��ư ( SellTab(�ǸŰ��� �޴����� ȭ��)���� �г���ȯ )
		JButton posbtn2 = new JButton("�ڷΰ���");
		posbtn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				SellTab st = new SellTab();
				st.setSize(500,500);
				st.setVisible(true);
			}
		});
		posbtn2.setBounds(50, 385, 115, 30);
		contentPane.add(posbtn2);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductsOnSaleTab pos = new ProductsOnSaleTab();
					pos.setSize(500, 500);
					pos.setVisible(true);
					pos.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
