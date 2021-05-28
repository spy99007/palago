package admin;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Post extends JPanel{
	
	JPanel p = new JPanel();
	JPanel p1= new JPanel(new GridLayout(1,0,10,10));
	JTextArea ta1;
	MainPage mainF;
	
	public Post(MainPage frame) {
		MainPage mainF=frame;
		p.setLayout(new BorderLayout());
		p.setBackground(Color.white);
		add(p);
		ta1=new JTextArea(20,20);
		p.add(ta1);
		p.add(p1,"South");
		
		
		

		
	}//생성자------



}
