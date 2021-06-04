package product;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class CouponType extends JPanel {

	JPanel p = new JPanel();
	JPanel pN= new JPanel(new GridLayout(2,2,30,30));
	
	JButton ecoupon;
	JButton voucher;
	JButton discount;
	JButton bogo;
	JButton next;
	 
	SellMainFrame sellF;

	public CouponType(SellMainFrame sell) {
		this.sellF=sell;
		
		setLayout(new BorderLayout());
		
		setBackground(Color.white);
		
		add(p,"North");
		p.add(pN);
		
		sellF.myborder(p, "��������");
		pN.setBackground(Color.white);
		pN.setBorder(new EmptyBorder(10,10,10,10));

		
		ecoupon=new JButton("����Ƽ ��ȯ��");
		voucher=new JButton("��ǰ�Ƿ�");
		discount=new JButton("��������/��Ÿ");
		bogo=new JButton("1+1����");
		next=new JButton("����");
		
		sellF.myFont(ecoupon,14);
		sellF.myFont(voucher,14);
		sellF.myFont(discount,14);
		sellF.myFont(bogo,14);
		sellF.myFont(next,14);
		
		
		pN.add(ecoupon);	pN.add(voucher);
		pN.add(discount); 	pN.add(bogo);
		add(next,"South");
		 

	
	}//������------

	
	@Override
	public Insets getInsets() {
		return new Insets(20,20,25,20);
	}

}