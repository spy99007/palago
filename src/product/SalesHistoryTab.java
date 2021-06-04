package product;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class SalesHistoryTab extends JFrame {

	private JPanel contentPane;
	private JTextField tf;
	private JTextArea ta;

	public SalesHistoryTab() {
		setTitle("판매관리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.white);

		JLabel shlb = new JLabel("판매내역");
		shlb.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		shlb.setBounds(70, 37, 61, 16);
		contentPane.add(shlb);

		tf = new JTextField("상품 이름을 검색해주세요!");
		tf.setForeground(Color.LIGHT_GRAY);
		tf.setBounds(130, 30, 250, 30);
		tf.setColumns(10);
		contentPane.add(tf);

		JButton shbtn1 = new JButton("검색");
		shbtn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		shbtn1.setBounds(385, 30, 50, 30);
		contentPane.add(shbtn1);

		ta = new JTextArea();
		contentPane.add(ta);
		ta.setBounds(70, 80, 360, 300);
		ta.setVisible(true);

		//뒤로가기 버튼 
		JButton shbtn = new JButton();
		shbtn.setIcon(new ImageIcon("./images/back.png"));
		shbtn.setSelectedIcon(new ImageIcon("./images/back.png"));
		shbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Menu menu = new Menu();
				
			}
		});
		shbtn.setBounds(10,10,30,30);
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
