package studentRecordsBackup.bst;

import studentRecordsBackup.util.OddEvenFilterI;

public interface SubjectI {
	public void registerNode(ObserverI node, OddEvenFilterI i);
	public void notifyNodes(int updateValueIn);
	
}	
