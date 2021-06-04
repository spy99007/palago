package product;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class SelectCoupon extends JPanel {

	
	JPanel pN= new JPanel(new GridLayout(2,2,20,20));
	
	JButton ecoupon;
	JButton voucher;
	JButton discount;
	JButton bogo;
	JButton next;
	
	SellMainFrame sellF;

	public SelectCoupon(SellMainFrame sell) {
		this.sellF=sell;
		
		
		setLayout(new BorderLayout());
		
		setBackground(Color.white);
		
		add(pN,"North");
		pN.setSize(500,500);
		pN.setBackground(Color.white);
		pN.setBorder(new TitledBorder("��������"));
		
		ecoupon=new JButton("����Ƽ ��ȯ��");
		voucher=new JButton("��ǰ�Ƿ�");
		discount=new JButton("��������/��Ÿ");
		bogo=new JButton("1+1����");
		next=new JButton("����");
		
		pN.add(ecoupon);	pN.add(voucher);
		pN.add(discount); 	pN.add(bogo);
		add(next,"South");
		 

	
	}//������------

	
	@Override
	public Insets getInsets() {
		return new Insets(20,20,40,20);
	}

}