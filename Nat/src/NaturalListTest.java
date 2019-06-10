import static org.junit.Assert.*;

import java.util.Collections;

import org.junit.Test;

import com.google.java.contract.PreconditionError;


public class NaturalListTest {
	
	// Test push = falsifies the precondition
	@Test(expected = PreconditionError.class)
	public void pushTest() {
		NaturalList p = new NaturalList();
		p.push(null);
	}

	// Test push = satisfies the postcondition
	@Test
	public void pushTest2() {
		NaturalList p = new NaturalList();
		p.push(new Natural(10));
	}
	// Test get = falsifies the precondition
	@Test(expected = PreconditionError.class)
	public void getTest() {
		NaturalList g = new NaturalList();
		g.get(-1);
	}

	// Test get = satisfies the postcondition
	@Test
	public void getTest2() {
		NaturalList g = new NaturalList();
		g.push(new Natural(10));
		g.push(new Natural(8));
		g.get(1);
	}
	
	// Test set = falsifies the precondition
	@Test(expected = PreconditionError.class)
	public void setTest() {
		NaturalList s = new NaturalList();
		s.set(5, new Natural(10));
	}

	// Test set = satisfies the postcondition
	@Test
	public void setTest2() {
		NaturalList s = new NaturalList();
		s.push(new Natural(6));
		s.push(new Natural(1));
		s.push(new Natural(3));
		
		s.set(1, new Natural(5));
	}

	// Test sort = falsifies the precondition
	@Test(expected = PreconditionError.class)
	public void sortTest() {
		NaturalList o = new NaturalList();
		o.sort();
	}

	// Test sort = satisfies the postcondition
	@Test
	public void sortTest2() {
		NaturalList o = new NaturalList();
		o.push(new Natural(9));
		o.push(new Natural(6));
		o.push(new Natural(1));
		o.push(new Natural(3));
		
		o.sort();
	}

	// Test search = falsifies the precondition
	@Test(expected = PreconditionError.class)
	public void searchTest() {
		NaturalList e = new NaturalList();
		e.search(new Natural(3));
	}

	// Test search = satisfies the postcondition
	@Test
	public void searchTest2() {
		NaturalList e = new NaturalList();
		e.push(new Natural(19));
		e.push(new Natural(9));
		e.push(new Natural(10));
		e.push(new Natural(31));
		
		e.sort();
		e.search(new Natural(19));
	}

	

}
