package admin;
import java.io.Serializable;


public class WriteMessage implements Serializable{
		private String title;
		private String text;
		private String name;
		private String regDate;
		
		
	public WriteMessage() {
		
	}
	public WriteMessage(String title,String text,String name
			,String regDate) {
		this.title=title; this.text=text;
		this.name=name; this.regDate=regDate;
	}

	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getRegDate() {
		return regDate;
	}


	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

		
		
}//////
