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
	String[] header = { "����", "����", "�۾���", "�ۼ���" };
	DefaultTableModel model;

	ObjectOutputStream out;
	ObjectInputStream in;
	FileOutputStream fout;
	FileInputStream fin;

	// hashtable ����
	Hashtable<String, WriteMessage> noticeTable = new Hashtable<>();

	public Notice(MainPage frame) {
		this.mainF = frame;
		add(p);
		p.add(p1, "Center");
		p.add(p2, "South");
		p.setBackground(Color.white);
		p1.setBackground(Color.white);
		
		noticeWrite=new NoticeWrite(this);

		
		btWrite = new JButton("�۾���");
		btDelete = new JButton("�ۻ���");
		//btView = new JButton("�ۺ���");

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
		//����Ŭ���� �Խù�����
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainF.setTitle("����Ŭ��");
				table = (JTable)e.getComponent();
				model = (DefaultTableModel)table.getModel();			
					//������ �� ����ȣ�� �˾Ƴ�
					int nRow = table.getSelectedRow();
					//int nColumn = table.getSelectedColumn();
					//�˾Ƴ� �࿭��ȣ�� ���ؼ� ������ ���� �˾Ƴ�
					Object viewtext = table.getValueAt(nRow,1);//���̸�
					//Object cValue = model.getValueAt(nRow, nColumn); //��		
					noticesee.ta.setText((String) viewtext);
					//WriteMessage wm=noticeTable.get(wrtiemessage);		
					noticesee.pack();
					noticesee.setVisible(true);			
					// ���� �����ϰ� �� ����
					System.out.println(table.getValueAt(table.getSelectedRow(), 1)); // (��, ��)
			
			}
		});

	}// ������------------------------------------------

	// �ؽ����̺� ������,����
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
		ta.setText("����\t����\t�۾���\t�ۼ���\n");
		ta.append("-------------\n");

		Collection<WriteMessage> cols = noticeTable.values();
		for (WriteMessage writeM : cols) {
			ta.append(writeM.getTitle() + "\t" + writeM.getText() + "\t" + writeM.getName() + "\t" + writeM.getRegDate()
					+ "\n");
		}
		ta.append("----------------------");
		ta.append("�Խñ� ��ϿϷ�: " + size + "��\n");
	}
	//hashtable �Խù����� ��ư
	public void deletenotice() {
		int row=table.getSelectedRow();
		if(row<0) {
			JOptionPane.showMessageDialog(p,"������ ���� �����ϼ���");
			//mainF.setTitle("������ ���� �����ϼ���");
			return;
		}
		String title=table.getValueAt(row, 0).toString();
		System.out.println(title+"<<<<<");
		
		
		WriteMessage wm=noticeTable.remove(title);
		System.out.println("wm=="+wm);
		saveFile("src/admin/notice.txt");
		readFile("src/admin/notice.txt");
		showNoticeTable();
		
		JOptionPane.showMessageDialog(p, "�����Ϸ�");
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
	
		// hashtable Ŭ���� �Խù�����
		@Override
		public void mousePressed(MouseEvent e) {
			mainF.setTitle("Daf");
			Object o = e.getSource();	
			if(o==btDelete) {
				deletenotice();
				
			}
			
		}
		
		 
		
		}//////////////////////////////////

	// read ���ϸ޼ҵ�
	public void readFile(String fileName) {
		try {
			fin = new FileInputStream(fileName);
			in = new ObjectInputStream(fin);
			Object obj = in.readObject();
			noticeTable = (Hashtable<String, WriteMessage>) obj;
			noticeWrite.setTitle("���� ��ϵȱ�: " + noticeTable.size());
		} catch (Exception e) {
			noticeWrite.setTitle("�д��� ����: " + e.getMessage());
		}
	}///////////////////////////////////
	
	// save ���� �޼ҵ�
	public void saveFile(String fileName) {
		System.out.println("saveFileŸ����....."+fileName);
		try {
			fout = new FileOutputStream(fileName);
			out = new ObjectOutputStream(fout);
			out.writeObject(noticeTable);
			out.flush();
			out.close();
			fout.close();
			System.out.println("noticeWrite=="+noticeWrite);
			noticeWrite.setTitle(fileName + "���� �Ϸ�");
			System.out.println(fileName + "�� ����Ϸ�");
		} catch (IOException e) {
			noticeWrite.setTitle("������ �����߻�: " + e.getMessage());
			e.printStackTrace();
		}
	}

}/////////////////////////////////////////
