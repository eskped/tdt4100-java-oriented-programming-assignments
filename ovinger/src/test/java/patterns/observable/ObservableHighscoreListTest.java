package patterns.observable;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ObservableHighscoreListTest {

	private ObservableHighscoreList highscoreList;
	private int pos1, pos2;

	private void checkHighscoreList(String contextMessage, ObservableHighscoreList list, List<Integer> elements) {
		Assertions.assertEquals(elements.size(), list.size(),
				contextMessage + " -> Lengden på highscore-listen ble feil");
		int i = 0;
		for (int element : elements) {
			Assertions.assertEquals(element, list.getElement(i),
					contextMessage + String.format(" -> Elementet på plass %d ble feil", i));
			i++;
		}
	}

	private void addResultWithListener(int pos, int element) {
		pos1 = pos;
		highscoreList.addResult(element);

		// Sjekke at posisjonen som ble endret er den samme som ble sendt til lytteren
		Assertions.assertEquals(pos1, pos2, "La til " + element + " på posisjon " + pos
				+ "Posisjonen som ble endret var ikke samme som ble sendt til lytteren");
	}

	@BeforeEach
	public void setup() {
		highscoreList = new ObservableHighscoreList(3);
		pos1 = -1;
		pos2 = -1;
	}

	@Test
	@DisplayName("Teste konstruktør")
	public void testConstructor() {
		Assertions.assertEquals(0, highscoreList.size(), "Highscorelist ble ikke initialisert til en tom liste");
	}

	@Test
	@DisplayName("Legge til resultater (enkel)")
	public void testAddElementSimple() {
		highscoreList.addResult(5);
		checkHighscoreList("La til 5 i tom liste", highscoreList, Arrays.asList(5));

		highscoreList.addResult(6);
		checkHighscoreList("La til 6 i listen [5]", highscoreList, Arrays.asList(5, 6));

		highscoreList.addResult(2);
		checkHighscoreList("La til 2 i listen [5, 6]", highscoreList, Arrays.asList(2, 5, 6));
	}

	@Test
	@DisplayName("Legge til resultater - listen blir for lang")
	public void testAddElementMoreThanMax() {
		highscoreList.addResult(5);
		highscoreList.addResult(6);
		highscoreList.addResult(2);
		checkHighscoreList("La til 5, 6 og 2 i listen", highscoreList, Arrays.asList(2, 5, 6));

		highscoreList.addResult(3);
		checkHighscoreList("La til 3 i listen [2, 5, 6]", highscoreList, Arrays.asList(2, 3, 5));

		highscoreList.addResult(7);
		checkHighscoreList("La til 7 i listen [2, 3, 5]", highscoreList, Arrays.asList(2, 3, 5));
	}

	@Test
	@DisplayName("Legge til to like elementer")
	public void testAddElementDuplicate() {
		highscoreList.addResult(5);
		highscoreList.addResult(6);
		highscoreList.addResult(2);
		checkHighscoreList("La til 5, 6 og 2 i listen", highscoreList, Arrays.asList(2, 5, 6));

		highscoreList.addResult(2);
		checkHighscoreList("La til 2 i listen [2, 5, 6]", highscoreList, Arrays.asList(2, 2, 5));
	}

	@Test
	@DisplayName("Teste lyttere (enkel)")
	public void testListListenersSimple() {
		// Mocke en lytter
		ObservableListListener listener = (list, pos) -> pos2 = pos;
		highscoreList.addObservableListListener(listener);

		addResultWithListener(0, 5);
		checkHighscoreList("La til 5 i listen []", highscoreList, Arrays.asList(5));

		addResultWithListener(1, 6);
		checkHighscoreList("La til 6 i listen [5]", highscoreList, Arrays.asList(5, 6));

		addResultWithListener(0, 2);
		checkHighscoreList("La til 2 i listen [5, 6]", highscoreList, Arrays.asList(2, 5, 6));
	}

	@Test
	@DisplayName("Med lytter - listen blir for lang")
	public void testListListenerMoreThanMax() {
		// Mocke en lytter
		ObservableListListener listener = (list, pos) -> pos2 = pos;
		highscoreList.addObservableListListener(listener);

		highscoreList.addResult(5);
		highscoreList.addResult(6);
		highscoreList.addResult(2);
		checkHighscoreList("La til 5, 6 og 2 i listen", highscoreList, Arrays.asList(2, 5, 6));

		addResultWithListener(1, 3);
		checkHighscoreList("La til 3 i listen [2, 5, 6]", highscoreList, Arrays.asList(2, 3, 5));

		// Nullstille pos2 siden neste element havner utenfor listen og blir dermed ikke
		// oppdatert av seg selv og sendt til lytter
		pos2 = -1;
		addResultWithListener(-1, 7);
		checkHighscoreList("La til 7 i listen [2, 3, 5]", highscoreList, Arrays.asList(2, 3, 5));
	}

	@Test
	@DisplayName("Med lytter - to like elementer")
	public void testListListenerDuplicate() {
		// Mocke en lytter
		ObservableListListener listener = (list, pos) -> pos2 = pos;
		highscoreList.addObservableListListener(listener);

		highscoreList.addResult(5);
		highscoreList.addResult(6);
		highscoreList.addResult(2);
		checkHighscoreList("La til 5, 6 og 2 i listen", highscoreList, Arrays.asList(2, 5, 6));

		addResultWithListener(1, 2);
		checkHighscoreList("La til 2 i listen [2, 5, 6]", highscoreList, Arrays.asList(2, 2, 5));
	}
}