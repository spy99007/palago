package report;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class QnA3 extends JFrame {

	private JPanel contentPane;
	private JTextField	tf;
	private String[] chat= {"전체 대화", "팝니다 대화", "삽니다 대화"};

	public QnA3() {
		setTitle("1:1 문의하기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		// 채팅 - "전체 대화", "팝니다 대화", "삽니다 대화" 선택하기
		JComboBox<String> comboBox = new JComboBox<String>(chat);
		comboBox.setBounds(32, 8, 160, 60);
		contentPane.add(comboBox);
		
		
		// 채팅 전 판매자 검색하는 textField
		tf = new JTextField();
		tf.setBounds(32, 50, 450, 40);
		contentPane.add(tf);
		tf.setColumns(10);
		
		
		
		// 1:1 문의하기 - 뒤로가기 버튼 (QnA.java로 패널 전환) 
		JButton q3btn1 = new JButton("뒤로가기");
		q3btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				QnA q1 = new QnA();
				q1.setSize(500,500);
				q1.setVisible(true);
			}
		});
		q3btn1.setBounds(350, 400, 115, 30);
		contentPane.add(q3btn1);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QnA3 q3 = new QnA3();
					q3.setVisible(true);
					q3.setVisible(true);
					q3.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
