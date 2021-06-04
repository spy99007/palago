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
		setTitle("구매요청 상품");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		// 구매요청 상품 - 구매내역 뒤로가기 버튼 (구매관리(PurchaseTab.java)로 패널 전환)
		JButton prbtn1 = new JButton("뒤로가기");
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
