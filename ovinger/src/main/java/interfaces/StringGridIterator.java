package interfaces;

import java.util.Iterator;

public class StringGridIterator implements Iterator<String> {
	
	private boolean rowMajor;
	private StringGrid stringGrid;
	private int row;
	private int column;
	
	
	public StringGridIterator(StringGrid stringGrid, boolean rowMajor) {
		this.stringGrid = stringGrid;
		this.rowMajor = rowMajor;
		this.row = 0;
		this.column = 0;
	}
	
	
	@Override
	public boolean hasNext() {
		if (this.column <= this.stringGrid.getColumnCount()-1 && this.row <= this.stringGrid.getRowCount()-1) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public String next() {
		String s = this.stringGrid.getElement(this.row , this.column);
		if (this.rowMajor == true) {
			this.nextNumber();	
		} 
		else {
			this.nextNumber();
		}
		return s;
	}
	
	public void remove() {
		throw new UnsupportedOperationException("Cannot remove string"); 
	}
	
	private void nextNumber() {
		if (this.rowMajor == true) {	
			if (this.column == this.stringGrid.getColumnCount()-1) { 
				this.row += 1;
				this.column = 0;
			}
			else {
				this.column += 1;
			}
		}
		else {
			if (this.row == this.stringGrid.getRowCount()-1) {
				this.column += 1;
				this.row = 0;
			}
			else {
				this.row += 1;
			}
		}
	}
}
