
public class TreeNode <T>{
	T data; 
	TreeNode<T> left; 
	TreeNode<T> right; 
	/**
	 * 
	 * @param dataNode
	 */
	public TreeNode(T dataNode) {
		right = null; 
		left = null; 
		data = dataNode; 
	}
	public TreeNode(TreeNode<T> node) {
		new TreeNode<T>(node); 
	}
	
	public T getData() {
		return data; 
	}
}
	
