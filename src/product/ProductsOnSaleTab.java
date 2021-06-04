package product;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ProductsOnSaleTab extends JFrame {

	private JPanel contentPane;
	private JTextField tf;

	
	public ProductsOnSaleTab() {
		setTitle("판매관리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		// 판매관리 - 판매중 상품 Label 
		JLabel poslb1 = new JLabel("판매중 상품");
		poslb1.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		poslb1.setBounds(70, 35, 61, 16);
		contentPane.add(poslb1);
		
		tf = new JTextField();
		tf.setBounds(140, 30, 250, 30);
		contentPane.add(tf);
		tf.setColumns(10);
		
		
		JButton posbtn1 = new JButton("검색");
		posbtn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		posbtn1.setBounds(390, 30, 50, 30);
		contentPane.add(posbtn1);
		
		
		
		
		
		// 판매관리 - 판매중 상품 패널의 뒤로가기 버튼 ( SellTab(판매관리 메뉴선택 화면)으로 패널전환 )
		JButton posbtn2 = new JButton("뒤로가기");
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
