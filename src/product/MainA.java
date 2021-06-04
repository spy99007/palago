package product;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import common.Common;
import report.Report;
import user.LoginFrame;
import user.MyPageFrame;
import user.User;

public class MainA extends JFrame {

	JPanel p = new JPanel();
	JPanel pn = new JPanel();
	JPanel panel = new JPanel();
	ButtonCoffee bcoffee;
	ButtonHam bham;
	
	JButton btn1, btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
	JPanel cp;
	CardLayout card;
	
	ButtonCoffee cffPane;
	ButtonStarbucks star;
	//////////////////////
	LoginFrame lgF;
	MyPageFrame mpF;
	Common com;
	String id;
	/////////////////////
	public LoginFrame getLgF() {
		return lgF;
	}

	public void setLgF(LoginFrame lgF) {
		this.lgF = lgF;
	}

	public MyPageFrame getMpF() {
		return mpF;
	}

	public void setMpF(MyPageFrame mpF) {
		this.mpF = mpF;
	}
	public Common getCom() {
		return com;
	}
	
	//////////////////////////////////////////
	public MainA(LoginFrame lf) {
		lgF=lf;
		mpF=new MyPageFrame(this);
		com=Common.getCommon();
		String id =this.id;
		
		
		//setLayout(card=new CardLayout());
				
		
		cp = new JPanel(new BorderLayout());
	    
		
		
		
		cffPane=new ButtonCoffee(this);
		star=new ButtonStarbucks(this);
		
		this.add(cp,"mainP");
		this.add(cffPane,"coffeeP");
		this.add(star,"star");
		
		cp.add(p, "Center");
		cp.add(pn,"North");
		cp.add(panel,"South");
		p.setBackground(Color.white);
		p.setLayout(new GridLayout(3,3,5,5));
		
		bcoffee=new ButtonCoffee(this);
		bham= new ButtonHam(this);

		
		
		ImageIcon normalIcon1= new ImageIcon("images/puppy.png");
		btn1 =new JButton("땡철이",normalIcon1);
		p.add(btn1);
		btn1.setHorizontalTextPosition(JButton.CENTER);
		btn1.setVerticalTextPosition(JButton.BOTTOM);
		btn1.setBackground(Color.white);
		btn1.setBorderPainted(false);
		
        ImageIcon normalIcon2= new ImageIcon("images/coffee.png");
		btn2=new JButton("카페",normalIcon2);
		p.add(btn2);
		btn2.setHorizontalTextPosition(JButton.CENTER);
		btn2.setVerticalTextPosition(JButton.BOTTOM);
		btn2.setBackground(Color.white);
		btn2.setBorderPainted(false);
		
		ImageIcon normalIcon3= new ImageIcon("images/shop.png");
		btn3 =new JButton("편의점",normalIcon3);
		p.add(btn3);
		btn3.setHorizontalTextPosition(JButton.CENTER);
		btn3.setVerticalTextPosition(JButton.BOTTOM);
		btn3.setBackground(Color.white);
		btn3.setBorderPainted(false);
		
		ImageIcon normalIcon4= new ImageIcon("images/ice-cream.png");
		btn4 =new JButton("아이스크림,빵",normalIcon4);
		p.add(btn4);
		btn4.setHorizontalTextPosition(JButton.CENTER);
		btn4.setVerticalTextPosition(JButton.BOTTOM);
		btn4.setBackground(Color.white);
		btn4.setBorderPainted(false);
		
		ImageIcon normalIcon5= new ImageIcon("images/ham.png");
		btn5 =new JButton("햄버거,치킨,피자",normalIcon5);
		p.add(btn5);
		btn5.setHorizontalTextPosition(JButton.CENTER);
		btn5.setVerticalTextPosition(JButton.BOTTOM);
		btn5.setBackground(Color.white);
		btn5.setBorderPainted(false);
		
		ImageIcon normalIcon6= new ImageIcon("images/joystick.png");
		btn6 =new JButton("게임,영화,문화",normalIcon6);
		p.add(btn6);
		btn6.setHorizontalTextPosition(JButton.CENTER);
		btn6.setVerticalTextPosition(JButton.BOTTOM);
		btn6.setBackground(Color.white);
		btn6.setBorderPainted(false);
		
		ImageIcon normalIcon7= new ImageIcon("images/fork.png");
		btn7 =new JButton("외식,분식",normalIcon7);
		p.add(btn7);
		btn7.setHorizontalTextPosition(JButton.CENTER);
		btn7.setVerticalTextPosition(JButton.BOTTOM);
		btn7.setBackground(Color.white);
		btn7.setBorderPainted(false);
		
		ImageIcon normalIcon8= new ImageIcon("images/cart1.png");
		btn8 =new JButton("백화점,뷰티",normalIcon8);
		p.add(btn8);
		btn8.setHorizontalTextPosition(JButton.CENTER);
		btn8.setVerticalTextPosition(JButton.BOTTOM);
		btn8.setBackground(Color.white);
		btn8.setBorderPainted(false);
		
		ImageIcon normalIcon9= new ImageIcon("images/phone.png");
		btn9 =new JButton("휴대폰 데이터",normalIcon9);
		p.add(btn9);
		btn9.setHorizontalTextPosition(JButton.CENTER);
		btn9.setVerticalTextPosition(JButton.BOTTOM);
		btn9.setBackground(Color.white);
		btn9.setBorderPainted(false);
		
		
//		JLabel lb=new JLabel("팔라고");
//		pn.add(lb);
		pn.setBackground(Color.white);
		pn.setLayout(new FlowLayout(FlowLayout.RIGHT,0,0));
		EventHendler eh =new EventHendler();
		btn2.addActionListener(eh);
		btn5.addActionListener(eh);
		///////
		JButton btMyPage = new JButton("마이페이지");
		pn.add(btMyPage);
		
		
		////////
			///////////////////////////////////////////////////////////////
			btMyPage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			Object obj =e.getSource();
			
			if(obj==btMyPage) {
			//String id=MainA.this.getTitle();
			
			String id=MainA.this.id;
			
			System.out.println("this.title==="+MainA.this.id);
			if(id!=null)
			System.out.println("id="+id);
			User user = com.getUser(id);
			System.out.println(user+"<<<<");
			if(user==null) return;
			
			mpF.tfId.setText(user.getId());
			mpF.tfNickName.setText(user.getNickName());
			mpF.tfPwd.setText(user.getPwd());
			mpF.tfTel.setText(user.getTel());
			mpF.tfEmail.setText(user.getEmail());
			
			mpF.setTitle(id);
			mpF.pack();
			mpF.setSize(500,500);
			mpF.setVisible(true);
			
			}
			
		}
	});
			///////////////////////////////////////////////////////////////
			
			
			//신고하기 버튼
			JButton mbtn2 = new JButton("");
			//mbtn2.setBounds(450, 10, 40, 40);
			mbtn2.setIcon(new ImageIcon("./images/notify.png"));
			mbtn2.setSelectedIcon(new ImageIcon("./images/notify.png"));
			mbtn2.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Report rp = new Report();
					rp.setSize(500, 500);
					rp.setVisible(true);
				}
			});
			pn.add(mbtn2);
			mbtn2.setBorderPainted(false);
			
			
			
			// 하단 메뉴 패널
			//JPanel panel = new JPanel();
			panel.setBounds(0, 411, 500, 61);
			panel.setBackground(Color.white);
			panel.setLayout(new FlowLayout(FlowLayout.CENTER,70,0));
			//cp.add(panel);

			
			
			// 하단 메뉴 - 홈 버튼
			ImageIcon Icon1 = new ImageIcon("images/home.png");
			JButton bbtn1 = new JButton("홈", Icon1);
			panel.add(bbtn1,BorderLayout.WEST);
			//bbtn1.setBounds(0, 0, 125, 60);
			panel.add(bbtn1);
			bbtn1.setHorizontalTextPosition(JButton.CENTER);
			bbtn1.setVerticalTextPosition(JButton.BOTTOM);
			bbtn1.setBorderPainted(false);

			// 하단 메뉴 - 검색 버튼
			ImageIcon Icon2 = new ImageIcon("images/buy15.png");
			JButton bbtn2 = new JButton("삽니다", Icon2);
			//bbtn2.setBounds(125, 0, 125, 60);
			panel.add(bbtn2);
			bbtn2.setHorizontalTextPosition(JButton.CENTER);
			bbtn2.setVerticalTextPosition(JButton.BOTTOM);
			bbtn2.setBorderPainted(false);

			// 하단메뉴 - 장바구니
			ImageIcon Icon3 = new ImageIcon("images/seller.png");
			JButton bbtn3 = new JButton("팝니다", Icon3);
			//bbtn3.setBounds(250, 0, 125, 60);
			panel.add(bbtn3);
			bbtn3.setHorizontalTextPosition(JButton.CENTER);
			bbtn3.setVerticalTextPosition(JButton.BOTTOM);
			bbtn3.setBorderPainted(false);

			// 하단 메뉴 - 마이페이지
			ImageIcon Icon4 = new ImageIcon("images/person.png");
			JButton bbtn4 = new JButton("마이페이지", Icon4);
			bbtn4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Page page = new Page();
					page.setSize(500, 500);
					page.setVisible(true);
					
				}
			});
			//bbtn4.setBounds(375, 0, 125, 60);
			panel.add(bbtn4);
			bbtn4.setHorizontalTextPosition(JButton.CENTER);
			bbtn4.setVerticalTextPosition(JButton.BOTTOM);
			bbtn4.setBorderPainted(false);

	}//생성자------
	
	

	

	public void setId(String id) {
		this.id =id;
	}
	
	
	class EventHendler implements ActionListener{
		

		@Override
		public void actionPerformed(ActionEvent e) {
			Object o=e.getSource();
			if(o==btn2) {
				//bcoffee.pack();
				//bcoffee.setVisible(true);
				card.show(MainA.this, "coffeeP");
			}
			else if(o==btn5){
				bham.pack();
				bham.setVisible(true);
			}
			
		}
		
	}
	
	

	public static void main(String[] args) {
		/*
		 * MainA my = new MainA(); 
		 * JFrame jf=new JFrame("Palago");
		 * jf.getContentPane().add(my); 
		 * jf.setSize(500, 500); jf.setVisible(true);
		 */
		
	}

}