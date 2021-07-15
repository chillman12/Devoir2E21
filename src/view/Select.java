package view;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.File;
import java.util.Iterator;

import javax.swing.JFileChooser;

import model.Directory;
import model.Node;
import visitor.CollectInfo;
//import visitor.CollectInfo;

public class Select implements ActionListener {
	
	public Select(PropertyChangeListener pcl) {
		addPropertyChangeListener(pcl);
	}
	
	private Iterator<String> imports = new Iterator<String>() {
		public boolean hasNext() { return false; }
		public String next() { return null; }
	};
	
	// Allows user to select a directory
	public void actionPerformed(ActionEvent e) {
		int result;
		File name;

		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		result = fileChooser.showOpenDialog(null);

		if (result == JFileChooser.APPROVE_OPTION) {   
			// get directory name
			name = new File(fileChooser.getSelectedFile().getPath());

			// create data structure that contains the directory tree under name
			Node base = new Directory(name);

			// create visitor
			CollectInfo visitor = new CollectInfo();
			
			// execute visitor and get imports results
			base.accept(visitor);
			imports = visitor.iterator();
			
			// advise obsevers that new results are available
	        pcs.firePropertyChange(null, null, null);
		}
	}
	
	// returns imports 
	public Iterator<String> getResults() {
		return imports;
	}

	// the following lines implements the Observer design pattern.
	// Select is a subject.
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        pcs.removePropertyChangeListener(listener);
    }
}
