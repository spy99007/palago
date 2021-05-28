package product;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class HandlerBuy extends MouseAdapter implements ActionListener{
	
	BuyMainFrame buyF;
	
	public HandlerBuy(BuyMainFrame buy) {
		this.buyF=buy;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		if(obj==buyF.buyproP.next) {
			buyF.card.show(buyF.pC, "info");
		}if(obj==buyF.infoP.before) {
			buyF.card.show(buyF.pC, "product");
		}
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		Object obj=e.getSource();
		if(obj==buyF.exit) {
			System.exit(0);
		}
		else if(obj==buyF.buyproP.pname) {
			buyF.buyproP.pname.setText("");
		}else if(obj==buyF.buyproP.min) {
			buyF.buyproP.min.setText("");
		}else if(obj==buyF.buyproP.max) {
			buyF.buyproP.max.setText("");
		}
		else if(obj==buyF.buyproP.rate) {
			buyF.buyproP.card.show(buyF.buyproP.p2S,"rate");
		}else if(obj==buyF.buyproP.won) {
			buyF.buyproP.card.show(buyF.buyproP.p2S, "price");
		}
		else if(obj==buyF.infoP.pinfo) {
			buyF.infoP.pinfo.setText("");
		}
	}

	

}



