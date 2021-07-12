package model;


import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import visitor.Visitor;

/**
 * Directory classe that accepts a visitor
 * @author Vincent Lacasse
 *
 */

public class Directory extends Node {
	
	private List<Node> children;

	public Directory(File file) {
		super(file);
		Node node;
		children = new ArrayList<Node>();
		
		for (File f : getFile().listFiles()) {
			if (f.isDirectory()) {
				node = new Directory(f);
			}
			else {
				node = new FileV(f);
			}
			children.add(node);
		}
	}
		
	public void accept (Visitor v) {
		Iterator<Node> i = children.iterator();
		v.visit(this);
		while (i.hasNext()) {
			i.next().accept(v);
		}
	}
}
