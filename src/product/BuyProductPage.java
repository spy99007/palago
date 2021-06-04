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
		
		//��ǰ���� �Է�
		buyF.myborder(p1,"��ǰ����");
		category=new JComboBox<>(buyF.cateArr);
		category.setFont(new Font("���� ���",Font.BOLD,12));
		pname=new JTextField("��ǰ���� �Է��ϼ���");
		buyF.mytext(pname);
		p1.add(category,"North");	p1.add(pname);
		
		//���Ա��� ���� �Է�
		buyF.myborder(p2,"���Ա���");
		price=new JTextField("���� �ݾ��� �Է��ϼ���");
		buyF.mytext(price);
		won=new JLabel("  ��");
		won.setFont(new Font("���� ���",Font.BOLD,14)); 
		p2.add(price,"West");
		p2.add(won);

		//�ϴ� ��ư
		next=new JButton("����");
		buyF.myFont(next, 14);
		pS.add(next);	

	
	}//������------


	@Override
	public Insets getInsets() {
		return new Insets(20,20,25,20);
	}

}