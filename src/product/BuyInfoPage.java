package product;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class BuyInfoPage extends JPanel {

	JPanel pC = new JPanel(new BorderLayout());
	JPanel pS = new JPanel(new GridLayout(0,2,10,10));
	
	JLabel pimage;
	JTextArea pinfo;
	JButton before,next;
	JFileChooser chooser=new JFileChooser();
	FileNameExtensionFilter filter
	=new FileNameExtensionFilter("JPG&PNG Images", "jpg","png");
	
	BuyMainFrame buyF; 

	public BuyInfoPage(BuyMainFrame buy) {
		this.buyF=buy;
		chooser.setFileFilter(filter);
		this.setBackground(Color.white);
		setLayout(new BorderLayout());
		add(pC,"Center");	add(pS,"South");
		
		//타이틀,배경 설정
		buyF.myborder(pC,"상품 정보");
		pS.setBackground(Color.white);
		
		//상품 사진, 설명 추가
		pimage=new JLabel("여기를 클릭하여 사진을 선택하세요");
		pinfo=new JTextArea("상품 설명을 입력해주세요");
		pimage.setFont(new Font("맑은 고딕",Font.BOLD,14));
		buyF.mytext(pinfo);
		pC.add(pimage,"North");	 
		pC.add(new JScrollPane(pinfo),"Center");
		
		//하단 버튼
		before=new JButton("이전");
		next=new JButton("등록하기");
		buyF.myFont(before, 14);
		buyF.myFont(next, 14);
		pS.add(before);	pS.add(next);

	
	}//생성자------

	@Override
	public Insets getInsets() {
		return new Insets(20,20,25,20);
	}

}