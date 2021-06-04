package user;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import common.Common;
import product.MainA;



public class MyPageFrame extends JFrame {

	JPanel p = new JPanel();
	JPanel p2=new JPanel();
	
	
	JPanel pS = new JPanel();
	
	public JTextField tfId,tfEmail,tfTel,tfNickName;
	public JPasswordField tfPwd;
	public JButton btChgPwd;
	public JButton btDelete;
	public JoinFrame joinF;
	ObjectInputStream in;
	FileInputStream fin;
	LoginFrame lgF;
	MainA ma;
	
	String id;
	
	Common com;
	Hashtable <String,Object> userTable;
	
	
	public MainA getMainA() {
		return ma;
	}
	
	public void setMainA(MainA ma) {
		this.ma =ma;
	}
	
	
	public MyPageFrame(MainA ma) { 
		//super("::MyPageFrame::");
		
		Container cp = this.getContentPane();
		
		
		String id = this.id;
		
		
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
		btChgPwd=new JButton("��й�ȣ����");
		btDelete=new JButton("ȸ��Ż��");
		
		p2.add(tfId);
		p2.add(tfNickName);
		p2.add(tfPwd);
		p2.add(tfTel);
		p2.add(tfEmail);
		p2.add(btChgPwd);
		p2.add(btDelete);
		tfId.setBounds(125,50,200,40);
		
		btChgPwd.setBounds(350,165,120,20);
		btDelete.setBounds(170,350,100,20);
		
		tfNickName.setBounds(125,100,200,40);
		tfPwd.setBounds(125,150,200,40);
		tfTel.setBounds(125,200,200,40);
		tfEmail.setBounds(125,250,200,40);
		
		
		
		
		tfId.setBorder(new TitledBorder("���̵�"));
		tfNickName.setBorder(new TitledBorder("�г���"));
		tfPwd.setBorder(new TitledBorder("��й�ȣ"));
		tfTel.setBorder(new TitledBorder("��ȭ��ȣ"));
		tfEmail.setBorder(new TitledBorder("�̸���"));
		
		//lgF=new LoginFrame();
		this.ma=ma;
		

		btChgPwd.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				Object obj = e.getSource();
				if(obj==btChgPwd) {
					changePwd();
					JOptionPane.showMessageDialog(p2,"��й�ȣ���� ����!.");
					dispose();
					return;
				}
			} 
		});
		
		btDelete.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				Object obj = e.getSource();
				if(obj==btDelete) {
					deleteUser();
					JOptionPane.showMessageDialog(p2,"ȸ��Ż�� �����Ͽ����ϴ�.");
					
					return;
				}
			} 
		});
		
		
		dispose();
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//������------
	
	public static void main(String[] args) {
		//MyPageFrame my = new MyPageFrame();
		//my.setSize(500, 600);
		//my.setVisible(true);
	}
	
	public void changePwd() {
		String id =tfId.getText();
		String email=tfEmail.getText();
		String NickNameString=tfNickName.getText();
		String Tel = tfTel.getText();
		
		User user= ma.getCom().getUser(id);
		System.out.println("user.id"+user.getId());
		System.out.println("user.email"+user.getEmail());
		char[] ch=tfPwd.getPassword();
		String pwd =new String(ch);
		user.setPwd(pwd);
		this.userTable=ma.getLgF().joinF.userTable;
		this.userTable.put(id, user);
		System.out.println("ma.getLgF().joinF.userTable.size(): "+ma.getLgF().joinF.userTable.size());
		ma.getCom().saveFile("src/files/user.txt", userTable);
		
	}
	
	public void deleteUser() {
		
		String id= tfId.getText();
		
		User user= ma.getCom().getUser(id);
		
		this.userTable=ma.getLgF().joinF.userTable;
		System.out.println(this.userTable);
		this.userTable.remove(id);
		ma.getCom().saveFile("src/files/user.txt", userTable);
		
		
	}
	public void setId(String id) {
		this.id =id;
	}
	
}