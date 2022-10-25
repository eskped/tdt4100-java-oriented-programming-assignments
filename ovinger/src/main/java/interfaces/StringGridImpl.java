package interfaces;

import java.util.ArrayList;
import java.util.Iterator;

public class StringGridImpl implements StringGrid {
		
	ArrayList<String> stringGrid = new ArrayList<String>();
	int rows;
	int columnCount;
	
	public StringGridImpl(int rows, int columnCount) {
		if (rows < 0 || columnCount < 0) 
			throw new IllegalArgumentException("Antall rader og kolonner kan ikke være mindre enn null");
		
		this.rows = rows;
		this.columnCount = columnCount;
		
		for (int i = 0; i < (rows * columnCount); i++) {
			stringGrid.add(null);
		}
	}
	
	@Override
	public int getRowCount() {
		return this.rows;
	}

	@Override
	public int getColumnCount() {
		return this.columnCount;
	}

	@Override
	public String getElement(int row, int column) {
		if (this.rows < row || row < 0) 
			throw new IllegalArgumentException("Du ber om en rad som ikke finnes");
		
		if (this.columnCount < column || column < 0) 
			throw new IllegalArgumentException("Du ber om en kolonne som ikke finnes");
		
		return stringGrid.get(row * this.getColumnCount() + column);
	}

	@Override
	public void setElement(int row, int column, String element) {
		if (this.rows < row || row < 0) 
			throw new IllegalArgumentException("Du ber om en rad som ikke finnes");
		
		if (this.columnCount < column || column < 0) 
			throw new IllegalArgumentException("Du ber om en kolonne som ikke finnes");
		
		
		stringGrid.set(row * this.getColumnCount() + column, element);
	}

	@Override
	public Iterator<StringGrid> iterator() {
		return null;
	}

}
