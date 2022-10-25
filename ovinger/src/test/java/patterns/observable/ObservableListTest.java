package patterns.observable;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ObservableListTest {

	private ObservableList observableList;
	private int pos1, pos2;

	private void checkObservableList(ObservableList list, List<Integer> elements, String contextMessage) {
		Assertions.assertEquals(elements.size(), list.size(),
				contextMessage + " -> Lengden på ObservableList ble feil");

		int i = 0;
		for (int element : elements) {
			Assertions.assertEquals(element, list.getElement(i),
					contextMessage + String.format(" -> Element på plass %d var feil", i));
			i++;
		}
	}

	private void addElementWithListener(int pos, int element) {
		pos1 = pos;
		observableList.addElement(pos, element);

		// Sjekke at posisjonen som ble endret er den samme som ble sendt til lytteren
		Assertions.assertEquals(pos1, pos2,
				"La til " + element + " på posisjon " + pos + "posisjonen mottat av lytter ble feil, den var " + pos2);
	}

	@BeforeEach
	public void setup() {
		observableList = new ObservableList() {
			@Override
			public boolean acceptsElement(final Object element) {
				return (element instanceof Integer);
			}
		};
		pos1 = -1;
		pos2 = -1;
	}

	@Test
	@DisplayName("Test konstruktør")
	public void testConstructor() {
		Assertions.assertEquals(0, observableList.size());
	}

	@Test
	@DisplayName("Sjekk at listen aksepterer riktige elementer")
	public void testAcceptsElement() {
		Assertions.assertTrue(observableList.acceptsElement(5), "Listen skulle akseptert integers");
		Assertions.assertFalse(observableList.acceptsElement("5"), "Listen skulle ikke akseptert strenger");

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			observableList.addElement("5");
		}, "Listen skulle utløst et IllegalArgument-unntak når man prøver å legge til en streng");
	}

	@Test
	@DisplayName("Teste å legge til elementer")
	public void testAddElement() {
		observableList.addElement(5);
		checkObservableList(observableList, Arrays.asList(5), "La til 5 i tom liste");

		observableList.addElement(6);
		checkObservableList(observableList, Arrays.asList(5, 6), "La til 6 i listen [5]");

		observableList.addElement(0, 2);
		checkObservableList(observableList, Arrays.asList(2, 5, 6), "La til 2 på posisjon 0 i listen [5, 6]");
	}

	@Test
	@DisplayName("Teste lytter")
	public void testListListener() {
		ObservableListListener listener = (list, pos) -> pos2 = pos;
		observableList.addObservableListListener(listener);

		addElementWithListener(0, 5);
		checkObservableList(observableList, Arrays.asList(5), "La til 5 i listen []");

		addElementWithListener(1, 6);
		checkObservableList(observableList, Arrays.asList(5, 6), "La til 6 i listen [5]");

		addElementWithListener(0, 2);
		checkObservableList(observableList, Arrays.asList(2, 5, 6), "La til 2 i listen [5, 6]");
	}
}