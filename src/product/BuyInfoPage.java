package product;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class BuyInfoPage extends JPanel {

	JPanel pC = new JPanel(new BorderLayout());
	JPanel pS = new JPanel(new GridLayout(0,2,10,10));
	
	JLabel pimage;
	JTextArea pinfo;
	JButton before,next;
	JFileChooser chooser=new JFileChooser();
	FileNameExtensionFilter filter
	=new FileNameExtensionFilter("JPG&PNG Images", "jpg","png");
	
	BuyMainFrame buyF; 

	public BuyInfoPage(BuyMainFrame buy) {
		this.buyF=buy;
		chooser.setFileFilter(filter);
		this.setBackground(Color.white);
		setLayout(new BorderLayout());
		add(pC,"Center");	add(pS,"South");
		
		//Ÿ��Ʋ,��� ����
		buyF.myborder(pC,"��ǰ ����");
		pS.setBackground(Color.white);
		
		//��ǰ ����, ���� �߰�
		pimage=new JLabel("���⸦ Ŭ���Ͽ� ������ �����ϼ���");
		pinfo=new JTextArea("��ǰ ������ �Է����ּ���");
		pimage.setFont(new Font("���� ���",Font.BOLD,14));
		buyF.mytext(pinfo);
		pC.add(pimage,"North");	 
		pC.add(new JScrollPane(pinfo),"Center");
		
		//�ϴ� ��ư
		before=new JButton("����");
		next=new JButton("����ϱ�");
		buyF.myFont(before, 14);
		buyF.myFont(next, 14);
		pS.add(before);	pS.add(next);

	
	}//������------

	@Override
	public Insets getInsets() {
		return new Insets(20,20,25,20);
	}

}