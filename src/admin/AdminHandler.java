package admin;
import java.util.*;
import java.awt.event.*;
import javax.swing.JOptionPane;


public class AdminHandler extends MouseAdapter implements ActionListener{
	
	MainPage mainF;
	MyPage myP;
	Notice notice;
	
	public AdminHandler (MainPage mainF) {
		this.mainF=mainF;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		mainF.setTitle("Login");
	//	Object o=e.getSource();
	//	if(o==myP.bt1) {
			
	//	}
	}

	
	@Override
	public void mousePressed(MouseEvent e){
		//mainF.setTitle("mouse");
		Object o=e.getSource();
		if(o==mainF.btNotice) {
			mainF.card.show(mainF.pC, "noP");
			mainF.notice.showNoticeTable();//(mainF.pC,"noP" );
		}else if(o==mainF.btMypage) {
			mainF.card.show(mainF.pC,"myP" );
		}else if(o==mainF.btPost) {
			mainF.card.show(mainF.pC, "poP");
		}
	}
	
	
}///////////
