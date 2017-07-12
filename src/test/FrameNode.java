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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

import javax.swing.Action;

public class FrameNode extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	public Attribute attrib;
	public LinkedHashMap <String, String> attributes;
	public BasicNode node;
	
	public ArrayList<String> numdata;
	ArrayList<String> parents;
	public String parentString; 
	
	/**
	 * @wbp.nonvisual location=63,14
	 */
	private final JLabel label = DefaultComponentFactory.getInstance().createTitle("New JGoodies title");
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JTextField textField_4;
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private JTextField textField_5;
	private final Action action = new SwingAttribute();
	private final Action action_1 = new SwingBelief();
	
	public FrameAbstractClass fAC;
	public FrameConcreteClass fCC;
	public FrameInterface fInf;
	public Object obj;
	public String className;
	
	private final Action action_2 = new SwingSave();
	private final Action action_3 = new SwingParent();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameNode frame = new FrameNode();
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
		System.out.println("In FrameNode: Attribute (name, value) = "+attrib.getName() + "  " + attrib.getValue());
	}
	
	public void postBelief(){
		
		System.out.println("In FrameNode: Belief = "+ numdata);
	}
	
	public void postParents(){
		String String1 = parentString;
		parents = new ArrayList<String> (Arrays.asList(String1.split(" ")));
		System.out.println("In FrameNode: Parents = "+ parents);
	}

	/**
	 * Create the frame.
	 */
	public FrameNode() {
		attrib = new Attribute();
		node = new BasicNode();
		attributes = new LinkedHashMap<String, String>();
		
		parents = new ArrayList<String>();
		
//		data = new Object[numOfRow][numOfCol];
		
		setTitle("Node");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 537, 529);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Options");
		menuBar.add(mnNewMenu);
		
		JMenu mnAdd = new JMenu("Add");
		mnNewMenu.add(mnAdd);
		
		JMenuItem mntmNode = new JMenuItem("Belief");
		mntmNode.setAction(action_1);
		mnAdd.add(mntmNode);
		
		JMenuItem mntmParent = new JMenuItem("Parent");
		mntmParent.setAction(action_3);
		mnAdd.add(mntmParent);
		
		JMenuItem mntmAttribute = new JMenuItem("Attribute");
		mntmAttribute.setAction(action);
		mnAdd.add(mntmAttribute);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.setAction(action_2);
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
		
		JMenuItem mntmClassInfo = new JMenuItem("Node Info");
		mnDisplay.add(mntmClassInfo);
		
		JMenuItem mntmNodeList = new JMenuItem("Belief");
		mnDisplay.add(mntmNodeList);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		table = new JTable();
		contentPane.add(table);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		contentPane.add(desktopPane);
		
		JLabel lblName = new JLabel("Node Name");
		lblName.setBounds(12, 25, 128, 16);
		desktopPane.add(lblName);
		
		textField = new JTextField();
		textField.setBounds(91, 22, 290, 22);
		desktopPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblParentClassName = new JLabel("Position in GUI:");
		lblParentClassName.setBounds(12, 97, 89, 16);
		desktopPane.add(lblParentClassName);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("");
		textField_1.setColumns(10);
		textField_1.setBounds(162, 94, 69, 22);
		desktopPane.add(textField_1);
		
		JLabel lblNodeLabel = new JLabel("Node Label");
		lblNodeLabel.setBounds(12, 60, 128, 16);
		desktopPane.add(lblNodeLabel);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(91, 57, 290, 22);
		desktopPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setToolTipText("");
		textField_3.setColumns(10);
		textField_3.setBounds(312, 94, 69, 22);
		desktopPane.add(textField_3);
		
		JLabel lblXCoord = new JLabel("X Coord");
		lblXCoord.setBounds(103, 97, 54, 16);
		desktopPane.add(lblXCoord);
		
		JLabel lblYCoord = new JLabel("Y Coord");
		lblYCoord.setBounds(257, 97, 54, 16);
		desktopPane.add(lblYCoord);
		
		JRadioButton rdbtnDiscreteChance = new JRadioButton("Discrete Chance");
		buttonGroup.add(rdbtnDiscreteChance);
		rdbtnDiscreteChance.setSelected(true);
		rdbtnDiscreteChance.setBounds(91, 132, 127, 25);
		desktopPane.add(rdbtnDiscreteChance);
		
		JRadioButton rdbtnContinuosChance = new JRadioButton("Continuos Chance");
		buttonGroup.add(rdbtnContinuosChance);
		rdbtnContinuosChance.setBounds(91, 162, 136, 25);
		desktopPane.add(rdbtnContinuosChance);
		
		JRadioButton rdbtnDecision = new JRadioButton("Decision");
		buttonGroup.add(rdbtnDecision);
		rdbtnDecision.setBounds(91, 193, 81, 25);
		desktopPane.add(rdbtnDecision);
		
		JRadioButton rdbtnUtility = new JRadioButton("Utility");
		buttonGroup.add(rdbtnUtility);
		rdbtnUtility.setBounds(91, 223, 62, 25);
		desktopPane.add(rdbtnUtility);
		
		JLabel lblNodeType = new JLabel("Node Type");
		lblNodeType.setBounds(12, 136, 69, 16);
		desktopPane.add(lblNodeType);
		
		JLabel lblNodeStatus = new JLabel("Node Status");
		lblNodeStatus.setBounds(257, 136, 69, 16);
		desktopPane.add(lblNodeStatus);
		
		JRadioButton rdbtnInput = new JRadioButton("Input");
		buttonGroup_1.add(rdbtnInput);
		rdbtnInput.setBounds(334, 132, 62, 25);
		desktopPane.add(rdbtnInput);
		
		JRadioButton rdbtnOutput = new JRadioButton("Output");
		buttonGroup_1.add(rdbtnOutput);
		rdbtnOutput.setBounds(334, 162, 69, 25);
		desktopPane.add(rdbtnOutput);
		
		JRadioButton rdbtnEmbedded = new JRadioButton("Embedded");
		buttonGroup_1.add(rdbtnEmbedded);
		rdbtnEmbedded.setSelected(true);
		rdbtnEmbedded.setBounds(334, 193, 89, 25);
		desktopPane.add(rdbtnEmbedded);
		
		JLabel lblNodeStates = new JLabel("Node States");
		lblNodeStates.setBounds(12, 261, 81, 16);
		desktopPane.add(lblNodeStates);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(91, 257, 383, 22);
		textField_4.setText("");
		desktopPane.add(textField_4);
		
		JTextArea txtrStatesIndicatedBy = new JTextArea();
		txtrStatesIndicatedBy.setText("States indicated by \"\" and separated by space");
		txtrStatesIndicatedBy.setBounds(12, 278, 462, 26);
		desktopPane.add(txtrStatesIndicatedBy);
		
		JLabel lblNodeSubtype = new JLabel("Node sub-type");
		lblNodeSubtype.setBounds(12, 329, 89, 16);
		desktopPane.add(lblNodeSubtype);
		
		JRadioButton rdbtnBoolean = new JRadioButton("Boolean");
		buttonGroup_2.add(rdbtnBoolean);
		rdbtnBoolean.setBounds(103, 325, 73, 25);
		desktopPane.add(rdbtnBoolean);
		
		JRadioButton rdbtnLabel = new JRadioButton("Label");
		buttonGroup_2.add(rdbtnLabel);
		rdbtnLabel.setBounds(180, 325, 69, 25);
		desktopPane.add(rdbtnLabel);
		
		JRadioButton rdbtnNumber = new JRadioButton("Number");
		buttonGroup_2.add(rdbtnNumber);
		rdbtnNumber.setSelected(true);
		rdbtnNumber.setBounds(253, 325, 73, 25);
		desktopPane.add(rdbtnNumber);
		
		JRadioButton rdbtnInterval = new JRadioButton("Interval");
		buttonGroup_2.add(rdbtnInterval);
		rdbtnInterval.setBounds(334, 325, 73, 25);
		desktopPane.add(rdbtnInterval);
		
		JLabel lblStateValues = new JLabel("State Values");
		lblStateValues.setBounds(12, 362, 81, 16);
		desktopPane.add(lblStateValues);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(91, 358, 383, 22);
		desktopPane.add(textField_5);
		
		JTextArea txtrValuesSeparatedBy = new JTextArea();
		txtrValuesSeparatedBy.setText("Values [numbers] separated by space");
		txtrValuesSeparatedBy.setBounds(91, 379, 383, 26);
		desktopPane.add(txtrValuesSeparatedBy);
	}
	
	public FrameNode(Object o, String className) {
		
		parents = new ArrayList<String>();
//		data = new Object[numOfRow][numOfCol];
		
		this.obj = o;
		this.className = className;
		
		if(className == "FrameAbstractClass") this.fAC = FrameAbstractClass.class.cast(obj);
		else if (className == "FrameConcreteClass") this.fCC = FrameConcreteClass.class.cast(obj);
		else if (className == "FrameInterface") this.fInf = FrameInterface.class.cast(obj);
		else System.out.println("Unknown Class name is provided to cast");
		
		attrib = new Attribute();
		node = new BasicNode();
		attributes = new LinkedHashMap<String, String>();
		
		setTitle("Node: " + className);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 537, 529);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Options");
		menuBar.add(mnNewMenu);
		
		JMenu mnAdd = new JMenu("Add");
		mnNewMenu.add(mnAdd);
		
		JMenuItem mntmNode = new JMenuItem("Belief");
		mntmNode.setAction(action_1);
		mnAdd.add(mntmNode);
		
		JMenuItem mntmParent = new JMenuItem("Parent");
		mntmParent.setAction(action_3);
		mnAdd.add(mntmParent);
		
		JMenuItem mntmAttribute = new JMenuItem("Attribute");
		mntmAttribute.setAction(action);
		mnAdd.add(mntmAttribute);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.setAction(action_2);
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
		
		JMenuItem mntmClassInfo = new JMenuItem("Node Info");
		mnDisplay.add(mntmClassInfo);
		
		JMenuItem mntmNodeList = new JMenuItem("Belief");
		mnDisplay.add(mntmNodeList);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		table = new JTable();
		contentPane.add(table);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		contentPane.add(desktopPane);
		
		JLabel lblName = new JLabel("Node Name");
		lblName.setBounds(12, 25, 128, 16);
		desktopPane.add(lblName);
		
		textField = new JTextField();
		textField.setBounds(91, 22, 290, 22);
		desktopPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblParentClassName = new JLabel("Position in GUI:");
		lblParentClassName.setBounds(12, 97, 89, 16);
		desktopPane.add(lblParentClassName);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("");
		textField_1.setColumns(10);
		textField_1.setBounds(162, 94, 69, 22);
		desktopPane.add(textField_1);
		
		JLabel lblNodeLabel = new JLabel("Node Label");
		lblNodeLabel.setBounds(12, 60, 128, 16);
		desktopPane.add(lblNodeLabel);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(91, 57, 290, 22);
		desktopPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setToolTipText("");
		textField_3.setColumns(10);
		textField_3.setBounds(312, 94, 69, 22);
		desktopPane.add(textField_3);
		
		JLabel lblXCoord = new JLabel("X Coord");
		lblXCoord.setBounds(103, 97, 54, 16);
		desktopPane.add(lblXCoord);
		
		JLabel lblYCoord = new JLabel("Y Coord");
		lblYCoord.setBounds(257, 97, 54, 16);
		desktopPane.add(lblYCoord);
		
		JRadioButton rdbtnDiscreteChance = new JRadioButton("Discrete Chance");
		buttonGroup.add(rdbtnDiscreteChance);
		rdbtnDiscreteChance.setSelected(true);
		rdbtnDiscreteChance.setBounds(91, 132, 127, 25);
		desktopPane.add(rdbtnDiscreteChance);
		
		JRadioButton rdbtnContinuosChance = new JRadioButton("Continuos Chance");
		buttonGroup.add(rdbtnContinuosChance);
		rdbtnContinuosChance.setBounds(91, 162, 136, 25);
		desktopPane.add(rdbtnContinuosChance);
		
		JRadioButton rdbtnDecision = new JRadioButton("Decision");
		buttonGroup.add(rdbtnDecision);
		rdbtnDecision.setBounds(91, 193, 81, 25);
		desktopPane.add(rdbtnDecision);
		
		JRadioButton rdbtnUtility = new JRadioButton("Utility");
		buttonGroup.add(rdbtnUtility);
		rdbtnUtility.setBounds(91, 223, 62, 25);
		desktopPane.add(rdbtnUtility);
		
		JLabel lblNodeType = new JLabel("Node Type");
		lblNodeType.setBounds(12, 136, 69, 16);
		desktopPane.add(lblNodeType);
		
		JLabel lblNodeStatus = new JLabel("Node Status");
		lblNodeStatus.setBounds(257, 136, 69, 16);
		desktopPane.add(lblNodeStatus);
		
		JRadioButton rdbtnInput = new JRadioButton("Input");
		buttonGroup_1.add(rdbtnInput);
		rdbtnInput.setBounds(334, 132, 62, 25);
		desktopPane.add(rdbtnInput);
		
		JRadioButton rdbtnOutput = new JRadioButton("Output");
		buttonGroup_1.add(rdbtnOutput);
		rdbtnOutput.setBounds(334, 162, 69, 25);
		desktopPane.add(rdbtnOutput);
		
		JRadioButton rdbtnEmbedded = new JRadioButton("Embedded");
		buttonGroup_1.add(rdbtnEmbedded);
		rdbtnEmbedded.setSelected(true);
		rdbtnEmbedded.setBounds(334, 193, 89, 25);
		desktopPane.add(rdbtnEmbedded);
		
		JLabel lblNodeStates = new JLabel("Node States");
		lblNodeStates.setBounds(12, 261, 81, 16);
		desktopPane.add(lblNodeStates);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(91, 257, 383, 22);
		desktopPane.add(textField_4);
		
		JTextArea txtrStatesIndicatedBy = new JTextArea();
		txtrStatesIndicatedBy.setText("States indicated by \"\" and separated by space");
		txtrStatesIndicatedBy.setBounds(12, 278, 462, 26);
		desktopPane.add(txtrStatesIndicatedBy);
		
		JLabel lblNodeSubtype = new JLabel("Node sub-type");
		lblNodeSubtype.setBounds(12, 329, 89, 16);
		desktopPane.add(lblNodeSubtype);
		
		JRadioButton rdbtnBoolean = new JRadioButton("Boolean");
		buttonGroup_2.add(rdbtnBoolean);
		rdbtnBoolean.setBounds(103, 325, 73, 25);
		desktopPane.add(rdbtnBoolean);
		
		JRadioButton rdbtnLabel = new JRadioButton("Label");
		buttonGroup_2.add(rdbtnLabel);
		rdbtnLabel.setBounds(180, 325, 69, 25);
		desktopPane.add(rdbtnLabel);
		
		JRadioButton rdbtnNumber = new JRadioButton("Number");
		buttonGroup_2.add(rdbtnNumber);
		rdbtnNumber.setSelected(true);
		rdbtnNumber.setBounds(253, 325, 73, 25);
		desktopPane.add(rdbtnNumber);
		
		JRadioButton rdbtnInterval = new JRadioButton("Interval");
		buttonGroup_2.add(rdbtnInterval);
		rdbtnInterval.setBounds(334, 325, 73, 25);
		desktopPane.add(rdbtnInterval);
		
		JLabel lblStateValues = new JLabel("State Values");
		lblStateValues.setBounds(12, 362, 81, 16);
		desktopPane.add(lblStateValues);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(91, 358, 383, 22);
		desktopPane.add(textField_5);
		
		JTextArea txtrValuesSeparatedBy = new JTextArea();
		txtrValuesSeparatedBy.setText("Values [numbers] separated by space");
		txtrValuesSeparatedBy.setBounds(91, 379, 383, 26);
		desktopPane.add(txtrValuesSeparatedBy);
	}
	
	private class SwingAttribute extends AbstractAction {
		public SwingAttribute() {
			putValue(NAME, "Attribute");
			putValue(SHORT_DESCRIPTION, "Click to add Attribute");
		}
		public void actionPerformed(ActionEvent e) {
			try {
				Object newObj = Class.forName("test.FrameNode").cast(FrameNode.this);
				FrameAttribute frame = new FrameAttribute(newObj, "FrameNode");
				frame.setVisible(true);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}
	private class SwingBelief extends AbstractAction {
		public SwingBelief() {
			putValue(NAME, "Belief");
			putValue(SHORT_DESCRIPTION, "Click to add belief");
		}
		public void actionPerformed(ActionEvent e) {
			// make here array list for making data table
			ArrayList<String> thisNodeStates = new ArrayList<String>();
	        ArrayList<ArrayList<String>> parentStates = new ArrayList<ArrayList<String>>();
	        String child = "ThisNode";
	        String states = textField_4.getText();
	        if(states == null || states == ""){
	        	thisNodeStates.add("TRUE");	
	        	thisNodeStates.add("FALSE");
	        }
	        else{
	        	String[] splitted = states.split(" ");
	        	for(int I = 0; I <splitted.length; I++)
	        		thisNodeStates.add(splitted[I]);
	        }
	        
	        LinkedHashMap<String, BasicNode> nodes;
	        
	        if(className == "FrameAbstractClass") nodes = fAC.nodes;
			else	nodes = fCC.nodes;
	        
	        for(int I = 0; I < parents.size(); I++){
	        	ArrayList<String> Par;// = new ArrayList<String>();
	        	
	        	BasicNode node = nodes.get(parents.get(I));
	        	String parentStatesTemp = node.states;
	        	Par = new ArrayList<String> (Arrays.asList(parentStatesTemp.split(" ")));
	        	
	        	parentStates.add(Par);
	        }
	        
	        try {
				Object newObj = Class.forName("test.FrameNode").cast(FrameNode.this);
				FrameTable frame = new FrameTable(newObj, "FrameNode");
				frame.createAndShowGUI(frame, child, thisNodeStates, parents, parentStates);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	private class SwingSave extends AbstractAction {
		public SwingSave() {
			putValue(NAME, "Save");
			putValue(SHORT_DESCRIPTION, "Press here to save the node information.");
		}
		public void actionPerformed(ActionEvent e) {
			node.name = textField.getText();
			node.label = textField_2.getText();
			node.attributes = attributes;
			node.posX = Integer.parseInt(textField_1.getText());
			node.posY = Integer.parseInt(textField_3.getText());
			node.states = textField_4.getText();
			node.stateValues = textField_5.getText();
			
			System.out.println(textField.getText() + textField_1.getText() + textField_2.getText() + textField_3.getText() + textField_4.getText() + textField_5.getText());
			
			if(className == "FrameAbstractClass"){
				fAC.node = node;
				fAC.postNodeInfo();
			}
			else if (className == "FrameConcreteClass"){
				fCC.node = node;
				fCC.postNodeInfo();
			}
			else if (className == "FrameInterface"){
				fInf.node = node;
				fInf.postNodeInfo();
			}
		}
	}
	private class SwingParent extends AbstractAction {
		public SwingParent() {
			putValue(NAME, "Parent");
			putValue(SHORT_DESCRIPTION, "Click here to add parent/s");
		}
		public void actionPerformed(ActionEvent e) {
			try {
				Object newObj = Class.forName("test.FrameNode").cast(FrameNode.this);
				FrameParent frame = new FrameParent(newObj, "FrameNode");
				frame.setVisible(true);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
