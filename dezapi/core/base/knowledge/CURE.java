package scripts.dezapi.core.base.knowledge;

import org.tribot.api2007.Inventory;
import org.tribot.api2007.types.RSItem;
import org.tribot.api2007.types.RSItemDefinition;
import scripts.dezapi.core.processor.operator.environment.wrappers.Wrapper;
import scripts.dezapi.utility.constant.Constants.Items;

import java.util.Arrays;

/**
 * @author JoeDezzy1
 */
public enum CURE implements Wrapper<RSItem[]>
{
	ANY(Items.ALL_ANTIPOISONS),
	ANTIPOISON(Items.ANTIPOISON),
	SUPER_ANTIPOISON(Items.SUPER_ANTIPOISON);

	/**
	 * The names of the cure
	 */
	private String[] names;

	/**
	 * Add cures here, just put their names
	 * @param names the names of thecure
	 */
	CURE(String... names)
	{
		this.names = names;
	}

	/**
	 * Get the names
	 * @return the names of the cure
	 */
	public String[] getNames()
	{
		return names;
	}

	/**
	 * Unboxes the cure
	 * @return the cure, unboxed as an RSItem
	 */
	@Override
	public RSItem[] unbox()
	{
		final RSItemDefinition[] definition = new RSItemDefinition[1];
		return Inventory.find(a->(definition[0] = a.getDefinition()) != null && Arrays.asList(getNames())
				.contains(definition[0].getName()));
	}

	/**
	 * Is something cureable? idk you tell me
	 * @param in - any test string
	 * @return true if it is from my perspective
	 */
	public static boolean isCureable(final String in)
	{
		return Arrays.stream(CURE.values()).anyMatch(c->Arrays.asList(c.names).contains(in));
	}

	/**
	 * Match up a string to see if its a cure
	 * @param in - any test string
	 * @return true if its a match!
	 */
	public static CURE match(final String in)
	{
		return Arrays.stream(CURE.values())
				.filter(c->Arrays.asList(c.names).contains(in))
				.distinct()
				.findFirst()
				.orElse(null);
	}

}
