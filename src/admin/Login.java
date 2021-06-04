package admin;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;

import admin.Login;
import admin.MainPage;

public class Login extends JFrame {

	JPanel p = new JPanel();
	JPanel p1 = new JPanel();
	JTextField tfId;
	JPasswordField tfPwd;
	JButton btlogin;

	MainPage mainF;

	public Login() {
		super("::Login::");
		Container cp = this.getContentPane();
		cp.add(p, "Center");
		p.setBackground(Color.white);
		add(p);
		p1.setLayout(new GridLayout(0, 1, 10, 10));
		p.add(p1, "Center");

		tfId = new JTextField(20);
		tfPwd = new JPasswordField(20);
		btlogin = new JButton("Login");

		p1.add(tfId);
		p1.add(tfPwd);
		p1.add(btlogin);

		p1.setOpaque(false);
		TitledBorder tb1 = null, tb2 = null;
		tfId.setBorder(tb1 = new TitledBorder("ManagerID"));
		tfPwd.setBorder(tb2 = new TitledBorder("PassWord"));
		tfId.setOpaque(false);
		tfPwd.setOpaque(false);
		tb1.setTitleColor(Color.BLACK);
		tb2.setTitleColor(Color.black);

		btlogin.setBackground(new Color(50, 100, 170));
		btlogin.setForeground(Color.white);

		mainF = new MainPage(this);

		MyHandler handler = new MyHandler();
		btlogin.addActionListener(handler);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}// ������------

	class MyHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// setTitle("asd");
			Object o = e.getSource();
			if (o == btlogin) {// �α��δ����� â�Ѿ��
				loginCheck();
			}
		}
	}

	public void showMsg(String message) {
		JOptionPane.showMessageDialog(p1, message);
	}

	// ������ �α��� �޼ҵ�( id=admin, pw=admin)
	public void loginCheck() {
		String mid = tfId.getText();
		char[] ch = tfPwd.getPassword();
		String mpw = new String(ch);

		if (mid == null || mpw == null || mid.trim().equals("") || mpw.trim().equals("")) {
			showMsg("���̵�,��й�ȣ �Է��ϼ���!");
			return;

		}
		mid = mid.trim();
		mpw = mpw.trim();

		if (mid.equals("admin") && mpw.equals("admin")) {
			showMsg("�α��μ���!");
			mainF.pack();
			mainF.setVisible(true);
			this.dispose();
			return;
		} else {
			showMsg("Ʋ�Ƚ��ϴ�. �ٽ� �Է��ϼ���");

		}
	}////

	public static void main(String[] args) {
		Login my = new Login();
		my.setSize(400, 250);
		my.setVisible(true);
	}

}