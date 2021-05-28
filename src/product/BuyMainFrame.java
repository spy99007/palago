package product;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class BuyMainFrame extends JFrame {

	JPanel p = new JPanel(new BorderLayout());
	JPanel pN = new JPanel(new BorderLayout());
	JPanel pC = new JPanel();
	
	BuyProductPage buyproP;
	BuyInfoPage infoP;
	
	CardLayout card;
	
	JLabel pgnum,exit;

	public BuyMainFrame() {
		super("::RegistBuyFrame::");
		Container cp = this.getContentPane();
		cp.add(p, "Center");
		p.setBackground(Color.white);
		
		cp.add(p);
		p.add(pN,"North"); 	p.add(pC,"Center"); 
		whiteback(pN);
		whiteback(pC);
		
		pgnum=new JLabel(new ImageIcon("images/buy.png"));
		exit=new JLabel(new ImageIcon("images/exit.png"));
		pN.add(pgnum);	
		pN.add(exit,"East");
		
		pC.setLayout(card=new CardLayout());
		buyproP=new BuyProductPage(this);
		infoP=new BuyInfoPage(this);
		
		pC.add("product",buyproP);
		pC.add("info",infoP);
		
		HandlerBuy handlerbuy=new HandlerBuy(this);
		
		this.exit.addMouseListener(handlerbuy);
		buyproP.pname.addMouseListener(handlerbuy);
		buyproP.rate.addMouseListener(handlerbuy);
		buyproP.won.addMouseListener(handlerbuy);
		buyproP.max.addMouseListener(handlerbuy);
		buyproP.min.addMouseListener(handlerbuy);
		buyproP.next.addActionListener(handlerbuy);
		
		infoP.before.addActionListener(handlerbuy);
		infoP.pinfo.addMouseListener(handlerbuy);
		

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//생성자------
	
	public void pborder(JPanel p,String str) {
		p.setBorder(new TitledBorder(str));
	}
	
	public void whiteback(Component c) {
		c.setBackground(Color.white);
	}

	public static void main(String[] args) {
		BuyMainFrame my = new BuyMainFrame();
		my.setSize(500, 500);
		my.setVisible(true);
	}

}