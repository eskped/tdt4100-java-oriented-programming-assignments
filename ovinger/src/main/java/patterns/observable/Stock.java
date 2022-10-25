package patterns.observable;

import java.util.ArrayList;

public class Stock implements StockListener {
	
	String ticker;
	double price;
	double newValue;
	double oldValue;
	private double oldPriceListener, newPriceListener;
	double oldPrice, newPrice;
	
	ArrayList<StockListener> stockListener = new ArrayList<StockListener>();

	
	
	public Stock(String ticker, double price) {
		this.ticker = ticker;
		this.price = price;
	}
	
	void setPrice(double price) {
		if (price <= 0) {
			throw new IllegalArgumentException("Prisen kan ikke være negativ eller null");
		}
		this.stockPriceChanged(this, this.getPrice(), price);
		this.price = price;
	}
	
	String getTicker() {
		return this.ticker;
	}
	
	double getPrice() {
		return this.price;
	}
	
	void addStockListener(StockListener stockListener) {
		this.stockListener.add(stockListener);
	}
	
	void removeStockListener(StockListener stockListener) {
		this.stockListener.remove(stockListener);

	}

	@Override
	public void stockPriceChanged(Stock stock, double oldValue, double newValue) {
		stock.setPrice(newValue);
	}
}
