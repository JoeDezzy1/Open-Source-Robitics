package scripts.dezapi.core.base.knowledge;

import org.tribot.api2007.NPCChat;
import org.tribot.api2007.types.RSInterface;
import scripts.dezapi.core.processor.operator.environment.wrappers.Wrapper;
import scripts.dezapi.core.processor.operator.environment.wrappers.types.MenuWrapper;
/**
 * @author JoeDezzy1
 */
public enum CHATBOX implements Wrapper<RSInterface>
{
	/**
	 * The chatboxes
	 */
	GAME(8,
	     9),
	PUBLIC(12,
	       13),
	PRIVATE(16,
	        17),
	CLAN(20,
	     21),
	TRADE(24,
	      25);

	/**
	 * The parent ID for the wrapper
	 */
	public static final int PARENT_ID = 162;

	/**
	 * The option wrapper
	 */
	private final MenuWrapper menu;
	/**
	 * The id
	 */
	private final int id;

	/**
	 * @param id
	 *            - the chat box id
	 * @param optionID
	 *            - the id for the menu with the option in it
	 */
	CHATBOX(int id, int optionID)
	{
		this.menu = new MenuWrapper(PARENT_ID,
		                            optionID);
		this.id = id;
	}

	/**
	 * The unboxed attribute
	 *
	 * @return
	 */
	@Override
	public RSInterface unbox()
	{
		return this.menu.unbox();
	}

	/**
	 * @return the text of the chatbox selection
	 */
	public String getText()
	{
		return menu.getText();
	}

	/**
	 * @return
	 */
	public int id()
	{
		return id;
	}

	/**
	 *
	 * @return
	 */
	public static String getNPCName()
	{
		return NPCChat.getName();
	}

	/**
	 *
	 * @return
	 */
	public static String[] getOptions()
	{
		return NPCChat.getOptions();
	}

	/**
	 *
	 * @return
	 */
	public static String getNPCMessage()
	{
		return NPCChat.getMessage();
	}

}
