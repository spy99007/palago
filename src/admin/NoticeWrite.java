package admin;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class NoticeWrite extends JPanel {

	JPanel p = new JPanel();
	JPanel p1= new JPanel(new BorderLayout());
	JPanel p2= new JPanel(new GridLayout(1,0,20,40));
	JTextField tf;
	JTextArea ta;
	JButton bt1, bt2;
	
	Notice noti;

	public NoticeWrite(Notice frame) {
		this.noti=frame;
		p.setBackground(Color.white);
		add(p);
		p.add(p1,"Center");
		p1.add(p2,"South");
		tf=new JTextField(30);
		ta=new JTextArea(10,10);
		bt1=new JButton("완료");
		bt2=new JButton("초기화");
		p1.add(tf,"North");
		p1.add(ta,"Center");
		p2.add(bt1,"South");
		p2.add(bt2,"South");
		
		ta.setBorder(new LineBorder(Color.black));
		
		
		

	}//생성자------

	
	
	public class Hanlder implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			Object o=e.getSource();
			if(o==bt1) {
				
			}
		}
		
	}
	
	
	public Insets getInsets() {
		return new Insets(45,25,25,25);
	}

	/*public static void main(String[] args) {
		NoticeWrite my = new NoticeWrite();
		my.setSize(500, 500);
		my.setVisible(true);
	}*/

}
