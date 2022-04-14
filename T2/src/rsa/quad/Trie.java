package rsa.quad;

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
		//missing implementation
		return false;
	}
	
	@Override
	public String toString() {
		return "Trie [bottomRightX=" + bottomRightX + ", bottomRightY=" + bottomRightY + ", topLeftX=" + topLeftX
				+ ", topLeftY=" + topLeftY + "]";
	}

	public static double getDistance(double x1,double y1,double x2,double y2) {
		return Math.hypot(x1-x2, y1-y2);
	}
}

