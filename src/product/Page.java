package product;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import common.MainWindow;
import report.QnA3;
import report.Report;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;

public class Page extends JFrame {

	private JPanel contentPane;

	

	public Page() {
		setTitle("마이페이지");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(Color.white);

		// 뒤로가기 버튼
		JButton mbtn1 = new JButton("");
		mbtn1.setBounds(10, 10, 35, 35);
		mbtn1.setIcon(new ImageIcon("./images/back.png"));
		mbtn1.setSelectedIcon(new ImageIcon("./images/back.png"));
		mbtn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Menu menu = new Menu();
				menu.setSize(500, 500);
				menu.setVisible(true);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(mbtn1);
		mbtn1.setBorderPainted(false);

		// 신고하기 버튼
		JButton mbtn2 = new JButton("");
		mbtn2.setBounds(450, 10, 40, 40);
		mbtn2.setIcon(new ImageIcon("./images/notify.png"));
		mbtn2.setSelectedIcon(new ImageIcon("./images/notify.png"));
		mbtn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Report rp = new Report();
				rp.setSize(500, 500);
				rp.setVisible(true);
			}
		});
		contentPane.add(mbtn2);
		mbtn2.setBorderPainted(false);

		// 하단 메뉴 패널
		JPanel panel = new JPanel();
		panel.setBounds(0, 411, 500, 61);
		panel.setBackground(Color.white);
		panel.setLayout(null);
		contentPane.add(panel);

		// 하단 메뉴 - 홈 버튼
		ImageIcon Icon1 = new ImageIcon("images/home.png");
		JButton btn1 = new JButton("홈", Icon1);
		btn1.setBounds(0, 0, 125, 60);
		panel.add(btn1);
		btn1.setHorizontalTextPosition(JButton.CENTER);
		btn1.setVerticalTextPosition(JButton.BOTTOM);
		btn1.setBorderPainted(false);

		// 하단 메뉴 - 검색 버튼
		ImageIcon Icon2 = new ImageIcon("images/buy15.png");
		JButton btn2 = new JButton("삽니다", Icon2);
		btn2.setBounds(125, 0, 125, 60);
		panel.add(btn2);
		btn2.setHorizontalTextPosition(JButton.CENTER);
		btn2.setVerticalTextPosition(JButton.BOTTOM);
		btn2.setBorderPainted(false);

		// 하단메뉴 - 장바구니
		ImageIcon Icon3 = new ImageIcon("images/seller.png");
		JButton btn3 = new JButton("팝니다", Icon3);
		btn3.setBounds(250, 0, 125, 60);
		panel.add(btn3);
		btn3.setHorizontalTextPosition(JButton.CENTER);
		btn3.setVerticalTextPosition(JButton.BOTTOM);
		btn3.setBorderPainted(false);

		// 하단 메뉴 - 마이페이지
		ImageIcon Icon4 = new ImageIcon("images/person.png");
		JButton btn4 = new JButton("마이페이지", Icon4);
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn4.setBounds(375, 0, 125, 60);
		panel.add(btn4);
		btn4.setHorizontalTextPosition(JButton.CENTER);
		btn4.setVerticalTextPosition(JButton.BOTTOM);
		btn4.setBorderPainted(false);

		// 마이페이지 - 카테고리(구매내역, 판매내역, 문의하기)

		// 구매내역
		ImageIcon Icon5 = new ImageIcon("images/purchase.png");
		JButton btn5 = new JButton("구매내역", Icon5);
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MainWindow mw = new MainWindow();
				mw.setSize(500, 500);
				mw.setVisible(true);
			}
		});
		btn5.setBounds(92, 91, 155, 110);
		contentPane.add(btn5);
		btn5.setHorizontalTextPosition(JButton.CENTER);
		btn5.setVerticalTextPosition(JButton.BOTTOM);
		btn5.setBorderPainted(false);

		// 판매내역
		ImageIcon Icon6 = new ImageIcon("images/receipt.png");
		JButton btn6 = new JButton("판매내역", Icon6);
		btn6.setBounds(253, 91, 150, 110);
		contentPane.add(btn6);
		btn6.setHorizontalTextPosition(JButton.CENTER);
		btn6.setVerticalTextPosition(JButton.BOTTOM);
		btn6.setBorderPainted(false);

		// 문의하기
		ImageIcon Icon7 = new ImageIcon("images/QnAchat.png");
		JButton btn7 = new JButton("문의하기", Icon7);
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				QnA3 q3 = new QnA3();
				q3.setSize(500, 500);
				q3.setVisible(true);
			}
		});
		btn7.setBounds(106, 228, 141, 112);
		contentPane.add(btn7);
		btn7.setHorizontalTextPosition(JButton.CENTER);
		btn7.setVerticalTextPosition(JButton.BOTTOM);
		btn7.setBorderPainted(false);
		
		
		//로그아웃 
		ImageIcon Icon8 = new ImageIcon("images/logout.png");
		JButton btn8 = new JButton("로그아웃",Icon8);
		btn8.setBounds(262, 229, 141, 110);
		contentPane.add(btn8);
		btn8.setHorizontalTextPosition(JButton.CENTER);
		btn8.setVerticalTextPosition(JButton.BOTTOM);
		btn8.setBorderPainted(false);

	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Page mp = new Page();
					mp.setSize(500,500);
					mp.setVisible(true);
					mp.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
