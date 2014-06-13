import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

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
		try{
			return cells.get(y).get(x);
		} catch(java.lang.IndexOutOfBoundsException e){
			return null;
		}
	}
	
	public void genRandomTraversal(){
		get(1, 1).setUsed(true);
		ArrayList<List<Cell>> possiblePaths = new ArrayList<List<Cell>>();
		possiblePaths.add(Arrays.asList(get(1, 2), get(1, 3)));
		possiblePaths.add(Arrays.asList(get(2, 1), get(3, 1)));
		
		
		while(possiblePaths.size() != 0){
			int currentId = (int)(Math.random() * possiblePaths.size());
			
			Cell target = possiblePaths.get(currentId).get(1);
			Cell passage = possiblePaths.get(currentId).get(0);
			
			if(!target.isUsed){
				target.setUsed(true);
				passage.setUsed(true);
				
				Cell left = get(target.x - 2, target.y);
				if(left != null && !left.isUsed){
					possiblePaths.add(Arrays.asList(get(target.x - 1, target.y), left));
				}
				
				Cell right = get(target.x + 2, target.y);
				if(right != null && !right.isUsed){
					possiblePaths.add(Arrays.asList(get(target.x + 1, target.y), right));
				}
				
				Cell top = get(target.x, target.y - 2);
				if(top != null && !top.isUsed){
					possiblePaths.add(Arrays.asList(get(target.x, target.y - 1), top));
				}
				
				Cell bottom = get(target.x, target.y + 2);
				if(bottom != null && !bottom.isUsed){
					possiblePaths.add(Arrays.asList(get(target.x, target.y + 1), bottom));
				}
			} else {
				
			}
			
			possiblePaths.remove(currentId);
		}
		
		
		/*while(possiblePaths.size() != 0){
			int currentId = (int)(Math.random() * possiblePaths.size());
			Cell current = possiblePaths.get(currentId);
			
			int usedNeighborCount = 0;
			
			Cell left = get(current.x - 1, current.y);
			if(left == null || left.isUsed){
				usedNeighborCount++;
			}
			Cell right = get(current.x + 1, current.y);
			if(right == null || right.isUsed){
				usedNeighborCount++;
			}
			Cell top = get(current.x, current.y - 1);
			if(top == null || top.isUsed){
				usedNeighborCount++;
			}
			Cell bottom = get(current.x, current.y + 1);
			if(bottom == null || bottom.isUsed){
				usedNeighborCount++;
			}
			
			if(usedNeighborCount > 1){
				current.setUsed(false);
			} else {
				current.setUsed(true);
				
				if(!left.isPath && !left.isCorner){
					possiblePaths.add(left);
					left.setPath(true);
				}
				if(!right.isPath && !right.isCorner){
					possiblePaths.add(right);
					right.setPath(true);
				}
				if(!top.isPath && !top.isCorner){
					possiblePaths.add(top);
					top.setPath(true);
				}
				if(!bottom.isPath && !bottom.isCorner){
					possiblePaths.add(bottom);
					bottom.setPath(true);
				}
			}
			
			possiblePaths.remove(currentId);
		}*/
	}
}









