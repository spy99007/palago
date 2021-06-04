package product;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class BuyProductPage extends JPanel {

	JPanel p = new JPanel(new GridLayout(2,0,10,10));
	JPanel p1 = new JPanel(new BorderLayout());
	JPanel p2 = new JPanel(new BorderLayout());
	JPanel pS = new JPanel(new GridLayout(1,0,10,10));
	
	
	JComboBox<String> category;
	JTextField pname,price;
	JButton next;
	JLabel won;
	CardLayout card;
	BuyMainFrame buyF;
	

	public BuyProductPage(BuyMainFrame buy) {
		this.buyF=buy;
		this.setBackground(Color.white);
		setLayout(new BorderLayout());
		add(p);
		add(pS,"South");
		p.add(p1);	
		p.add(p2);	
		p.setBackground(Color.white);
		pS.setBackground(Color.white);
		
		//상품정보 입력
		buyF.myborder(p1,"상품정보");
		category=new JComboBox<>(buyF.cateArr);
		category.setFont(new Font("맑은 고딕",Font.BOLD,12));
		pname=new JTextField("상품명을 입력하세요");
		buyF.mytext(pname);
		p1.add(category,"North");	p1.add(pname);
		
		//매입기준 가격 입력
		buyF.myborder(p2,"매입기준");
		price=new JTextField("매입 금액을 입력하세요");
		buyF.mytext(price);
		won=new JLabel("  원");
		won.setFont(new Font("맑은 고딕",Font.BOLD,14)); 
		p2.add(price,"West");
		p2.add(won);

		//하단 버튼
		next=new JButton("다음");
		buyF.myFont(next, 14);
		pS.add(next);	

	
	}//생성자------


	@Override
	public Insets getInsets() {
		return new Insets(20,20,25,20);
	}

}