package product;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ButtonStarbucks extends JPanel {

	JPanel p = new JPanel();
	JPanel pn = new JPanel();
	MainA ma;
	ButtonCoffee bcoffee;
	ButtonStarbucks bstar; 
	
	
	JScrollPane jp = new JScrollPane(p);
	

	JButton btn1,btn2,btn3,btn4,btn5;
	    public ButtonStarbucks(MainA ma) {
		this.ma=ma;
		Container cp = this;
		cp.setLayout(new BorderLayout());
		cp.add(jp, "Center");
		cp.add(pn,"North");
		p.setBackground(Color.white);
		p.setLayout(new GridLayout(0,1,5,5));

		
		
		
		ImageIcon Icon1= new ImageIcon("images/자바칩.PNG");
		btn1 =new JButton(Icon1);
		p.add(btn1);
		btn1.setHorizontalAlignment(JButton.LEFT);
		btn1.setBackground(Color.white);
		
		ImageIcon Icon2= new ImageIcon("images/카라멜.PNG");
		btn2 =new JButton(Icon2);
		p.add(btn2);
		btn2.setHorizontalAlignment(JButton.LEFT);
		btn2.setBackground(Color.white);
		
		ImageIcon Icon3= new ImageIcon("images/카페모카.PNG");
		btn3 =new JButton(Icon3);
		p.add(btn3);
		btn3.setHorizontalAlignment(JButton.LEFT);
		btn3.setBackground(Color.white);
		
		ImageIcon Icon4= new ImageIcon("images/아메리카노.PNG");
		btn4 =new JButton(Icon4);
		p.add(btn4);
		btn4.setHorizontalAlignment(JButton.LEFT);
		btn4.setBackground(Color.white);
		
		ImageIcon Icon5= new ImageIcon("images/카페라떼.PNG");
		btn5 =new JButton(Icon5);
		p.add(btn5);
		btn5.setHorizontalAlignment(JButton.LEFT);
		btn5.setBackground(Color.white);
		
		
		
		
		
	}//생성자------

	

}