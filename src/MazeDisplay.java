import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MazeDisplay extends JPanel{
	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 1500;
	public static final int HEIGHT = 1000;
	
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
		String x = JOptionPane.showInputDialog("Enter a width for the maze between 10 and 50");
		String y= JOptionPane.showInputDialog("Enter a height for the maze between 10 and 30");
		int w = Integer.parseInt(x);
		int h = Integer.parseInt(y);
		if(w>50)
			w=50;
		if(h>30)
			h=30;
		if(w<10)
			w=10;
		if(h<10)
			h=10;
		maze= MazeMaker.generateMaze(w , h);
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
