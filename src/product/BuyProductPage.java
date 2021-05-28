package product;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class BuyProductPage extends JPanel {

	JPanel p1 = new JPanel(new BorderLayout());
	JPanel p2 = new JPanel(new BorderLayout());
	JPanel p2N = new JPanel(new GridLayout(0,2,10,10));
	JPanel p2S=new JPanel(card=new CardLayout());
	JPanel p2rate=new JPanel(new FlowLayout());
	JPanel pS = new JPanel(new GridLayout(1,0,10,10));
	
	
	JComboBox<String> category;
	JTextField pname,min,max,price;
	JButton rate,won,next;
	JLabel lb;
	
	CardLayout card;
	BuyMainFrame buyF;
	

	public BuyProductPage(BuyMainFrame buy) {
		this.buyF=buy;
		buyF.whiteback(this);
		setLayout(new BorderLayout());
		add(pS,"South");
		add(p1,"North");	add(p2,"Center");
		p2.add(p2N);	p2.add(p2rate);
		
		
		buyF.whiteback(p1);
		buyF.whiteback(p2); buyF.whiteback(p2N);
		buyF.whiteback(p2rate);	buyF.whiteback(p2S);
		buyF.whiteback(pS);
		
		buyF.pborder(p1,"상품정보");
		category=new JComboBox<>();
		pname=new JTextField("상품명을 입력하세요");
		pname.setForeground(Color.LIGHT_GRAY);
		p1.add(category,"North");	p1.add(pname);
		
		buyF.pborder(p2,"매입기준");
		rate=new JButton("할인률(%)");
		won=new JButton("금액(원)");
		p2.add(p2N,"North");
		p2N.add(rate);	p2N.add(won);
		p2.add(p2S,"Center"); 
		
		min=new JTextField("최소(%)",15);
		max=new JTextField("최대(%)",15);
		min.setForeground(Color.LIGHT_GRAY);
		max.setForeground(Color.LIGHT_GRAY);
		lb=new JLabel("~");
		p2rate.add(min);	p2rate.add(lb);		p2rate.add(max);
		price=new JTextField("매입 금액을 입력하세요",38);
		price.setForeground(Color.LIGHT_GRAY);

		p2S.add("rate",p2rate);
		p2S.add("price",price);

		
		
		
		next=new JButton("다음");
		pS.add(next);	

	
	}//생성자------


	@Override
	public Insets getInsets() {
		return new Insets(20,20,25,20);
	}

}