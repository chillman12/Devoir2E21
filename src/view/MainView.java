package view;


import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;
import java.awt.Font;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Main View for homework 2
 * @author Vincent Lacasse
 */
@SuppressWarnings("serial")
public class MainView extends JFrame implements PropertyChangeListener {

	private JButton buttonSelect;
	private JButton buttonClose;
	private JTextArea textResults;
	private Select select;

	/**
	 * Constructor
	 * - buils main view
	 * - assigns Listeners to buttons
	 */
	public MainView() {
		super("Dependances");
		JPanel mainPanel;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		mainPanel.setLayout(new BorderLayout(0, 0));
		setContentPane(mainPanel);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		mainPanel.add(buttonPanel, BorderLayout.SOUTH);

		// button Select
		select = new Select(this);
		buttonSelect = new JButton("Choisir repertoire");
		buttonSelect.addActionListener(select);
		buttonPanel.add(buttonSelect);
		
		// button Close
		buttonClose = new JButton("Fermer l'application");
		buttonClose.addActionListener(l->System.exit(0));
		buttonPanel.add(buttonClose);

		// results are shown in a scrollable JTextArea
		textResults = new JTextArea();
		textResults.setFont(new Font("Monospaced", Font.PLAIN, 10));
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(textResults);		
		mainPanel.add(scrollPane, BorderLayout.CENTER);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		StringBuffer sb = new StringBuffer();
		Iterator<String> imports = select.getResults();
		while (imports.hasNext()) {
			sb.append(imports.next());
		}
		textResults.setText(sb.toString());
	}
}