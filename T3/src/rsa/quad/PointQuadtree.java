package rsa.quad;

/**
 * This class a presents a single access point to manage quad trees.
 * @author Tiago Coelho e Vasco Soares;
 */
public class PointQuadtree<T extends HasPoint>{
	protected double bottomRightX;
	protected double bottomRightY;
	protected double topLeftX;
	protected double topLeftY;
	public PointQuadtree(double topLeftX,double topLeftY,double bottomRightX,double bottomRightY) {
		this.topLeftX = topLeftX;
		this.topLeftY = topLeftY;
		this.bottomRightX = bottomRightX;
		this.bottomRightY = bottomRightY;
	}
	
	public T find(T point) {
		return null;
	}
	
	public void insert(T point) {}
	
	public void insertReplace(T point) {}
	
	public java.util.Set<T> findNear(double x,double y,double radius){
		return null;
	}
	
	public void delete(T point) {}

	public java.util.Set<T> getAll(){
		return null;
	}
}
