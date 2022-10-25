package interfaces;

import java.util.Iterator;
import java.util.function.BinaryOperator;

public class BinaryComputingIterator implements Iterator<Double> {
	
	private Iterator<Double> iterator1;
	private Iterator<Double> iterator2;
	private BinaryOperator<Double> operator;
	private Double default1,default2;
	private Double a,b;
	
	
	public BinaryComputingIterator(Iterator<Double> iterator1, Iterator<Double> iterator2, BinaryOperator<Double> operator) {
		this.iterator1 = iterator1;
		this.iterator2 = iterator2;
		this.operator = operator;
	}	
	
	public BinaryComputingIterator(Iterator<Double> iterator1, Iterator<Double> iterator2, Double default1, Double default2, BinaryOperator<Double> operator) {
		this.iterator1 = iterator1;
		this.iterator2 = iterator2;
		this.operator = operator;
		this.default1 = default1;
		this.default2 = default2;
	}
	
	@Override
	public boolean hasNext() {
		if (this.iterator1.hasNext() || this.iterator2.hasNext()) {
			if (this.iterator1.hasNext() && this.iterator2.hasNext()) {
				return true;
			}
			if ((!this.iterator1.hasNext() && this.default1 != null) || (!this.iterator2.hasNext() && this.default2 != null)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Double next() {
		if (this.iterator1.hasNext()) {
			a = this.iterator1.next();
		} else {
			a = this.default1;
		}
		
		if (this.iterator2.hasNext()) {
			b = this.iterator2.next();
		} else {
			b = this.default2;
		}
		return this.operator.apply(a, b);
	}
}
