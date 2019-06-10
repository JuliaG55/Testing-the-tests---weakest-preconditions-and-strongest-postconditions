import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.java.contract.ContractImport;
import com.google.java.contract.Ensures;
import com.google.java.contract.Invariant;
import com.google.java.contract.Requires;

//Add an invariant here.
@Invariant("numbers != null")
public class NaturalList {
	private ArrayList<Natural> numbers;
	
	// No contracts required for the following methods.
	public NaturalList(NaturalList o) { 
		numbers = new ArrayList<Natural>();
		for(Natural n : o.numbers) 
			numbers.add(new Natural(n));
	}
	
	public NaturalList() {
		numbers = new ArrayList<Natural>();
	}
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof NaturalList)) return false;
		NaturalList other = (NaturalList) o;
		return numbers.equals(other.numbers);
	}

	@Override
	public String toString() {
		return numbers.toString(); 
	}
	
	private boolean isSorted() {
		//check if value is greater than previous and less than next
		for(int i = 0; i < numbers.size() - 1; i++) {
			if (numbers.get(i).compareTo(numbers.get(i + 1)) > 0) {
				return false;
			}
		}
		return true;
	}
	
	private boolean correctSearch(Natural n, int x) {
		if(x >= 0) {
			if (numbers.get(x).compareTo(n)==0) {
				return true;
			}
		} else {
			int pos = -(x + 1);
			if(x == -1 && numbers.get(pos).compareTo(n)>0) {
				return true;
			} else if(numbers.get(pos).compareTo(n)<0 && numbers.get(pos-1).compareTo(n)>0) {
				return true;
			}
		}
		return false;
	}

	// Add contracts to all following methods.
	@Requires("n != null")
	@Ensures("numbers.size() == old(numbers.size()) + 1") //
	public void push(Natural n) {
		numbers.add(n);
	}
	
	@Requires("i >= 0 &&  i < numbers.size()")
	@Ensures("result == numbers.get(i)") //
	public Natural get(int i) {
		return numbers.get(i);
	}
	
	@Requires("i >= 0 && i < numbers.size() && n != null")
	@Ensures("numbers.get(i) == n") //
	public void set(int i, Natural n) {
		numbers.set(i, n);
	}
	
	@Requires("!(numbers.isEmpty())")
	@Ensures("isSorted()")
	public void sort() {
		Collections.sort(numbers);
	}
	
	@Requires("!(numbers.isEmpty()) && isSorted()")
	@Ensures("correctSearch(n, result)")
	public int search(Natural n) {
		return Collections.binarySearch(numbers, n);
	}
}
