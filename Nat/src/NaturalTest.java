import static org.junit.Assert.*;
import org.junit.Test;
import com.google.java.contract.PreconditionError;
import com.google.java.contract.InvariantError;

public class NaturalTest {

	// Test Constructor = falsifies the precondition
	// No precondition, but testing invariant
	@Test(expected = InvariantError.class)
	public void naturalTest() {
		Natural a = new Natural(-5);
	}

	// Test Constructor = satisfies the postcondition
	@Test
	public void naturalTest2() {
		Natural a = new Natural(1);
	}

	// Test increment = falsifies the precondition
	@Test(expected = PreconditionError.class)
	public void increment() {
		Natural i = new Natural(Integer.MAX_VALUE);
		i.increment();
	}

	// Test increment = satisfies the postcondition
	@Test
	public void increment2() {
		Natural i = new Natural(3);
		i.increment();
	}

	// Test decrement = falsifies the precondition
	@Test(expected = PreconditionError.class)
	public void decrement() {
		Natural d = new Natural(0);
		d.decrement();
	}

	// Test decrement = satisfies the postcondition
	@Test
	public void decrement2() {
		Natural d = new Natural(10);
		d.decrement();
	}

	// Test add = falsifies the precondition
	@Test(expected = PreconditionError.class)
	public void add() {
		Natural a = new Natural(Integer.MAX_VALUE);
		a.add(new Natural(Integer.MAX_VALUE));
	}

	// Test add = satisfies the postcondition
	@Test
	public void add2() {
		Natural a = new Natural(10);
		a.add(new Natural(5));
	}

	// Test subtract = falsifies the precondition
	@Test(expected = PreconditionError.class)
	public void subtract() {
		Natural s = new Natural(5);
		s.subtract(new Natural(10));
	}

	// Test subtract = satisfies the postcondition
	@Test
	public void subtract2() {
		Natural s = new Natural(15);
		s.subtract(new Natural (2));
	}

	// Test multiply = falsifies the precondition
	@Test(expected = PreconditionError.class)
	public void multiply() {
		Natural m = new Natural(Integer.MAX_VALUE);
		m.multiply(new Natural (3));
	}

	// Test multiply = satisfies the postcondition
	@Test
	public void multiply2() {
		Natural m = new Natural(10);
		m.multiply(new Natural (4));
	}

	// Test divide = falsifies the precondition
	@Test(expected = PreconditionError.class)
	public void divide() {
		Natural d = new Natural(5);
		d.divide(new Natural (0));
	}

	// Test divide = satisfies the postcondition
	@Test
	public void divide2() {
		Natural d = new Natural(4);
		d.divide(new Natural (2));
	}

}
