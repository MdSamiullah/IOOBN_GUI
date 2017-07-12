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

public class FrameAttribute extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	public String attribName;
	public String attribValue;
	
	FrameAbstractClass fAC;
	FrameConcreteClass fCC;
	FrameInterface fInf;
	FrameInstance fIns;
	FrameNode fNd;
	FrameEdge fEd;
	
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
	private final Action action = new SaveAttribute();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameAttribute frame = new FrameAttribute();
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
	public FrameAttribute() {
		setTitle("Attribute");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 535, 197);
		
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
		
		JLabel lblName = new JLabel("Attribute Name");
		lblName.setBounds(12, 25, 128, 16);
		desktopPane.add(lblName);
		
		textField = new JTextField();
		textField.setBounds(106, 22, 290, 22);
		desktopPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNodeLabel = new JLabel("Attribute Value");
		lblNodeLabel.setBounds(12, 60, 128, 16);
		desktopPane.add(lblNodeLabel);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(106, 57, 290, 22);
		desktopPane.add(textField_2);
	}
	
	public FrameAttribute(Object o, String className) {
		this.obj = o;
		
		this.className = className;
		
		if(className == "FrameAbstractClass") this.fAC = FrameAbstractClass.class.cast(obj);
		else if (className == "FrameConcreteClass") this.fCC = FrameConcreteClass.class.cast(obj);
		else if (className == "FrameInterface") this.fInf = FrameInterface.class.cast(obj);
		else if (className == "FrameInstance") this.fIns = FrameInstance.class.cast(obj);
		else if (className == "FrameNode") this.fNd = FrameNode.class.cast(obj);
		else if (className == "FrameEdge") this.fEd = FrameEdge.class.cast(obj);
		else System.out.println("Unknown Class name is provided to cast");
		
		setTitle("Attribute: " + className);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 535, 197);
		
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
		
		JLabel lblName = new JLabel("Attribute Name");
		lblName.setBounds(12, 25, 128, 16);
		desktopPane.add(lblName);
		
		textField = new JTextField();
		textField.setBounds(106, 22, 290, 22);
		desktopPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNodeLabel = new JLabel("Attribute Value");
		lblNodeLabel.setBounds(12, 60, 128, 16);
		desktopPane.add(lblNodeLabel);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(106, 57, 290, 22);
		desktopPane.add(textField_2);
	}
	
	private class SaveAttribute extends AbstractAction {
		public SaveAttribute() {
			putValue(NAME, "Save");
			putValue(SHORT_DESCRIPTION, "Click here to save the attribute");
		}
		public void actionPerformed(ActionEvent e) {
			attribName = textField.getText();
			attribValue = textField_2.getText();
			
			if(className == "FrameAbstractClass"){
				fAC.attrib.name = attribName;
				fAC.attrib.value = attribValue;
				fAC.postAttribValue();
			}
			else if (className == "FrameConcreteClass"){
				fCC.attrib.name = attribName;
				fCC.attrib.value = attribValue;
				fCC.postAttribValue();
			}
			else if (className == "FrameInterface"){
				fInf.attrib.name = attribName;
				fInf.attrib.value = attribValue;
				fInf.postAttribValue();
			}
			else if (className == "FrameInstance"){
				fIns.attrib.name = attribName;
				fIns.attrib.value = attribValue;
				fIns.postAttribValue();
			}
			else if (className == "FrameNode"){
				fNd.attrib.name = attribName;
				fNd.attrib.value = attribValue;
				fNd.postAttribValue();
			}
			else if (className == "FrameEdge"){
				fEd.attrib.name = attribName;
				fEd.attrib.value = attribValue;
				fEd.postAttribValue();
			}
			else System.out.println("Unknown Class name is provided to cast");
			
		}
	}
}
