package com.lm.cartmanager.constants;

import java.math.BigDecimal;

/**
 * Defines Tax Rates by Item Types.
 * 
 * @author santiagojimenodelatorre
 *
 */
public enum ItemType {
	
	GENERIC(TaxConstants.TAX_BASIC_RATE), 
	BOOK(TaxConstants.TAX_EXENTBASIC_RATE), 
	FOOD(TaxConstants.TAX_EXENTBASIC_RATE), 
	MEDICAL(TaxConstants.TAX_EXENTBASIC_RATE);
	
	private BigDecimal rate;
	
	private ItemType(final BigDecimal appliedRate){
		this.rate = appliedRate;
	}
	
	public BigDecimal getRate() {
		return this.rate;
	}
	
}
