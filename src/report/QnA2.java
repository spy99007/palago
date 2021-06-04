package report;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Choice;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QnA2 extends JFrame {

	private JPanel contentPane;
	private JTextField tf;

	public QnA2() {
		setTitle("문의글 작성하기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		// 문의글 작성하기 - 제목 Label, textField 
		JLabel q2lb1 = new JLabel("제목");
		q2lb1.setBounds(52, 42, 61, 16);
		contentPane.add(q2lb1);
		
		tf = new JTextField();
		tf.setBounds(93, 31, 362, 39);
		contentPane.add(tf);
		tf.setColumns(10);
		
		
		// 문의글 작성하기 - 문의내용 Label, textArea
		JLabel q2lb2 = new JLabel("문의 내용");
		q2lb2.setBounds(26, 99, 61, 16);
		contentPane.add(q2lb2);
		
		JTextArea ta = new JTextArea();
		ta.setBounds(93, 99, 362, 289);
		contentPane.add(ta);
		
		
		// 문의글 작성하기 - 등록하기 버튼
		JButton q2btn1 = new JButton("등록하기");
		q2btn1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "등록 되었습니다.", "등록하기",JOptionPane.PLAIN_MESSAGE);
			dispose();
			QnA q1 = new QnA();
			q1.setSize(500,500);
			q1.setVisible(true);
		}
	});
		q2btn1.setBounds(145, 400, 115, 30);
		contentPane.add(q2btn1);
		
		
		// 문의글 작성하기 - 뒤로가기 버튼 (문의하기(QnA.java) 패널로 전환됨)
		JButton q2btn2 = new JButton("뒤로가기");
		q2btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				QnA q1 = new QnA();
				q1.setSize(500,500);
				q1.setVisible(true);
			}
		});
		q2btn2.setBounds(300, 400, 115, 30);
		contentPane.add(q2btn2);
	}
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QnA2 q2 = new QnA2();
					q2.setVisible(true);
					q2.setVisible(true);
					q2.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
