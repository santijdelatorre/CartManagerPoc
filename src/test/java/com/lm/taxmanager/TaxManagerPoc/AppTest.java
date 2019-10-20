package com.lm.taxmanager.TaxManagerPoc;

import java.util.ArrayList;
import java.util.List;

import com.lm.cartmanager.CartManager;
import com.lm.cartmanager.constants.ItemType;
import com.lm.cartmanager.entity.CartEntry;
import com.lm.cartmanager.entity.CartTotalOutput;
import com.lm.cartmanager.entity.Item;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {

	public void testInput1() {
		System.out.println("--- TEST Cart 1 Begin ---");
		
		Item item1 = new Item("Book", ItemType.BOOK, 12.49, false);
		Item item2 = new Item("music CD", ItemType.GENERIC, 14.99, false);
		Item item3 = new Item("chocolate bar", ItemType.FOOD, 0.85, false);

		CartEntry cartEntry1 = new CartEntry(item1, 1);
		CartEntry cartEntry2 = new CartEntry(item2, 1);
		CartEntry cartEntry3 = new CartEntry(item3, 1);

		List<CartEntry> cart = new ArrayList<CartEntry>();
		cart.add(cartEntry1);
		cart.add(cartEntry2);
		cart.add(cartEntry3);
		CartManager cartManager = new CartManager();
		CartTotalOutput cartOutput = cartManager.getcartbreakdown(cart);

		for (CartEntry cartEntry : cartOutput.getEntries()) {
			System.out.println(cartEntry.getNumberOfElements() + " " + cartEntry.getItem().getDescription() + ": "
					+ cartEntry.getTotalCost());
		}

		System.out.println("Sales Taxes: " + cartOutput.getSalesTaxes());
		System.out.println("TOTAL: " + cartOutput.getTotalCart());

		assertEquals(1.50, cartOutput.getSalesTaxes().doubleValue());
		assertEquals(29.83, cartOutput.getTotalCart().doubleValue());

		System.out.println("--- TEST Cart 1 End ---");

	}

	public void testInput2() {
		System.out.println("--- TEST Cart 2 Begin ---");
		
		Item item1 = new Item("box of chocolates", ItemType.FOOD, 10.00, true);
		Item item2 = new Item("bottle of perfume", ItemType.GENERIC, 47.50, true);

		CartEntry cartEntry1 = new CartEntry(item1, 1);
		CartEntry cartEntry2 = new CartEntry(item2, 1);

		List<CartEntry> cart = new ArrayList<CartEntry>();
		cart.add(cartEntry1);
		cart.add(cartEntry2);
		CartManager cartManager = new CartManager();
		CartTotalOutput cartOutput = cartManager.getcartbreakdown(cart);

		for (CartEntry cartEntry : cartOutput.getEntries()) {
			System.out.println(cartEntry.getNumberOfElements() + " " + cartEntry.getItem().getDescription() + ": "
					+ cartEntry.getTotalCost());
		}

		System.out.println("Sales Taxes: " + cartOutput.getSalesTaxes());
		System.out.println("TOTAL: " + cartOutput.getTotalCart());

		assertEquals(7.65, cartOutput.getSalesTaxes().doubleValue());
		assertEquals(65.15, cartOutput.getTotalCart().doubleValue());
		
		System.out.println("--- TEST Cart 2 End ---");

	}

	public void testInput3() {
		System.out.println("--- TEST Cart 3 Begin ---");
		
		Item item1 = new Item("bottle of perfume", ItemType.GENERIC, 27.99, true);
		Item item2 = new Item("bottle of perfume", ItemType.GENERIC, 18.99, false);
		Item item3 = new Item("packet of headache pills", ItemType.MEDICAL, 9.75, false);
		Item item4 = new Item("box of chocolates", ItemType.FOOD, 11.25, true);

		CartEntry cartEntry1 = new CartEntry(item1, 1);
		CartEntry cartEntry2 = new CartEntry(item2, 1);
		CartEntry cartEntry3 = new CartEntry(item3, 1);
		CartEntry cartEntry4 = new CartEntry(item4, 1);

		List<CartEntry> cart = new ArrayList<CartEntry>();
		cart.add(cartEntry1);
		cart.add(cartEntry2);
		cart.add(cartEntry3);
		cart.add(cartEntry4);
		CartManager cartManager = new CartManager();
		CartTotalOutput cartOutput = cartManager.getcartbreakdown(cart);

		for (CartEntry cartEntry : cartOutput.getEntries()) {
			System.out.println(cartEntry.getNumberOfElements() + " " + cartEntry.getItem().getDescription() + ": "
					+ cartEntry.getTotalCost());
		}

		System.out.println("Sales Taxes: " + cartOutput.getSalesTaxes());
		System.out.println("TOTAL: " + cartOutput.getTotalCart());

		assertEquals(6.70, cartOutput.getSalesTaxes().doubleValue());
		assertEquals(74.68, cartOutput.getTotalCart().doubleValue());

		
		System.out.println("--- TEST Cart 3 End ---");

	}
}
