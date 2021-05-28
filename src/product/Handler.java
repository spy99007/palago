package product;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Handler extends MouseAdapter implements ActionListener{
	
	

	SellMainFrame sellF;
	public Handler(SellMainFrame sell) {
		this.sellF=sell;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		String selbrand=sellF.brandP.btf.getText();
		String selproduct=sellF.productP.ptf.getText();
		
		if(obj==sellF.couponP.next) {
			//저장
			sellF.card.show(sellF.pC, "brand");
		}else if(obj==sellF.brandP.before) {
			sellF.card.show(sellF.pC, "coupon");
		}else if(obj==sellF.brandP.next) {
			//저장
			sellF.detailP.pname.setText(selbrand);
			sellF.card.show(sellF.pC, "product");
		}else if(obj==sellF.productP.before) {
			sellF.card.show(sellF.pC, "brand");
		}else if(obj==sellF.productP.next) {
			//저장
			sellF.detailP.pname.setText(selbrand+"  "+selproduct);
			sellF.card.show(sellF.pC, "detail");
		}else if(obj==sellF.detailP.before) {
			sellF.card.show(sellF.pC, "product");
		}else if(obj==sellF.detailP.fin) {
			//저장
			System.exit(0);
		}
		
	}
	
	
	@Override
	public void mousePressed(MouseEvent e) {
		Object obj=e.getSource();
		if(obj==sellF.exit) {
//			메인으로
			System.exit(0);	
		}else if(obj==sellF.brandP.btf) {
			sellF.brandP.btf.setText("");
		}else if(obj==sellF.productP.ptf) {
			sellF.productP.ptf.setText("");
		}else if(obj==sellF.detailP.price1) {
			sellF.detailP.price1.setText("");
		}else if(obj==sellF.detailP.price2) {
			sellF.detailP.price2.setText("");
		}
	}
}
