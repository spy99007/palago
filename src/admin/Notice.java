package admin;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;




public class Notice extends JPanel {

	JPanel p = new JPanel(new BorderLayout());
	JPanel p1=new JPanel(new GridLayout(1,0,10,10));
	JPanel p2=new JPanel();
	
	
	
	JButton bt1, bt2; //bt1 글쓰기 bt2 삭제
	MainPage mainF;
	
	CardLayout card2;
	NoticeWrite nwrite;
	
	
	public Notice(MainPage frame) {
		this.mainF=frame;
		
		p.setBackground(Color.white);
		add(p);
		p.add(p1,"North");
		p.add(p2,"Center");
		p2.setBackground(Color.white);
		
		
		bt1=new JButton("글쓰기");
		bt2=new JButton("삭제");
		
		p1.add(bt1);
		p1.add(bt2);
	
		p2.setLayout(card2=new CardLayout());
		nwrite=new NoticeWrite(this);
		p2.add("None",new JPanel());
		p2.add("Write", nwrite);
		
		
		Handelr2 hand=new Handelr2();
		bt1.addActionListener(hand);
		
		
		
	
	}//생성자------

	
	class Handelr2 implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			//setTitle("As");
			Object o=e.getSource();
			if(o==bt1) {
				card2.show(p2, "Write");
			}
			
		}
		
		
	}
	

}

