package report;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class QnA extends JFrame {

	private JPanel contentPane;

	public QnA() {
		setTitle("�����ϱ�");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// �����ϱ� - ���Ǳ� �ۼ��ϱ� ��ư (QnA2.java�� �г� ��ȯ)
		JButton qbtn1 = new JButton("���Ǳ� �ۼ��ϱ�");
		qbtn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				QnA2 q2 = new QnA2();
				q2.setSize(500, 500);
				q2.setVisible(true);
			}
		});
		qbtn1.setBounds(50, 150, 170, 140);
		contentPane.add(qbtn1);

		// �����ϱ� - 1:1 �����ϱ� ��ư (QnA3.java�� �г� ��ȯ)
		JButton qbtn2 = new JButton("1:1 �����ϱ�");
		qbtn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				QnA3 q3 = new QnA3();
				q3.setSize(500, 500);
				q3.setVisible(true);
			}
		});
		qbtn2.setBounds(285, 150, 170, 140);
		contentPane.add(qbtn2);

		// �����ϱ� - �������� ���ư��� ��ư
		JButton qbtn3 = new JButton("���ΰ���");
		qbtn3.setBounds(195, 413, 117, 29);
		contentPane.add(qbtn3);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QnA q = new QnA();
					q.setVisible(true);
					q.setVisible(true);
					q.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
