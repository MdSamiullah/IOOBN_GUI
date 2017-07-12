package test;

/*
 * Warning: from now on, if you directly run this, instead of calling from its parents like "FrameConcreteClass"/
 * "FrameAbstractClass" ... then it will return exception. This is because, it is sending/returning some data
 * attribute name and attribute value to its parents. If there is no parent, then it will return an exception
 * */

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JTable;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;

public class FrameInputBinding extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	public String formalNode; // internal node of an instance
	public String actualNode; // external node connected with an instance node (may be following another instance name and "_" character [x_node1])
	
	FrameInstance fIns;
	
	Object obj;
	String className;
	/**
	 * @wbp.nonvisual location=63,14
	 */
	private final JLabel label = DefaultComponentFactory.getInstance().createTitle("New JGoodies title");
	private JTextField textField;
	private JTextField textField_2;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private final Action action = new SaveBinding();
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameInputBinding frame = new FrameInputBinding();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrameInputBinding() {
		setTitle("Input Bindings");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 548, 299);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Options");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.setAction(action);
		mnNewMenu.add(mntmSave);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JMenuItem mntmCut = new JMenuItem("Cut");
		mnEdit.add(mntmCut);
		
		JMenuItem mntmCopy = new JMenuItem("Copy");
		mnEdit.add(mntmCopy);
		
		JMenuItem mntmPaste = new JMenuItem("Paste");
		mnEdit.add(mntmPaste);
		
		JMenu mnDisplay = new JMenu("Display");
		menuBar.add(mnDisplay);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Attribute Info");
		mnDisplay.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		table = new JTable();
		contentPane.add(table);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		contentPane.add(desktopPane);
		
		JLabel lblName = new JLabel("Internal Node Name");
		lblName.setBounds(12, 25, 128, 16);
		desktopPane.add(lblName);
		
		textField = new JTextField();
		textField.setBounds(138, 22, 290, 22);
		desktopPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNodeLabel = new JLabel("External Node Name");
		lblNodeLabel.setBounds(12, 112, 128, 16);
		desktopPane.add(lblNodeLabel);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(194, 109, 290, 22);
		desktopPane.add(textField_2);
		
		JLabel lblExternalNodeInstance = new JLabel("Keep blank if external node is not a node of an instance");
		lblExternalNodeInstance.setBounds(167, 172, 341, 33);
		desktopPane.add(lblExternalNodeInstance);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(194, 150, 290, 22);
		desktopPane.add(textField_1);
		
		JLabel label_1 = new JLabel("External Node Instance Name");
		label_1.setBounds(12, 153, 168, 16);
		desktopPane.add(label_1);
	}
		
	public FrameInputBinding(Object o, String className) {
		this.obj = o;
		
		this.className = className;
		
		if (className == "FrameInstance") this.fIns = FrameInstance.class.cast(obj);
		else System.out.println("Unknown Class name is provided to cast");
		
		setTitle("Input Bindings");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 548, 299);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Options");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.setAction(action);
		mnNewMenu.add(mntmSave);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JMenuItem mntmCut = new JMenuItem("Cut");
		mnEdit.add(mntmCut);
		
		JMenuItem mntmCopy = new JMenuItem("Copy");
		mnEdit.add(mntmCopy);
		
		JMenuItem mntmPaste = new JMenuItem("Paste");
		mnEdit.add(mntmPaste);
		
		JMenu mnDisplay = new JMenu("Display");
		menuBar.add(mnDisplay);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Attribute Info");
		mnDisplay.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		table = new JTable();
		contentPane.add(table);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		contentPane.add(desktopPane);
		
		JLabel lblName = new JLabel("Internal Node Name");
		lblName.setBounds(12, 25, 128, 16);
		desktopPane.add(lblName);
		
		textField = new JTextField();
		textField.setBounds(138, 22, 290, 22);
		desktopPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNodeLabel = new JLabel("External Node Name");
		lblNodeLabel.setBounds(12, 112, 128, 16);
		desktopPane.add(lblNodeLabel);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(194, 109, 290, 22);
		desktopPane.add(textField_2);
		
		JLabel lblExternalNodeInstance = new JLabel("Keep blank if external node is not a node of an instance");
		lblExternalNodeInstance.setBounds(167, 172, 341, 33);
		desktopPane.add(lblExternalNodeInstance);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(194, 150, 290, 22);
		desktopPane.add(textField_1);
		
		JLabel label_1 = new JLabel("External Node Instance Name");
		label_1.setBounds(12, 153, 168, 16);
		desktopPane.add(label_1);
	}
	
	private class SaveBinding extends AbstractAction {
		public SaveBinding() {
			putValue(NAME, "Save");
			putValue(SHORT_DESCRIPTION, "Click here to save the attribute");
		}
		public void actionPerformed(ActionEvent e) {
			formalNode = textField.getText();
			actualNode = textField_1.getText() + "_" + textField_2.getText();
			
			if(className == "FrameInstance"){
				fIns.formalNode = formalNode;
				fIns.actualNode = actualNode;
				fIns.postInputBinding();
			}
			else System.out.println("Unknown Class name is provided to cast");	
		}
	}
}
