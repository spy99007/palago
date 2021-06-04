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
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Server extends JFrame {
	JTextArea ta; 
	JTextField tf;
	JButton btn1;

	ServerSocket serverSocket;
	Socket socket;
	DataInputStream dis;
	DataOutputStream dos;

	public Server() {
		setTitle("1:1 문의하기");
		setBounds(450, 50, 500, 350);

		
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

		
		ServerThread serverThread = new ServerThread();
		serverThread.setDaemon(true); 
		serverThread.start();

		
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
					if (serverSocket != null)
						serverSocket.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
	}


	
	class ServerThread extends Thread {
		@Override
		public void run() {
			try { 
				serverSocket = new ServerSocket(10001);
				ta.append("Client 접속 대기중\n");
				socket = serverSocket.accept();
				ta.append(socket.getInetAddress().getHostAddress() + "님이 접속하셨습니다.\n");


				dis = new DataInputStream(socket.getInputStream());
				dos = new DataOutputStream(socket.getOutputStream());

				while (true) {
					String msg = dis.readUTF();
					ta.append(" [Clinent] : " + msg + "\n");
					ta.setCaretPosition(ta.getText().length());
				}

			} catch (IOException e) {
				ta.append("Client가 대화에서 나갔습니다.\n");
			}
		}
	}

	void sendMessage() {
		String msg = tf.getText(); 
		tf.setText(""); 
		ta.append(" [SERVER] : " + msg + "\n");
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
}/////////////////////////////////// class
