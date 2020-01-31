
import java.util.*;
public class BinarySearch {
	public static String sayHello(String name) {
		return "Hello " + name;
	}
	
	public int binarySearch(List<Integer> sortedList, int element) {
		int first = 0, last = sortedList.size();
		
		while(first <= last) {
			int middle = first + (last - first) / 2;
			
			if (sortedList.get(middle).equals(element)) {
				return middle;
			}
			else if (element < sortedList.get(middle)) {
				last = middle - 1;
			}
			else {
				first = middle + 1;
			}
		}
		
		return -1;
		
	}
	
	public static void main(String[] args) {
		BinarySearch b = new BinarySearch();
		List<Integer> sortedList = new ArrayList<Integer>() {{add(1);add(2);add(4);add(5);add(7);add(13);add(18);add(31);}};

		int index = b.binarySearch(sortedList, 31);
	}
}
