package product;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Client extends JFrame {
	JTextArea ta; 
	JTextField tf;
	JButton btn1;

	Socket socket;
	DataInputStream dis;
	DataOutputStream dos;

	public Client() {
		setTitle("1:1 문의하기");
		setBounds(450, 400, 500, 350);

		ta = new JTextArea();
		ta.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(ta);
		add(scrollPane, BorderLayout.CENTER);

		JPanel msgPanel = new JPanel();
		msgPanel.setLayout(new BorderLayout());
		tf = new JTextField();
		btn1 = new JButton("전송하기");
		msgPanel.add(tf, BorderLayout.CENTER);
		msgPanel.add(btn1, BorderLayout.EAST);

		add(msgPanel, BorderLayout.SOUTH);


		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sendMessage();
			}
		});

		
		tf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				super.keyPressed(e);

				int keyCode = e.getKeyCode();
				switch (keyCode) {
				case KeyEvent.VK_ENTER:
					sendMessage();
					break;
				}
			}
		});

		setVisible(true);
		tf.requestFocus();

		ClientThread clientThread = new ClientThread();
		clientThread.setDaemon(true);
		clientThread.start();

		addWindowListener(new WindowAdapter() {
			@Override 
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				try {
					if (dos != null)
						dos.close();
					if (dis != null)
						dis.close();
					if (socket != null)
						socket.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});

	}

	class ClientThread extends Thread {
		@Override
		public void run() {
			try {
				socket = new Socket("127.0.0.1", 10001);
				ta.append("1:1 문의하기에 참여하셨습니다. 문의사항을 말씀해주세요.\n");
				InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();

				dis = new DataInputStream(is);
				dos = new DataOutputStream(os);

				while (true) {
					String msg = dis.readUTF();
					ta.append(" [SERVER] : " + msg + "\n");
					ta.setCaretPosition(ta.getText().length());
				}
			} catch (UnknownHostException e) {
				ta.append("서버 주소를 확인해주세요.\n");
			} catch (IOException e) {
				ta.append("상대방과 연결이 끊어졌습니다.\n");
			}
		}
	}

	void sendMessage() {
		String msg = tf.getText();
		tf.setText(""); 
		ta.append(" [Clinet] : " + msg + "\n");
		ta.setCaretPosition(ta.getText().length());

		Thread t = new Thread() {
			@Override
			public void run() {
				try { 
					dos.writeUTF(msg);
					dos.flush(); 
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		t.start();
	}
}//////////////////// class