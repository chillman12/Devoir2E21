package controler;

/**
 * adds LICENSE to list
 * @author Vincent Lacasse
 *
 */

@SuppressWarnings("serial")
class LicenseCommand extends Command {

	@Override
	public void execute() {
		add("    LICENSE exists\n");
	}
}
