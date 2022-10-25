package interfaces;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class RPNCalc {
	public List<Double> calc = new ArrayList<>();
	
	private HashMap<Character, BinaryOperator<Double>> binaryOperators = new HashMap<>();
	private HashMap<Character, UnaryOperator<Double>> unaryOperators = new HashMap<>();
	private HashMap<Character, Supplier<Double>> suppliers = new HashMap<>();

	
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
		if (!binaryOperators.containsKey(operator)) {
			throw new UnsupportedOperationException("Kan ikke utføre en operasjon som ikke er lagt til");
		}
		
		double n1 = this.pop();
		if (binaryOperators.containsKey(operator)) {
			double n2 = this.pop();
			calc.add(binaryOperators.get(operator).apply(n2, n1));
		} else if (unaryOperators.containsKey(operator)) {
			calc.add(unaryOperators.get(operator).apply(n1));
		} else if (suppliers.containsKey(operator)) {
			calc.add(suppliers.get(operator).get());
		}
		
	}
	
	public boolean addOperator(char operatorSign, BinaryOperator<Double> operator) {
		if(checkAdd(operatorSign)) {
			binaryOperators.put(operatorSign, operator);
			return true;
		}
		
		return false;
	}	

	public boolean addOperator(char operatorSign, UnaryOperator<Double> operator) {
		if(checkAdd(operatorSign)) {
			unaryOperators.put(operatorSign, operator);
			return true;
		}
		return false;
	}
	
	public boolean addOperator(char operatorSign, Supplier<Double> operator) {
		if(checkAdd(operatorSign)) {
			suppliers.put(operatorSign, operator);
			return true;
		}
		return false;
	}
	
	private boolean checkAdd(char operatorSign) {
		if (!suppliers.containsKey(operatorSign) && !unaryOperators.containsKey(operatorSign) && !binaryOperators.containsKey(operatorSign))
			return true;
		return false;
	}
	
	
	public void removeOperator(char operatorSign) {
		if (!binaryOperators.containsKey(operatorSign)) {
			throw new UnsupportedOperationException("Kan ikke fjerne noe som ikke er der");
		}
		binaryOperators.remove(operatorSign);
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
