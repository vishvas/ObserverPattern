package studentRecordsBackup.bst;


public class BST {
	private Node root;
	private int sum=0;
	private Node maxNode=null;
	private int incrementValue=0;
	/**
	 * BST Constructor
	 */
	public BST(){
		this.root=null;
	}

	/**
	 * Insert Node function in the tree
	 * @param node
	 */
	public void insert(Node node){
		if(root==null){
			//System.out.println("Node root value inserted"+ BNumberIn);
			root=node;
			maxNode = node;
			maxNode.setFlag(true);
			return;
		}
		
		Node current= root;
		Node parent=null;
		while(true){
			parent= current;
			if(node.getBNumber()<current.getBNumber()){
				current = current.getLeft();
				if(current==null){
					parent.setLeft(node);
					if(node.getBNumber()>maxNode.getBNumber()){
						maxNode.setFlag(false);
						maxNode= node;
						maxNode.setFlag(true);
					}
					return;
				}
			}else{
					current= current.getRight();
					if(current==null){
						parent.setRight(node);
						if(node.getBNumber()>maxNode.getBNumber()){
							maxNode.setFlag(false);
							maxNode= node;
							maxNode.setFlag(true);
						}
						
						return;
					}
			}
		}
		
	}
	
	/**
	 * Tree Inorder Function Traversal by getting a root
	 */
	public void inorder(){ // calling inorderTraversal by getting a root node
		inorderTraversal(root);
		System.out.println();
	}
	/**
	 * InorderTraversal function by taking
	 * @param node
	 */
	public void inorderTraversal(Node node){ // InorderTraversal 
		if(node!=null){
			inorderTraversal(node.getLeft());
			System.out.print(node.getBNumber()+ " ");
			inorderTraversal(node.getRight());
		}
		
	}
	
	/**
	 * Tree BNumber Sum
	 */
	public void printBSum(){
		sum=0;
		System.out.println("The sum of all the B-Numbers is: "+ bSum(root));
	}
	
	private int bSum(Node node){
		if(node!=null){
			sum= sum+node.getBNumber();
			bSum(node.getLeft());
			bSum(node.getRight());
		}
		return sum;
	}
	
	
	/**
	 * Update Tree with given value by inorder Traversal
	 * @param updateValueIn
	 */
	public void updateTree(int updateValueIn){ // calling this function to update the entier tree value
		this.incrementValue=updateValueIn;
		incrementValue(root,incrementValue); // got root node and called 
		
		
	}
	/**
	 * Increment Node with update Value
	 * @param node
	 * @param updateValueIn
	 */
	private void incrementValue(Node node,int updateValueIn){  // called by update Tree method
		if(node!=null){
			node.updateValue(updateValueIn); // main tree node updated 
			node.notifyNodes(updateValueIn); // notify corresponding other nodes
			incrementValue(node.getLeft(),updateValueIn);
			incrementValue(node.getRight(), updateValueIn);
		}
	}
	

}	
