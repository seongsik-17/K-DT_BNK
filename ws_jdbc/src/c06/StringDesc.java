package c06;

import java.util.Comparator;

public class StringDesc implements Comparator<String>{
	@Override
	public int compare(String o1, String o2) {
		
		return o2.compareTo(o1);
	}
	

}
