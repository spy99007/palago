package product;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import report.SellReport;

public class SellTab extends JFrame {

	private JPanel contentPane;

	public SellTab() {
		setTitle("판매관리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		JButton stbtn1 = new JButton("판매중 상품");
		stbtn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				ProductsOnSaleTab pos = new ProductsOnSaleTab();
				pos.setSize(500, 500);
				pos.setVisible(true);
			}
		});
		stbtn1.setBounds(24, 166, 135, 99);
		contentPane.add(stbtn1);

		
		JButton stbtn2 = new JButton("판매내역");
		stbtn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				SalesHistoryTab sh = new SalesHistoryTab();
				sh.setSize(500,500);
				sh.setVisible(true);
			}
		});
		stbtn2.setBounds(191, 166, 127, 99);
		contentPane.add(stbtn2);
		
		
		

		JButton stbtn3 = new JButton("신고하기");
		stbtn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				SellReport sr = new SellReport();
				sr.setSize(500,500);
				sr.setVisible(true);
			}
		});
		stbtn3.setBounds(351, 166, 127, 99);
		contentPane.add(stbtn3);
		
		
		

		JButton stbtn4 = new JButton("메인으로 돌아가기");
		stbtn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		stbtn4.setBounds(176, 410, 158, 29);
		contentPane.add(stbtn4);

	}

	
	static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SellTab st = new SellTab();
					st.setSize(500, 500);
					st.setVisible(true);
					st.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
