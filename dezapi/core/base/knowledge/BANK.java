package dezapi.core.base.knowledge;

import java.util.Arrays;
import java.util.AbstractMap.SimpleImmutableEntry;

import org.tribot.api2007.Equipment;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.types.RSArea;
import org.tribot.api2007.types.RSTile;

import static org.tribot.api2007.Skills.*;

import scripts.dezapi.utility.constant.Constants;

/**
 * Stores banks and their traversal methods
 *
 * @author JoeDezzy1
 */
public enum BANK
{
	EDGEVILLE("Edgeville",
	          new RSArea(new RSTile(3101,
	                                3460,
	                                0),
	                     new RSTile(3071,
	                                3514,
	                                0)),
	          BANK_METHOD.GLORY,
	          BANK_METHOD.WALK),

	LUMBRIDGE("Lumbridge",
	          new RSArea(new RSTile(3205,
	                                3225,
	                                2),
	                     new RSTile(3211,
	                                3214,
	                                2)),
	          BANK_METHOD.LUMBRIDGE_TAB,
	          BANK_METHOD.WALK),

	VARROCK_WEST("Varrock",
	             new RSArea(new RSTile(3180,
	                                   3444,
	                                   0),
	                        new RSTile(3185,
	                                   3436,
	                                   0)),
	             BANK_METHOD.VARROCK_TAB,
	             BANK_METHOD.WALK),

	VARROCK_EAST("Varrock",
	             new RSArea(new RSTile(3250,
	                                   3422,
	                                   0),
	                        new RSTile(3257,
	                                   3419,
	                                   0)),
	             BANK_METHOD.VARROCK_TAB,
	             BANK_METHOD.WALK),

	FALADOR_WEST("Falador",
	             new RSArea(new RSTile(3009,
	                                   3357,
	                                   0),
	                        new RSTile(3018,
	                                   3355,
	                                   0)),
	             BANK_METHOD.FALADOR_TAB,
	             BANK_METHOD.WALK),

	FALADOR_EAST("Falador",
	             new RSArea(new RSTile(2943,
	                                   3372,
	                                   0),
	                        new RSTile(2947,
	                                   3368,
	                                   0)),
	             BANK_METHOD.FALADOR_TAB,
	             BANK_METHOD.WALK),

	CATHERBY("Catherby",
	         new RSArea(new RSTile(2806,
	                               3441,
	                               0),
	                    new RSTile(2812,
	                               3438,
	                               0)),
	         BANK_METHOD.CAMELOT_TAB,
	         BANK_METHOD.WALK),

	CAMELOT("Camelot",
	        new RSArea(new RSTile[] {
			        new RSTile(2721,
			                   3493,
			                   0),
			        new RSTile(2721,
			                   3490,
			                   0),
			        new RSTile(2724,
			                   3490,
			                   0),
			        new RSTile(2724,
			                   3487,
			                   0),
			        new RSTile(2728,
			                   3487,
			                   0),
			        new RSTile(2728,
			                   3490,
			                   0),
			        new RSTile(2730,
			                   3490,
			                   0),
			        new RSTile(2730,
			                   3493,
			                   0)
	        }),
	        BANK_METHOD.CAMELOT_TAB,
	        BANK_METHOD.WALK),

	GRAND_EXCHANGE("Grand exchange",
	               new RSArea(new RSTile(3161,
	                                     3492,
	                                     0),
	                          new RSTile(3168,
	                                     3486,
	                                     0)),
	               BANK_METHOD.RING_OF_WEALTH,
	               BANK_METHOD.WALK),

	CASTLE_WARS("Castle wars",
	            new RSArea(new RSTile[] {
			            new RSTile(2442,
			                       3085,
			                       0),
			            new RSTile(2444,
			                       3085,
			                       0),
			            new RSTile(2445,
			                       3085,
			                       0),
			            new RSTile(2445,
			                       3085,
			                       0),
			            new RSTile(2446,
			                       3084,
			                       0),
			            new RSTile(2447,
			                       3083,
			                       0),
			            new RSTile(2447,
			                       3081,
			                       0),
			            new RSTile(2446,
			                       3081,
			                       0),
			            new RSTile(2445,
			                       3081,
			                       0),
			            new RSTile(2444,
			                       3081,
			                       0),
			            new RSTile(2443,
			                       3082,
			                       0),
			            new RSTile(2442,
			                       3082,
			                       0),
			            new RSTile(2442,
			                       3085,
			                       0)
	            }),
	            BANK_METHOD.RING_OF_DUELING,
	            BANK_METHOD.WALK);

	/**
	 * The name
	 */
	private final String name;

	/**
	 * The area of the bank
	 */
	private final RSArea area;
	/**
	 * The methods of access
	 */
	private final BANK_METHOD[] METHODS;

	/**
	 *
	 * @param name
	 * @param METHODS
	 */
	BANK(final String name, final RSArea area, final BANK_METHOD... METHODS)
	{
		this.name = name;
		this.area = area;
		this.METHODS = METHODS;
	}

	/**
	 * Gets the name of the location
	 * @return the name of the location the bank is in
	 */
	public String location()
	{
		return name;
	}

	/**
	 * gets the area to traverse to
	 * @return the area to traverse to to get to the bank
	 */
	public RSArea area()
	{
		return area;
	}

	/**
	 * Gets the bank method travel types
	 * @return the available methods to get to the bank
	 */
	public BANK_METHOD[] METHODS()
	{
		return METHODS;
	}

	/**
	 * Bank methods, add them here
	 */
	public enum BANK_METHOD
	{
		WALK(()->true,
		     entry(0,
		           "")),

		GLORY(()->true,
		      entry(1,
		            Constants.Items.CHARGED_GLORY)),

		CAMELOT_TAB(()->true,
		            entry(1,
		                  Constants.Items.CAMELOT_TAB)),

		LUMBRIDGE_TAB(()->true,
		              entry(1,
		                    Constants.Items.LUMBRIDGE_TAB)),

		VARROCK_TAB(()->true,
		            entry(1,
		                  Constants.Items.VARROCK_TAB)),

		FALADOR_TAB(()->true,
		            entry(1,
		                  Constants.Items.FALADOR_TAB)),

		HOUSE_TAB(()->getActualLevel(SKILLS.CONSTRUCTION) >= 48,
		          entry(1,
		                Constants.Items.HOUSE_TAB)),

		RING_OF_DUELING(()->Inventory.find(Constants.Items.RING_OF_DUELING).length
		                    + Equipment.find(Constants.Items.RING_OF_DUELING).length > 0,
		                entry(1,
		                      Constants.Items.RING_OF_DUELING)),

		RING_OF_WEALTH(()->Inventory.find(Constants.Items.RING_OF_WEALTH_CHARGED).length
		                   + Equipment.find(Constants.Items.RING_OF_WEALTH_CHARGED).length > 0,
		               entry(1,
		                     Constants.Items.RING_OF_WEALTH_CHARGED)),

		HOUSE_RUNES(()->getActualLevel(SKILLS.CONSTRUCTION) >= 48 && getActualLevel(SKILLS.MAGIC) >= 40,
		            entry(1,
		                  Constants.Items.LAW_RUNE),
		            entry(1,
		                  Constants.Items.EARTH_RUNE),
		            entry(1,
		                  Constants.Items.AIR_RUNE));
		/**
		 * The items required for the bank method with the amount needed
		 */
		private final java.util.Map.Entry<String[], Integer>[] items;
		/**
		 * The requirement satisifier
		 */
		private final java.util.function.BooleanSupplier requirements;

		/**
		 * Create a new bankign method
		 * @param requirements - the requirements for the teleport to be useable by the player
		 * @param items - the item name entries with how many are neccessary of that item
		 */
		@SafeVarargs
		BANK_METHOD(final java.util.function.BooleanSupplier requirements,
		            final java.util.Map.Entry<String[], Integer>... items)
		{
			this.requirements = requirements;
			this.items = items;
		}

		/**
		 * Will return true if the requirements to use the bank method are satisfied by the current player
		 * @return the requirements validator
		 */
		public java.util.function.BooleanSupplier getRequirements()
		{
			return this.requirements;
		}

		/**
		 * Get the entries stored with how many of each item is needed to preform the bank method
		 * @return the bank method entries
		 */
		public java.util.Map.Entry<String[], Integer>[] getItemEntries()
		{
			return this.items;
		}

		/**
		 * Gets the 2x array with all item names for each item requirement
		 *
		 * @return the 2x array with all names that meet the specific bank method requirement i.e)
		 * new String[][] {
		 *     { "Glory 1", "Glory 2", "Glory etc..." }
		 *     { "Earth rune", "Earth battlestaff" }
		 *     { "Law rune" }
		 * }
		 */
		public String[][] getItems()
		{
			final String[][] items = new String[this.items.length][];
			int[] ndx = new int[] { -1 };
			Arrays.stream(items).forEach(i->items[++ndx[0]] = this.items[ndx[0]].getKey());
			return items;
		}

		/**
		 * Helper method
		 * @param amount
		 * @param names
		 * @return a new entry instance
		 */
		private static SimpleImmutableEntry<String[], Integer> entry(final int amount, final String... names)
		{
			return new SimpleImmutableEntry<>(names,
			                                  amount);
		}

	}

}
