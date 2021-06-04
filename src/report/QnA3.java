package report;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import admin.MyPage;
import product.Client;
import product.Page;
import product.Server;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class QnA3 extends JFrame {

	private JPanel contentPane;
	private JTextField tf;
	// private String[] chat= {"��ü ��ȭ", "�˴ϴ� ��ȭ", "��ϴ� ��ȭ"};

	public QnA3() {
		setTitle("1:1 �����ϱ�");
		setBounds(100, 100, 500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.white);

		//Server ��ư 
		ImageIcon Icon1 = new ImageIcon("images/server.png");
		JButton btnsv1 = new JButton("Server",Icon1);
		btnsv1.setBounds(50, 125, 200, 200);
		btnsv1.setHorizontalTextPosition(JButton.CENTER);
		btnsv1.setVerticalTextPosition(JButton.BOTTOM);
		btnsv1.setBorderPainted(false);
		
		//Client ��ư
		ImageIcon Icon2 = new ImageIcon("images/client2.png");
		JButton btnct2 = new JButton("Client",Icon2);
		btnct2.setBounds(250, 125, 200, 200);
		btnct2.setHorizontalTextPosition(JButton.CENTER);
		btnct2.setVerticalTextPosition(JButton.BOTTOM);
		btnct2.setBorderPainted(false);

		
		// ��ưŬ�� �׼ǿ� �����ϱ� ���� ������ ��ü ���� �� �߰�
		btnsv1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// ServerFrame ��ü ����
				Server frame = new Server();
			}
		});
		btnct2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// ClientFrame ��ü ����
				Client frame = new Client();
			}
		});

		contentPane.add(btnsv1);
		contentPane.add(btnct2);

		JButton q3btn1 = new JButton();
		q3btn1.setIcon(new ImageIcon("./images/back.png"));
		q3btn1.setSelectedIcon(new ImageIcon("./images/back.png"));
		q3btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Page mp = new Page();
				mp.setSize(500,500);
				mp.setVisible(true);
			}
		});
		q3btn1.setBounds(10,10,30,30);
		contentPane.add(q3btn1);
		q3btn1.setBorderPainted(false);
		
		
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

	}
	
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QnA3 q3 = new QnA3();
					q3.setVisible(true);
					q3.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
