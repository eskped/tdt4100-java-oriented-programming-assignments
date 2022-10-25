package ord2014.part2;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

public class Quiz {
	
	Collection<Question> questions;
	
	public Quiz(Question...questions) {
		this.questions = new ArrayList<>(Arrays.asList(questions));
	}
	
	
	public void run() {
		Scanner scanner = new Scanner(System.in);
		for (Question question : questions) {
			while (true) {
				
				question.askQuestion(System.out);
				
				String answer = scanner.nextLine();
	            if (question.checkAnswer(answer)) {
	                break;
	            }
	            System.out.println("Feil, prøv igjen!");
	            question.askQuestion(System.out);
	        }
	    }
	    scanner.close();
	}
	
	public void init() {
	    addQuestion(new Question("Hva heter hovedstaden i Norge?", "Oslo"));
	    addQuestion(new Question("Hva slags ost er månen laget av?", "Roquefort", "Camembert", "Roquefort", "Brie"));
	    addQuestion(new Question("Hvor høy er Galdhøpiggen?", "2469", "2469", "2471"));
	    addQuestion(new Question("Er Java gøy?", "ja"));
	}
	private void addQuestion(Question question) {
		questions.add(question);
		
	}


	public static void main(String[] args) {
	    Quiz quiz = new Quiz();
	    quiz.init();
	    quiz.run();
	}
}



