package w11.rpn;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class RPNlambda extends AbstractRPN {
	private Map<Character, BinaryOperator<Double>> binaryOperators;
	private Map<Character, UnaryOperator<Double>> unaryOperators;
	private Map<Character, Supplier<Double>> constants;

	public RPNlambda() {
		binaryOperators = new HashMap<Character, BinaryOperator<Double>>();
		unaryOperators = new HashMap<Character, UnaryOperator<Double>>();
		constants = new HashMap<Character, Supplier<Double>>();

		binaryOperators.put('+', (d1, d2) -> d1 + d2);
		binaryOperators.put('-', (d1, d2) -> d2 - d1);
		binaryOperators.put('*', (d1, d2) -> d1 * d2);
		binaryOperators.put('/', (d1, d2) -> d2 / d1);
		// power of
		binaryOperators.put('^', (d1, d2) -> Math.pow(d2, d1));
		// compare
		binaryOperators.put('=', (d1, d2) -> Double.valueOf(Double.compare(d2, d1)));
		// remainder
		binaryOperators.put('%', (d1, d2) -> d2 % d1);

		// absolute
		unaryOperators.put('|', (d) -> Math.abs(d));
		// square root
		unaryOperators.put('v', (d) -> Math.sqrt(d));
		// floor
		unaryOperators.put('_', (d) -> Math.floor(d));
		// signum
		unaryOperators.put('?', (d) -> Math.signum(d));

		// pi
		constants.put('p', () -> Math.PI);
		// e
		constants.put('e', () -> Math.exp(1.0));
	}

	@Override
	public void performOperation(char operation) {
		if (binaryOperators.containsKey(operation)) {
			double d1 = pop(), d2 = pop();
			BinaryOperator<Double> op = binaryOperators.get(operation);
			push(op.apply(d1, d2));
		} else if (unaryOperators.containsKey(operation)) {
			double d1 = pop();
			UnaryOperator<Double> op = unaryOperators.get(operation);
			push(op.apply(d1));
		} else if (constants.containsKey(operation)) {
			Supplier<Double> op = constants.get(operation);
			push(op.get());
		} else {
			switch (operation) {
			// dup
			case ',': {
				double d = pop(0.0);
				// push back twice
				push(d);
				push(d);
				break;
			}
			// pop
			case '.': {
				// remove the topmost value
				pop(0.0);
				break;
			}
			// swap
			case '~': {
				// swap the two topmost values, by popping them and pushing them in reverse
				// order
				double d1 = pop(0.0), d2 = pop(0.0);
				push(d1);
				push(d2);
				break;
			}
			}
		}
	}
}
