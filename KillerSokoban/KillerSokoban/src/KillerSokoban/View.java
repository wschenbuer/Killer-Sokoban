package KillerSokoban;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javafx.scene.image.*;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class View extends JFrame {
	
	Floor game = new Floor();
	
	
	private JPanel MenuJPanel = new JPanel();
	
	private JMenuBar menuBar = new JMenuBar();
	private JMenu GameMenu = new JMenu("GameMenu");
	private JMenuItem exit = new JMenuItem("Exit");
	
	private JMenuItem newGame= new JMenuItem ("New Game");
	private JMenuItem loadGame= new JMenuItem ("Load Game");
	private JMenuItem saveGame= new JMenuItem ("Save Game");
	
	
	private JPanel GameJPanel = new JPanel();
	

	 
	
	View()
	{
		
	GameJPanel.setLayout(new GridLayout(6,6));

	GridPane gp = new GridPane();
	
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setSize(400,400);
	MenuJPanel.add(menuBar);
	menuBar.add(GameMenu);
	GameMenu.add(newGame);
	GameMenu.add(loadGame);
	GameMenu.add(saveGame);

	JLabel wall= new JLabel(new ImageIcon("res/Wall_Gray.png"));
	
	
	GameMenu.add(exit);
	exit.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) { 
			System.exit(0);
		}
	});
	setJMenuBar(menuBar);
		this.add(MenuJPanel);
		
		GameJPanel.add(wall);
	
		this.add(GameJPanel);
		
	}

	
	

}
