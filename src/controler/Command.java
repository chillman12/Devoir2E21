package controler;


import java.util.ArrayList;

/**
 * Command class, return results as a List of String
 * @author Vincent Lacasse
 *
 */
@SuppressWarnings("serial")
public abstract class Command extends ArrayList<String> {
	public abstract void execute();
}
