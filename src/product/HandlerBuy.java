package product;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class HandlerBuy extends MouseAdapter implements ActionListener,FocusListener{
	
	BuyMainFrame buyF;
	
	public HandlerBuy(BuyMainFrame buy) {
		this.buyF=buy;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		if(obj==buyF.buyproP.next) {
			buyF.card.show(buyF.pC, "info");
		}else if(obj==buyF.infoP.before) {
			buyF.card.show(buyF.pC, "product");
		}else if(obj==buyF.infoP.next) {
			JOptionPane.showMessageDialog(buyF.pC,"등록이 완료되었습니다.");
			buyF.dispose();
		}
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		Object obj=e.getSource();
		if(obj==buyF.exit) {
			System.exit(0);
		}else if(obj==buyF.infoP.pimage) {
			try {
				buyF.infoP.chooser.showOpenDialog(buyF);
				String file=buyF.infoP.chooser.getSelectedFile().getPath();
				buyF.infoP.pimage.setIcon(new ImageIcon(file));
			}catch(NullPointerException ex){
				buyF.infoP.pimage.setIcon(new ImageIcon("images/picicon1.png"));
			}
			buyF.infoP.pimage.setPreferredSize(new Dimension(150,150));
			buyF.infoP.pimage.setText("");
		}
		
	}
	@Override
	public void focusGained(FocusEvent e) {
		Object obj=e.getSource();
		if(obj==buyF.buyproP.pname) {
			buyF.buyproP.pname.setText(""); 
		}else if(obj==buyF.buyproP.price) {
			buyF.buyproP.price.setText("");
		}else if(obj==buyF.infoP.pinfo) {
			buyF.infoP.pinfo.setText("");
		}
	}
	@Override
	public void focusLost(FocusEvent e) {
		
	}

	

}



