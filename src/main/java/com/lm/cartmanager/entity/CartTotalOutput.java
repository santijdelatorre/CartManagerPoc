package com.lm.cartmanager.entity;

import java.math.BigDecimal;
import java.util.List;

/**
 * Class for storing and generation data for Cart output.
 * 
 * @author santiagojimenodelatorre
 *
 */
public class CartTotalOutput {

	private List<CartEntry> entries;
	
	private BigDecimal salesTaxes = BigDecimal.ZERO;
	
	private BigDecimal totalCart = BigDecimal.ZERO;

	public List<CartEntry> getEntries() {
		return entries;
	}

	public void setEntries(List<CartEntry> entries) {
		this.entries = entries;
	}

	public BigDecimal getSalesTaxes() {
		return salesTaxes;
	}

	public void setSalesTaxes(BigDecimal salesTaxes) {
		this.salesTaxes = salesTaxes;
	}

	public BigDecimal getTotalCart() {
		return totalCart;
	}

	public void setTotalCart(BigDecimal totalCart) {
		this.totalCart = totalCart;
	}
	
}
