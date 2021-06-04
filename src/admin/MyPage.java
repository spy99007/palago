package admin;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyPage extends JPanel {

	JPanel p = new JPanel();
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel(new GridLayout(1, 0, 10, 10));
	JPanel p3 = new JPanel(new GridLayout(1, 0, 10, 10));
	JPasswordField pw1, pw2, pw3;
	JLabel lb1, lb2;
	JButton bt1, bt2;
	MainPage mainF;

	public MyPage(MainPage frame) {
		this.mainF = frame;
		
		add(p);
		//p.setBackground(Color.white);
		//p1.setBackground(Color.white);
		//p2.setBackground(Color.white);
		//p3.setBackground(Color.white);
		p.setLayout(new BorderLayout());

		p.add(p2, "North");
		p.add(p3, "Center");

		lb1 = new JLabel("���� ��й�ȣ");
		lb2 = new JLabel("�� ��й�ȣ");

		pw1 = new JPasswordField(15);
		pw2 = new JPasswordField(15);

		bt1 = new JButton("��й�ȣ Ȯ��");
		bt2 = new JButton("�����ϱ�");

		p2.add(lb1);
		p2.add(pw1);
		p2.add(bt1);

		p3.add(lb2);
		p3.add(pw2);
		p3.add(bt2);
		
		bt1.setBackground(new Color(50, 100, 170));
		bt1.setForeground(Color.white);
		bt2.setBackground(new Color(50, 100, 170));
		bt2.setForeground(Color.white);

		Handler hand = new Handler();
		bt1.addActionListener(hand);
		bt2.addActionListener(hand);

	}// ������------

	// �н�����üũ �ڵ鷯
	class Handler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Object o = e.getSource();
			if (o == bt1) {
				pwCheck();
			} else if (o == bt2) {
				mainF.setTitle("Asd");
				pwChange();
			}
		}
	}

	// ��к�ȣ ���� ������ ��й�ȣ Ȯ��
	public void pwCheck() {
		char[] ch1 = pw1.getPassword();
		char[] ch2 = pw2.getPassword();
		String mpw1 = new String(ch1);
		String mpw2 = new String(ch2);
		if (mpw1 == null || mpw1.trim().equals("")) {
			JOptionPane.showMessageDialog(p, "��й�ȣ�� �Է��ϼ���");
			pw1.setText("");
			pw1.requestFocus();
			return;
		} else if (!mpw1.equals("admin")) {
			JOptionPane.showMessageDialog(p, "��й�ȣ�� ��ġ�����ʽ��ϴ�.");
			pw1.setText("");
			pw1.requestFocus();
			this.bt2.setEnabled(false);
			return;
		} else if (mpw1.equals("admin")) {
			JOptionPane.showMessageDialog(p, "������ ��й�ȣ �Է����ּ���.");
			pw2.setText("");
			pw2.requestFocus();
			this.bt2.setEnabled(true);

		}

	}

	public void pwChange() {
		char[] ch2 = pw2.getPassword();
		String mpw2 = new String(ch2);
		pw2.setText("");
		if (mpw2 == null || mpw2.trim().equals("")) {
			JOptionPane.showMessageDialog(p, "������ ��й�ȣ�� �Է��ϼ���.");
			return;
		} else if (mpw2 != "") {
			JOptionPane.showMessageDialog(p, "����Ǿ����ϴ�.");
			mainF.card.show(mainF.pC, "noP");
		}

	}
}