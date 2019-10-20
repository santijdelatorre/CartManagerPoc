package com.lm.cartmanager.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Utility Class for amount calculations.
 * 
 * @author santiagojimenodelatorre
 *
 */
public class TaxUtils {

	private final static BigDecimal TAX_ROUND_INCREMENT = new BigDecimal(0.05);
	
	public static BigDecimal roundAmount(final BigDecimal value) {
		
		BigDecimal divided = value.divide(TAX_ROUND_INCREMENT, 0, RoundingMode.UP);
		BigDecimal result = divided.multiply(TAX_ROUND_INCREMENT);
		
		return result.setScale(2, BigDecimal.ROUND_HALF_EVEN);
	}
}
