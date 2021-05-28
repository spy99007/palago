package product;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonCoffee extends JFrame {

	JPanel p = new JPanel();
	JPanel pn = new JPanel();


	public ButtonCoffee() {
		super("::ButtonCoffee::");
		Container cp = this.getContentPane();
		cp.add(p, "Center");
		cp.add(pn,"North");
		p.setBackground(Color.white);
		p.setLayout(new GridLayout(2,3,5,5));
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		ImageIcon Icon1= new ImageIcon("images/starbucks.PNG");
		JButton btn1 =new JButton("스타벅스",Icon1);
		p.add(btn1);
		btn1.setHorizontalTextPosition(JButton.CENTER);
		btn1.setVerticalTextPosition(JButton.BOTTOM);
		
		ImageIcon Icon2= new ImageIcon("images/twosome.PNG");
		JButton btn2 =new JButton("투썸플레이스",Icon2);
		p.add(btn2);
		btn2.setHorizontalTextPosition(JButton.CENTER);
		btn2.setVerticalTextPosition(JButton.BOTTOM);
		
		ImageIcon Icon3= new ImageIcon("images/ediya.PNG");
		JButton btn3 =new JButton("이디야",Icon3);
		p.add(btn3);
		btn3.setHorizontalTextPosition(JButton.CENTER);
		btn3.setVerticalTextPosition(JButton.BOTTOM);
		
		ImageIcon Icon4= new ImageIcon("images/hollys.PNG");
		JButton btn4 =new JButton("할리스",Icon4);
		p.add(btn4);
		btn4.setHorizontalTextPosition(JButton.CENTER);
		btn4.setVerticalTextPosition(JButton.BOTTOM);
		
		ImageIcon Icon5= new ImageIcon("images/pull.PNG");
		JButton btn5 =new JButton("풀바셋",Icon5);
		p.add(btn5);
		btn5.setHorizontalTextPosition(JButton.CENTER);
		btn5.setVerticalTextPosition(JButton.BOTTOM);
		
		
		ImageIcon Icon6= new ImageIcon("images/tom.PNG");
		JButton btn6 =new JButton("탐앤탐스",Icon6);
		p.add(btn6);
		btn6.setHorizontalTextPosition(JButton.CENTER);
		btn6.setVerticalTextPosition(JButton.BOTTOM);
		
		
		JButton btnb =new JButton("돌아가기");
		pn.add(btnb);
		btnb.setHorizontalAlignment(JButton.LEFT);
		btnb.setVerticalAlignment(JButton.BOTTOM);
		
		JLabel lb=new JLabel("카페");
		pn.add(lb);
		
	}//생성자------

	public static void main(String[] args) {
		ButtonCoffee my = new ButtonCoffee();
		my.setSize(500, 500);
		my.setVisible(true);
	}

}