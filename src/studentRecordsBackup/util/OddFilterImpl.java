package studentRecordsBackup.util;

public class OddFilterImpl implements OddEvenFilterI{

	@Override
	public boolean checkValue(int value) {
		if(value%2!=0){
			return true;
		}
		return false;
	}

}
