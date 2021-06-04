package product;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class HandlerSell extends MouseAdapter implements ActionListener,
FocusListener,ListSelectionListener{
	
	String price;

	SellMainFrame sellF;
	public HandlerSell(SellMainFrame sell) {
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
			Coupon c=new Coupon();
			c.setBrand(selbrand);
			c.setProduct(selproduct);
//			int finprice=Integer.parseInt(price);
//			c.setPrice(finprice);
			int i=sellF.detailP.pcategory.getSelectedIndex();
			c.setCategory(sellF.cateArr[i]);
			sellF.coupons.add(c);
			sellF.setTitle("저장완료");

			JOptionPane.showMessageDialog(sellF.pC, "판매가 등록되었습니다.");
//			sellF.dispose();
		}
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		Object obj=e.getSource();
		if(obj==sellF.exit) {
//			메인으로
			sellF.dispose();	
		}
		else if(obj==sellF.detailP.pimage) {
			try {
				sellF.detailP.chooser.showOpenDialog(sellF);
				String file=sellF.detailP.chooser.getSelectedFile().getPath();
				ImageIcon img=new ImageIcon(file);
				sellF.detailP.pimage.setIcon(img);
				//이미지 크기 조절
			}catch(NullPointerException ex){
				sellF.detailP.pimage.setIcon(new ImageIcon("images/picicon1.png"));
			}
			sellF.detailP.pimage.setText("");
			sellF.pack();
		}
	}
	
	@Override
	public void focusGained(FocusEvent e) {
		Object obj=e.getSource();
		if(obj==sellF.brandP.btf) {
			sellF.brandP.btf.setText("");
		}else if(obj==sellF.productP.ptf) {
			sellF.productP.ptf.setText("");
		}else if(obj==sellF.detailP.price1) {
			sellF.detailP.price1.setText("");
		}else if(obj==sellF.detailP.price2) {
			sellF.detailP.price2.setText("");
		}else if(obj==sellF.detailP.pinfo) {
			sellF.detailP.pinfo.setText("");
		}
	} 
	@Override
	public void focusLost(FocusEvent e) {
		
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		Object obj=e.getSource();
		if(obj==sellF.brandP.brandList) {
			int i=sellF.brandP.brandList.getSelectedIndex();
			sellF.brandP.btf.setText(sellF.brandArr[i]);
		}else if(obj==sellF.productP.productList) {
			int i=sellF.productP.productList.getSelectedIndex();
			sellF.productP.ptf.setText(sellF.productArr[i]);
		}else if(obj==sellF.detailP.price2) {
			price=sellF.detailP.price2.getText();
			
		}
		
	}
}






