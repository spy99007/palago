package product;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PurchaseRequest extends JFrame {

	private JPanel contentPane;

	public PurchaseRequest() {
		setTitle("���ſ�û ��ǰ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		// ���ſ�û ��ǰ - ���ų��� �ڷΰ��� ��ư (���Ű���(PurchaseTab.java)�� �г� ��ȯ)
		JButton prbtn1 = new JButton("�ڷΰ���");
		prbtn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				PurchaseTab pt = new PurchaseTab();
				pt.setSize(500,500);
				pt.setVisible(true);
			}
		});
		prbtn1.setBounds(196, 386, 117, 29);
		contentPane.add(prbtn1);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PurchaseRequest pr = new PurchaseRequest();
					pr.setSize(500, 500);
					pr.setVisible(true);
					pr.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
