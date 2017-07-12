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
import components.ClassDefn;
import components.Instance;

import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.util.LinkedHashMap;

import javax.swing.Action;

public class FrameConcreteClass extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	public Attribute attrib;
	public LinkedHashMap <String, String> attributes;
	public BasicNode node;
	public LinkedHashMap <String, BasicNode> nodes;
	public ClassDefn concreteClass; // int type; // 0 for interface, 1 for abstract class, 2 for class/ concrete class
	public Instance instance;
	public LinkedHashMap <String, Instance> instances;
	
	/**
	 * @wbp.nonvisual location=63,14
	 */
	private final JLabel label = DefaultComponentFactory.getInstance().createTitle("New JGoodies title");
	private JTextField textField;
	private JTextField txtSeparatedByCommas;
	private JTextField textField_1;
	private final Action action = new SwingNode();
	private final Action action_1 = new SwingEdge();
	private final Action action_2 = new SwingInstance();
	private final Action action_3 = new SwingAttribute();
	private final Action action_4 = new SwingSave();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameConcreteClass frame = new FrameConcreteClass();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void postAttribValue(){
		if(attributes.get(attrib.name) != null){
			System.err.println("You have updated an existing attribute");
			attributes.put(attrib.name, attrib.value);
//			System.out.println(attributes);
		}
		else attributes.put(attrib.name, attrib.value);
		System.out.println("In FrameInstance: Attribute (name, value) = "+attrib.getName() + "  " + attrib.getValue());
	}
	
	public void postNodeInfo(){
		if(nodes.get(node.name) != null){
			System.err.println("You have updated an existing node");
			nodes.put(node.name, node);
		}
		else nodes.put(node.name, node);
		
		System.out.println(nodes);
	}
	
	public void postInstanceInfo(){
		if(instances.get(instance.name) != null){
			System.err.println("You have updated an existing node");
			instances.put(instance.name, instance);
		}
		else instances.put(instance.name, instance);
		
		System.out.println(instances);
	}

	/**
	 * Create the frame.
	 */
	public FrameConcreteClass() {
		concreteClass = new ClassDefn();
		
		attrib = new Attribute();
		
		node = new BasicNode();
		attributes = new LinkedHashMap<String, String>();
		nodes = new LinkedHashMap<String, BasicNode>();
		instances = new LinkedHashMap<String, Instance>();
		
		setTitle("Concrete Class");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 470, 486);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Options");
		menuBar.add(mnNewMenu);
		
		JMenu mnAdd = new JMenu("Add");
		mnNewMenu.add(mnAdd);
		
		JMenuItem mntmNode = new JMenuItem("Node");
		mntmNode.setAction(action);
		mnAdd.add(mntmNode);
		
		JMenuItem mntmEdge = new JMenuItem("Edge");
		mntmEdge.setAction(action_1);
		mnAdd.add(mntmEdge);
		
		JMenuItem mntmInstace = new JMenuItem("Instace");
		mntmInstace.setAction(action_2);
		mnAdd.add(mntmInstace);
		
		JMenuItem mntmAttribute = new JMenuItem("Attribute");
		mntmAttribute.setAction(action_3);
		mnAdd.add(mntmAttribute);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.setAction(action_4);
		mnNewMenu.add(mntmSave);
		
		JMenuItem mntmCompile = new JMenuItem("Compile");
		mnNewMenu.add(mntmCompile);
		
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
		
		JMenuItem mntmNodeList = new JMenuItem("Node List");
		mnDisplay.add(mntmNodeList);
		
		JMenuItem mntmEdges = new JMenuItem("Edges");
		mnDisplay.add(mntmEdges);
		
		JMenuItem mntmCpt = new JMenuItem("CPT");
		mnDisplay.add(mntmCpt);
		
		JMenuItem mntmParentClass = new JMenuItem("Parent Class");
		mnDisplay.add(mntmParentClass);
		
		JMenuItem mntmParentInterfaces = new JMenuItem("Parent Interfaces");
		mnDisplay.add(mntmParentInterfaces);
		
		JMenu mnBeliefe = new JMenu("Beliefe");
		menuBar.add(mnBeliefe);
		
		JMenuItem mntmPropagation = new JMenuItem("Propagation");
		mnBeliefe.add(mntmPropagation);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		table = new JTable();
		contentPane.add(table);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		contentPane.add(desktopPane);
		
		JLabel lblName = new JLabel("Concrete class Name");
		lblName.setBounds(12, 54, 128, 16);
		desktopPane.add(lblName);
		
		textField = new JTextField();
		textField.setBounds(152, 51, 189, 22);
		desktopPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblListOfParents = new JLabel("List of Parent Interfaces");
		lblListOfParents.setBounds(12, 177, 145, 16);
		desktopPane.add(lblListOfParents);
		
		txtSeparatedByCommas = new JTextField();
		txtSeparatedByCommas.setToolTipText("");
		txtSeparatedByCommas.setBounds(152, 174, 278, 22);
		desktopPane.add(txtSeparatedByCommas);
		txtSeparatedByCommas.setColumns(10);
		
		JTextArea txtrParentsShouldBe = new JTextArea();
		txtrParentsShouldBe.setText("Parents should be separated by Comma");
		txtrParentsShouldBe.setBounds(68, 206, 374, 26);
		desktopPane.add(txtrParentsShouldBe);
		
		JLabel lblParentClassName = new JLabel("Parent Class Name");
		lblParentClassName.setBounds(12, 116, 145, 16);
		desktopPane.add(lblParentClassName);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("");
		textField_1.setColumns(10);
		textField_1.setBounds(152, 113, 278, 22);
		desktopPane.add(textField_1);
	}
	private class SwingNode extends AbstractAction {
		public SwingNode() {
			putValue(NAME, "Node");
			putValue(SHORT_DESCRIPTION, "Click to add a node");
		}
		public void actionPerformed(ActionEvent e) {
			
			try {
				Object newObj = Class.forName("test.FrameConcreteClass").cast(FrameConcreteClass.this);
				FrameNode frame = new FrameNode(newObj, "FrameConcreteClass");
				frame.setVisible(true);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	private class SwingEdge extends AbstractAction {
		public SwingEdge() {
			putValue(NAME, "Edge");
			putValue(SHORT_DESCRIPTION, "Click to add an edge");
		}
		public void actionPerformed(ActionEvent e) {
			FrameEdge frame = new FrameEdge();
			frame.setVisible(true);
		}
	}
	private class SwingInstance extends AbstractAction {
		public SwingInstance() {
			putValue(NAME, "Instance");
			putValue(SHORT_DESCRIPTION, "Click to add an instance");
		}
		public void actionPerformed(ActionEvent e) {
			
			try {
				Object newObj = Class.forName("test.FrameConcreteClass").cast(FrameConcreteClass.this);
				FrameInstance frame = new FrameInstance(newObj, "FrameConcreteClass");
				frame.setVisible(true);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	private class SwingAttribute extends AbstractAction {
		public SwingAttribute() {
			putValue(NAME, "Attribute");
			putValue(SHORT_DESCRIPTION, "Click to add an attribute");
		}
		public void actionPerformed(ActionEvent e) {
			try {
				Object newObj = Class.forName("test.FrameConcreteClass").cast(FrameConcreteClass.this);
				FrameAttribute frame = new FrameAttribute(newObj, "FrameConcreteClass");
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
			putValue(SHORT_DESCRIPTION, "Press here to save the Concrete class.");
		}
		public void actionPerformed(ActionEvent e) {
			
		}
	}
}
