package com.lm.cartmanager;

import java.util.List;

import com.lm.cartmanager.entity.CartEntry;
import com.lm.cartmanager.entity.CartTotalOutput;

/**
 * Manages processing of data included into Cart List.
 * 
 * @author santiagojimenodelatorre
 *
 */
public class CartManager {

	public CartTotalOutput getcartbreakdown(final List<CartEntry> cartentries) {
		CartTotalOutput cartOutput = new CartTotalOutput();
		cartOutput.setEntries(cartentries);
		
		for (CartEntry cartEntry : cartentries) {
			cartOutput.setSalesTaxes(cartOutput.getSalesTaxes().add(cartEntry.getTotalTax()));
			cartOutput.setTotalCart(cartOutput.getTotalCart().add(cartEntry.getTotalCost()));
		}
		
		return cartOutput;
	}
	
	
}
