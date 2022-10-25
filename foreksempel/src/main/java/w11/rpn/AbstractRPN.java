package w11.rpn;

import java.util.Stack;

public abstract class AbstractRPN {
	private Stack<Double> operandStack;

	public AbstractRPN() {
		operandStack = new Stack<Double>();
	}

	@Override
	public String toString() {
		return operandStack.toString();
	}

	public void push(double value) {
		operandStack.push(value);
	}

	public int getSize() {
		return operandStack.size();
	}

	public double peek(int n) {
		return operandStack.get(operandStack.size() - n - 1);
	}

	public double pop() {
		return operandStack.pop();
	}

	public double pop(double def) {
		if (operandStack.isEmpty()) {
			return def;
		}
		return pop();
	}

	/**
	 * Perform the operation denoted by {@code operation}. Each operation pops and
	 * pushes values off and onto the operand stack.
	 * 
	 * @param operation the operation to perform
	 */
	abstract public void performOperation(char operation);
}
