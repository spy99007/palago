package admin;
import java.util.*;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class Handler extends MouseAdapter implements ActionListener{
	
	MainPage mainF;
	MyPage myP;
	
	public Handler (MainPage mainF) {
		this.mainF=mainF;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		mainF.setTitle("±â´ÉÇÔ");
		Object o=e.getSource();
		if(o==myP.bt1) {
			
		}
	}

	
	@Override
	public void mousePressed(MouseEvent e){
		//mainF.setTitle("mouse");
		Object o=e.getSource();
		if(o==mainF.lbmyP) {
			mainF.card.show(mainF.pC ,"mpP");
		}else if(o==mainF.lbnoticeP) {
			mainF.card.show(mainF.pC,"noP" );
		}else if(o==mainF.lbpostP) {
			mainF.card.show(mainF.pC, "poP");
		}
	}
	
	
}///////////
