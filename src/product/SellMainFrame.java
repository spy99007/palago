package product;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SellMainFrame extends JFrame {
 
	JPanel p = new JPanel(new BorderLayout());
	JPanel pN = new JPanel(new BorderLayout());
	JPanel pC = new JPanel();
	
	CouponType couponP;
	BrandPage brandP;
	ProductPage productP;
	DetailPage detailP;

	CardLayout card;
	
	JLabel pgnum;
	JLabel exit;
	
	

	public SellMainFrame() {
		super("::RegistSell::");
		Container cp = this.getContentPane();
		cp.add(p, "Center");
		p.setBackground(Color.white);
		pN.setBackground(Color.white);
		pC.setBackground(Color.white);
		
		p.add(pN,"North");
		p.add(pC,"Center");
		
		pgnum=new JLabel(new ImageIcon("images/selling.png"));
		exit=new JLabel(new ImageIcon("images/exit.png"));
		pN.add(pgnum);
		pN.add(exit,"East");
		
		pC.setLayout(card=new CardLayout());
		couponP=new CouponType(this);
		brandP=new BrandPage(this);
		productP=new ProductPage(this);
		detailP=new DetailPage(this);
		
		pC.add("coupon",couponP);
		pC.add("brand",brandP);
		pC.add("product",productP);
		pC.add("detail",detailP); 
		
		
		Handler handler=new Handler(this);
		exit.addMouseListener(handler);
		couponP.next.addActionListener(handler);
		
		brandP.btf.addMouseListener(handler);
		brandP.before.addActionListener(handler);
		brandP.next.addActionListener(handler);
		
		productP.ptf.addMouseListener(handler);
		productP.before.addActionListener(handler);
		productP.next.addActionListener(handler);
		
		detailP.price1.addMouseListener(handler);
		detailP.price2.addMouseListener(handler);
		
		detailP.before.addActionListener(handler);
		detailP.fin.addActionListener(handler);
		
	

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//생성자------

	public static void main(String[] args) {
		SellMainFrame my = new SellMainFrame();
		my.setSize(500, 500);
		my.setVisible(true);
	}

}