package product;

import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;


public class SellMainFrame extends JFrame {
 
	JPanel p = new JPanel(new BorderLayout());
	JPanel pN = new JPanel(new BorderLayout());
	JPanel pC = new JPanel();
	
	CouponType couponP;
	BrandPage brandP;
	ProductPage productP;
	DetailPage detailP;

	CardLayout card;
	
	JLabel sellicon;
	JLabel exit;
	
	Vector<Coupon> coupons=new Vector<>();
	
	String []cateArr={"ī��","������","���̽�ũ��,��","�ܹ���,ġŲ,����",
			"����,��ȭ,��ȭ","�ܽ�,�н�","��ȭ��,��Ƽ","�޴��� ������"};
	String []brandArr={"��Ÿ����","�����÷��̽�","�̵��","�Ҹ���","���ټ�","Ž��Ž��","CU","�ѷ��긣","����ŷ",
			"�ø��꿵"};
	String []productArr={"�Ƹ޸�ī��","���̽��Ƹ޸�ī��","ī���","���̽��ٴҶ��","�׸�Ƽ��"};
	
	
	ObjectOutputStream out;
	FileOutputStream fout;
	
	
	public SellMainFrame() {
		super("::'�ȰԿ�' �ۼ�::");
		Container cp = this.getContentPane();
		cp.add(p, "Center");
		p.setBackground(Color.white); 
		pN.setBackground(Color.white);
		pC.setBackground(Color.white);
		
		p.add(pN,"North");
		p.add(pC,"Center");
		pN.setBackground(new Color(50,100,170));
		
		//��� sell,x ������
		sellicon=new JLabel(new ImageIcon("images/sell2.png"));
		exit=new JLabel(new ImageIcon("images/remove.png"));
		pN.add(sellicon,"West");
		pN.add(exit,"East");
		
		//�߾� - ī�� ���̾ƿ� 
		pC.setLayout(card=new CardLayout());
		couponP=new CouponType(this);
		brandP=new BrandPage(this);
		productP=new ProductPage(this);
		detailP=new DetailPage(this);
		
		pC.add("coupon",couponP);
		pC.add("brand",brandP);
		pC.add("product",productP);
		pC.add("detail",detailP); 
		
		
		HandlerSell handler=new HandlerSell(this);
		exit.addMouseListener(handler);
		couponP.next.addActionListener(handler);
		
		brandP.btf.addFocusListener(handler);
		brandP.brandList.addListSelectionListener(handler);
		brandP.before.addActionListener(handler);
		brandP.next.addActionListener(handler);
		
		productP.ptf.addFocusListener(handler);
		productP.productList.addListSelectionListener(handler);
		productP.before.addActionListener(handler);
		productP.next.addActionListener(handler);
		
		detailP.price1.addFocusListener(handler);
		detailP.price2.addFocusListener(handler);
		detailP.pimage.addMouseListener(handler);
		detailP.pinfo.addFocusListener(handler);
		detailP.before.addActionListener(handler);
		detailP.fin.addActionListener(handler);
		
	
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				//coupons ���Ͽ� ����
				saveFile("src/palago/coupon.txt");
				System.exit(0);
			}
		});
	}//������------
	public void saveFile(String fileName) {
		try {
			fout=new FileOutputStream(fileName);
			out=new ObjectOutputStream(fout);
			out.writeObject(coupons);
			out.flush();
			out.close();
			fout.close();
			System.out.println(fileName+"�� ���� �Ϸ�!");
		}catch(IOException e) {
			System.out.println("���� ���� �� ���� �߻�: "+e.getMessage());
			e.printStackTrace();
		}
	}//--------------
		
	
	
	//���� ����
	public void setmargin(JComponent c) {
		c.setBorder(new EmptyBorder(0,20,0,0));
	}//----------
	
	//��ư ��Ʈ ����
	public void myFont(JComponent c,int size) {
		c.setBackground(new Color(50,100,170));
		c.setForeground(Color.white);
		c.setFont(new Font("���� ���",Font.BOLD,size));
	}//-------------------
 
	//����� �ۼ� �ؽ�Ʈ ����,��Ʈ,���� ���� 
	public void settext(JComponent c) {
		c.setForeground(Color.gray);
		c.setFont(new Font("���� ���",Font.BOLD,13));
		c.setBorder(new EmptyBorder(5,10,5,5));
	}
	//titledborder ����
	public void myborder(JPanel p,String s) {
		p.setBackground(Color.white);
		TitledBorder tb=new TitledBorder(s);
		tb.setTitleFont(new Font("���� ���",Font.BOLD,15));
		tb.setTitleColor(new Color(50,100,170));
		p.setBorder(tb);
	}

	public static void main(String[] args) {
		SellMainFrame my = new SellMainFrame();
		my.setSize(500, 500);
		my.setVisible(true);
	}

}