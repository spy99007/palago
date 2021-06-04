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
		super("공지작성");
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

		tfTitle = new JTextField(30); // 제목
		tfName = new JTextField(5); // 작성자
		tfregDate = new JTextField(8); // 작성일
		taText = new JTextArea(10, 10);//내용
		btEnroll = new JButton("등록");
		btCancel = new JButton("취소");

		lbTitle = new JLabel("제목");
		lbName = new JLabel("작성자");
		lbRegDate = new JLabel("작성일");
		lbText = new JLabel("내용");
		
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
		tfTitle.setBorder(tb1 = new TitledBorder("제목"));
		tfName.setBorder(tb2 = new TitledBorder("작성자"));
		tfregDate.setBorder(tb3 = new TitledBorder("작성일"));
		taText.setBorder(tb4 = new TitledBorder("내용"));
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
				//noticeTable 불러와서 보여주기
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

	// 등록버튼 메소드
	public void inputTable() {
		String title = tfTitle.getText();
		String name = tfName.getText();
		String regDate = tfregDate.getText();
		String text = taText.getText();

		WriteMessage write = new WriteMessage(title, text, name, regDate);
		notice.noticeTable.put(title, write);
		System.out.println(notice.noticeTable);
		setTitle("게시글 등록 완료! 현재 게시글 수: " + notice.noticeTable.size() + "개");
		//파일저장
		notice.saveFile("src/admin/notice.txt");
		JOptionPane.showMessageDialog(p, "작성완료!");
		notice.readFile("src/admin/notice.txt");
		notice.showNoticeTable();
		notice.table.updateUI();
		dispose();
		
	}

	// 글 등록을 위한 버튼 조건 메소드
	public void enrollCheck() {

		String notiTitle = tfTitle.getText();
		String notiName = tfName.getText();
		String notiRegDate = tfregDate.getText();
		String notiText = taText.getText();

		if (notiTitle == null || notiText == null || notiName == null || notiRegDate == null
				|| notiTitle.trim().equals("") || notiText.trim().equals("") || notiName.trim().equals("")
				|| notiRegDate.trim().equals("")) {
			JOptionPane.showMessageDialog(p, "빈칸이 있어요 입력하세요");
			return;
		} else {
			inputTable();

		}
	}
	//noticewrite 초기화
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
