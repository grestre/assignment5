import java.util.ArrayList;

public class MorseCodeTree implements LinkedConverterTreeInterface{
	TreeNode<String> root = null; 
	String letter; 
	
	public MorseCodeTree() {
		buildTree(); 
	}
	@Override
	public TreeNode getRoot() {
		return root; 
	}

	@Override
	public void setRoot(TreeNode newNode) {
		root = newNode; 
	}

	/**
	 * @param code: 
	 * @param result: 
	 * Adds element to the correct position in the tree. This method will call addNode
	 */
	@Override
	public void insert(Object code, Object letter) {
		addNode(root, code, letter); 
	}

	/**
	 * @param root: root of the tree
	 * @param code: code for the recursive instance
	 * @param letter: data of the new TreeNode
	 * Recursive method that adds element to the correct position in the tree
	 * '.' means to go to the left, '-' means right
	 */
	@Override
	public void addNode(TreeNode root, Object code, Object letter) {
		if(((String) code).length() == 1) {
			if(code.equals("."))
				root.left = new TreeNode<String>((String) letter); 				//Left child is "."
		
			else {
				root.right = new TreeNode<String>((String) letter); 			//Right child is "-"
			}
		}
		else {
			if(((String) code).substring(0,1).equals(".")) {					//Checks after the "."
				addNode(root.left, ((String) code).substring(1), letter); 		//If the string is ".." it assigns it to the left child of the left child of the root
			}
			else
				addNode(root.right, ((String) code).substring(1), letter); 		//Else assigns it to the right
		}
	}
	
	/**
	 * Fetch the data in the tree based on the code
	 * Calls recursive fetchNode method
	 * @param code: Code that describes the traversals to retrieve the string (letter)
	 */
	@Override
	public String fetch(String code) {
		String data = fetchNode(root, code); 
		return data; 
	}

	/**
	 * Recursive method that fetches the data of the TreeNode that corresponds with the code
	 * '.' means traverse to the left, '-' goes to the right
	 * @param root: root of the tree
	 * @param code: code for this recursive instance of addNode
	 */
	@Override
	//Wrong
	public String fetchNode(TreeNode root, Object code) {
		if(((String) code).length() == 1) {
			if(code.equals(".")) {
				letter = (String) root.left.getData(); 
			}
			else {
				letter = (String) root.right.getData(); 
			}
		}
		else {
			if(((String) code).substring(0,1).equals(".")) {			//Checks after the "."
				fetchNode(root.left, ((String) code).substring(1));	 	//If its ".." adds it to the left child of the left child of the root
			}
			else {
				fetchNode(root.right, ((String) code).substring(1)); 	//Else adds it to the right
			}
		}
		return letter; 
	}

	/**
	 * Return a reference to the current tree
	 * @param data: data of the node to be deleted
	 */
	@Override
	public LinkedConverterTreeInterface delete(Object data) throws UnsupportedOperationException {
		return null;
	}

	/**
	 * Return a reference to the current tree
	 * 
	 */
	@Override
	public LinkedConverterTreeInterface update() throws UnsupportedOperationException {
		return null;
	}

	/**
	 * Builds the MorseCodeTree by inserting the nodes of the tree level by level based on the code
	 * The root will have a value of ""
	 */
	@Override
	public void buildTree() {
		root = new TreeNode<String>(""); 
		insert(".", "e");
		insert("-", "t");
		insert("..", "i");
		insert(".-", "a");
		insert("-.", "n");
		insert("--", "m");
		insert("...", "s");
		insert("..-", "u");
		insert(".-.", "r");
		insert(".--", "w");
		insert("-..", "d");
		insert("-.-", "k");
		insert("--.", "g");
		insert("---", "o");
		insert("....", "h");
		insert("...-", "v");
		insert("..-.", "f");
		insert(".-..", "l");
		insert(".--.", "p");
		insert(".---", "j");
		insert("-...", "b");
		insert("-..-", "x");
		insert(".-.-", "c");
		insert("-.--", "y");
		insert("--..", "z");
		insert("--.-", "q");
	}

	/**
	 * Returns an arraylist of the items in the linked tree in Inorder traversal
	 */
	@Override
	public ArrayList toArrayList() {
		ArrayList<String> tree = new ArrayList<String>(); 
		LNRoutputTraversal(root, tree); 						//Calls LNRoutputTraversal method
		return tree; 
	}

	/**
	 * Inorder traversal recursive 
	 */
	@Override
	public void LNRoutputTraversal(TreeNode root, ArrayList list) {
		if(root != null) {
			LNRoutputTraversal(root.left, list); 
			list.add(root.getData()); 
			LNRoutputTraversal(root.right, list); 
		}
	}

}
