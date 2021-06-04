package product;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.filechooser.FileNameExtensionFilter;

//import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Text;

public class DetailPage extends JPanel{

	JPanel p=new JPanel(new GridLayout(2,0,10,10));
	JPanel pS=new JPanel(new BorderLayout());
	JPanel p1 = new JPanel(new GridLayout(2,1,10,10));
	JPanel p2 = new JPanel(new GridLayout(2,3,10,10));
	JPanel p3 = new JPanel(new BorderLayout());
	JPanel p4 = new JPanel(new GridLayout(1,2,10,10));
	
	JLabel pname,pimage,pricenm1,pricenm2,won1,won2;
	JComboBox<String> pcategory; 
	JTextField price1,price2;
	JTextArea pinfo;
	JButton before,fin;
	
	SellMainFrame sellF;
	
	CardLayout card;
	
	//���Ͼ��ε� â
	JFileChooser chooser=new JFileChooser();
	FileNameExtensionFilter filter
	=new FileNameExtensionFilter("JPG & PNG images", "jpg", "png");
			
	public DetailPage(SellMainFrame rgst) {
		this.sellF=rgst;
		chooser.setFileFilter(filter);
		
		//panel��漳��,add
		setBackground(Color.white);
		setLayout(new BorderLayout());
		p.setBackground(Color.white);
		pS.setBackground(Color.white);
		add(p,"North"); add(pS,"South");
		p.add(p1);	p.add(p2);	
		pS.add(p3,"Center");
		pS.add(p4,"South");	
		
		//�ǸŻ�ǰ ����
		sellF.myborder(p1, "�ǸŻ�ǰ");
		pname=new JLabel();
		pcategory=new JComboBox<String>(sellF.cateArr);
		pcategory.setFont(new Font("���� ���",Font.BOLD,12));
		pname.setFont(new Font("���� ���",Font.BOLD,12));
		sellF.setmargin(pname);
		p1.add(pname,"North");	
		p1.add(pcategory);
		 
		//�������� �Է�
		sellF.myborder(p2, "��������");
		pricenm1=new JLabel("�Һ��ڰ�");
		pricenm2=new JLabel("�ǸŰ�");
		sellF.setmargin(pricenm1);
		sellF.setmargin(pricenm2);
		pricenm1.setFont(new Font("���� ���",Font.BOLD,12));
		pricenm2.setFont(new Font("���� ���",Font.BOLD,12));
		price1=new JTextField("�ݾ� �Է�");
		price2=new JTextField("�ݾ� �Է�");
		price1.setHorizontalAlignment(JTextField.RIGHT);
		price2.setHorizontalAlignment(JTextField.RIGHT);
		sellF.settext(price1);
		sellF.settext(price2);
		won1=new JLabel("��");
		won2=new JLabel("��");
		won1.setFont(new Font("���� ���",Font.BOLD,12));
		won2.setFont(new Font("���� ���",Font.BOLD,12));
		p2.add(pricenm1);p2.add(price1);p2.add(won1);	
		p2.add(pricenm2);p2.add(price2);p2.add(won2);
		
		//��ǰ ����,���� ���ε�
		sellF.myborder(p3, "��ǰ����");
		pimage=new JLabel("��������");
		pimage.setFont(new Font("���� ���",Font.BOLD,12));
		pinfo=new JTextArea(">>��ǰ ����",6,25);
		p3.add(pimage,"West");	p3.add(pinfo);
		sellF.settext(pinfo);
		
		//����,���� ��ư
		p4.setBackground(Color.white);
		before=new JButton("����");
		fin=new JButton("����ϱ�");
		p4.add(before);	p4.add(fin);
		sellF.myFont(before, 14);
		sellF.myFont(fin, 14);
		
		
	}//������------
	
	
	
	@Override
	public Insets getInsets() {
		return new Insets(20,20,25,20);
	}

}