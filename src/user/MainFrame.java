package user;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;




public class MainFrame extends JFrame {

	JPanel p = new JPanel(new BorderLayout());
	
	
	LoginFrame loginF;
	
	public MainFrame() {
		super("::MainFrame::");
		Container cp = this.getContentPane();
		cp.add(p, "Center");
		p.setBackground(Color.white);
		
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//생성자------

	public static void main(String[] args) {
		MainFrame my = new MainFrame();
		my.setSize(500, 500);
		my.setVisible(true);
	}

}