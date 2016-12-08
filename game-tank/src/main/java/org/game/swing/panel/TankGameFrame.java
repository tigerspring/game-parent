package org.game.swing.panel;

import java.awt.Color;

import javax.swing.JFrame;

public class TankGameFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7378612313400226797L;
	
	public TankGameFrame(){
		super("坦克大战");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(true);
		TankPanel tp = new TankPanel(700,500);
		this.setSize(tp.getWidth(), tp.getHeight());
		this.add(tp);
		this.addKeyListener(tp);
		this.setBackground(Color.gray);
		new Thread(tp).start();
	}
	
}
