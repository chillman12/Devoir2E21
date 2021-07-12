package controler;


import java.io.File;

/**
 * Creates command when a command ID is provided.
 * @author Vincent Lacasse
 *
 */
public class Factory {

	public enum ID {
		README,
		LICENSE,
		JAVA,
		XML
	};
	
	private static Factory instance = new Factory();;
	private Factory() { }
	public static Factory get() { return instance; }
	
	public Command create(ID id, File file) {
		switch (id) {
		case README: return new ReadMeCommand();
		case LICENSE: return new LicenseCommand();
		case JAVA: return new JavaCommand(file);
		case XML: return new XMLCommand(file);
		}
		return null;
	}
}
