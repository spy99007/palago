package product;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.*;
import javax.swing.border.*;


public class BrandPage extends JPanel {
	
	JPanel pN=new JPanel();
	JPanel pC = new JPanel();
	JPanel pS = new JPanel(new GridLayout(1,2,10,10));
	JTextField btf;
	JButton before,next;
	JList<String> brandList;
	

	SellMainFrame sellF;
	
	public BrandPage(SellMainFrame rgst) {
		this.sellF=rgst;

		
		setBackground(Color.white);
		setLayout(new BorderLayout());
		pN.setBackground(Color.white);
		pC.setBackground(Color.white);
		pS.setBackground(Color.white);
		
		add(pN,"North");	add(pC,"Center");	add(pS,"South");
		
		btf=new JTextField("예)스타벅스,배스킨라빈스 등",38);
		pN.add(btf);
		pN.setBorder(new TitledBorder("브랜드"));
		btf.setForeground(Color.LIGHT_GRAY);
		
		before=new JButton("이전");
		next=new JButton("다음");
		pS.add(before);	pS.add(next);
		
		brandList=new JList<>();
		pC.add(brandList);

	
	}//생성자------
	
	@Override
	public Insets getInsets() {
		return new Insets(20,20,25,20);
	}

}