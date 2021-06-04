package user;
import java.awt.event.*;
public class UserHandler implements ActionListener{
	
	
	JoinFrame joinF;
	
	public UserHandler(JoinFrame joinF) {
		this.joinF=joinF;
		
	}
	
	@Override 
	public void actionPerformed(ActionEvent e) {
		
		Object obj =e.getSource();
		if(obj==joinF.btReset) {
			joinF.Reset();
		}
	}
}
