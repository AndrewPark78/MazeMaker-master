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
		Cell cell = maze.getCell(((int)(width*Math.random()+1)), 0);
		cell.setNorthWall(false);
		selectNextPath(cell);

		return maze;
	}

	private static void selectNextPath(Cell currentCell) {
		currentCell.setBeenVisited(true);
		ArrayList<Cell> unvisted = getUnvisitedNeighbors(currentCell);
		if (unvisted.size() > 0) {
			int rand = randGen.nextInt(unvisted.size());
			uncheckedCells.push(unvisted.get(rand));
			removeWalls(currentCell, unvisted.get(rand));
			currentCell = unvisted.get(rand);
			currentCell.setBeenVisited(true);
			selectNextPath(currentCell);
		} else if (uncheckedCells.size() > 0) {
			currentCell = uncheckedCells.pop();
			selectNextPath(currentCell);
		}
		else{
			int x = randGen.nextInt(2);
			if(x==0){
			Cell cell = maze.getCell(new Random().nextInt(width), height-1);
			cell.setSouthWall(false);
			}
			else if(x==1){
				Cell cell = maze.getCell(0, new Random().nextInt(height));
				cell.setWestWall(false);
			}
			else{
				Cell cell = maze.getCell(width-1, new Random().nextInt(height));
				cell.setEastWall(false);
			}
		}
	}

	private static void removeWalls(Cell c1, Cell c2) {
		if (c1.getX() == c2.getX()) {
			if (c1.getY() > c2.getY()) {
				c1.setNorthWall(false);
				c2.setSouthWall(false);
			} else {
				c1.setSouthWall(false);
				c2.setNorthWall(false);
			}
		}
		if (c1.getY() == c2.getY()) {
			if (c1.getX() > c2.getX()) {
				c1.setWestWall(false);
				c2.setEastWall(false);
			} else {
				c1.setEastWall(false);
				c2.setWestWall(false);
			}
		}
	}

	private static ArrayList<Cell> getUnvisitedNeighbors(Cell c) {
		ArrayList<Cell> cells = new ArrayList<Cell>();
		int x = c.getX();
		int y = c.getY();
		if (x != 0) {
			if (!maze.getCell((x - 1), y).hasBeenVisited()) {
				cells.add(maze.getCell((x - 1), y));
			}
		}
		if (x != maze.getWidth() - 1) {
			if (!maze.getCell((x + 1), y).hasBeenVisited()) {
				cells.add(maze.getCell((x + 1), y));
			}
		}
		if (y != 0) {
			if (!maze.getCell(x, (y - 1)).hasBeenVisited()) {
				cells.add(maze.getCell(x, (y - 1)));
			}
		}
		if (y != maze.getHeight() - 1) {
			if (!maze.getCell(x, (y + 1)).hasBeenVisited()) {
				cells.add(maze.getCell(x, (y + 1)));
			}
		}
		return cells;
	}
}