package studentRecordsBackup.bst;


import java.util.HashMap;
import java.util.Map;

import studentRecordsBackup.util.OddEvenFilterI;

public class Node implements ObserverI, SubjectI  {

	private int BNumber=-1;
	private Node left=null;
	private Node right=null;
	private boolean flag=false;
	private HashMap<ObserverI,OddEvenFilterI> nodelist = new HashMap<>();
	
	public boolean isFlag() { //flag for maximum value
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	
	/**
	 * Node creator constructor with input BNumber
	 * @param BNumberIn
	 */
	public Node(int BNumberIn){

		BNumber= BNumberIn;
		left=null;
		right=null;
		flag=false;
	}


	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public int getBNumber() {
		return BNumber;
	}
	public void setBNumber(int bNumber) {
		BNumber = bNumber;
	}

	/**
	 * Register Node As Observer
	 */
	@Override
	public void registerNode(ObserverI node, OddEvenFilterI i) { // register the node into the list 
		nodelist.put(node, i);

	}

	/**
	 * Update node value with given value and also according to maximum Node
	 */
	@Override
	public void updateValue(int updateValueIn) {

		// TODO Auto-generated method stub
		if(this.isFlag()){
			this.setBNumber(this.getBNumber()+2*updateValueIn);
		}else{
			this.setBNumber(this.getBNumber()+updateValueIn);
		}
	}



	/**
	 * Notify Corresponding registered corresponding nodes to main 
	 */
	@Override
	public void notifyNodes(int updateValueIn) {
		// TODO Auto-generated method stub
		Map<ObserverI, OddEvenFilterI> map = new HashMap<ObserverI, OddEvenFilterI>(nodelist);
		for (Map.Entry<ObserverI, OddEvenFilterI> me : map.entrySet()) {
			if(me.getValue().checkValue(updateValueIn)){
				me.getKey().updateValue(updateValueIn);
				
			}

		}
	}




}
