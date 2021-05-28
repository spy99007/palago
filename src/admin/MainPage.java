package admin;

import java.awt.*;
import java.awt.event.*;
import java.util.Hashtable;

import javax.swing.*;
import javax.swing.border.EtchedBorder;

public class MainPage extends JFrame {

	JPanel p = new JPanel(new BorderLayout());
	JPanel pN=new JPanel(new GridLayout(1,0,10,10));
	JPanel pC=new JPanel();
	
	JLabel lbmyP, lbnoticeP, lbpostP;
	
	MyPage mypage;
	Notice notice;
	Post post;
	NoticeWrite notW;
	WriteMassage wm;
	
	CardLayout card;
	
	Hashtable<String, WriteMassage> noticeTable=new Hashtable<>();
	
	Login lg;
	public MainPage(Login lg) {
		super("::MainPage::");
		this.lg=lg;
		Container cp = this.getContentPane();
		cp.add(p, "Center");
		add(p);
		p.setBackground(Color.white);
		p.add(pN,"North");
		p.add(pC,"Center");
		pC.setBackground(Color.white);
		
		lbnoticeP=new JLabel("공지사항");
		lbmyP=new JLabel("마이페이지");
		lbpostP=new JLabel("신고게시판");
	
		labelUI(lbnoticeP);
		labelUI(lbmyP);
		labelUI(lbpostP);
		
		pN.add(lbnoticeP);
		pN.add(lbmyP);
		pN.add(lbpostP);
		
		pC.setLayout(card=new CardLayout());
		notice=new Notice(this);
		mypage=new MyPage(this);
		post=new Post(this);
		
		pC.add("noP",notice);
		pC.add("mpP",mypage);
		pC.add("poP",post);
		
		Handler hand=new Handler(this);
		lbnoticeP.addMouseListener(hand);
		lbmyP.addMouseListener(hand);
		lbpostP.addMouseListener(hand);
		
		

		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
			}
		});
	}//생성자------
	public void noitce() {
		String title=notW.tf.getText();
		String text=notW.ta.getText();
	}
	

	
	
	public void labelUI(JLabel lb){
		lb.setOpaque(true);
		lb.setBackground(Color.LIGHT_GRAY);
		lb.setHorizontalTextPosition(JLabel.CENTER);
		lb.setVerticalTextPosition(JLabel.BOTTOM);
		lb.setBorder(new EtchedBorder(EtchedBorder.RAISED));
	}
/*
	public static void main(String[] args) {
		MainPage my = new MainPage();
		my.setSize(500, 500);
		my.setVisible(true);
	}
	*/

}
