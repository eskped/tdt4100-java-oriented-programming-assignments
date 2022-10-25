package ord2014.part2;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question {
	
	private String question;
	private String answer;
	private List<String> alt;
	
	
	
	public Question(String question, String answer, String... alt) {
		this(question, answer, Arrays.asList(alt));
	}
	
	public Question(String question, String answer, List<String> list) {
		this(question, answer);
		if (!list.contains(answer)) {
			throw new IllegalArgumentException("Alternativene må innehode svaret");
		}
		
		this.alt = list;
	}
	
	public Question(String question, String answer) {
		if (question instanceof String) {
			this.question = question;
		} else {
			throw new IllegalArgumentException("Må være streng");
		}
		if (answer instanceof String) {
			this.answer = answer;
		} else {
			throw new IllegalArgumentException("Må være streng");
		}
		this.alt = new ArrayList<String>();
	}
	
	public void askQuestion(PrintStream ps) {
		System.out.println(question);
		ps.append(question);
		ps.append("\n");
		if (this.alt.size() != 0) {
			for (int i = 1; i <= alt.size(); i++) {
				ps.append(String.valueOf(i)+ " : ");
				ps.append(alt.get(i-1) + "\n");
			}
		}
	}
	
	public boolean checkAnswer(String answer) {
		if (alt.size() > 0) {
			try {
				int num = Integer.valueOf(answer);
				if (this.answer.equals(alt.get(num-1))) {
					return true;
				}
			} catch (Exception e) {}
		}
		return this.answer.equals(answer);
	}
	
	public void setAlt(String...alt) {
		this.alt = new ArrayList<String>(Arrays.asList(alt));
	}
	
	public List<String> getAlt() {
		return this.alt;
	}
	
	public String getQuestion() {
		return question;
	}
	
	public String getAnswer() {
		return answer;
	}
	
	public void run() {
		
	}
	
	
	public static void main(String[] args) {
		
	}
}






