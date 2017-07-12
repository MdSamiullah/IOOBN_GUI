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

public class FrameInterface extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	public Attribute attrib;
	public LinkedHashMap <String, String> attributes;
	public BasicNode node;
	public LinkedHashMap <String, BasicNode> nodes;
	public ClassDefn interface1; // int type; // 0 for interface, 1 for abstract class, 2 for class/ concrete class
	
	/**
	 * @wbp.nonvisual location=63,14
	 */
	private final JLabel label = DefaultComponentFactory.getInstance().createTitle("New JGoodies title");
	private JTextField textField;
	private JTextField txtSeparatedByCommas;
	private final Action action = new SwingNode();
	private final Action action_1 = new SwingAttribute();
	private final Action action_2 = new SwingSave();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameInterface frame = new FrameInterface();
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
	
	/**
	 * Create the frame.
	 */
	public FrameInterface() {
		interface1 = new ClassDefn();
		attrib = new Attribute();
		node = new BasicNode();
		attributes = new LinkedHashMap<String, String>();
		nodes = new LinkedHashMap<String, BasicNode>();
		
		setTitle("Interface");
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
		
		JMenuItem mntmAttribute = new JMenuItem("Attribute");
		mntmAttribute.setAction(action_1);
		mnAdd.add(mntmAttribute);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.setAction(action_2);
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
		
		JMenuItem mntmInfo = new JMenuItem("Info");
		mnDisplay.add(mntmInfo);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		table = new JTable();
		contentPane.add(table);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		contentPane.add(desktopPane);
		
		JLabel lblName = new JLabel("Interface Name");
		lblName.setBounds(12, 94, 116, 16);
		desktopPane.add(lblName);
		
		textField = new JTextField();
		textField.setBounds(118, 91, 189, 22);
		desktopPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblListOfParents = new JLabel("List of Parents");
		lblListOfParents.setBounds(12, 147, 98, 16);
		desktopPane.add(lblListOfParents);
		
		txtSeparatedByCommas = new JTextField();
		txtSeparatedByCommas.setToolTipText("");
		txtSeparatedByCommas.setBounds(118, 144, 312, 22);
		desktopPane.add(txtSeparatedByCommas);
		txtSeparatedByCommas.setColumns(10);
		
		JTextArea txtrParentsShouldBe = new JTextArea();
		txtrParentsShouldBe.setText("Parents should be separated by Comma");
		txtrParentsShouldBe.setBounds(118, 179, 312, 26);
		desktopPane.add(txtrParentsShouldBe);
	}
	private class SwingNode extends AbstractAction {
		public SwingNode() {
			putValue(NAME, "Node");
			putValue(SHORT_DESCRIPTION, "Click to add a node");
		}
		public void actionPerformed(ActionEvent e) {
//			FrameNode frame = new FrameNode();
//			frame.setVisible(true);
			
			try {
				Object newObj = Class.forName("test.FrameInterface").cast(FrameInterface.this);
				FrameNode frame = new FrameNode(newObj, "FrameInterface");
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
				Object newObj = Class.forName("test.FrameInterface").cast(FrameInterface.this);
				FrameAttribute frame = new FrameAttribute(newObj, "FrameInterface");
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
			putValue(SHORT_DESCRIPTION, "Press here to save the interface.");
		}
		public void actionPerformed(ActionEvent e) {
			
		}
	}
}
