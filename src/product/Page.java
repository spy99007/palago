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
		setTitle("����������");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(Color.white);

		// �ڷΰ��� ��ư
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

		// �Ű��ϱ� ��ư
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

		// �ϴ� �޴� �г�
		JPanel panel = new JPanel();
		panel.setBounds(0, 411, 500, 61);
		panel.setBackground(Color.white);
		panel.setLayout(null);
		contentPane.add(panel);

		// �ϴ� �޴� - Ȩ ��ư
		ImageIcon Icon1 = new ImageIcon("images/home.png");
		JButton btn1 = new JButton("Ȩ", Icon1);
		btn1.setBounds(0, 0, 125, 60);
		panel.add(btn1);
		btn1.setHorizontalTextPosition(JButton.CENTER);
		btn1.setVerticalTextPosition(JButton.BOTTOM);
		btn1.setBorderPainted(false);

		// �ϴ� �޴� - �˻� ��ư
		ImageIcon Icon2 = new ImageIcon("images/buy15.png");
		JButton btn2 = new JButton("��ϴ�", Icon2);
		btn2.setBounds(125, 0, 125, 60);
		panel.add(btn2);
		btn2.setHorizontalTextPosition(JButton.CENTER);
		btn2.setVerticalTextPosition(JButton.BOTTOM);
		btn2.setBorderPainted(false);

		// �ϴܸ޴� - ��ٱ���
		ImageIcon Icon3 = new ImageIcon("images/seller.png");
		JButton btn3 = new JButton("�˴ϴ�", Icon3);
		btn3.setBounds(250, 0, 125, 60);
		panel.add(btn3);
		btn3.setHorizontalTextPosition(JButton.CENTER);
		btn3.setVerticalTextPosition(JButton.BOTTOM);
		btn3.setBorderPainted(false);

		// �ϴ� �޴� - ����������
		ImageIcon Icon4 = new ImageIcon("images/person.png");
		JButton btn4 = new JButton("����������", Icon4);
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn4.setBounds(375, 0, 125, 60);
		panel.add(btn4);
		btn4.setHorizontalTextPosition(JButton.CENTER);
		btn4.setVerticalTextPosition(JButton.BOTTOM);
		btn4.setBorderPainted(false);

		// ���������� - ī�װ�(���ų���, �Ǹų���, �����ϱ�)

		// ���ų���
		ImageIcon Icon5 = new ImageIcon("images/purchase.png");
		JButton btn5 = new JButton("���ų���", Icon5);
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

		// �Ǹų���
		ImageIcon Icon6 = new ImageIcon("images/receipt.png");
		JButton btn6 = new JButton("�Ǹų���", Icon6);
		btn6.setBounds(253, 91, 150, 110);
		contentPane.add(btn6);
		btn6.setHorizontalTextPosition(JButton.CENTER);
		btn6.setVerticalTextPosition(JButton.BOTTOM);
		btn6.setBorderPainted(false);

		// �����ϱ�
		ImageIcon Icon7 = new ImageIcon("images/QnAchat.png");
		JButton btn7 = new JButton("�����ϱ�", Icon7);
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
		
		
		//�α׾ƿ� 
		ImageIcon Icon8 = new ImageIcon("images/logout.png");
		JButton btn8 = new JButton("�α׾ƿ�",Icon8);
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
