package visitor;

import model.Directory;
import model.FileV;

public interface Visitor extends Iterable<String> {
	public void visit(FileV filev);
	public void visit(Directory directory);
}
