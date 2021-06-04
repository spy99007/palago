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
		setTitle("문의하기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// 문의하기 - 문의글 작성하기 버튼 (QnA2.java로 패널 전환)
		JButton qbtn1 = new JButton("문의글 작성하기");
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

		// 문의하기 - 1:1 문의하기 버튼 (QnA3.java로 패널 전환)
		JButton qbtn2 = new JButton("1:1 문의하기");
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

		// 문의하기 - 메인으로 돌아가기 버튼
		JButton qbtn3 = new JButton("메인가기");
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
