package product;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class ProductPage extends JPanel {

	JPanel pN = new JPanel();
	JPanel pC = new JPanel();
	JPanel pS = new JPanel(new GridLayout(1,2,10,10));
	
	JTextField ptf;
	JButton before,next;

	SellMainFrame sellF;

	public ProductPage(SellMainFrame rgst) {
		this.sellF=rgst;
		
		setBackground(Color.white);
		setLayout(new BorderLayout());
		
		add(pN,"North");	add(pC,"Center");	add(pS,"South");
		pN.setBackground(Color.white);
		pC.setBackground(Color.white);
		pS.setBackground(Color.white);
		
		ptf=new JTextField("상품명을 입력하세요",38);
		pN.add(ptf);
		pN.setBorder(new TitledBorder("상품명"));
		ptf.setForeground(Color.LIGHT_GRAY);
		
		before=new JButton("이전");
		next=new JButton("다음");
		pS.add(before);
		pS.add(next);

	
	}//생성자------

	
	@Override
	public Insets getInsets() {
		return new Insets(20,20,25,20);
	}

}