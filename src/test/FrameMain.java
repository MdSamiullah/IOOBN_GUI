package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;

public class FrameMain extends JFrame {

	private JPanel contentPane;
	private final Action action = new SwingInterface();
	private final Action action_1 = new SwingAbstractClass();
	private final Action action_2 = new SwingConcreteClass();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameMain frame = new FrameMain();
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
	public FrameMain() {
		setTitle("Monash TANKS IOOBN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 617, 529);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenu mnNew = new JMenu("New");
		mnNewMenu.add(mnNew);
		
		JMenuItem mntmInterface = new JMenuItem("Interface");
		mntmInterface.setAction(action);
		mnNew.add(mntmInterface);
		
		JMenuItem mntmAbstractClass = new JMenuItem("Abstract Class");
		mntmAbstractClass.setAction(action_1);
		mnNew.add(mntmAbstractClass);
		
		JMenuItem mntmClassconcrete = new JMenuItem("Class (Concrete)");
		mntmClassconcrete.setAction(action_2);
		mnNew.add(mntmClassconcrete);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Open");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnNewMenu.add(mntmExit);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JMenuItem mntmCut = new JMenuItem("Cut");
		mnEdit.add(mntmCut);
		
		JMenuItem mntmCopy = new JMenuItem("Copy");
		mnEdit.add(mntmCopy);
		
		JMenuItem mntmPaste = new JMenuItem("Paste");
		mnEdit.add(mntmPaste);
		
		JMenu mnAbout = new JMenu("About");
		menuBar.add(mnAbout);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

	private class SwingInterface extends AbstractAction {
		public SwingInterface() {
			putValue(NAME, "Interface");
			putValue(SHORT_DESCRIPTION, "Click to add a new interface");
		}
		public void actionPerformed(ActionEvent e) {
			FrameInterface frame = new FrameInterface();
			frame.setVisible(true);
		}
	}
	private class SwingAbstractClass extends AbstractAction {
		public SwingAbstractClass() {
			putValue(NAME, "Abstract Class");
			putValue(SHORT_DESCRIPTION, "Click to add a new abstract class");
		}
		public void actionPerformed(ActionEvent e) {
			FrameAbstractClass frame = new FrameAbstractClass();
			frame.setVisible(true);
		}
	}
	private class SwingConcreteClass extends AbstractAction {
		public SwingConcreteClass() {
			putValue(NAME, "Concrete Class");
			putValue(SHORT_DESCRIPTION, "Click to add a new concrete class");
		}
		public void actionPerformed(ActionEvent e) {
			FrameConcreteClass frame = new FrameConcreteClass();
			frame.setVisible(true);
		}
	}
}
