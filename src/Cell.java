public class Cell{
	public boolean isUsed = false; // Used or unused
	public boolean isWall = false; // whether it can be a wall piece. This is not related to isUsed.
	public boolean isPath = false; // whether or not it is part of an experimental path.
	public boolean isCorner = false;
	
//	+-+-+-+
//	|X|X|X|
//	+-+-+-+
//	|X|X|X|
//	+-+-+-+

//	All + or - or | are isWall = true; all X are isWall = false.

	public int x;
	public int y;
	
	public String symbol = " ";
	
	public Cell(int x, int y){
		this.x = x;
		this.y = y;
		
		if((x % 2 == 0) || (y % 2 == 0)){
			this.isWall = true;
			if((x % 2 == 0) && (y % 2 == 0)){
				isCorner = true;
			}
		}
		
		updateSymbol();
	}
	
	public String getSymbol(){
		return symbol;
	}
	
	private void updateSymbol(){
		if(isWall){
			if(isUsed){
				symbol = " ";
			} else {
				if(isCorner){
					symbol = "█";
				} else if(x % 2 == 0){
					symbol = "▓";
				} else {
					symbol = "▓";
				}
			}
		} else if(isUsed){
			symbol = " ";
		} else {
			symbol = "~";
		}
	}
	
	public void setUsed(boolean newState){
		isUsed = newState;
		updateSymbol();
	}
	
	public void setPath(boolean newState){
		isPath = newState;
		updateSymbol();
	}
	
}
