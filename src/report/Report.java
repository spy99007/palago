package report;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import product.Menu;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Report extends JFrame {

	private JPanel contentPane;
	private JTextField tf;

	public Report() {
		setTitle("�Ű��ϱ�");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.white);

		// �Ű��ϱ� - �Ű��� Username Label, textField
		JLabel rplb1 = new JLabel("�Ű� Username");
		rplb1.setBounds(30, 60, 95, 15);
		contentPane.add(rplb1);

		tf = new JTextField();
		tf.setBounds(125, 55, 335, 30);
		contentPane.add(tf);
		tf.setColumns(10);

		// �Ű��ϱ� - �Ű� ���� Label, textArea
		JLabel rplb2 = new JLabel("�Ű� ����");
		rplb2.setBounds(70, 105, 60, 15);
		contentPane.add(rplb2);

		JTextArea ta = new JTextArea();
		ta.setBounds(125, 105, 335, 265);
		contentPane.add(ta);
		
		
		// �Ű��ϱ� - �ڷΰ��� ��ư
		JButton rpbtn1 = new JButton();
		rpbtn1.setIcon(new ImageIcon("./images/back.png"));
		rpbtn1.setSelectedIcon(new ImageIcon("./images/back.png"));
		rpbtn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Menu menu = new Menu();
				menu.setSize(500, 500);
				menu.setVisible(true);
			}
		});
		rpbtn1.setBounds(10,10,30,30);
		contentPane.add(rpbtn1);
		rpbtn1.setBorderPainted(false);

		// �Ű��ϱ� - �Ű� �����ϱ� ��ư
		JButton rpbtn2 = new JButton("�Ű� �����ϱ�");
		rpbtn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "������ �Ϸ�Ǿ����ϴ�.", "�Ű� ����", JOptionPane.PLAIN_MESSAGE);
				dispose();
				Menu menu = new Menu();
				menu.setSize(500, 500);
				menu.setVisible(true);
			}
		});
		rpbtn2.setBounds(300, 400, 115, 30);
		contentPane.add(rpbtn2);

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Report rp = new Report();
					rp.setSize(500, 500);
					rp.setVisible(true);
					rp.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
