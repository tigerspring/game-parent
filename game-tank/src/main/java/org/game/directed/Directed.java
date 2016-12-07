package org.game.directed;

public enum Directed {

	
	EAST(65),WEST(68),SOUTH(83),NORTH(87);
	
	private int directed;
	
	Directed(int directed){
		this.directed = directed;
	}
	
	public int getDirected() {
		return directed;
	}

	public void setDirected(int directed) {
		this.directed = directed;
	}
	
		
}
