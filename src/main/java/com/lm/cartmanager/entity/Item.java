package com.lm.cartmanager.entity;

import java.math.BigDecimal;

import com.lm.cartmanager.constants.ItemType;
import com.lm.cartmanager.constants.TaxConstants;
import com.lm.cartmanager.util.TaxUtils;

/**
 * This class perform the management of Items included into a Cart List, storing data of item, and generating its cost,
 * applying tax rate if correponds.
 * 
 * @author santiagojimenodelatorre
 *
 */
public class Item {
	
	private String description;
	
	private ItemType type;
	
	private BigDecimal cost;
	
	private boolean imported;

	public Item(String description, ItemType type, double cost, boolean imported) {
		this.description = description;
		this.type = type;
		this.cost = new BigDecimal(cost);
		this.imported = imported;
	}

	public String getDescription() {
		return (imported) ? "imported " + description : description;
	}

	public ItemType getType() {
		return type;
	}

	public BigDecimal getCost() {
		return cost;
	}	

	public BigDecimal getTaxToPay(){
		BigDecimal taxAmount = TaxUtils.roundAmount(cost.multiply(type.getRate()));
		BigDecimal taxAmountItemImport = BigDecimal.ZERO;
		if (imported) {
			taxAmountItemImport = TaxUtils.roundAmount(cost.multiply(TaxConstants.TAX_IMPORTED_ITEM_RATE));
		}
		
		return taxAmount.add(taxAmountItemImport);
	}
	
	public BigDecimal getTotalCost() {
		return cost.add(getTaxToPay()).setScale(2, BigDecimal.ROUND_HALF_EVEN);
	}
}
