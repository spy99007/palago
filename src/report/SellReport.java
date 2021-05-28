package report;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import product.SellTab;

public class SellReport extends JFrame {

	private JPanel contentPane;
	private JTextField tf;

	public SellReport() {
		setTitle("신고하기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		// 신고하기 - 신고할 Username Label, textField
		JLabel rplb1 = new JLabel("신고 Username");
		rplb1.setBounds(20, 35, 95, 15);
		contentPane.add(rplb1);
		
		tf = new JTextField();
		tf.setBounds(115, 30, 335, 30);
		contentPane.add(tf);
		tf.setColumns(10);
		
		
		// 신고하기 - 신고 사유 Label, textArea
		JLabel rplb2 = new JLabel("신고 사유");
		rplb2.setBounds(55, 105, 60, 15);
		contentPane.add(rplb2);
		
		JTextArea ta = new JTextArea();
		ta.setBounds(115, 105, 335, 265);
		contentPane.add(ta);
		
		
		
		// 신고하기 - 신고 접수하기 버튼 
		JButton rpbtn1 = new JButton("신고 접수하기");
		rpbtn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "접수가 완료되었습니다.", "신고 접수",JOptionPane.PLAIN_MESSAGE);
				dispose();
				SellTab pt = new SellTab();
				pt.setSize(500,500);
				pt.setVisible(true);
			}
		});
		rpbtn1.setBounds(145, 400, 115, 30);
		contentPane.add(rpbtn1);
		
		
		// 신고하기 - 뒤로가기 버튼 (
		JButton rpbtn2 = new JButton("뒤로가기");
		rpbtn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				SellTab st = new SellTab();
				st.setSize(500,500);
				st.setVisible(true);
			}
		});
		rpbtn2.setBounds(300, 400, 115, 30);
		contentPane.add(rpbtn2);
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SellReport sr = new SellReport();
					sr.setSize(500, 500);
					sr.setVisible(true);
					sr.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
