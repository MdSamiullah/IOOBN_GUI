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
import components.Potential;

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

public class FrameEdge extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	public Attribute attrib;
//	public Potential edge;
	public LinkedHashMap <String, String> attributes;
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameEdge frame = new FrameEdge();
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
	
	/**
	 * Create the frame.
	 */
	public FrameEdge() {
		attrib = new Attribute();
		attributes = new LinkedHashMap<String, String>();
		
		setTitle("Edge");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 535, 197);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Options");
		menuBar.add(mnNewMenu);
		
		JMenu mnAdd = new JMenu("Add");
		mnNewMenu.add(mnAdd);
		
		JMenuItem mntmAttribute = new JMenuItem("Attribute");
		mntmAttribute.setAction(action);
		mnAdd.add(mntmAttribute);
		
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
		
		JMenuItem mntmEdgeInfo = new JMenuItem("Edge Info");
		mnDisplay.add(mntmEdgeInfo);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		table = new JTable();
		contentPane.add(table);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		contentPane.add(desktopPane);
		
		JLabel lblName = new JLabel("Child Vertex");
		lblName.setBounds(12, 25, 128, 16);
		desktopPane.add(lblName);
		
		textField = new JTextField();
		textField.setBounds(106, 22, 290, 22);
		desktopPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNodeLabel = new JLabel("Parent Vertex");
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
				Object newObj = Class.forName("test.FrameEdge").cast(FrameEdge.this);
				FrameAttribute frame = new FrameAttribute(newObj, "FrameEdge");
				frame.setVisible(true);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
//			FrameAttribute frame = new FrameAttribute();
//			frame.setVisible(true);
		}
	}
	private class SwingSave extends AbstractAction {
		public SwingSave() {
			putValue(NAME, "Save");
			putValue(SHORT_DESCRIPTION, "Press here to save the edge.");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
