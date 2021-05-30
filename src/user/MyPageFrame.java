package user;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;



public class MyPageFrame extends JFrame {

	JPanel p = new JPanel();
	JPanel p2=new JPanel();
	
	
	JPanel pS = new JPanel();
	
	JTextField tfId,tfEmail,tfTel,tfNickName;
	JPasswordField tfPwd;
	JButton btChgPwd;
	JoinFrame joinF;
	Hashtable <String,User> userTable = new Hashtable<>();
	ObjectInputStream in;
	FileInputStream fin;
	LoginFrame loginF;
	
	
	public MyPageFrame() {
		super("::MyPageFrame::");
		Container cp = this.getContentPane();
		
		readFile("src/files/user.txt");
		
		cp.add(p, "Center");
		p.setBackground(Color.white);
		p.setLayout(new BorderLayout());
		
				
		p.add(p2,"Center");
		p2.setLayout(null);
		p.add(pS,"South");
		/* pS.setLayout(new GridLayout(1,3,10,10)); */
		pS.setLayout(null);
		pS.setBackground(Color.RED);
		p2.setBackground(Color.WHITE);
		
		tfId=new JTextField();
		tfEmail=new JTextField();
		tfTel=new JTextField();
		tfNickName=new JTextField();
		tfPwd=new JPasswordField();
		btChgPwd=new JButton("비밀번호변경");
		
		p2.add(tfId);
		p2.add(tfNickName);
		p2.add(tfPwd);
		p2.add(tfTel);
		p2.add(tfEmail);
		p2.add(btChgPwd);
		tfId.setBounds(125,50,200,40);
		
		btChgPwd.setBounds(350,165,120,20);
		
		tfNickName.setBounds(125,100,200,40);
		tfPwd.setBounds(125,150,200,40);
		tfTel.setBounds(125,300,200,40);
		tfEmail.setBounds(125,350,200,40);
		
		
		tfId.setBorder(new TitledBorder("아이디"));
		tfNickName.setBorder(new TitledBorder("닉네임"));
		tfPwd.setBorder(new TitledBorder("비밀번호"));
		tfTel.setBorder(new TitledBorder("전화번호"));
		tfEmail.setBorder(new TitledBorder("이메일"));
		
		
		
		
		

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//생성자------
	
	public static void main(String[] args) {
		MyPageFrame my = new MyPageFrame();
		my.setSize(500, 600);
		my.setVisible(true);
	}
	
	/*마이페이지 회원정보를 불러오는 메소드*/
	public void readFile(String fileName) {
	   try {  
		   	fin = new FileInputStream(fileName);
		   	in = new ObjectInputStream(fin);
//		   	in.defaultReadObject();
		   	Object o = in.readObject();
		   	userTable = (Hashtable<String,User>)o;
		   	
		   	
		   	
		   	System.out.println(userTable.get("id"));
		   	
		   	
		   	
//		   	System.out.println(userTable);
		   	
		   	System.out.println(fileName+"로드되었습니다.");
		   	
//		   	//tfId.setText();
////		   	tfId.setText();
//		   	tfNickName.setText("");
//		   	char[] ch= tfPwd.getPassword();
//		   	String pwd=new String(ch);
//		   	tfPwd.setText(pwd);
//		   	tfTel.setText("");
//		   	tfEmail.setText("");
//		   	
		   	
	   	   }catch(Exception e) {
	   		   System.out.println("파일 불러오는 중 오류 "+e.getMessage());
	   		   e.printStackTrace();
	   	   }
	   	
	   	   
	   
	   		
	     
	     
	}
	
	
	
	

}