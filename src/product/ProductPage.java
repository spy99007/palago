package product;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

public class ProductPage extends JPanel {

	JPanel pN = new JPanel();
	JPanel pC = new JPanel();
	JPanel pS = new JPanel(new GridLayout(1,2,10,10));
	
	JTextField ptf;
	JButton before,next;
	JList<String> productList;

	SellMainFrame sellF;

	public ProductPage(SellMainFrame rgst) {
		this.sellF=rgst;
		setBackground(Color.white);
		setLayout(new BorderLayout());
		
		add(pN,"North");	add(pC,"Center");	add(pS,"South");
		pN.setBackground(Color.white);
		pC.setBackground(Color.white);
		pS.setBackground(Color.white);
		
		//Ÿ��Ʋ, ����� �Է�ĭ 
		sellF.myborder(pN, "��ǰ��");
		ptf=new JTextField("��ǰ���� �Է��ϼ���",35);
		pN.add(ptf);
		sellF.settext(ptf);
		
		//��ǰ ����Ʈ
		productList=new JList<String> (sellF.productArr);
		productList.setFont(new Font("���� ���",Font.BOLD,12));
		pC.add(productList);
		productList.setFixedCellHeight(30);
		productList.setFixedCellWidth(400);
		
		//����, ���� ��ư
		before=new JButton("����");
		next=new JButton("����");
		pS.add(before);
		pS.add(next);
		sellF.myFont(before, 14);
		sellF.myFont(next, 14);
 
	
	}//������------

	
	@Override
	public Insets getInsets() {
		return new Insets(20,20,25,20);
	}

}