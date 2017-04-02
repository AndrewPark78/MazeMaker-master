import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class MazeMaker {

	private static int width;
	private static int height;

	private static Maze maze;

	private static Random randGen = new Random();
	private static Stack<Cell> uncheckedCells = new Stack<Cell>();

	public static Maze generateMaze(int w, int h) {
		width = w;
		height = h;
		maze = new Maze(width, height);

		// select a random cell to start
		int h1 = randGen.nextInt(height -1);
		int w1 = randGen.nextInt(width -1);
		maze.getCell(h1, w1);
		// call selectNextPath method with the randomly selected cell
		selectNextPath(maze.getCell(h1, w1));
		removeWalls(maze.getCell(0, 0), maze.getCell(0, 1));
		return maze;

	}

	private static void selectNextPath(Cell currentCell) {
		// mark current cell as visited
		currentCell.setBeenVisited(true);
		// check for unvisited neighbors

		// if has unvisited neighbors,
		// select one at random.
		// push it to the stack
		// remove the wall between the two cells
		// make the new cell the current cell and mark it as visited

		// call the selectNextPath method with the current cell

		// if all neighbors are visited
		// if the stack is not empty
		// pop a cell from the stack
		// make that the current cell

		// call the selectNextPath method with the current cell
	}

	private static void removeWalls(Cell c1, Cell c2) {
		int x1 = c1.getX();
		int y1 = c1.getY();
		int x2 = c2.getX();
		int y2 = c2.getY();
		if (x1 == x2) {
			if (y1 > y2) {
				c1.setEastWall(false);
				c2.setWestWall(false);
			} else {
				c1.setWestWall(false);
				c2.setEastWall(false);
			}
		}
		if (y1 == y2) {
			if (x1 > x2) {
				c1.setSouthWall(false);
				c2.setNorthWall(false);
			} else {
				c1.setNorthWall(false);
				c2.setSouthWall(false);
			}
		}
	}

	private static ArrayList<Cell> getUnvisitedNeighbors(Cell c) {
		return null;
	}
}