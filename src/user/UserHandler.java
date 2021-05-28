package user;
import java.awt.event.*;
public class UserHandler implements ActionListener{
	
	
	JoinFrame joinF =new JoinFrame();
	
	public UserHandler() {
		
	}
	
	
	
	@Override 
	public void actionPerformed(ActionEvent e) {
		
		
		
		Object obj =e.getSource();
		if(obj==joinF.btReset) {
			joinF.Reset();
		}
	}
}
