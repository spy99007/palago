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
	
	String []cateArr={"카페","편의점","아이스크림,빵","햄버거,치킨,피자",
			"게임,영화,문화","외식,분식","백화점,뷰티","휴대폰 데이터"};
	String []brandArr={"스타벅스","투썸플레이스","이디야","할리스","폴바셋","탐앤탐스","CU","뚜레쥬르","버거킹",
			"올리브영"};
	String []productArr={"아메리카노","아이스아메리카노","카페라떼","아이스바닐라라떼","그린티라떼"};
	
	
	ObjectOutputStream out;
	FileOutputStream fout;
	
	
	public SellMainFrame() {
		super("::'팔게요' 작성::");
		Container cp = this.getContentPane();
		cp.add(p, "Center");
		p.setBackground(Color.white); 
		pN.setBackground(Color.white);
		pC.setBackground(Color.white);
		
		p.add(pN,"North");
		p.add(pC,"Center");
		pN.setBackground(new Color(50,100,170));
		
		//상단 sell,x 아이콘
		sellicon=new JLabel(new ImageIcon("images/sell2.png"));
		exit=new JLabel(new ImageIcon("images/remove.png"));
		pN.add(sellicon,"West");
		pN.add(exit,"East");
		
		//중앙 - 카드 레이아웃 
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
				//coupons 파일에 저장
				saveFile("src/palago/coupon.txt");
				System.exit(0);
			}
		});
	}//생성자------
	public void saveFile(String fileName) {
		try {
			fout=new FileOutputStream(fileName);
			out=new ObjectOutputStream(fout);
			out.writeObject(coupons);
			out.flush();
			out.close();
			fout.close();
			System.out.println(fileName+"에 저장 완료!");
		}catch(IOException e) {
			System.out.println("파일 저장 중 에러 발생: "+e.getMessage());
			e.printStackTrace();
		}
	}//--------------
		
	
	
	//마진 설정
	public void setmargin(JComponent c) {
		c.setBorder(new EmptyBorder(0,20,0,0));
	}//----------
	
	//버튼 폰트 설정
	public void myFont(JComponent c,int size) {
		c.setBackground(new Color(50,100,170));
		c.setForeground(Color.white);
		c.setFont(new Font("맑은 고딕",Font.BOLD,size));
	}//-------------------
 
	//사용자 작성 텍스트 색상,폰트,마진 설정 
	public void settext(JComponent c) {
		c.setForeground(Color.gray);
		c.setFont(new Font("맑은 고딕",Font.BOLD,13));
		c.setBorder(new EmptyBorder(5,10,5,5));
	}
	//titledborder 설정
	public void myborder(JPanel p,String s) {
		p.setBackground(Color.white);
		TitledBorder tb=new TitledBorder(s);
		tb.setTitleFont(new Font("맑은 고딕",Font.BOLD,15));
		tb.setTitleColor(new Color(50,100,170));
		p.setBorder(tb);
	}

	public static void main(String[] args) {
		SellMainFrame my = new SellMainFrame();
		my.setSize(500, 500);
		my.setVisible(true);
	}

}