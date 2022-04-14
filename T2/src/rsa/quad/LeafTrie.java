package rsa.quad;

class LeafTrie<T extends HasPoint> extends Trie<T>{
	LeafTrie(double topLeftX,double topLeftY,double bottomRightX,double bottomRightY){
		super(topLeftX,topLeftY,bottomRightX,bottomRightY);
	}
	
	
}

