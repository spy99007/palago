package admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class NoticeWrite extends JFrame {

	JPanel p = new JPanel(new BorderLayout());
	JPanel p1 = new JPanel(new GridLayout(0, 1, 20, 20));
	JPanel p2 = new JPanel(new GridLayout(1, 2, 20, 40));
	JPanel p3 = new JPanel(new GridLayout(0, 1, 20, 20));

	JTextField tfTitle, tfName, tfregDate;
	JTextArea taText;

	JButton btEnroll, btCancel;
	JLabel lbTitle, lbText, lbName, lbRegDate;

	
	Notice notice;

	public NoticeWrite(Notice notice ) {
		super("�����ۼ�");
		this.notice=notice;
		Container cp = this.getContentPane();
		cp.add(p, "Center");
		p.setBackground(Color.white);
		p2.setBackground(Color.white);
		p3.setBackground(Color.white);

		add(p);
		p.add(p1, "Center");
		p.add(p2, "South");
		p.add(p3, "North");

		tfTitle = new JTextField(30); // ����
		tfName = new JTextField(5); // �ۼ���
		tfregDate = new JTextField(8); // �ۼ���
		taText = new JTextArea(10, 10);//����
		btEnroll = new JButton("���");
		btCancel = new JButton("���");

		lbTitle = new JLabel("����");
		lbName = new JLabel("�ۼ���");
		lbRegDate = new JLabel("�ۼ���");
		lbText = new JLabel("����");
		
		JScrollPane scroll= new JScrollPane(taText);

		p3.add(tfTitle);
		p3.add(tfName);
		p3.add(tfregDate);
		p1.add(scroll);
		p2.add(btEnroll, "South");
		p2.add(btCancel, "South");
		
		scroll.getViewport().setBackground(Color.white);
		
		btEnroll.setBackground(new Color(50,100,170));
		btEnroll.setForeground(Color.white);
		btCancel.setBackground(Color.DARK_GRAY);
		btCancel.setForeground(Color.white);
		

		p1.setOpaque(false);

		TitledBorder tb1 = null, tb2 = null, tb3 = null, tb4 = null;
		tfTitle.setBorder(tb1 = new TitledBorder("����"));
		tfName.setBorder(tb2 = new TitledBorder("�ۼ���"));
		tfregDate.setBorder(tb3 = new TitledBorder("�ۼ���"));
		taText.setBorder(tb4 = new TitledBorder("����"));
		tfTitle.setOpaque(false);
		tfName.setOpaque(false);
		tfregDate.setOpaque(false);
		taText.setOpaque(false);
		tb1.setTitleColor(Color.BLACK);
		tb2.setTitleColor(Color.black);
		tb3.setTitleColor(Color.black);
		tb4.setTitleColor(Color.black);

		Hanlder hand = new Hanlder();
		btEnroll.addActionListener(hand);
		btCancel.addActionListener(hand);
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				//noticeTable �ҷ��ͼ� �����ֱ�
				notice.readFile("src/admin/notice.txt");
				notice.showNoticeTable();
				notice.table.updateUI();
				dispose();
			}
		});

	}// ------------------

	class Hanlder implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			Object o = e.getSource();
			if (o == btEnroll) {
				enrollCheck();	
				clearInput();
			} else if (o == btCancel) {
				dispose();
			}
		}
	
	}

	// ��Ϲ�ư �޼ҵ�
	public void inputTable() {
		String title = tfTitle.getText();
		String name = tfName.getText();
		String regDate = tfregDate.getText();
		String text = taText.getText();

		WriteMessage write = new WriteMessage(title, text, name, regDate);
		notice.noticeTable.put(title, write);
		System.out.println(notice.noticeTable);
		setTitle("�Խñ� ��� �Ϸ�! ���� �Խñ� ��: " + notice.noticeTable.size() + "��");
		//��������
		notice.saveFile("src/admin/notice.txt");
		JOptionPane.showMessageDialog(p, "�ۼ��Ϸ�!");
		notice.readFile("src/admin/notice.txt");
		notice.showNoticeTable();
		notice.table.updateUI();
		dispose();
		
	}

	// �� ����� ���� ��ư ���� �޼ҵ�
	public void enrollCheck() {

		String notiTitle = tfTitle.getText();
		String notiName = tfName.getText();
		String notiRegDate = tfregDate.getText();
		String notiText = taText.getText();

		if (notiTitle == null || notiText == null || notiName == null || notiRegDate == null
				|| notiTitle.trim().equals("") || notiText.trim().equals("") || notiName.trim().equals("")
				|| notiRegDate.trim().equals("")) {
			JOptionPane.showMessageDialog(p, "��ĭ�� �־�� �Է��ϼ���");
			return;
		} else {
			inputTable();

		}
	}
	//noticewrite �ʱ�ȭ
	public void clearInput() {
		tfTitle.setText("");
		tfName.setText("");
		tfregDate.setText("");
		taText.setText("");	
		tfTitle.requestFocus();
	}

	public Insets getInsets() {
		return new Insets(45, 25, 25, 25);
	}

}
