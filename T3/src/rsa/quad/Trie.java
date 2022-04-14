package rsa.quad;

/**
 * Abstract class common to all classes implementing the trie structure.
 * @author Tiago Coelho e Vasco Soares;
 */

public abstract class Trie<T extends HasPoint> {
	protected double bottomRightX;
	protected double bottomRightY;
	static int capacity;
	protected double topLeftX;
	protected double topLeftY;
	
	protected Trie(double topLeftX,double topLeftY,double bottomRightX,double bottomRightY){
		this.topLeftX = topLeftX;
		this.topLeftY = topLeftY;
		this.bottomRightX = bottomRightX;
		this.bottomRightY = bottomRightY;
	}
	
	public static int getCapacity(){
		return capacity;
	}
	
	public static void setCapacity(int capacity){
		rsa.quad.Trie.capacity = capacity;
	}
	
	abstract T find(T point);
	
	abstract Trie<T> insert(T point);
	
	abstract Trie<T> insertReplace(T point);
	
	abstract void collectNear(double x,double y,double radius,java.util.Set<T> points);
	
	abstract void collectAll(java.util.Set<T> points);
	
	abstract void delete(T point);
	
	boolean overlaps(double x,double y,double radius){
		//if it is outside of the rectangle on the right side
		if(x+radius > this.bottomRightX){
			return false;
		}
		//if it is outside on the left side
		else if(x-radius < this.topLeftX){
			return false;
		}
		//if it is outside of the rectangle on the bottom side
		if(y+radius > this.bottomRightY){
			return false;
		}
		//if it is outside on the top side
		else if(y-radius < this.topLeftY){
			return false;
		}
		else {
			return true;
		}
	}
	
	@Override
	public String toString() {
		return "Trie [bottomRightX=" + bottomRightX + ", bottomRightY=" + bottomRightY + ", topLeftX=" + topLeftX
				+ ", topLeftY=" + topLeftY + "]";
	}

	public static double getDistance(double x1,double y1,double x2,double y2) {
		return Math.hypot(x1-x2, y1-y2);
	}
	
	/**
	 * Represents the possible trie quadrants.
	 * @author Tiago Coelho e Vasco Soares;
	 */
	static enum Quadrant{
		NW,
		NE,
		SE,
		SW;
	}
	
	/**
	 * Represents the nodes of a trie.
	 * @author Tiago Coelho e Vasco Soares;
	 */  
	
	@SuppressWarnings("hiding")
	class NodeTrie<T extends HasPoint>{
		java.util.Map<Quadrant,Trie<T>> tries;
		protected double bottomRightX;
		protected double bottomRightY;
		protected double topLeftX;
		protected double topLeftY;
		NodeTrie(double topLeftX, double topLeftY, double bottomRightX, double bottomRightY){
			this.bottomRightX = bottomRightX;
			this.bottomRightY = bottomRightY;
			this.topLeftX = topLeftX;
			this.topLeftY = topLeftY;
		}
		
		T find(T point) {
			return null;
		}
		
		Trie.Quadrant quadrantOf(T point){
			return null;
		}
		
		Trie<T> insert(T point){
			return null;
		}
		
		Trie<T> insertReplace(T point){
			return null;
		}
		
		void delete(T point) {
		}
		
		void collectNear(double x, double y, double radius,java.util.Set<T> nodes) {
		}
		
		void collectAll(java.util.Set<T> points) {
		}

		@Override
		public String toString() {
			return "NodeTrie [tries=" + tries + ", bottomRightX=" + bottomRightX + ", bottomRightY=" + bottomRightY
					+ ", topLeftX=" + topLeftX + ", topLeftY=" + topLeftY + "]";
		}
	}
}

