package product;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import common.MainWindow;
import report.Report;

public class PurchaseTab extends JFrame {

	private JPanel contentPane;

	public PurchaseTab() {
		setTitle("구매관리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		JButton ptbtn1 = new JButton("구매요청 상품");
		ptbtn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				PurchaseRequest pr = new PurchaseRequest();
				pr.setSize(500, 500);
				pr.setVisible(true);
			}
		});
		ptbtn1.setBounds(70, 30, 180, 180);
		contentPane.add(ptbtn1);

		
		JButton ptbtn2 = new JButton("구매내역");
		ptbtn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				MainWindow mw = new MainWindow();
				mw.setSize(500,500);
				mw.setVisible(true);
			}
		});
		ptbtn2.setBounds(270, 30, 180, 180);
		contentPane.add(ptbtn2);
		
		
		

		JButton ptbtn3 = new JButton("구매하기");
		ptbtn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				PurchaseConfirm pcf = new PurchaseConfirm();
				pcf.setSize(500,500);
				pcf.setVisible(true);
			}
		});
		ptbtn3.setBounds(70, 220, 180, 180);
		contentPane.add(ptbtn3);
		
		
		JButton ptbtn4 = new JButton("신고하기");
		ptbtn4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Report rp = new Report();
				rp.setSize(500,500);
				rp.setVisible(true);
			}
		});
		ptbtn4.setBounds(270, 220, 180, 180);
		contentPane.add(ptbtn4);
		
		
		

		JButton ptbtn5 = new JButton("메인으로 돌아가기");
		ptbtn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ptbtn5.setBounds(176, 410, 158, 29);
		contentPane.add(ptbtn5);

	}

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PurchaseTab pt = new PurchaseTab();
					pt.setSize(500, 500);
					pt.setVisible(true);
					pt.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
