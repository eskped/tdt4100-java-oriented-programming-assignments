package encapsulation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.BinaryOperator;

public class RPNCalc implements BinaryOperator<Double> {
	public List<Double> calc = new ArrayList<>();
	
	private Collection<BinaryOperator<Double>> operators = new ArrayList<>();
	
	public void push(double number) {
		this.calc.add(number);
	}
	
	public double pop() {
		if (this.calc.size() != 0) {
			double n1 = calc.get(calc.size()-1);
			calc.remove(calc.size()-1);
			return n1; 
		} else {
			return Double.NaN;
		}
	}
	
	public double peek(int index) {
		if (Math.abs(index) <= this.calc.size()-1) {
			if (index >= 0) {
				int place = this.calc.size() -1 - index;
				return this.calc.get(place);
			} else {
				int place = this.calc.size() -1 + index;
				return this.calc.get(place);
			}

		} else {
			return Double.NaN;
		}
	}
	
	public int getSize() {
		return this.calc.size();
	}
	
	public void performOperation(char operator) {
		double n1 = this.pop();
		double n2 = this.pop();
		if (operator == '+') {
			this.push(n1+n2);
		}
		else if (operator == '-') {
			this.push(n2-n1);
		} 
		else if (operator == '*') {
			this.push(n1*n2);
		}
		else if (operator == '/') {
			this.push(n2/n1);
		}
	}
	
	public boolean addOperator(char operator, BinaryOperator<Double> binaryOperator) {
		if (!operators.contains(binaryOperator)) {
			operators.add(binaryOperator);
			return true;
		}
		return false;
	}
	
	public void removeOperator(char operatorSign) {
		operators.removeIf(a -> a.toString().equals("(a,b) -> a " + operatorSign + " b" ));
		
//		for (BinaryOperator<Double> bo: operators) {
//			if (bo.)
//		}
	}
	

	@Override
	public Double apply(Double t, Double u) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public static void main(String[] args) {
		RPNCalc calc1 = new RPNCalc();
		calc1.push(10.0);
		calc1.push(4.0);
		
		System.out.println(calc1.peek(0));
		System.out.println(calc1.peek(1));
		calc1.performOperation('/');
		System.out.println(calc1.peek(0));

		
		

	}

	
}
