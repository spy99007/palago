package admin;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyPage extends JPanel {

	JPanel p = new JPanel();
	JPasswordField pw1, pw2, pw3;
	JButton bt1;
	MainPage mainF;

	public MyPage(MainPage frame) {
		this.mainF=frame;
		add(p);
		p.setLayout(new GridLayout(0,1,10,10));
		
		pw1=new JPasswordField(15);
		pw2=new JPasswordField(15);
		p.add(pw1);
		p.add(pw2);
		
		bt1=new JButton("변경하기");		
			
		p.add(bt1);
		
	}//생성자------
	
	
	
	



}