package model;


import java.io.File;

import visitor.Visitor;

/**
 * File class that accepts a visitor
 * @author Vincent Lacasse
 *
 */
public class FileV extends Node {
	
	public FileV(File file) {
		super(file);
	}
	
	public void accept(Visitor v) {
		v.visit(this);
	}
}
