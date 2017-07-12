package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class FrameTable extends JFrame {

	private JPanel contentPane;
	
    public int NumOfParents = 0;
	private boolean DEBUG = false;
	
	public Object[][] data;
	
	public ArrayList<String> numdata;
	public TableModel model;
	
	public FrameNode fNd;
	public Object obj;
	public String className;
	
	private final Action action = new SwingSave();
	
    /**
     * @wbp.parser.constructor
     */
    public void FrameTableBuilder(String[] columnNames, String childNodeName, ArrayList<String> childStates, ArrayList<String> parents, ArrayList<ArrayList<String>> parentStates) 
    {
    	setTitle("CPT");
        NumOfParents = parents.size();
        int numOfRow = childStates.size()+parents.size();
        int numOfCol = 1;
        if(parents.size()>0){
	        for(int I = 0; I <parentStates.size(); I++)
	        		numOfCol *= parentStates.get(I).size();
        }
        numOfCol++;
        data = new Object[numOfRow][numOfCol];
        //System.out.println(numOfRow + " " +numOfCol );
        // make rows for parents other than 1st parent, which is already added in header row by "columnNames"
        int K = 0;
        for(K = 1; K < parents.size(); K++){
        	data[K-1][0] = parents.get(K);// name of first (any) parent
        	int step = 1;
        	for(int I = K+1; I< parents.size(); I++)	step *= parentStates.get(I).size();
        	int J = -1;
            for(int I = 1; I < numOfCol; I += step){
            	J++;
            // this loop adds in 1st row/header the name of 1st parent and its states with required spaces
            	data[K-1][I] = parentStates.get(K).get((J%parentStates.get(K).size()));// remaining will be blank in 1st header row  
            }
        }
        
        // now make rows for each state of child node with 1st cell as state name and others as blank for data
        if(parents.size()<1) K = 0;
        for(int J = 0; J <childStates.size(); J++){
        	data[K+J][0] = childStates.get(J);
        }
        
        //System.out.println(parents.size());
        
        model = new DefaultTableModel(data, columnNames)
        {
          public boolean isCellEditable(int row, int column)
          {
        	  if(row < parents.size())
        		  return false;//This causes all cells to be not editable
        	  else return true;
          }
          public void cellBackground(int row, int column){
        	  
          }
        };
        
        final JTable table = new JTable(model);
        table.setSurrendersFocusOnKeystroke(true);
        table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        table.setColumnSelectionAllowed(true);
        table.setCellSelectionEnabled(true);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
//        table.setEditingRow(0);
        table.setFillsViewportHeight(true);
        ColorRenderer bgRenderer = new ColorRenderer(parents.size());
        table.setDefaultRenderer(Object.class, bgRenderer);
 
        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);
 
        //Add the scroll pane to this panel.
        add(scrollPane);
        
        //System.out.println("Table " + table + "\nModel " + model);
    }

	/**
	 * Launch the application.
	 */
	public void createAndShowGUI(JFrame frame, String child, ArrayList<String> childStates, ArrayList<String> parents, ArrayList<ArrayList<String>> parentStates) {
        //Create and set up the window.
        
        int numOfRow = childStates.size()+parents.size();
        int numOfCol = 1;
        for(int I = 0; I <parentStates.size(); I++)
        		numOfCol *= parentStates.get(I).size();
        
        numOfCol++;
        String[] columnNames = new String[numOfCol];
        Arrays.fill(columnNames, "");
        
        int step;
        // making first column
        if(parents.size()>0){
	        columnNames[0] = parents.get(0);// name of first (any) parent
	        step = numOfCol / parentStates.get(0).size();
	        
	        int J = -1;
	        for(int I = 1; I < numOfCol; I += step){
	        	J++; 
	        	columnNames[I] = parentStates.get(0).get(J%parentStates.get(0).size());// remaining will be blank in 1st header row
	        }
        }
        //Create and set up the content pane.
        FrameTableBuilder(columnNames, child, childStates, parents, parentStates);

        frame.setOpacity((float) 1.0);
        frame.pack();
        frame.setVisible(true);
    }
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ArrayList<String> childStates = new ArrayList<String>();
			        ArrayList<String> parents = new ArrayList<String>();
			        ArrayList<ArrayList<String>> parentStates = new ArrayList<ArrayList<String>>();
			        String child = "P";
			        
			        childStates.add("P1");	childStates.add("P2");
			        parents.add("M");	parents.add("N");	parents.add("O");
			        ArrayList<String> Par1 = new ArrayList<String>();
			        ArrayList<String> Par2 = new ArrayList<String>();
			        ArrayList<String> Par3 = new ArrayList<String>();
			        Par1.add("M1"); 	Par1.add("M2");		Par1.add("M3");
			        Par2.add("N1"); 	Par2.add("N2");
			        Par3.add("O1"); 	Par3.add("O2");
			        parentStates.add(Par1);
			        parentStates.add(Par2);
			        parentStates.add(Par3);
			        
					FrameTable frame = new FrameTable();
					frame.createAndShowGUI(frame, child, childStates, parents, parentStates);
//					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrameTable() {
		setTitle("CPT");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 470, 486);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Options");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mnNewMenu.add(mntmSave);
		mntmSave.setAction(action);
		
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
		
		JMenuItem mntmClassInfo = new JMenuItem("Info");
		mnDisplay.add(mntmClassInfo);
	}
	
	public FrameTable(Object o, String className) {
		setTitle("CPT");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 470, 486);
		
		
		this.obj = o;
		this.className = className;
		
		if(className == "FrameNode") this.fNd = FrameNode.class.cast(obj);
		else System.out.println("Unknown Class name is provided to cast");
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Options");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mnNewMenu.add(mntmSave);
		mntmSave.setAction(action);
		
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
		
		JMenuItem mntmClassInfo = new JMenuItem("Info");
		mnDisplay.add(mntmClassInfo);
	
	}
	
	private class SwingSave extends AbstractAction {
		public SwingSave() {
			putValue(NAME, "Save");
			putValue(SHORT_DESCRIPTION, "Press here to save the node information.");
		}
		public void actionPerformed(ActionEvent e) {
			//System.out.println("Save is clicked");
			
			numdata = new ArrayList<String>();
			
			for (int I = NumOfParents; I < model.getRowCount(); I++){
				for(int J = 1; J < model.getColumnCount(); J++){
					if(model.getValueAt(I, J) != null){
		              numdata.add(model.getValueAt(I, J).toString());
					}
					else numdata.add("0");;
				}
	        }
			
			//System.out.println(numdata);
			
			if(className == "FrameNode"){
				//System.out.println(numdata);
				fNd.numdata = numdata;
				fNd.postBelief();
			}
			else System.out.println("Unknown frame class is given.");
		}
	}

}
