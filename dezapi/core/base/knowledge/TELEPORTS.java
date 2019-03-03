package dezapi.core.base.knowledge;

import org.tribot.api.interfaces.Clickable07;
import org.tribot.api2007.Equipment;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.Skills;
import org.tribot.api2007.types.RSArea;
import org.tribot.api2007.types.RSItem;
import org.tribot.api2007.types.RSTile;

import scripts.dezapi.core.processor.operator.environment.wrappers.Wrapper;
import scripts.dezapi.core.processor.operator.environment.wrappers.types.ItemWrapper;
import scripts.dezapi.core.processor.operator.environment.wrappers.types.MenuWrapper;
import scripts.dezapi.core.processor.operator.environment.wrappers.types.WrapConstants;
import scripts.dezapi.utility.constant.Constants;
import scripts.dezapi.utility.constant.EdgevilleData;
import scripts.dezapi.utility.constant.Constants.Items;

import java.util.AbstractMap;
import java.util.Arrays;

import static org.tribot.api2007.Skills.getActualLevel;

/**
 * @author JoeDezzy1
 */
public enum TELEPORTS implements Wrapper<Clickable07>
{
	GLORY(()->Inventory.find(Items.CHARGED_GLORY).length + Equipment.find(Items.CHARGED_GLORY).length > 0,
	      new RSArea(new RSTile(3075,
	                            3505,
	                            0),
	                 new RSTile(3103,
	                            3476,
	                            0)),
	      entry(1,
	            Constants.Items.CHARGED_GLORY)),

	CAMELOT_TAB(()->Inventory.find(Items.CAMELOT_TAB).length > 0,
	            new RSArea(new RSTile(2751,
	                                  3484,
	                                  0),
	                       new RSTile(2764,
	                                  3468,
	                                  0)),
	            entry(1,
	                  Constants.Items.CAMELOT_TAB)),

	LUMBRIDGE_TAB(()->Inventory.find(Items.LUMBRIDGE_TAB).length > 0,
	              new RSArea(new RSTile(3199,
	                                    3236,
	                                    0),
	                         new RSTile(3227,
	                                    3199,
	                                    0)),
	              entry(1,
	                    Constants.Items.LUMBRIDGE_TAB)),

	VARROCK_TAB(()->Inventory.find(Items.VARROCK_TAB).length > 0,
	            new RSArea(new RSTile(3203,
	                                  3439,
	                                  0),
	                       new RSTile(3223,
	                                  3416,
	                                  0)),
	            entry(1,
	                  Constants.Items.VARROCK_TAB)),

	FALADOR_TAB(()->Inventory.find(Items.FALADOR_TAB).length > 0,
	            new RSArea(new RSTile(2955,
	                                  3391,
	                                  0),
	                       new RSTile(2977,
	                                  3369,
	                                  0)),
	            entry(1,
	                  Constants.Items.FALADOR_TAB)),

	HOUSE_TAB(()->getActualLevel(Skills.SKILLS.CONSTRUCTION) >= 48 && Inventory.find(Items.HOUSE_TAB).length > 0,
	          null,
	          entry(1,
	                Constants.Items.HOUSE_TAB)),

	LUMBRIDGE_HOME(()->true,
	               new RSArea(new RSTile(3191,
	                                     3241,
	                                     0),
	                          new RSTile(3235,
	                                     3197,
	                                     0)),
	               new MenuWrapper(-1,
	                               -1)),

	RING_OF_DUELING(()->Inventory.find(Constants.Items.RING_OF_DUELING).length
	                    + Equipment.find(Constants.Items.RING_OF_DUELING).length > 0,
	                new RSArea(new RSTile(2435,
	                                      3098,
	                                      0),
	                           new RSTile(2447,
	                                      3079,
	                                      0)),
	                entry(1,
	                      Constants.Items.RING_OF_DUELING)),

	RING_OF_WEALTH(()->Inventory.find(Constants.Items.RING_OF_WEALTH_CHARGED).length
	                   + Equipment.find(Constants.Items.RING_OF_WEALTH_CHARGED).length > 0,
	               new RSArea(new RSTile(3142,
	                                     3509,
	                                     0),
	                          new RSTile(3185,
	                                     3455,
	                                     0)),
	               entry(1,
	                     Constants.Items.RING_OF_WEALTH_CHARGED)),

	HOUSE_RUNES(()->getActualLevel(Skills.SKILLS.CONSTRUCTION) >= 48 && getActualLevel(Skills.SKILLS.MAGIC) >= 40,
	            null,
	            entry(3,
	                  Constants.Items.LAW_RUNE,
	                  Constants.Items.EARTH_RUNE,
	                  Constants.Items.AIR_RUNE));
	/**
	 * The items required for the bank method with the amount needed
	 */
	private final Wrapper<? extends Clickable07> wrapper;
	/**
	 * The destination area
	 */
	private final RSArea destination;
	/**
	 * The requirement satisifier
	 */
	private final java.util.function.BooleanSupplier requirements;

	/**
	 * Create a new bankign method
	 * @param requirements - the requirements for the teleport to be useable by the player
	 * @param wrapper - the wrapper entries with what is to be wrapped around and executed on
	 */
	TELEPORTS(final java.util.function.BooleanSupplier requirements, final RSArea destination,
	          final Wrapper<? extends Clickable07> wrapper)
	{
		this.requirements = requirements;
		this.destination = destination;
		this.wrapper = wrapper;
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
	 * Gets the 2x array with all item names for each item requirement
	 *
	 * @return the 2x array with all names that meet the specific bank method requirement i.e)
	 * new String[][] {
	 *     { "Glory 1", "Glory 2", "Glory etc..." }
	 *     { "Earth rune", "Earth battlestaff" }
	 *     { "Law rune" }
	 * }
	 */
	public Wrapper<? extends Clickable07> getWrappers()
	{
		return this.wrapper;
	}

	/**
	 * Helper method
	 * @param amount
	 * @param names
	 * @return a new entry instance
	 */
	private static ItemWrapper entry(final int amount, final String... names)
	{
		return new ItemWrapper(amount,
		                       names);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see scripts.dezapi.wrap.E_WRAPPER#unbox()
	 */
	@Override
	public final Clickable07 unbox()
	{
		return this.wrapper.unbox();
	}

	/**
	 *
	 * @return
	 */
	public final RSArea destination()
	{
		return this.destination;
	}}
