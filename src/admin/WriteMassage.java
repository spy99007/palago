package admin;

public class WriteMassage {
		private String title;
		private String text;
		
		
	public WriteMassage() {
		
	}
	public WriteMassage(String tit, String tex) {
		title=tit; text=tex;
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
		
		
}//////
