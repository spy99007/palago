package user;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class LoginFrame extends JFrame {

	JPanel p = new JPanel();
	JPanel pN,pC,pS;
	JButton btJoin,btFind,btLogin;
	JTextField tfId;
	JPasswordField tfPwd;
	public LoginFrame() {
		
		super("::LoginFrame::");
		
		
		p.setLayout(new BorderLayout());
		add(p);
		
		pC=new JPanel(new BorderLayout());
		pS=new JPanel();
		p.add(pC,"Center");
		p.add(pS,"South");
		JPanel p1=new JPanel();		
		pS.setBackground(Color.WHITE);
		pC.add(p1);		
		pS.setLayout(new GridLayout(1,3,10,10));
		p1.setLayout(null);
		
		tfId=new JTextField(20);
		tfPwd=new JPasswordField(20);
		
		p1.add(tfId);
		p1.add(tfPwd);
		tfId.setBounds(100,90,170,50);
		tfPwd.setBounds(100,180,170,50);
		p1.setBackground(Color.WHITE);		
		btJoin    = new JButton("회원가입");
		btFind    = new JButton("정보찾기");
		btLogin   = new JButton("로그인");
		
		pS.add(btJoin);
		pS.add(btFind);
		pS.add(btLogin);
		
		tfId.setBorder(new TitledBorder("아이디"));
		tfPwd.setBorder(new TitledBorder("비밀번호"));

		
		
		
		
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//생성자------
	
	
	 
	
	
	public static void main(String[] args) {
		LoginFrame my = new LoginFrame();
		my.setSize(400, 400);
		my.setVisible(true);
	}

}
