package w11.rpn;

public class RPN extends AbstractRPN {
	@Override
	public void performOperation(char operation) {
		switch (operation) {
		case '+': {
			// pop two operands and push the sum, missing values default to 0.0
			double d1 = pop(0.0), d2 = pop(0.0);
			push(d2 + d1);
			break;
		}
		case '-': {
			// pop two operands and push the difference, missing values default to 0.0
			double d1 = pop(0.0), d2 = pop(0.0);
			push(d2 - d1);
			break;
		}
		case '*': {
			// pop two operands and push the product, missing values default to 1.0
			double d1 = pop(1.0), d2 = pop(1.0);
			push(d2 * d1);
			break;
		}
		case '/': {
			// pop two operands and push the quotient, missing values default to 1.0
			double d1 = pop(1.0), d2 = pop(1.0);
			push(d2 / d1);
			break;
		}
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
		// extra operators
		// remainder
		case '%': {
			double d1 = pop(1.0), d2 = pop(1.0);
			push(d2 % d1);
			break;
		}
		// absolute
		case '|': {
			double d = pop(0.0);
			push(Math.abs(d));
			break;
		}
		// square root
		case 'v': {
			double d = pop(1.0);
			push(Math.sqrt(d));
			break;
			// no break, fall through into power!!!
		}
		// power of
		case '^': {
			double d1 = pop(1.0), d2 = pop(1.0);
			push(Math.pow(d2, d1));
			break;
		}
		// floor
		case '_': {
			double d = pop(0.0);
			push(Math.floor(d));
			break;
		}
		// compare
		case '=': {
			double d1 = pop(1.0), d2 = pop(1.0);
			push(Double.compare(d2, d1));
			break;
		}
		// signum
		case '?': {
			double d = pop(0.0);
			push(Math.signum(d));
			break;
		}
		// pi
		case 'p': {
			push(Math.PI);
			break;
		}
		// e
		case 'e': {
			push(Math.exp(1.0));
			break;
		}
		}
	}
}