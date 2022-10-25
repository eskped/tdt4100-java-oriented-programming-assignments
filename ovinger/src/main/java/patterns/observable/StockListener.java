package patterns.observable;

public interface StockListener {
	
	void stockPriceChanged(Stock stock, double oldValue, double NewValue);
}
