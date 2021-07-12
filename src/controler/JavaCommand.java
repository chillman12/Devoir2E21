package controler;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Open a file and extract all import lines
 * @author Vincent Lacasse
 *
 */

@SuppressWarnings("serial")
class JavaCommand extends Command {
	
	private File file;
	
	public JavaCommand(File file) {
		this.file = file;
	}

	@Override
	public void execute() {
		FileReader fr = null;

		try {
			fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			br.lines()
			  .filter(s->s.startsWith("import"))
		      .forEach(s->add("        JAVA: " + s + "\n"));
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
