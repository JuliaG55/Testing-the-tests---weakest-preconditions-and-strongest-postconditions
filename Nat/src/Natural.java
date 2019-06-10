import com.google.java.contract.Ensures;
import com.google.java.contract.Invariant;
import com.google.java.contract.Requires;

//Add an invariant here.
@Invariant("this.data >= 0")
public class Natural implements Comparable<Natural> {
	private int data;

	// No contracts required for the following methods.

	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Natural)) return false;
		Natural n = (Natural) o;
		return data==n.data;
	}
	
	public int compareTo(Natural n) { 
		return Integer.compare(data, n.data); 
	}
	
	public Natural(Natural n) {
		this(n.data);
	}

	@Override
	public String toString() {
		return Integer.toString(data); 
	}

	// Add contracts to all following methods.
	
	@Ensures("this.data == d")
	public Natural(int d) {
		data = d;
	}
	
	@Requires("data < Integer.MAX_VALUE")
	@Ensures("this.data == old(this.data) + 1")
	public void increment() {
		data++; 
	}
	
	@Requires("data > 0")
	@Ensures("this.data == old(this.data) - 1")
	public void decrement() {
		data--;
	}
	
	@Requires("n.data <= Integer.MAX_VALUE - data")
	@Ensures("this.data == old(this.data) + n.data")
	public void add(Natural n) {
		data += n.data;
	}
	
	@Requires("n.data <= data")
	@Ensures("this.data == old(this.data) - n.data")
	public void subtract(Natural n) {
		data -= n.data;
	}
	
	@Requires("n.data <= Integer.MAX_VALUE / data")
	@Ensures("this.data == old(this.data) * n.data")
	public void multiply(Natural n) {
		data *= n.data;
	}
	
	@Requires("n.data != 0")
	@Ensures("this.data == old(this.data) / n.data")
	public void divide(Natural n) {
		data /= n.data;
	}
}
