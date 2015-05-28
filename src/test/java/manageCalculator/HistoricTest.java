package manageCalculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class HistoricTest {
	@InjectMocks Historic hist;
	
	@Before
	public void setUpHistoric() {
	}
	
	@Test
	public void testAddExp() {
		int size0 = hist.getList().size();
		hist.addToList("2+3", "5", "0.801173");
		int size = hist.getList().size();
		assertTrue(size==(size0+1));
		System.out.println("Checked that History size increased by one after adding an expression.");
		assertEquals(hist.getList().get(0).getExp(),"2+3");
		System.out.println("Checked that History stored successfully the expression");
		assertEquals(hist.getList().get(0).getResult(),"5");
		System.out.println("Checked that History stored successfully the result");
		assertEquals(hist.getList().get(0).getTime(),"0.801173");
		System.out.println("Checked that History stored successfully the time of computation");
	}
}
