package product;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class BuyInfoPage extends JPanel {

	JPanel pC = new JPanel(new BorderLayout());
	JPanel pS = new JPanel(new GridLayout(0,2,10,10));
	
	JLabel pimage;
	JTextArea pinfo;
	
	JButton before,next;
	
	BuyMainFrame buyF;

	public BuyInfoPage(BuyMainFrame buy) {
		this.buyF=buy;
		buyF.whiteback(this);
		setLayout(new BorderLayout());
		add(pC,"Center");	add(pS,"South");
		
		buyF.whiteback(pC);
		buyF.whiteback(pS);
		
		buyF.pborder(pC, "상품정보");
		pimage=new JLabel(new ImageIcon("images/picicon1.png"));
		pinfo=new JTextArea("상품 설명을 입력해주세요");
		pinfo.setForeground(Color.LIGHT_GRAY);
		pinfo.setBorder(new TitledBorder(""));
		
		pC.add(pimage,"North");	
		pC.add(pinfo,"Center");
		
		before=new JButton("이전");
		next=new JButton("등록하기");
		
		pS.add(before);	pS.add(next);

	
	}//생성자------

	@Override
	public Insets getInsets() {
		return new Insets(20,20,25,20);
	}

}