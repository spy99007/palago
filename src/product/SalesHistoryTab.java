package product;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class SalesHistoryTab extends JFrame {

	private JPanel contentPane;
	private JTextField tf;

	public SalesHistoryTab() {
		setTitle("판매관리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel shlb = new JLabel("판매내역");
		shlb.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		shlb.setBounds(70, 35, 61, 16);
		contentPane.add(shlb);
		
		tf = new JTextField();
		tf.setBounds(140, 30, 250, 30);
		contentPane.add(tf);
		tf.setColumns(10);
		
		JButton shbtn1 = new JButton("검색");
		shbtn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		shbtn1.setBounds(390, 30, 50, 30);
		contentPane.add(shbtn1);
		
		
		JButton shbtn = new JButton("뒤로가기");
		shbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				SellTab st = new SellTab();
				st.setSize(500,500);
				st.setVisible(true);
			}
		});
		shbtn.setBounds(50, 385, 115, 30);
		contentPane.add(shbtn);
	}
		
		
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalesHistoryTab sh = new SalesHistoryTab();
					sh.setSize(500, 500);
					sh.setVisible(true);
					sh.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			
			}
		});
	}

}
