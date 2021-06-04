package product;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UploadedCoupon extends JFrame {

	JPanel p = new JPanel(new GridLayout(0,2,10,10));
	JButton bt1,bt2,bt3,bt4,bt5,bt6;
	

	public UploadedCoupon() {
		
		Container cp = this.getContentPane();
		cp.add(p, "Center");
		p.setBackground(Color.white);
		
		SellMainFrame sellF=new SellMainFrame();
		for(int i=0;i<sellF.coupons.size();i++) {
			JButton bt=new JButton();
			
		}
		
		

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//»ý¼ºÀÚ------


	public static void main(String[] args) {
		UploadedCoupon my = new UploadedCoupon();
		my.setSize(500, 500);
		my.setVisible(true);
	}

}