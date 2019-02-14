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
}
