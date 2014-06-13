import java.util.ArrayList;
import java.util.List;

public class Grid{
	
	private ArrayList<ArrayList<Cell>> cells = new ArrayList<ArrayList<Cell>>();
	private int width;
	private int height;
	
	public Grid(int width, int height){
		this.width = width;
		this.height = height;
		
		if((width % 2 == 0) || (height % 2 == 0)){
			System.out.println("Error: Grid dimensions must not be even numbers!");
		} else {
			buildEmptyGrid();
		}
		
		genRandomTraversal();
		
		print();
	}
	
	private void buildEmptyGrid(){
		for(int y = 0; y < height; y++){
			
			cells.add(new ArrayList<Cell>());
			for(int x = 0; x < width; x++){
				cells.get(y).add(new Cell(x, y));
			}
		}
	}
	
	public void print(){
		String outStr = "\n";
		for(int y = 0; y < height; y++){
			ArrayList<Cell> active = cells.get(y);
			for(int x = 0; x < width; x++){
				outStr += active.get(x).getSymbol();
			}
			outStr += "\n";
		}
		System.out.println(outStr);
	}
	
	public Cell get(int x, int y){
		return cells.get(y).get(x);
	}
	
	public void genRandomTraversal(){
		get(1, 1).setUsed(true);
	}
}









