package model;


import java.io.File;

import visitor.Visitor;

/**
 * Abstract file class that accepts a visitor
 * @author Vincent Lacasse
 *
 */

public abstract class Node {
	
	private File file;
	
	public Node(File file) {
		this.file = file;
	}
	
	public File getFile () {
		return file;
	}
	
	public abstract void accept(Visitor v);
}