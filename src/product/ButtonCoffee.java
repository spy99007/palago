package product;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonCoffee extends JPanel {

	JPanel p = new JPanel();
	JPanel pn = new JPanel();
	MainA ma;
	JButton btnb;
	JButton btn1, btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
	public ButtonCoffee(MainA ma) {
		this.ma=ma;
		
		Container cp = this;
		cp.setLayout(new BorderLayout());
		cp.add(p, "Center");
		cp.add(pn,"North");
		p.setBackground(Color.white);
		p.setLayout(new GridLayout(3,3,5,5));
		
		  
		
		ImageIcon Icon1= new ImageIcon("images/starbucks.PNG");
		 btn1 =new JButton("스타벅스",Icon1);
		p.add(btn1);
		btn1.setHorizontalTextPosition(JButton.CENTER);
		btn1.setVerticalTextPosition(JButton.BOTTOM);
		btn1.setBackground(Color.white);
		
		ImageIcon Icon2= new ImageIcon("images/twosome.PNG");
		 btn2 =new JButton("투썸플레이스",Icon2);
		p.add(btn2);
		btn2.setHorizontalTextPosition(JButton.CENTER);
		btn2.setVerticalTextPosition(JButton.BOTTOM);
		btn2.setBackground(Color.white);
		
		ImageIcon Icon3= new ImageIcon("images/ediya.PNG");
		 btn3 =new JButton("이디야",Icon3);
		p.add(btn3);
		btn3.setHorizontalTextPosition(JButton.CENTER);
		btn3.setVerticalTextPosition(JButton.BOTTOM);
		btn3.setBackground(Color.white);
		
		ImageIcon Icon4= new ImageIcon("images/hollys.PNG");
		 btn4 =new JButton("할리스",Icon4);
		p.add(btn4);
		btn4.setHorizontalTextPosition(JButton.CENTER);
		btn4.setVerticalTextPosition(JButton.BOTTOM);
		btn4.setBackground(Color.white);
		
		ImageIcon Icon5= new ImageIcon("images/pull.PNG");
		 btn5 =new JButton("풀바셋",Icon5);
		p.add(btn5);
		btn5.setHorizontalTextPosition(JButton.CENTER);
		btn5.setVerticalTextPosition(JButton.BOTTOM);
		btn5.setBackground(Color.white);
		
		ImageIcon Icon6= new ImageIcon("images/tom.PNG");
		 btn6 =new JButton("탐앤탐스",Icon6);
		p.add(btn6);
		btn6.setHorizontalTextPosition(JButton.CENTER);
		btn6.setVerticalTextPosition(JButton.BOTTOM);
		btn6.setBackground(Color.white);
		
		ImageIcon Icon7= new ImageIcon("images/gong.PNG");
		btn7 =new JButton("공차",Icon7);
		p.add(btn7);
		btn7.setHorizontalTextPosition(JButton.CENTER);
		btn7.setVerticalTextPosition(JButton.BOTTOM);
		btn7.setBackground(Color.white);
		
		ImageIcon Icon8= new ImageIcon("images/angel.PNG");
		btn8 =new JButton("엔제리너스",Icon8);
		p.add(btn8);
		btn8.setHorizontalTextPosition(JButton.CENTER);
		btn8.setVerticalTextPosition(JButton.BOTTOM);
		btn8.setBackground(Color.white);
		
		ImageIcon Icon9= new ImageIcon("images/pas.PNG");
		btn9 =new JButton("파스쿠찌",Icon9);
		p.add(btn9);
		btn9.setHorizontalTextPosition(JButton.CENTER);
		btn9.setVerticalTextPosition(JButton.BOTTOM);
		btn9.setBackground(Color.white);
		
		btnb =new JButton("돌아가기");
		
		EventHendler eh=new EventHendler();
		
		btn1.addActionListener(eh);
		btnb.addActionListener(eh);
		
		pn.add(btnb);
		btnb.setHorizontalAlignment(JButton.LEFT);
		btnb.setVerticalAlignment(JButton.BOTTOM);
		
		btnb.setBackground(Color.white);
		JLabel lb=new JLabel("카페");
		pn.add(lb);
		btnb.setBackground(Color.white);
		pn.add(btnb,"EAST");
		
	}//생성자------

	/*
	 * public static void main(String[] args) { ButtonCoffee my = new
	 * ButtonCoffee(); my.setSize(500, 500); my.setVisible(true); }
	 */
	
	
class EventHendler implements ActionListener{
		

		@Override
		public void actionPerformed(ActionEvent e) {
			Object o=e.getSource();
			/*if(o==btnb) {
				ma.card.show(ma, "mainP");
			}else if(o==btn1) {
				ma.card.show(ma, "star");
			}*/
			
			
		}
		
	}

}