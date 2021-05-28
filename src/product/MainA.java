package product;
import java.awt.*;
import javax.swing.*;

public class MainA extends JFrame {

	JPanel p = new JPanel();
	JPanel pn = new JPanel();

	public MainA() {
		super("::::");
		Container cp = this.getContentPane();
		cp.add(p, "Center");
		cp.add(pn,"North");
		p.setBackground(Color.white);
		p.setLayout(new GridLayout(3,3,5,5));
		

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon normalIcon1= new ImageIcon("images/puppy.png");
		JButton btn1 =new JButton("땡철이",normalIcon1);
		p.add(btn1);
		btn1.setHorizontalTextPosition(JButton.CENTER);
		btn1.setVerticalTextPosition(JButton.BOTTOM);
		
        ImageIcon normalIcon2= new ImageIcon("images/coffee.png");
		JButton btn2 =new JButton("카페",normalIcon2);
		p.add(btn2);
		btn2.setHorizontalTextPosition(JButton.CENTER);
		btn2.setVerticalTextPosition(JButton.BOTTOM);
		
		ImageIcon normalIcon3= new ImageIcon("images/shop.png");
		JButton btn3 =new JButton("편의점",normalIcon3);
		p.add(btn3);
		btn3.setHorizontalTextPosition(JButton.CENTER);
		btn3.setVerticalTextPosition(JButton.BOTTOM);
		
		ImageIcon normalIcon4= new ImageIcon("images/ice-cream.png");
		JButton btn4 =new JButton("아이스크림,빵",normalIcon4);
		p.add(btn4);
		btn4.setHorizontalTextPosition(JButton.CENTER);
		btn4.setVerticalTextPosition(JButton.BOTTOM);
		
		ImageIcon normalIcon5= new ImageIcon("images/ham.png");
		JButton btn5 =new JButton("햄버거,치킨,피자",normalIcon5);
		p.add(btn5);
		btn5.setHorizontalTextPosition(JButton.CENTER);
		btn5.setVerticalTextPosition(JButton.BOTTOM);
		
		ImageIcon normalIcon6= new ImageIcon("images/joystick.png");
		JButton btn6 =new JButton("게임,영화,문화",normalIcon6);
		p.add(btn6);
		btn6.setHorizontalTextPosition(JButton.CENTER);
		btn6.setVerticalTextPosition(JButton.BOTTOM);
		
		ImageIcon normalIcon7= new ImageIcon("images/fork.png");
		JButton btn7 =new JButton("외식,분식",normalIcon7);
		p.add(btn7);
		btn7.setHorizontalTextPosition(JButton.CENTER);
		btn7.setVerticalTextPosition(JButton.BOTTOM);
		
		ImageIcon normalIcon8= new ImageIcon("images/cart.png");
		JButton btn8 =new JButton("백화점,뷰티",normalIcon8);
		p.add(btn8);
		btn8.setHorizontalTextPosition(JButton.CENTER);
		btn8.setVerticalTextPosition(JButton.BOTTOM);
		
		ImageIcon normalIcon9= new ImageIcon("images/phone.png");
		JButton btn9 =new JButton("휴대폰 데이터",normalIcon9);
		p.add(btn9);
		btn9.setHorizontalTextPosition(JButton.CENTER);
		btn9.setVerticalTextPosition(JButton.BOTTOM);
		
		
		JLabel lb=new JLabel("팔라고");
		pn.add(lb);
		
		
		
		
		
	}//생성자------

	public static void main(String[] args) {
		MainA my = new MainA();
		my.setSize(500, 500);
		my.setVisible(true);
	}

}