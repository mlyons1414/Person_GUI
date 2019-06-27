package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import controller.Controller;

public class MainFrame extends JFrame {

	// MainFrame Components
	private TextPanel textPanel;
	private JButton btn;
	private ToolBar toolbar;
	private FormPanel formPanel;
	private JFileChooser fileChooser;
	private Controller controller;
	private TablePanel tablePanel;

	public MainFrame() {
		super("Person DataBase");

		setLayout(new BorderLayout());

		textPanel = new TextPanel();
		toolbar = new ToolBar();
		formPanel = new FormPanel();
		tablePanel = new TablePanel();

		controller = new Controller();

		tablePanel.setData(controller.getPeople());

		fileChooser = new JFileChooser();
		fileChooser.addChoosableFileFilter(new PersonFileFilter());

		setJMenuBar(createMenuBar());

		toolbar.setStringListener(new StringListener() {
			public void textEmitted(String text) {
				textPanel.appendText(text);
			}
		});

		formPanel.setFormListener(new FormListener() {
			public void FormEventOcc(FormEvent e) {
				controller.addPerson(e);
				tablePanel.refresh();
			}
		});

		add(formPanel, BorderLayout.WEST);
		add(tablePanel, BorderLayout.CENTER);
		// add(toolbar, BorderLayout.NORTH);

		setMinimumSize(new Dimension(700, 600));
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setVisible(true);

	}

	public JMenuBar createMenuBar() {

		// Set Up JMenu
		JMenuBar menuBar = new JMenuBar();

		JMenu fileMenu = new JMenu("File");
		JMenu windowMenu = new JMenu("Window");

		JMenuItem exportDataItem = new JMenuItem("Export Data...");
		JMenuItem importDataItem = new JMenuItem("Import Data...");
		JMenuItem exitItem = new JMenuItem("Exit");

		fileMenu.add(importDataItem);
		fileMenu.add(exportDataItem);
		fileMenu.addSeparator();
		fileMenu.add(exitItem);

		JMenu showMenu = new JMenu("Show");
		JCheckBoxMenuItem showFormItem = new JCheckBoxMenuItem("Person Form");
		showFormItem.setSelected(true);

		showMenu.add(showFormItem);
		windowMenu.add(showMenu);

		menuBar.add(fileMenu);
		menuBar.add(windowMenu);

		// Form Panel ActionListner
		showFormItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JCheckBoxMenuItem menuItem = (JCheckBoxMenuItem) e.getSource();

				formPanel.setVisible(menuItem.isSelected());
			}

		});

		// Mnemonics & Accelerators
		fileMenu.setMnemonic(KeyEvent.VK_F);
		windowMenu.setMnemonic(KeyEvent.VK_W);
		exitItem.setMnemonic(KeyEvent.VK_X);
		exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));

		// Import ActionListener
		importDataItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (fileChooser.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
					try {
						controller.loadFromFile(fileChooser.getSelectedFile());
						tablePanel.refresh();
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(MainFrame.this, "Could not load data from file.", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}

		});

		// Export ActionListener
		exportDataItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (fileChooser.showSaveDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
					try {
						controller.saveToFile(fileChooser.getSelectedFile());
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(MainFrame.this, "Could not save data to file.", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}

		});

		// Exit ActionListener
		exitItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int action = JOptionPane.showConfirmDialog(MainFrame.this, "Are you sure you want to Exit?",
						"Confirm Exit", JOptionPane.OK_CANCEL_OPTION);
				if (action == JOptionPane.OK_OPTION) {
					System.exit(0);
				}
			}

		});

		return menuBar;
	}
}
