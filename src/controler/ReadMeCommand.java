package controler;

/**
 * add README to list
 * @author Vincent Lacasse
 *
 */

@SuppressWarnings("serial")
class ReadMeCommand extends Command {

	@Override
	public void execute() {
		add("    README.md exists\n");
	}
}
