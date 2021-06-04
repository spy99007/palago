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
		
		//Ÿ��Ʋ,���� ����		
		sellF.myborder(pN, "�귣��");
		pC.setBackground(Color.white);
		pS.setBackground(Color.white);
		
		add(pN,"North");	add(pC,"Center");	add(pS,"South");
		
		//����� �Է� ĭ
		btf=new JTextField("��)��Ÿ����,�轺Ų��� ��",35);
		pN.add(btf);
		sellF.settext(btf);
		
		//����,���� ��ư ����
		before=new JButton("����");
		next=new JButton("����");
		sellF.myFont(before, 14);
		sellF.myFont(next, 14);
		pS.add(before);	pS.add(next);
		
		//�߾� �귣�� ����Ʈ
		brandList=new JList<>(sellF.brandArr);
		brandList.setFont(new Font("���� ���",Font.BOLD,12));
		pC.add(brandList);
		brandList.setFixedCellHeight(25);
		brandList.setFixedCellWidth(400);
	

	
	}//������------
	
	
	@Override
	public Insets getInsets() {
		return new Insets(20,20,25,20);
	}

}