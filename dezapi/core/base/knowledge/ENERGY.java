package dezapi.core.base.knowledge;

import org.tribot.api2007.Inventory;

import org.tribot.api2007.types.RSItem;
import org.tribot.api2007.types.RSItemDefinition;
import scripts.dezapi.core.processor.operator.environment.wrappers.Wrapper;
import scripts.dezapi.utility.constant.Constants.Items;

import java.util.Arrays;

/** @author JoeDezzy1 */
public enum ENERGY implements Wrapper<RSItem[]>
{
	/**
	 * All validate boosts we can use
	 */
	STAMINA_POTION(20,
	               Items.STAMINA_POTIONS),
	SUPER_ENERGY(20,
	             Items.SUPER_ENERGY_POTIONS),
	ENERGY_POTION(10,
	              Items.ENERGY_POTIONS),
	ANY(15,
	    Items.ALL_ENERGY_BOOSTS);

	/**
	 * The names of the boost
	 */
	private String[] names;

	/**
	 * The amount of energy the boost provides
	 */
	private int boost;

	/**
	 * Creates a new energy boost with the boost amount and all of the possible names
	 *
	 * @param boost
	 * 		- the amount the item boosts the energy by
	 * @param names
	 * 		- all the names for the boost
	 */
	ENERGY(int boost, String... names)
	{
		this.boost = boost;
		this.names = names;
	}

	/**
	 * @return the energy item unboxed
	 */
	@Override
	public RSItem[] unbox()
	{
		final RSItemDefinition[] definition = new RSItemDefinition[1];
		return Inventory.find(a->(definition[0] = a.getDefinition()) != null && Arrays.asList(getNames())
				.contains(definition[0].getName()));
	}

	/**
	 * Gets the amount of energy boost from the current boost
	 *
	 * @return the amount of energy boost provided by the boost
	 */
	public int getBoost()
	{
		return boost;
	}

	/**
	 * Gets all the names of the boost
	 *
	 * @return the names
	 */
	public final String[] getNames()
	{
		return names;
	}

	/**
	 * @return
	 */
	public final boolean hasBoost()
	{
		return this.unbox().length > 0;
	}
}
