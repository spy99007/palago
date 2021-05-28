package product;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class DetailPage extends JPanel{

	JPanel p=new JPanel(new GridLayout(2,0,10,10));
	JPanel pS=new JPanel(new BorderLayout());
	JPanel p1 = new JPanel(new GridLayout(2,1,10,10));
	JPanel p2 = new JPanel(new GridLayout(2,1,10,10));
	JPanel p3 = new JPanel(new BorderLayout());
	JPanel p4 = new JPanel();
	JPanel p5 = new JPanel(new GridLayout(1,2,10,10));
	
	JLabel pname,pimage,pricenm1,pricenm2;
	JComboBox<String> pcategory;
	JTextField price1,price2;
	JTextArea pinfo;
	JButton pin,before,fin;
	
	SellMainFrame sellF;
	
	TitledBorder title;
	
	public DetailPage(SellMainFrame rgst) {
		this.sellF=rgst;
		
		setBackground(Color.white);
		setLayout(new BorderLayout());
		p.setBackground(Color.white);
		pS.setBackground(Color.white);
//		add(new JScrollPane(p));
		add(p,"North"); add(pS,"South");
		p.add(p1);	p.add(p2);	
		add(p3,"Center");
		pS.add(p4);	pS.add(p5,"South");	
		
		p1.setBorder(new TitledBorder("판매상품"));
		p1.setBackground(Color.white);
		pname=new JLabel();
		pcategory=new JComboBox<>();
		p1.add(pname);	p1.add(pcategory);
		
		p2.setBackground(Color.white);
		p2.setBorder(new TitledBorder("가격정보"));
		pricenm1=new JLabel("소비자가");
		pricenm2=new JLabel("판매가");		
		price1=new JTextField("금액 입력");
		price2=new JTextField("금액 입력");
		price1.setForeground(Color.LIGHT_GRAY);
		price2.setForeground(Color.LIGHT_GRAY);		
		p2.add(pricenm1);p2.add(price1);	
		p2.add(pricenm2);p2.add(price2);
		
		p3.setBackground(Color.white);
		p3.setBorder(new TitledBorder("상품정보"));
		pimage=new JLabel(new ImageIcon("images/picicon1.png"));
		pinfo=new JTextArea(10,10);
		p3.add(pimage,"North");	p3.add(pinfo);
		pinfo.setBorder(new TitledBorder(""));
		
		p4.setBackground(Color.white);
		p4.setBorder(new TitledBorder("PIN(쿠폰번호)"));
		pin=new JButton("+ 쿠폰 추가");
		p4.add(pin);
		
		p5.setBackground(Color.white);
		before=new JButton("이전");
		fin=new JButton("등록하기");
		p5.add(before);	p5.add(fin);

	
	}//생성자------
	
	
	
	@Override
	public Insets getInsets() {
		return new Insets(20,20,25,20);
	}

}