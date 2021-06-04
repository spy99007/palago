package user;


import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import common.Common;

public class FindPassword extends JFrame {
	
	
	JPanel p =new JPanel();
	JTextField tfEmail =new JTextField();
	JTextField tfId=new JTextField(20);
	JPasswordField tfPwd=new JPasswordField(20);
	JButton btEmailCheck;
	Common com =Common.getCommon();
	
	public FindPassword() {
		super("::FindPassword::");
		
		Container cp = this.getContentPane();
		add(p);
		
		p.setLayout(null);
		p.setBackground(Color.WHITE);
		//JTextField tfEmail = new JTextField(20);
		JButton btEmailCheck =new JButton("�̸���üũ");
		
		
		p.add(tfEmail);
		tfEmail.setBounds(90,100, 200, 50);
		p.add(btEmailCheck);
		btEmailCheck.setBounds(300,115,100, 28);
		
		/*
		 * p.add(tfId); p.add(tfPwd);
		 */
		
		/*
		 * tfId.setBounds(90,200,200,50); tfPwd.setBounds(90,250,200,50);
		 */
		
		tfEmail.setBorder(new TitledBorder("�̸����Է�"));
		/*
		 * tfId.setBorder(new TitledBorder("���̵�")); tfPwd.setBorder(new
		 * TitledBorder("��й�ȣ"));
		 */
		
		
		btEmailCheck.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				emailCheck();
				
				
			} });
		
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//������------
	
	public void emailCheck() {
		 //System.out.println("ddddd");
		String email= tfEmail.getText();
		System.out.println("email="+email);
		 
		
		if(email==null||email.trim().equals("")) {
		 JOptionPane.showMessageDialog(p,"�̸����� �Է��ϼ���"); return; } 
		email=email.trim();
		 
		 User user=com.getUserInfo(email);
		 
		 if(user==null) {
			 JOptionPane.showMessageDialog(p, "�ش��ϴ� �̸����� �����ϴ�.");
			 return;
		 }
		 if (user!=null) {
			 //System.out.println("user.getId= "+user.getId());
			 //System.out.println("user.getEmail()= "+user.getEmail());
			 String pwd=user.getPwd();
			 String id = user.getId();
			 JOptionPane.showMessageDialog(p, "���̵�="+id+"\n"+"��й�ȣ="+pwd+"\n"+"�Դϴ�");
			 dispose();
		 }
	}
	
	public static void main(String[] args) {
		//FindPassword fp = new FindPassword();
		//fp.setSize(500, 500);
		//fp.setVisible(true);
	}

}
