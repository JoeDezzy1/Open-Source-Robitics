package dezapi.core.base.knowledge;

import org.tribot.api2007.Inventory;
import org.tribot.api2007.Skills;
import org.tribot.api2007.Skills.SKILLS;
import org.tribot.api2007.ext.Filters;
import org.tribot.api2007.types.RSItem;
import org.tribot.api2007.types.RSItemDefinition;
import scripts.dezapi.core.processor.operator.environment.wrappers.Wrapper;

import java.util.Arrays;

/**
 * @author JoeDezzy1
 * An enum that has all the food items stored
 * <p>
 * Gives their healing amount and their know names and phases
 * <p>
 * The list is in order from least to greatest in healing power
 */
public enum FOOD implements Wrapper<RSItem[]>
{
	SHRIMP(3,
	       "Shrimp"),
	COOKED_CHICKEN(3,
	               "Cooked Chicken"),
	SARDINE(3,
	        "Sardine"),
	COOKED_MEAT(3,
	            "Cooked meat"),
	BREAD(5,
	      "Bread"),
	HERRING(5,
	        "Herring"),
	MACKEREL(6,
	         "Mackerel"),
	TROUT(7,
	      "Trout"),
	COD(7,
	    "Cod"),
	PIKE(8,
	     "Pike"),
	ROAST_BEAST_MEAT(8,
	                 "Roast beast meat"),
	PINEAPPLE_PUNCH(9,
	                "Pineapple punch"),
	SALMON(9,
	       "Salmon"),
	TUNA(10,
	     "Tuna"),
	JUG_OF_WINE(11,
	            "Jug of wine"),
	RAINBOW_FISH(11,
	             "Rainbow fish"),
	STEW(11,
	     "Stew"),
	CAKE(12 / 3,
	     "Cake",
	     "Cake 2/3",
	     "Cake 1/3"),
	MEAT_PIE(12 / 2,
	         "Meat pie",
	         "Half of meat pie"),
	LOBSTER(12,
	        "Lobster"),
	BASS(13,
	     "Bass"),
	PLAIN_PIZZA(14 / 2,
	            "Plain pizza",
	            "Half of plain pizza"),
	SWORDFISH(14,
	          "Swordfish"),
	POTATO_WITH_BUTTER(14,
	                   "Potato with butter"),
	CHOCOLATE_CAKE(15 / 3,
	               "Chocolate cake",
	               "Chocolate cake 2/3",
	               "Chocolate cake 1/3"),
	TANGLED_TOADS_LEGS(15,
	                   "Tangled toads legs"),
	POTATO_WITH_CHEESE(16,
	                   "Potato with cheese"),
	MEAT_PIZZA(16 / 2,
	           "Meat pizza",
	           "Half of meat pizza"),
	MONKFISH(16,
	         "Monkfish"),
	ANCHOVY_PIZZA(18 / 2,
	              "Anchovy pizza",
	              "Half of anchovy pizza"),
	COOKED_KARAMBWAN(18,
	                 "Cooked karambwan"),
	CURRY(19,
	      "Curry"),
	UGTHANKI_KEBAB(19,
	               "Ugthanki kebab"),
	MUSHROOM_POTATO(20,
	                "Mushroom potato"),
	SHARK(20,
	      "Shark"),
	SEA_TUTRLE(21,
	           "Sea turtle"),
	PINEAPPLE_PIZZA(22 / 2,
	                "Pineapple pizza",
	                "Half of pineapple pizza"),
	MANTA_RAY(22,
	          "Manta ray"),
	TUNA_POTATO(22,
	            "Tuna potato"),
	DARK_CRAB(22,
	          "Dark crab"),
	SARADOMIN_BREW(64 / 4,
	               "Saradomin brew(4)",
	               "Saradomin brew(3)",
	               "Saradomin brew(2)",
	               "Saradomin brew(1)");

	/**
	 * The amount the food heals
	 */
	private final int heals;

	/**
	 * The names/phases of the food
	 */
	private final String[] names;

	/**
	 * Creates a new enum type of food
	 *
	 * @param heals
	 * 		- the amount of health the food gives to the player
	 * @param names
	 * 		- the known names/phases of the food
	 */
	FOOD(int heals, String... names)
	{
		this.heals = heals;
		this.names = names;
	}

	FOOD()
	{
		this.heals = -1;
		this.names = new String[0];
	}

	/**
	 * Gets the amount that the food heals for a player
	 *
	 * @return the healing amount
	 */
	public int getHealAmount()
	{
		return heals;
	}

	/**
	 * Gets the names for the food
	 *
	 * @return all of the known names for the food
	 */
	public String[] getNames()
	{
		return names;
	}

	/**
	 * @return
	 */
	public boolean hasFood()
	{
		return this.unbox().length > 0;
	}

	/**
	 * @param countStacks
	 * @return
	 */
	public int getTotal(boolean countStacks)
	{
		return countStacks
		       ? Arrays.stream(unbox()).mapToInt(RSItem::getStack).sum()
		       : unbox().length;
	}

	/**
	 * The unboxed attribute
	 *
	 * @return
	 */
	@Override
	public RSItem[] unbox()
	{
		final RSItemDefinition[] definition = new RSItemDefinition[1];
		return Inventory.find(a->(definition[0] = a.getDefinition()) != null && Arrays.asList(getNames())
				.contains(definition[0].getName()));
	}

	/**
	 * Determines if we should eat food or if its a waste because it heals more than we can currently heal
	 *
	 * @param FOOD
	 * 		- the food to check
	 * @return true if the food will be beneficial to heal
	 */
	public static boolean shouldEatAtBank(FOOD FOOD)
	{
		return Skills.getActualLevel(SKILLS.HITPOINTS) - Skills.getCurrentLevel(SKILLS.HITPOINTS)
		       >= FOOD.getHealAmount();
	}

	/**
	 * Determines if we have the specified food type in our inventory
	 *
	 * @param FOOD
	 * 		- the type of food to check if we have
	 * @return true if we have the food in our inventory
	 */
	public static boolean hasFood(FOOD FOOD)
	{
		return FOOD.unbox().length > 0;
	}

	/**
	 * Gets any food we have in the inventory
	 *
	 * @return true if we have any type of food in the inventory
	 */
	public static RSItem[] getAnyValidFood()
	{
		return Inventory.find(Filters.Items.actionsContains("Eat"));
	}

	/**
	 * @param checking
	 * @return
	 */
	public static boolean isFood(String checking)
	{
		return Arrays.stream(values()).anyMatch(a->Arrays.asList(a.getNames()).contains(checking));
	}

	/**
	 * @param checking
	 * @return
	 */
	public static FOOD getFoodFor(String checking)
	{
		return Arrays.stream(values())
				.distinct()
				.filter(a->Arrays.asList(a.getNames()).contains(checking))
				.findFirst()
				.orElse(null);
	}

	/**
	 * @return
	 */
	public static FOOD getAnyValidFoodType()
	{
		return Arrays.stream(values())
				.distinct()
				.filter(a->Inventory.find(a.getNames()).length > 0)
				.findAny()
				.orElse(null);
	}

}
