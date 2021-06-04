package admin;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;




public class NoticeSee extends JFrame {

	JPanel p = new JPanel(new BorderLayout());
	JPanel p1 = new JPanel();
	JTextArea ta = new JTextArea();
	JButton bt= new JButton("확인");
	
	Notice notice;
	NoticeWrite noticeWrite;
	WriteMessage writeM;
	
	
	public NoticeSee(Notice notice) {
		super("::NoticeSee::");
		
		this.notice=notice;
		
		Container cp = this.getContentPane();
		cp.add(p, "Center");
		p.setBackground(Color.white);

		p.add(ta, "Center");
		
		p.add(bt,"South");
		
		bt.setBackground(new Color(50, 100, 170));
		bt.setForeground(Color.white);
		
		
		
		Handler hand=new Handler();
		bt.addActionListener(hand);
		

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
			}
		});

	}// 생성자------
	class Handler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Object o=e.getSource();
			if(o==bt) {
				dispose();
			}
	
		}
	}

	@Override
	public Insets getInsets() {
		return new Insets(40, 20, 40, 20);
	}

	/*public static void main(String[] args) {
		NoticeSee my = new NoticeSee();
		my.setSize(500, 500);
		my.setVisible(true);
	}*/

}
