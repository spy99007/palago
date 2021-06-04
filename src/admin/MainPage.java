package admin;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Hashtable;

import javax.swing.*;
import javax.swing.border.EtchedBorder;

public class MainPage extends JFrame {

	JPanel p = new JPanel(new BorderLayout());
	JPanel pN = new JPanel(new GridLayout(1, 0, 10, 10));
	JPanel pC = new JPanel();

	JButton btNotice, btMypage, btPost;

	MyPage mypage;
	Notice notice;
	Post post;
	NoticeWrite noticeWrite;
	WriteMessage writeMessage;

	CardLayout card;

	Hashtable<String, WriteMessage> noticeTable = new Hashtable<>();

	Login lg;

	public MainPage(Login lg) {
		super("::MainPage::");

		this.lg = lg;
		Container cp = this.getContentPane();
		cp.setBackground(Color.white);
		cp.add(p, "Center");
		p.setBackground(Color.white);
		add(p);
		p.add(pN, "North");
		p.add(pC, "Center");
		pN.setBackground(Color.white);
		pC.setBackground(Color.white);
		p.setOpaque(true);

		btNotice = new JButton("공지사항");
		btMypage = new JButton("마이페이지");
		btPost = new JButton("게시판관리");

		pN.add(btNotice);
		pN.add(btMypage);
		pN.add(btPost);

		pC.setLayout(card = new CardLayout());
		notice = new Notice(this);
		mypage = new MyPage(this);
		post = new Post(this);

		pC.add("noP", notice);
		pC.add("myP", mypage);
		pC.add("poP", post);

		btNotice.setBackground(new Color(50, 100, 170));
		btNotice.setForeground(Color.white);
		btMypage.setBackground(new Color(50, 100, 170));
		btMypage.setForeground(Color.white);
		btPost.setBackground(new Color(50, 100, 170));
		btPost.setForeground(Color.white);

		AdminHandler hand = new AdminHandler(this);
		btNotice.addMouseListener(hand);
		btMypage.addMouseListener(hand);
		btPost.addMouseListener(hand);

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {

			}
		});
	}// 생성자------
	/*
	 * public void noitce() { String title=noticeWrite.tf.getText(); String
	 * text=noticeWrite.ta.getText(); }
	 */

	/*
	 * public static void main(String[] args) { MainPage my = new MainPage();
	 * my.setSize(500, 500); my.setVisible(true); }
	 */

}
