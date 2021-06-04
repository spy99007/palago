package user;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import common.Common;

public class JoinFrame extends JFrame {
	
	LoginFrame loginF;
	
	JPanel p = new JPanel();
	JPanel p2=new JPanel();
	
	
	JPanel pS = new JPanel();
	
	JTextField tfId,tfEmail,tfTel,tfNickName;
	JPasswordField tfPwd,tfPwd2;
	JButton btOverlap,btJoin,btReset,btCancel;
	
	Hashtable <String,Object> userTable =new Hashtable<>();
	
	ObjectOutputStream out;
	//ObjectInputStream in; 
	OutputStreamWriter outOut;
	
	FileOutputStream fout;
	//FileInputStream fin;
	
	
	public JoinFrame(LoginFrame lf) {
		super("::JoinFrame::");
		this.loginF=lf;
		Container cp = this.getContentPane();
		
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
		tfPwd2=new JPasswordField();
		
		
		btOverlap=new JButton("중복검사");
		p2.add(tfId);
		p2.add(btOverlap);
		p2.add(tfNickName);
		p2.add(tfPwd);
		p2.add(tfPwd2);
		p2.add(tfTel);
		p2.add(tfEmail);
		
		tfId.setBounds(125,50,200,40);
		btOverlap.setBounds(350,63,100,20);
		tfNickName.setBounds(125,100,200,40);
		tfPwd.setBounds(125,150,200,40);
		tfPwd2.setBounds(125,200,200,40);
		tfTel.setBounds(125,300,200,40);
		tfEmail.setBounds(125,350,200,40);
		
		
		tfId.setBorder(new TitledBorder("아이디"));
		tfNickName.setBorder(new TitledBorder("닉네임"));
		tfPwd.setBorder(new TitledBorder("비밀번호"));
		tfPwd2.setBorder(new TitledBorder("비밀번호확인"));
		tfTel.setBorder(new TitledBorder("전화번호"));
		tfEmail.setBorder(new TitledBorder("이메일"));
		
		
		btJoin     =new JButton("회원가입");
		btReset    =new JButton("다시쓰기");
		btCancel  =new JButton("취소");
		
		p2.add(btJoin);
		p2.add(btReset);
		p2.add(btCancel);
		
		btJoin.setBounds(80,490,100,40);
		btReset.setBounds(210,490,100,40);
		btCancel.setBounds(340,490,100,40);
		
		
		btReset.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				Reset(); 
			} });
		  //리셋버튼 이벤트처리
		
		btJoin.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				join();
				
			
			} 
		});
		
		btOverlap.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				if(tfId.getText().equals("")) {
					JOptionPane.showMessageDialog(p2, "아이디를 입력하세요.");
					return;
				}
				
				Boolean idCheckResult=idCheck(tfId.getText());
				
				if(!idCheckResult) {
					JOptionPane.showMessageDialog(p2, "이 아이디는 사용할 수 있습니다.");
				}else {
					JOptionPane.showMessageDialog(p2, "아이디가 중복됩니다.");
				}
				
			} });
		
		
		
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.dispose();
	}//생성자------
	
	//다시쓰기 
	public void Reset() {
		tfId.setText("");
		tfNickName.setText("");
		tfPwd.setText("");
		tfPwd2.setText("");
		tfTel.setText("");
		tfEmail.setText("");
		tfId.requestFocus();
	}
	//회원가입
	public void join() {
		
		String id=tfId.getText();
		String nickName=tfNickName.getText();
		
		char[] ch =tfPwd.getPassword();
		String pwd=new String(ch);
		char[] ch2=tfPwd2.getPassword();
		String pwd2=new String(ch2);
		
		if(!pwd.equals(pwd2)) {
			JOptionPane.showMessageDialog(p, "비밀번호가 일치하지않습니다");
			tfPwd.setText("");
			tfPwd2.setText("");
			return;
		}//비밀번호 체크 
		
		else {
		String tel = tfTel.getText();
		String email=tfEmail.getText();
		
		User user = new User(id, pwd, email, tel, nickName);
		
		userTable.put(id, user);
		
		Common com =Common.getCommon();
		com.saveFile("src/files/user.txt",userTable);
		
		setTitle("저장완료"+userTable.size()+"명");
		
		dispose();
		}
		
	}
	
	
	public boolean idCheck(String id) {
		Common com =Common.getCommon();
		Hashtable <String,Object> table=com.readFile("src/files/user.txt");
		System.out.println("table===="+table);
		return table.containsKey(id);
		
	}
	
	
	/*
	 * public static void main(String[] args) { JoinFrame my = new JoinFrame();
	 * my.setSize(500, 600); my.setVisible(true); }
	 */
}