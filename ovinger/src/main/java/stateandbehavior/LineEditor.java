package stateandbehavior;

public class LineEditor {
	String text = "";
	int insertionIndex = 0;
	
	
	
	public void left() {
		checkIfTextIsNull();
		if (insertionIndex > 0) {
			insertionIndex--;
		}
	}
	
	public void right() {
		checkIfTextIsNull();
		if (text.length() > insertionIndex) {
			insertionIndex++;
		}
	}
	
	public void insertString(String s) {
		checkIfTextIsNull();
		text = text.substring(0,insertionIndex) + s + text.substring(insertionIndex,text.length());
		insertionIndex += s.length();
	}
	
	public 	void deleteLeft() {
		if (text != null && text != "") {
			text = text.substring(0,insertionIndex-1) + text.substring(insertionIndex,text.length());
			if (text != null || text != "") {
				insertionIndex--;
			}
		}
		if (text == null) {
			text = "";
		}
	}

	public void deleteRight() {
		if (text != null && text != "") {
			text = text.substring(0,insertionIndex) + text.substring(insertionIndex+1,text.length());
		}
		
		if (text == null) {
			text = "";
		}
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String s) {
		text = s;
		insertionIndex += s.length();
	}
	
	public int getInsertionIndex() {
		return insertionIndex;
	}
	
	public void setInsertionIndex(int number) {
		if (number > text.length()) {
			insertionIndex = text.length();
		}
		else {
			insertionIndex = number;
		}
	}
	
	private void checkIfTextIsNull() {
		if (text == null) {
			text = "";
		}	
	}
	
	@Override
	public String toString() {
		checkIfTextIsNull();
		if (text == null || text == "" || text == " ") {
			return "|";
		}
		else {
			return text.substring(0,insertionIndex) + "|" + text.substring(insertionIndex,text.length());
		}
	}
	
	public static void main(String[] args) {
		LineEditor l1 = new LineEditor();
				
		l1.left();		
		System.out.println(l1);

		l1.setText("J");		
		l1.setInsertionIndex(1);
		System.out.println(l1);


		l1.left();
		System.out.println(l1);

	}
	
}
	
	
