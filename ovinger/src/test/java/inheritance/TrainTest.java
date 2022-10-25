package inheritance;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TrainTest {

	private Train train;
	private PassengerCar pc1, pc2;
	private CargoCar cc1, cc2;

	@BeforeEach
	public void setup() {
		train = new Train();
		pc1 = new PassengerCar(2000, 200);
		pc2 = new PassengerCar(1500, 100);
		cc1 = new CargoCar(3000, 5000);
		cc2 = new CargoCar(2500, 7000);
	}

	@Test
	@DisplayName("Sjekk at toget inneholder vogner etter at de er lagt til")
	public void testAddCarToTrain() {
		train.addTrainCar(pc1);
		train.addTrainCar(pc2);
		train.addTrainCar(cc1);
		Assertions.assertTrue(train.contains(pc1), "Toget skulle inneholdt passasjervogn 1 etter at det er lagt til");
		Assertions.assertTrue(train.contains(pc2), "Toget skulle inneholdt passasjervogn 2 etter at det er lagt til");
		Assertions.assertTrue(train.contains(cc1), "Toget skulle inneholdt lastvogn 1 etter at det er lagt til");
		Assertions.assertFalse(train.contains(cc2), "Toget skulle inneholdt lastvogn 2 etter at det er lagt til");
	}

	@Test
	@DisplayName("Sjekke totalvekt på toget etter å ha lagt til vogner")
	public void testTotalTrainWeight() {
		train.addTrainCar(pc1);
		train.addTrainCar(cc1);

		Assertions.assertEquals(8000 + (2000 + (200 * 80)), train.getTotalWeight(),
				"Togets totalvekt ble feil etter å ha lagt til to vogner");

		train.addTrainCar(pc2);

		Assertions.assertEquals(8000 + (2000 + (200 * 80)) + (1500 + (100 * 80)), train.getTotalWeight(),
				"Togets totalvekt ble feil etter å ha lagt til  enda en passasjervogn");
	}

	@Test
	@DisplayName("Sjekk total passajerantall etter å ha lagt til to passasjervogner")
	public void testPassengerCount() {
		train.addTrainCar(pc1);
		train.addTrainCar(pc2);
		Assertions.assertEquals(300, train.getPassengerCount(),
				"Passasjerantall ble feil etter å ha lagt til to passasjervogner");
		train.addTrainCar(cc1);
		Assertions.assertEquals(300, train.getPassengerCount(),
				"Passasjerantall ble feil etter å ha lagt til en lastvogn");
	}

	@Test
	@DisplayName("Sjekk lastvekt på toget etter å ha lagt til to lastvogner")
	public void testCargoWeight() {
		train.addTrainCar(cc1);
		train.addTrainCar(cc2);
		Assertions.assertEquals(12000, train.getCargoWeight(), "Lastvekt ble feil etter å ha lagt til to lastvogner");

		train.addTrainCar(pc1);
		Assertions.assertEquals(12000, train.getCargoWeight(),
				"Lastvekt ble feil etter å ha lagt til en passasjervogn");
	}
}