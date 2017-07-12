package test;

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

import components.Attribute;
import components.BasicNode;
import components.Instance;

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
import java.util.LinkedHashMap;

import javax.swing.Action;

public class FrameInstance extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	public Attribute attrib;
	public LinkedHashMap <String, String> attributes;
	public Instance instance;
	/**
	 * @wbp.nonvisual location=63,14
	 */
	private final JLabel label = DefaultComponentFactory.getInstance().createTitle("New JGoodies title");
	private JTextField textField;
	private JTextField textField_2;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private final Action action = new SwingAttribute();
	private final Action action_1 = new SwingSave();
	
	FrameAbstractClass fAC;
	FrameConcreteClass fCC;
	Object obj;
	String className;
	
	public String formalNode; // internal node of an instance
	public String actualNode; // external node connected with an instance node (may be following another instance name and "_" character [x_node1])
	
	public LinkedHashMap <String, String> inputBindings;
	public LinkedHashMap <String, String> outputBindings;
	
	private final Action action_2 = new SwingInputBinding();
	private final Action action_3 = new SwingOutputBinding();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameInstance frame = new FrameInstance();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void postAttribValue(){
		if(instance.getAttributes().get(attrib.name) != null){
			System.err.println("You have updated an existing attribute");
			instance.insertAttribute(attrib);
//			System.out.println(instance);
		}
		else instance.insertAttribute(attrib);
		System.out.println("In FrameInstance: Attribute (name, value) = "+attrib.getName() + "  " + attrib.getValue());
	}
	
	public void postInputBinding(){
		if(inputBindings.get(formalNode) != null){
			System.err.println("You have updated an existing attribute");
			inputBindings.put(formalNode, actualNode);
		}
		else inputBindings.put(formalNode, actualNode);
		
		System.out.println(inputBindings);
	}

	public void postOutputBinding(){
		if(outputBindings.get(formalNode) != null){
			System.err.println("You have updated an existing attribute");
			outputBindings.put(formalNode, actualNode);
		}
		else outputBindings.put(formalNode, actualNode);
		
		System.out.println(outputBindings);
	}
	
	/**
	 * Create the frame.
	 */
	public FrameInstance() {
		attrib = new Attribute();
		instance = new Instance();
		
		attributes = new LinkedHashMap<String, String>();
		
		inputBindings = new LinkedHashMap <String, String>();
		outputBindings = new LinkedHashMap <String, String>();
		
		setTitle("Instance");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 537, 240);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Options");
		menuBar.add(mnNewMenu);
		
		JMenu mnAdd = new JMenu("Add");
		mnNewMenu.add(mnAdd);
		
		JMenuItem mntmInputBinding = new JMenuItem("Input Binding");
		mntmInputBinding.setAction(action_2);
		mnAdd.add(mntmInputBinding);
		
		JMenuItem mntmOutputBinding = new JMenuItem("Output Binding");
		mntmOutputBinding.setAction(action_3);
		mnAdd.add(mntmOutputBinding);
		
		JMenuItem mntmNode = new JMenuItem("Attribute");
		mntmNode.setAction(action);
		mnAdd.add(mntmNode);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.setAction(action_1);
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
		
		JMenuItem mntmClassInfo = new JMenuItem("Class Info");
		mnDisplay.add(mntmClassInfo);
		
		JMenuItem mntmNodeList = new JMenuItem("Interface");
		mnDisplay.add(mntmNodeList);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Instance Info");
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
		
		JLabel lblName = new JLabel("Instance Name");
		lblName.setBounds(12, 25, 128, 16);
		desktopPane.add(lblName);
		
		textField = new JTextField();
		textField.setBounds(106, 22, 290, 22);
		desktopPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNodeLabel = new JLabel("Class Name");
		lblNodeLabel.setBounds(12, 60, 128, 16);
		desktopPane.add(lblNodeLabel);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(106, 57, 290, 22);
		desktopPane.add(textField_2);
	}
	
	public FrameInstance(Object o, String className) {
		this.obj = o;
		this.className = className;
		
		if(className == "FrameAbstractClass") this.fAC = FrameAbstractClass.class.cast(obj);
		else if (className == "FrameConcreteClass") this.fCC = FrameConcreteClass.class.cast(obj);
		else System.out.println("Unknown Class name is provided to cast");
		
		
		attrib = new Attribute();
		instance = new Instance();
		
		attributes = new LinkedHashMap<String, String>();
		
		inputBindings = new LinkedHashMap <String, String>();
		outputBindings = new LinkedHashMap <String, String>();
		
		setTitle("Instance " + className);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 537, 240);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Options");
		menuBar.add(mnNewMenu);
		
		JMenu mnAdd = new JMenu("Add");
		mnNewMenu.add(mnAdd);
		
		JMenuItem mntmInputBinding = new JMenuItem("Input Binding");
		mntmInputBinding.setAction(action_2);
		mnAdd.add(mntmInputBinding);
		
		JMenuItem mntmOutputBinding = new JMenuItem("Output Binding");
		mntmOutputBinding.setAction(action_3);
		mnAdd.add(mntmOutputBinding);
		
		JMenuItem mntmNode = new JMenuItem("Attribute");
		mntmNode.setAction(action);
		mnAdd.add(mntmNode);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.setAction(action_1);
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
		
		JMenuItem mntmClassInfo = new JMenuItem("Class Info");
		mnDisplay.add(mntmClassInfo);
		
		JMenuItem mntmNodeList = new JMenuItem("Interface");
		mnDisplay.add(mntmNodeList);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Instance Info");
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
		
		JLabel lblName = new JLabel("Instance Name");
		lblName.setBounds(12, 25, 128, 16);
		desktopPane.add(lblName);
		
		textField = new JTextField();
		textField.setBounds(106, 22, 290, 22);
		desktopPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNodeLabel = new JLabel("Class Name");
		lblNodeLabel.setBounds(12, 60, 128, 16);
		desktopPane.add(lblNodeLabel);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(106, 57, 290, 22);
		desktopPane.add(textField_2);
	}
	
	private class SwingAttribute extends AbstractAction {
		public SwingAttribute() {
			putValue(NAME, "Attribute");
			putValue(SHORT_DESCRIPTION, "Click to add an attribute");
		}
		public void actionPerformed(ActionEvent e) {
			try {
				Object newObj = Class.forName("test.FrameInstance").cast(FrameInstance.this);
				FrameAttribute frame = new FrameAttribute(newObj, "FrameInstance");
				frame.setVisible(true);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	private class SwingSave extends AbstractAction {
		public SwingSave() {
			putValue(NAME, "Save");
			putValue(SHORT_DESCRIPTION, "Press here to save the instance.");
		}
		public void actionPerformed(ActionEvent e) {
			instance.name = textField.getText();
			instance.className = textField_2.getText();
			instance.inputBindings = inputBindings.toString();
			instance.outputBindings = outputBindings.toString();
			
			if(className == "FrameAbstractClass"){
				fAC.instance = instance;
				fAC.postInstanceInfo();
			}
			else if (className == "FrameConcreteClass"){
				fCC.instance = instance;
				fCC.postInstanceInfo();
			}
		}
	}
	private class SwingInputBinding extends AbstractAction {
		public SwingInputBinding() {
			putValue(NAME, "Input Binding");
			putValue(SHORT_DESCRIPTION, "Click to add an input binding (a referential edge from external node to input node)");
		}
		public void actionPerformed(ActionEvent e) {
			try {
				Object newObj = Class.forName("test.FrameInstance").cast(FrameInstance.this);
				FrameInputBinding frame = new FrameInputBinding(newObj, "FrameInstance");
				frame.setVisible(true);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	private class SwingOutputBinding extends AbstractAction {
		public SwingOutputBinding() {
			putValue(NAME, "Output Binding");
			putValue(SHORT_DESCRIPTION, "Click to add an output binding (a referential edge from output node to external node)");
		}
		public void actionPerformed(ActionEvent e) {
			try {
				instance.name = textField.getText();
				Object newObj = Class.forName("test.FrameInstance").cast(FrameInstance.this);
				FrameOutputBinding frame = new FrameOutputBinding(newObj, "FrameInstance");
				frame.setVisible(true);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
