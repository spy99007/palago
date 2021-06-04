package product;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class PurchaseConfirm extends JFrame {

	private JPanel contentPane;
	private JTextField tf;

	
	public PurchaseConfirm() {
		setTitle("구매하기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton pcfbtn1 = new JButton("구매하기");
		pcfbtn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showConfirmDialog(null, "구매하시겠습니까?", "구매하기", JOptionPane.YES_NO_CANCEL_OPTION);
				dispose();
				PurchaseTab pt = new PurchaseTab();
				pt.setSize(500,500);
				pt.setVisible(true);
			}
		});
		pcfbtn1.setBounds(100, 385, 115, 30);
		contentPane.add(pcfbtn1);
		
		
		
		
		JButton pcfbtn2 = new JButton("뒤로가기");
		pcfbtn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				PurchaseTab pt = new PurchaseTab();
				pt.setSize(500,500);
				pt.setVisible(true);
			}
		});
		pcfbtn2.setBounds(300, 385, 115, 30);
		contentPane.add(pcfbtn2);
	}
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductsOnSaleTab pos = new ProductsOnSaleTab();
					pos.setSize(500, 500);
					pos.setVisible(true);
					pos.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
