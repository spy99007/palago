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
		
		sellF.myborder(p, "쿠폰종류");
		pN.setBackground(Color.white);
		pN.setBorder(new EmptyBorder(10,10,10,10));

		
		ecoupon=new JButton("기프티 교환권");
		voucher=new JButton("상품권류");
		discount=new JButton("할인쿠폰/기타");
		bogo=new JButton("1+1쿠폰");
		next=new JButton("다음");
		
		sellF.myFont(ecoupon,14);
		sellF.myFont(voucher,14);
		sellF.myFont(discount,14);
		sellF.myFont(bogo,14);
		sellF.myFont(next,14);
		
		
		pN.add(ecoupon);	pN.add(voucher);
		pN.add(discount); 	pN.add(bogo);
		add(next,"South");
		 

	
	}//생성자------

	
	@Override
	public Insets getInsets() {
		return new Insets(20,20,25,20);
	}

}