package edu.bsu.cs.hergin.integration_test_mock;

import java.util.ArrayList;
import java.util.List;

public class Store {
	List<Item> items;
	ItemPriceService itemPriceService;

	public Store() {
		items = new ArrayList<>();
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public ItemPriceService getItemPriceService() {
		return itemPriceService;
	}

	public void setItemPriceService(ItemPriceService itemPriceService) {
		this.itemPriceService = itemPriceService;
	}

	public double getInventoryValue() {
		double result = 0.0;
		for (Item item : items) {
			result += itemPriceService.getPrice(item) * item.getQuantity();
		}
		return result;
	}

	public Item getTheMostExpensiveProduct() {
		Item result = null;
		if (items.size() > 0) {
			result = items.get(0);
		}
		for (Item item : items) {
			if (itemPriceService.getPrice(item) > itemPriceService.getPrice(result)) {
				result = item;
			}
		}
		return result;
	}

	public Item getTheCheapestProduct() {
		Item result = null;
		if (items.size() > 0) {
			result = items.get(0);
		}
		for (Item item : items) {
			if (itemPriceService.getPrice(item) < itemPriceService.getPrice(result)) {
				result = item;
			}
		}
		return result;
	}

	public List<Double> getAllPrices() {
		List<Double> result = new ArrayList<Double>();
		for (Item item : items) {
			result.add(itemPriceService.getPrice(item));
		}
		return result;
	}
}
