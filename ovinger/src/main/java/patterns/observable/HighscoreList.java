package patterns.observable;

import java.util.ArrayList;
import java.util.Collection;

public class HighscoreList {
	
	private final int maxSize;
	private ArrayList<Integer> highscores;
	private Collection<HighscoreListListener> highscoreListListeners;
	
	public HighscoreList(int listeners) {
		this.maxSize = listeners;
		this.highscores = new ArrayList<>();
	}
	
	public void addResult(int result) {
		int i = 0;
		boolean bool = false;
		
		if (highscores.size() == 0 && highscores.size() <= maxSize) {
			highscores.add(result);
			i = 0;
			bool = true;
		} else if (highscores.get(highscores.size()-1) < result && highscores.size() <= maxSize ) {
			highscores.add(result);
			i = highscores.size()-1;
			bool = true;
		} else {
			for (i = 0; i < highscores.size(); i++) {
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
		
		if (!bool) {
			fireLL(this,-1);
		} else if (bool) {
			fireLL(this, i);
		}
		
		
		if (highscores.size() > maxSize) {
			int index = highscores.size()-1;
			highscores.remove(index);
		}
	}
	

	private void fireLL(HighscoreList highscoreList, int i) {
		if (highscoreListListeners == null) {
			highscoreListListeners = new ArrayList<>();
		}
		for (HighscoreListListener ll : highscoreListListeners) {
			ll.listChanged(highscoreList, i);
		}
		
	}

	public int size() {
		return highscores.size();
	}
	
	public int getElement(int index) {
		return highscores.get(index);
	}
	
	public void addHighscoreListListener(HighscoreListListener LL) {
		if (highscoreListListeners == null) {
			this.highscoreListListeners = new ArrayList<>();
		}
		highscoreListListeners.add(LL);
	}
	
	public void removeHighscoreListListener(HighscoreListListener LL) {
		highscoreListListeners.remove(LL);
	}
	
}
