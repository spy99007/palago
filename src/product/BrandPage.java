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
		
		//타이틀,배경색 설정		
		sellF.myborder(pN, "브랜드");
		pC.setBackground(Color.white);
		pS.setBackground(Color.white);
		
		add(pN,"North");	add(pC,"Center");	add(pS,"South");
		
		//사용자 입력 칸
		btf=new JTextField("예)스타벅스,배스킨라빈스 등",35);
		pN.add(btf);
		sellF.settext(btf);
		
		//이전,다음 버튼 설정
		before=new JButton("이전");
		next=new JButton("다음");
		sellF.myFont(before, 14);
		sellF.myFont(next, 14);
		pS.add(before);	pS.add(next);
		
		//중앙 브랜드 리스트
		brandList=new JList<>(sellF.brandArr);
		brandList.setFont(new Font("맑은 고딕",Font.BOLD,12));
		pC.add(brandList);
		brandList.setFixedCellHeight(25);
		brandList.setFixedCellWidth(400);
	

	
	}//생성자------
	
	
	@Override
	public Insets getInsets() {
		return new Insets(20,20,25,20);
	}

}