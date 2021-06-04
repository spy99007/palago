package product;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonHam extends JFrame {

	JPanel p = new JPanel();
	JPanel pn = new JPanel();
	MainA ma;
	
	JButton btn1, btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;

	public ButtonHam(MainA ma) {
		super("::ButtonHam::");
		this.ma=ma;
		Container cp = this.getContentPane();
		cp.add(p, "Center");
		cp.add(pn,"North");
		p.setBackground(Color.white);
		p.setLayout(new GridLayout(3,3,5,5));
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		ImageIcon Icon1= new ImageIcon("images/bbq.PNG");
		JButton btn1 =new JButton("BBQ",Icon1);
		p.add(btn1);
		btn1.setHorizontalTextPosition(JButton.CENTER);
		btn1.setVerticalTextPosition(JButton.BOTTOM);
		btn1.setBackground(Color.white);
		
		ImageIcon Icon2= new ImageIcon("images/bhc.PNG");
		JButton btn2 =new JButton("BHC",Icon2);
		p.add(btn2);
		btn2.setHorizontalTextPosition(JButton.CENTER);
		btn2.setVerticalTextPosition(JButton.BOTTOM);
		btn2.setBackground(Color.white);
		
		ImageIcon Icon3= new ImageIcon("images/goobne.PNG");
		JButton btn3 =new JButton("굽네치킨",Icon3);
		p.add(btn3);
		btn3.setHorizontalTextPosition(JButton.CENTER);
		btn3.setVerticalTextPosition(JButton.BOTTOM);
		btn3.setBackground(Color.white);
		
		ImageIcon Icon4= new ImageIcon("images/gyochon.PNG");
		JButton btn4 =new JButton("교촌치킨",Icon4);
		p.add(btn4);
		btn4.setHorizontalTextPosition(JButton.CENTER);
		btn4.setVerticalTextPosition(JButton.BOTTOM);
		btn4.setBackground(Color.white);
		
		ImageIcon Icon5= new ImageIcon("images/burgerking.PNG");
		JButton btn5 =new JButton("버거킹",Icon5);
		p.add(btn5);
		btn5.setHorizontalTextPosition(JButton.CENTER);
		btn5.setVerticalTextPosition(JButton.BOTTOM);
		btn5.setBackground(Color.white);
		
		ImageIcon Icon6= new ImageIcon("images/moms.PNG");
		JButton btn6 =new JButton("맘스터치",Icon6);
		p.add(btn6);
		btn6.setHorizontalTextPosition(JButton.CENTER);
		btn6.setVerticalTextPosition(JButton.BOTTOM);
		btn6.setBackground(Color.white);
		
		ImageIcon Icon7= new ImageIcon("images/lotteria.PNG");
		JButton btn7 =new JButton("롯데리아",Icon7);
		p.add(btn7);
		btn7.setHorizontalTextPosition(JButton.CENTER);
		btn7.setVerticalTextPosition(JButton.BOTTOM);
		btn7.setBackground(Color.white);
		
		ImageIcon Icon8= new ImageIcon("images/pizzahut.PNG");
		JButton btn8 =new JButton("피자헛",Icon8);
		p.add(btn8);
		btn8.setHorizontalTextPosition(JButton.CENTER);
		btn8.setVerticalTextPosition(JButton.BOTTOM);
		btn8.setBackground(Color.white);
		
		ImageIcon Icon9= new ImageIcon("images/domino.PNG");
		JButton btn9 =new JButton("도미노피자",Icon9);
		p.add(btn9);
		btn9.setHorizontalTextPosition(JButton.CENTER);
		btn9.setVerticalTextPosition(JButton.BOTTOM);
		btn9.setBackground(Color.white);
		
		JButton btnb =new JButton("돌아가기");
		pn.add(btnb);
		btnb.setHorizontalAlignment(JButton.LEFT);
		btnb.setVerticalAlignment(JButton.BOTTOM);
		btnb.setBackground(Color.white);
		
		JLabel lb=new JLabel("피자,햄버거,치킨");
		pn.add(lb);
		pn.add(btnb,"EAST");
		
		
	}//생성자------

	

}