import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MazeDisplay extends JPanel{
	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 900;
	public static final int HEIGHT = 800;
	
	private JFrame window;
	
	private Maze maze;
	
	MazeDisplay(){
		super();
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		window = new JFrame();
		
		window.add(this);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		window.pack();
		String x = JOptionPane.showInputDialog("Enter a width for the maze between 2 and 6");
		String y= JOptionPane.showInputDialog("Enter a height for the maze between 2 and 6");
		int w = Integer.parseInt(x);
		int h = Integer.parseInt(y);
		if(w>6)
			w=6;
		if(h>6)
			h=6;
		if(w<2)
			w=2;
		if(h<2)
			h=2;
		maze= MazeMaker.generateMaze(w, h);
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g){
		maze.draw(g);
	}
	
	public static void main(String[] args) {
		MazeDisplay md = new MazeDisplay();
	}
}
