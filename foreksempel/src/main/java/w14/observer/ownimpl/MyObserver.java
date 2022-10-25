package w14.observer.ownimpl;

public class MyObserver implements MyChangeListner {
	private String observerName;

	public MyObserver(String observerName) {
		this.observerName = observerName;
	}

	@Override
	public void changeNotification(String lastMsg, String newMsg) {
		System.out.println(
				String.format("[%s] => (last) '%s' vs. (new) '%s'", observerName, lastMsg, newMsg));
	}
}
