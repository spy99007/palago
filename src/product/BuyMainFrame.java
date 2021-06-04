package product;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.border.*;


public class BuyMainFrame extends JFrame {

	JPanel p = new JPanel(new BorderLayout());
	JPanel pN = new JPanel(new BorderLayout());
	JPanel pC = new JPanel();
	
	BuyProductPage buyproP;
	BuyInfoPage infoP;
	 
	CardLayout card;
	
	JLabel buyicon,exit;
	
	String []cateArr={"카페","편의점","아이스크림,빵","햄버거,치킨,피자",
			"게임,영화,문화","외식,분식","백화점,뷰티","휴대폰 데이터"};
	

	public BuyMainFrame() {
		super("::'살게요' 작성::");
		Container cp = this.getContentPane();
		cp.add(p, "Center");
		p.setBackground(Color.white);
		
		cp.add(p);
		p.add(pN,"North"); 	p.add(pC,"Center"); 
		pN.setBackground(new Color(50,100,170));
		pC.setBackground(Color.white);	
		
		//화면 상단 buy,x 아이콘
		buyicon=new JLabel(new ImageIcon("images/buy.png"));
		exit=new JLabel(new ImageIcon("images/remove.png"));
		pN.add(buyicon,"West");	
		pN.add(exit,"East");
		
		//중앙-card layout
		pC.setLayout(card=new CardLayout());
		buyproP=new BuyProductPage(this);
		infoP=new BuyInfoPage(this);
		
		pC.add("product",buyproP);
		pC.add("info",infoP);
		
		
		HandlerBuy handlerB=new HandlerBuy(this);
		this.exit.addMouseListener(handlerB);
		buyproP.pname.addFocusListener(handlerB);
		buyproP.won.addMouseListener(handlerB);
		buyproP.price.addFocusListener(handlerB);
		buyproP.next.addActionListener(handlerB);
		
		infoP.before.addActionListener(handlerB);
		infoP.next.addActionListener(handlerB);
		infoP.pimage.addMouseListener(handlerB);
		infoP.pinfo.addFocusListener(handlerB);
		

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//생성자------
	
	//버튼 폰트 설정
	public void myFont(JComponent c,int size) {
		c.setBackground(new Color(50,100,170));
		c.setForeground(Color.white);
		c.setFont(new Font("맑은 고딕",Font.BOLD,size));
	}
	
	//titledborder설정
	public void myborder(JComponent c,String str) {
		c.setBackground(Color.white);
		TitledBorder tb=new TitledBorder(str);
		tb.setTitleFont(new Font("맑은 고딕",Font.BOLD,15));
		tb.setTitleColor(new Color(50,100,170));
		c.setBorder(tb);
	} 
	
	//사용자 작성 텍스트 - 색상,폰트,마진 설정
	public void mytext(JComponent c) {
		c.setForeground(Color.gray);
		c.setFont(new Font("맑은 고딕",Font.BOLD,13));
		c.setBorder(new EmptyBorder(5,5,5,5));
	}

	public static void main(String[] args) {
		BuyMainFrame my = new BuyMainFrame();
		my.setSize(500, 500);
		my.setVisible(true);
	}

}