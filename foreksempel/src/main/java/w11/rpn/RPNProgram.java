package w11.rpn;
import java.util.Scanner;

public class RPNProgram {
	private AbstractRPN rpn ;
	
	public void init() {
		rpn = new RPN(); // originalt eksempl
		//rpn = new RPNlambda(); // eksempl med lambda
	}

	public void run() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("RPN: " + rpn);
			System.out.println("Enter double value or operation: ");
			if (scanner.hasNextDouble()) {
				double argument = scanner.nextDouble();
				rpn.push(argument);
			} else {
				String token = scanner.next();
				if (token.length() == 1) {
					rpn.performOperation(token.charAt(0));
				} else if ("exit".equals(token)) {
					break;
				} else {
					System.err.println(token + " is illegal as input!");
				}
			}
		}
		scanner.close();
	}
	
	public static void main(String[] args) {
		RPNProgram program = new RPNProgram();
		program.init();
		program.run();
	}
} 