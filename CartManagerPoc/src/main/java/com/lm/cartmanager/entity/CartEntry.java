package com.lm.cartmanager.entity;

import java.math.BigDecimal;

/**
 * This class permits the add of Items into a Cart. Contains data of item included and the number of elements 
 * of this item added to the cart.
 * 
 * @author santiagojimenodelatorre
 *
 */
public class CartEntry {

	private Item item;
	
	private int numberOfElements;
		
	public CartEntry(Item item, int numberOfElements) {
		super();
		this.item = item;
		this.numberOfElements = numberOfElements;
	}

	public Item getItem() {
		return item;
	}
	
	public int getNumberOfElements() {
		return numberOfElements;
	}
	
	public BigDecimal getTotalTax() {
		BigDecimal totalTax = BigDecimal.ZERO;
		for (int i = 0; i < numberOfElements; i++) {
			totalTax = totalTax.add(item.getTaxToPay());
		}
		
		return totalTax.setScale(2, BigDecimal.ROUND_HALF_EVEN);
	}
	
	public BigDecimal getTotalCost() {
		BigDecimal totalCost = BigDecimal.ZERO;
		for (int i = 0; i < numberOfElements; i++) {
			totalCost = totalCost.add(item.getTotalCost());
		}
		
		return totalCost.setScale(2, BigDecimal.ROUND_HALF_EVEN);
		
	}
}
