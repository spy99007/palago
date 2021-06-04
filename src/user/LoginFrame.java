package user;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
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
import user.User;
public class LoginFrame extends JFrame {

	JPanel p = new JPanel();
	JPanel pN,pC,pS;
	JButton btJoin,btFind,btLogin;
	JTextField tfId;
	JPasswordField tfPwd;
	JoinFrame joinF;
	MainA mainF; 
	FindPassword fp;
	Common com;
	
	
	
	public LoginFrame() {
		
		super("::LoginFrame::");
		mainF =new MainA(this);
		FindPassword fp= new FindPassword();
		
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
		btJoin    = new JButton("ȸ������");
		btFind    = new JButton("����ã��");
		btLogin   = new JButton("�α���");
		
		pS.add(btJoin);
		pS.add(btFind);
		pS.add(btLogin);
		
		tfId.setBorder(new TitledBorder("���̵�"));
		tfPwd.setBorder(new TitledBorder("��й�ȣ"));
		
		joinF=new JoinFrame(this);
		com=Common.getCommon();
		//�α��ι�ư
		btLogin.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				login();
				/*if(obj==btLogin) {
					main.pack();
					main.setSize(500,500);
					main.setVisible(true);
					
					main.setTitle(tfId.getText()+"�� �������Դϴ�.");
					//�α����Ѿ��̵� �޾ƿͼ� main�������� ������ �Ѹ��� 
					dispose();
				
				}*///�α��� ��ư
			}	
		});
		//ȸ�����Թ�ư
		btJoin.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				Object obj = e.getSource();
				
				if(obj==btJoin) {
					joinF.pack();
					joinF.setSize(500, 600);
					joinF.setVisible(true);
				}
			} 
		});
		//�̸��Ϸ� ���̵� �� ��й�ȣ ã�� ��ư 
		btFind.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				Object obj = e.getSource();
				
				if(obj==btFind) {
					fp.pack();
					fp.setSize(500,500);
					fp.setVisible(true);
					
				}
			} 
		});
		
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//������------
	
	//�α��� �޼ҵ�
	 public void login() {
		 String id = tfId.getText();
		 char[] ch = tfPwd.getPassword();
		 String pwd =new String(ch);
		 
		 if(id==null||pwd==null||id.trim().equals("")||pwd.trim().equals("")) {
			 JOptionPane.showMessageDialog(pC,"���̵� �Է·��ϼ���");
			 return;
		 }
		 id=id.trim();
		 pwd=pwd.trim();
		 
		 //nullüũ 
		 
		 
		 
		 User user=com.getUser(id);
		 //������ü��������
		 
		 if(user==null) {
			 JOptionPane.showMessageDialog(pC,"�ش��ϴ� ���̵� �����ϴ�.");
			 return;
		 }
		 if(user!=null) {
			 	System.out.println(pwd);
			 	System.out.println(user.getPwd());
			 if(!pwd.equals(user.getPwd())) {
				 JOptionPane.showMessageDialog(pC,"��й�ȣ�� Ʋ���ϴ�.");
				 return;
			 }
		 }
		 
		 JOptionPane.showMessageDialog(pC,"�α��� �Ǿ����ϴ�.");
		 
			this.setTitle(id);
			System.out.println("here>>>>"+id);
			  
				
			
			
			 
			 
			   
			  //MainA mainF= new MainA(this);
			  //JFrame jf=new JFrame();
			  
				/*
				 * jf.getContentPane().add(mainF); jf.setSize(500, 500); jf.setVisible(true);
				 */
				
			 mainF.setSize(500,500); mainF.setVisible(true);
			  mainF.setTitle(tfId.getText()); //�α����Ѿ��̵� �޾ƿͼ� main�������� ������ �Ѹ���
			 mainF.setId(tfId.getText());
			  
			  
			  dispose();
	 }
	
	
	public static void main(String[] args) {
		LoginFrame my = new LoginFrame();
		my.setSize(400, 400);
		my.setVisible(true);
	}

}
