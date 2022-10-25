package patterns.observable;

import java.util.ArrayList;
import java.util.Collection;

public class ObservableHighscoreList extends ObservableList {
	
	private ArrayList<Integer> highscores;
	private int maxSize;
	private Collection<ObservableListListener> observers;
	
	public ObservableHighscoreList(int maxSize) {
		if (highscores == null) {
			highscores = new ArrayList<>();
		}
		this.maxSize = maxSize;
	}
	
	public int size() {
		return highscores.size();
	}
	
	public int getElement(int index) {
		return highscores.get(index);
	}
	
	public void addResult(int result) {
		int i = 0;
		boolean bool = false;
		
		if (highscores.size() == 0 && highscores.size() <= maxSize) {
			highscores.add(result);
			i = 0;
			bool = true;
		} else if (highscores.get(highscores.size()-1) < result && highscores.size() < maxSize ) {
			highscores.add(result);
			i = highscores.size()-1;
			bool = true;
		} else {
			for (i = 0; i < highscores.size()-1; i++) {
				if (highscores.get(i) > result) {
					highscores.add(i, result);
					bool = true;
					break;
				} else if (highscores.get(i) == result) {
					i++;
					highscores.add(i, result);
					bool = true;
					break;
				}
			}
		}
		if (bool && observers != null) {
			for (ObservableListListener listener : observers) {
				listener.listChanged(this, i);
			}
		}
		
		if (highscores.size() > maxSize) {
			highscores.remove(highscores.size()-1);
		}
		
	}
	
	public void addObservableListListener(ObservableListListener list) {
		if (observers == null) {
			observers = new ArrayList<>();
		}
		this.observers.add(list);
	}
	
	public void removeObservableListListener(ObservableListListener list) {
		this.observers.remove(list);
	}

	
}
