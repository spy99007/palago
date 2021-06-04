package common;

import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;
import java.text.DateFormat;
import java.util.Date;

public class MainWindow extends JFrame implements PropertyChangeListener {

	private static final long serialVersionUID = 1L;
	private JTextArea ta = new JTextArea(100, 100);
	JFormattedTextField textField = new JFormattedTextField(DateFormat.getDateInstance(DateFormat.SHORT));

	

	public MainWindow() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		setTitle("구매내역 조회");

		Container cp = getContentPane();
		FlowLayout flowLayout = new FlowLayout();

		cp.setLayout(flowLayout);
		cp.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

		JLabel pblb1 = new JLabel("조회기간 검색하기");
		pblb1.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		cp.add(pblb1);

		textField.setValue(new Date()); // 최근 날짜
		textField.setPreferredSize(new Dimension(130, 30));
		cp.add(textField);

		//조회버튼
		ImageIcon Icon2 = new ImageIcon("images/calendar.png");
		JButton calButton = new JButton("",Icon2);
		cp.add(calButton);
		calButton.setHorizontalTextPosition(JButton.CENTER);
		calButton.setVerticalTextPosition(JButton.BOTTOM);
		calButton.setBorderPainted(false);

		
		CalendarWindow calendarWindow = new CalendarWindow();
		calendarWindow.setUndecorated(true);
		calendarWindow.addPropertyChangeListener(this);

		calButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calendarWindow.setLocation(textField.getLocationOnScreen().x,
						(textField.getLocationOnScreen().y + textField.getHeight()));

				Date selectedDate = (Date) textField.getValue();
				calendarWindow.resetSelection(selectedDate);

				calendarWindow.setVisible(true);
			}
		});

		JButton backbtn = new JButton("뒤로가기");
		backbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Menu menu = new Menu();
				
			}
		});
		backbtn.setBounds(265, 400, 115, 30);
		cp.add(backbtn);
		cp.add(new JScrollPane(ta));

	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {

		if (event.getPropertyName().equals("selectedDate")) {
			java.util.Calendar cal = (java.util.Calendar) event.getNewValue();
			Date selDate = cal.getTime();

			textField.setValue(selDate);
		}
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MainWindow window = null;
				try {
					window = new MainWindow();
					window.setVisible(true);
				} catch (Exception exp) {
					exp.printStackTrace();
				}
			}
		});
	}

}
