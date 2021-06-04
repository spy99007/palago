package admin;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.util.*;

public class Notice extends JPanel {

	JPanel p = new JPanel(new BorderLayout());
	JPanel p1 = new JPanel(new BorderLayout());
	JPanel p2 = new JPanel(new GridLayout(1, 0, 10, 10));

	JTextArea ta;
	JButton btWrite, btDelete, btView;
	MainPage mainF;

	NoticeWrite noticeWrite;
	NoticeSee noticesee;
	WriteMessage wrtiemessage;

	JTable table;
	Object[][] noticeData = { { null, null, null, null } };
	String[] header = { "제목", "내용", "글쓴이", "작성일" };
	DefaultTableModel model;

	ObjectOutputStream out;
	ObjectInputStream in;
	FileOutputStream fout;
	FileInputStream fin;

	// hashtable 생성
	Hashtable<String, WriteMessage> noticeTable = new Hashtable<>();

	public Notice(MainPage frame) {
		this.mainF = frame;
		add(p);
		p.add(p1, "Center");
		p.add(p2, "South");
		p.setBackground(Color.white);
		p1.setBackground(Color.white);
		
		noticeWrite=new NoticeWrite(this);

		
		btWrite = new JButton("글쓰기");
		btDelete = new JButton("글삭제");
		//btView = new JButton("글보기");

		p2.add(btWrite);
		p2.add(btDelete);
		//p2.add(btView);

		btWrite.setBackground(new Color(50, 100, 170));
		btWrite.setForeground(Color.white);
		btDelete.setBackground(Color.DARK_GRAY);
		btDelete.setForeground(Color.white);

		model = new DefaultTableModel(noticeData, header);
		table = new JTable(model);
		p1.add(new JScrollPane(table), "Center");

		Handelr2 hand = new Handelr2();
		btWrite.addActionListener(hand);
		btDelete.addMouseListener(hand);
		readFile("src/admin/notice.txt");
		showNoticeTable();
		
		noticesee=new NoticeSee(this);
		//더블클릭시 게시물보기
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainF.setTitle("더블클릭");
				table = (JTable)e.getComponent();
				model = (DefaultTableModel)table.getModel();			
					//선택한 행 열번호를 알아냄
					int nRow = table.getSelectedRow();
					//int nColumn = table.getSelectedColumn();
					//알아낸 행열번호를 통해서 각각의 값을 알아냄
					Object viewtext = table.getValueAt(nRow,1);//열이름
					//Object cValue = model.getValueAt(nRow, nColumn); //값		
					noticesee.ta.setText((String) viewtext);
					//WriteMessage wm=noticeTable.get(wrtiemessage);		
					noticesee.pack();
					noticesee.setVisible(true);			
					// 행은 선택하고 열 고정
					System.out.println(table.getValueAt(table.getSelectedRow(), 1)); // (행, 열)
			
			}
		});

	}// 생성자------------------------------------------

	// 해시테이블 모델전달,설정
	public void showNoticeTable() {
		Collection<WriteMessage> cols = noticeTable.values();
		if (cols == null)
			return;

		Iterator<WriteMessage> it = cols.iterator();

		noticeData = new Object[noticeTable.size()][4];
		System.out.println(noticeTable.size());

		for (int i = 0; it.hasNext(); i++) {
			WriteMessage writeM = it.next();

			noticeData[i][0] = writeM.getTitle();
			noticeData[i][1] = writeM.getText();
			noticeData[i][2] = writeM.getName();
			noticeData[i][3] = writeM.getRegDate();
		}

		model.setDataVector(noticeData, header);
		table.setModel(model);
		table.setRowHeight(20);
		table.setModel(model);
	}////////

	public void shownotice() {
		int size = noticeTable.size();
		ta.setText("제목\t내용\t글쓴이\t작성일\n");
		ta.append("-------------\n");

		Collection<WriteMessage> cols = noticeTable.values();
		for (WriteMessage writeM : cols) {
			ta.append(writeM.getTitle() + "\t" + writeM.getText() + "\t" + writeM.getName() + "\t" + writeM.getRegDate()
					+ "\n");
		}
		ta.append("----------------------");
		ta.append("게시글 등록완료: " + size + "개\n");
	}
	//hashtable 게시물삭제 버튼
	public void deletenotice() {
		int row=table.getSelectedRow();
		if(row<0) {
			JOptionPane.showMessageDialog(p,"삭제할 글을 선택하세요");
			//mainF.setTitle("삭제할 글을 선택하세요");
			return;
		}
		String title=table.getValueAt(row, 0).toString();
		System.out.println(title+"<<<<<");
		
		
		WriteMessage wm=noticeTable.remove(title);
		System.out.println("wm=="+wm);
		saveFile("src/admin/notice.txt");
		readFile("src/admin/notice.txt");
		showNoticeTable();
		
		JOptionPane.showMessageDialog(p, "삭제완료");
	}
	
	class Handelr2 extends MouseAdapter implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// setTitle("As");
			Object o = e.getSource();
			if (o == btWrite) {
				noticeWrite.pack();
				noticeWrite.setVisible(true);
			}else if(o == btDelete) {
				deletenotice();
		}
	}
	
		// hashtable 클릭시 게시물삭제
		@Override
		public void mousePressed(MouseEvent e) {
			mainF.setTitle("Daf");
			Object o = e.getSource();	
			if(o==btDelete) {
				deletenotice();
				
			}
			
		}
		
		 
		
		}//////////////////////////////////

	// read 파일메소드
	public void readFile(String fileName) {
		try {
			fin = new FileInputStream(fileName);
			in = new ObjectInputStream(fin);
			Object obj = in.readObject();
			noticeTable = (Hashtable<String, WriteMessage>) obj;
			noticeWrite.setTitle("현재 등록된글: " + noticeTable.size());
		} catch (Exception e) {
			noticeWrite.setTitle("읽는중 에러: " + e.getMessage());
		}
	}///////////////////////////////////
	
	// save 파일 메소드
	public void saveFile(String fileName) {
		System.out.println("saveFile타는지....."+fileName);
		try {
			fout = new FileOutputStream(fileName);
			out = new ObjectOutputStream(fout);
			out.writeObject(noticeTable);
			out.flush();
			out.close();
			fout.close();
			System.out.println("noticeWrite=="+noticeWrite);
			noticeWrite.setTitle(fileName + "저장 완료");
			System.out.println(fileName + "에 저장완료");
		} catch (IOException e) {
			noticeWrite.setTitle("저장중 에러발생: " + e.getMessage());
			e.printStackTrace();
		}
	}

}/////////////////////////////////////////
