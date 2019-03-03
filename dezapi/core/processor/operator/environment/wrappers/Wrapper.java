package dezapi.core.processor.operator.environment.wrappers;

import org.tribot.api.interfaces.Clickable07;

/**
 * @author JoeDezzy1
 */
@FunctionalInterface
public interface Wrapper<E>
{
	enum Attribute
	{
		Filters,
		Names,
		IDs,
	}

	/**
	 * Unboxes the value this wrapper is wrapping around
	 *
	 * @return the unboxed value of this wrapper
	 */
	E unbox();

	/**
	 * Returns this wrappers instance
	 *
	 * @return this instance
	 */
	default Wrapper<E> wrapper()
	{
		return this;
	}

	/**
	 * Default return for clickable entities
	 *
	 * @return true if this wrapper is clickable
	 */
	default boolean isClickable()
	{
		final E unboxed = unbox();
		return unboxed instanceof Clickable07 && ((Clickable07) unboxed).isClickable();
	}
}
