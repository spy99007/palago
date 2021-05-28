package common;

import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import product.PurchaseTab;

public class MainWindow extends JFrame implements PropertyChangeListener {

	private static final long serialVersionUID = 1L;
	private JTextArea ta = new JTextArea(100, 100);

	JFormattedTextField textField = new JFormattedTextField(DateFormat.getDateInstance(DateFormat.SHORT));

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

		
		JButton calButton = new JButton("조회");
		cp.add(calButton);

		
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
				PurchaseTab pt = new PurchaseTab();
				pt.setSize(500, 500);
				pt.setVisible(true);
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

}
