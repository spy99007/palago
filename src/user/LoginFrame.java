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
	JoinFrame joinF;
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

		btLogin.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				
			
			} 
		});
		
		btJoin.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				Object obj = e.getSource();
				JoinFrame joinF = new JoinFrame();
				if(obj==btJoin) {
					joinF.pack();
					joinF.setSize(500, 600);
					joinF.setVisible(true);
				}
			} 
		});
		
		
		
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//생성자------
	
	
	 public void login() {
		 String id = tfId.getText();
		 char[] ch = tfPwd.getPassword();
		 String pwd =new String(ch);
		 
		 if(id==null||pwd==null||id.trim().equals("")||pwd.trim().equals("")) {
			 JOptionPane.showMessageDialog(pC,"아이디를 입력력하세요");
			 return;
		 }
		 id=id.trim();
		 pwd=pwd.trim();
		 
		 //null체크 
		 
		 boolean isExist = joinF.userTable.containsKey(id);
		 
		 if(!isExist) {
			 JOptionPane.showMessageDialog(pC,"해당하는 아이디가 없습니다.");
			 tfId.setText("");
			 tfPwd.setText("");
			 tfId.requestFocus();
			 return;
		 }//아이디 체크
		 
		 User tmpUser = joinF.userTable.get(id);
		 String tmpPwd= tmpUser.getPwd();
		 if(!pwd.equals(tmpPwd)) {
			 JOptionPane.showMessageDialog(pC,"비밀번호가 틀렸습니다.");
			 tfId.setText("");
			 tfPwd.setText("");
			 tfId.requestFocus();
			 return;
		 }
		 
		 JOptionPane.showMessageDialog(pC,"로그인 되었습니다.");
		 
		 
		 
	 }
	
	
	public static void main(String[] args) {
		LoginFrame my = new LoginFrame();
		my.setSize(400, 400);
		my.setVisible(true);
	}

}
