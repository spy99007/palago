package common;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.util.Enumeration;
import java.util.Hashtable;

import user.LoginFrame;
import user.User;


public class Common {

	ObjectOutputStream out;
	OutputStreamWriter outOut;
	FileOutputStream fout;	
	ObjectInputStream in;
	FileInputStream fin;
	private static Common com;
	
	private Common() {
		
	}
	
	public static Common getCommon() {
		com=new Common();
		return com;
	}
	
	
	
	public void saveFile(String fileName,Hashtable <String,Object> table) {
		try {
			fout = new FileOutputStream(fileName);
			out = new ObjectOutputStream(fout);
			
			//out.writeUTF("UTF-8");
			out.writeObject(table);
			out.flush(); 
			out.close();
			
			fout.close();

			System.out.println(fileName+"저장되었습니다.");
		}catch(IOException e) {
			System.out.println("오류가 발생했습니다. : "+e.getMessage());
			e.printStackTrace();
		}
	} 
	
	
	
	
	
	public Hashtable<String,Object> readFile(String fileName) {
		   try {  
			   	fin = new FileInputStream(fileName);
			   	in = new ObjectInputStream(fin);
			   	//in.defaultReadObject();
			   	Object o = in.readObject();
			   	
			   	Hashtable<String,Object> table = (Hashtable<String,Object>)o;
			   	
			   	//System.out.println(userTable.get("id"));
			   	
			   	//System.out.println(userTable);
			   	//System.out.println(fileName+"로드되었습니다.");
			   	return table;
		   	   }catch(Exception e) {
		   		   System.out.println("파일 불러오는 중 오류 "+e.getMessage());
		   		   e.printStackTrace();
		   	   }
		   return null;
		   
	}
	
	
	
	
	
	
	
	public User getUser(String id) 
	{
		 System.out.println("getUser() id: "+id);
	 //Common com =new Common();
	 Hashtable <String,Object> userTable=readFile("src/files/user.txt");
	 //Enumeration<Object> en=userTable.elements();
	 //Hashtable<String,String>user = new Hashtable<>(); 	
	 
	 Enumeration <String> keys=userTable.keys();
	 User user=null;
	 while(keys.hasMoreElements()) {
		 String key=keys.nextElement();
		 
		 System.out.println(key);
		 //System.out.println(user.getId());
		 if(id.equals(key)) {
			 System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^");
			 user=(User) userTable.get(key);
			 System.out.println("^^^^^^^^^^^^^^^^^^^^^^user>>"+user);
			break;
		 }
	 }
	 return user;
	}
	
	
	
	
	
	
	public User getUserInfo(String email) {
		Hashtable <String,Object> userTable=readFile("src/files/user.txt");
		Enumeration <String> keys=userTable.keys();
		 User user=null;
		 while(keys.hasMoreElements()) {
			 String key=keys.nextElement();
			 
				 user=(User) userTable.get(key);
				 //System.out.println("getUserInfo().user.getEmail="+user.getEmail());
				 if(email.equals(user.getEmail())) {
					 return user;
				 }
				 
		 }
		 return null;
	}
	
	public static void main(String[] args) {

	}

}
