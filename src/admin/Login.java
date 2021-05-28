package admin;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.border.*;

public class Login extends JFrame {

	JPanel p = new JPanel();
	JPanel p1=new JPanel();
	JTextField tfId;
	JPasswordField tfPwd;
	JButton bt;
	
	MainPage mainF;

	
	public Login() {
		super("::Login::");
		Container cp = this.getContentPane();
		cp.add(p, "Center");
		p.setBackground(new Color(255,255,240));
		add(p);
		p1.setLayout(new GridLayout(0,1,10,10));
		p.add(p1,"Center");
		
		tfId=new JTextField(20);
		tfPwd=new JPasswordField(20);
		bt=new JButton("Login");
		
		p1.add(tfId);
		p1.add(tfPwd);
		p1.add(bt);
		
		p1.setOpaque(false);
		TitledBorder tb1=null, tb2=null;
		tfId.setBorder(tb1=new TitledBorder("관리자 ID"));
		tfPwd.setBorder(tb2=new TitledBorder("PassWord"));
		tfId.setOpaque(false);
		tfPwd.setOpaque(false);
		tb1.setTitleColor(Color.BLACK);
		tb2.setTitleColor(Color.black);
		
		bt.setBackground(new Color(50,100,170));
		bt.setForeground(Color.white);
		
		mainF=new MainPage(this);
		
		MyHandler handler=new MyHandler();
		bt.addActionListener(handler);
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//생성자------
	class MyHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			//setTitle("asd");
			Object o=e.getSource();
			if(o==bt) {//로그인버튼누르면 창넘어가게
				loginCheck();	 
			}
		}	
	}
	public void showMsg(String message) {
		JOptionPane.showMessageDialog(p1, message);
	}
		
	
	
	//로그인 처리(관리자 id=admin, pw=admin)
	public void loginCheck() {
		String mid=tfId.getText();	
		char[] ch=tfPwd.getPassword();
		String mpw=new String(ch);
		mid=mid.trim();	
		mpw=mpw.trim();
		
		if(mid==null || mpw==null || mid.trim().equals("") || mpw.trim().equals("")) {
			showMsg("아이디, 비밀번호 입력하세요.!!");
			return;
		}
		
		
		if(mid.equals("admin") && mpw.equals("admin")) {
			showMsg("로그인 성공!");
			 mainF.pack();
	         mainF.setVisible(true);  
	         this.dispose();
			return;   
		}else {
			showMsg("아이디,비밀번호가 틀립니다.");
		}
			
}////
	
	public static void main(String[] args) {
		Login my = new Login();
		my.setSize(400, 250);
		my.setVisible(true);
	}

}
