package manageCalculator;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CalculatorTest {
	
	// ver class InputTest

	@InjectMocks
	Calculator testcalc;

	@Mock
	Historic hist;

	@Mock
	Statistic stat;


	@Before
	public void SetUpCalculator() {

	}

	@Test
	public void testCalcExp() {
		String test = "5-4+9/1-2*6";
		ExpressionC expression = new ExpressionC(test, "0", "0");
		testcalc.setExpression(expression);
		String testresult = testcalc.result();
		String[] a = testresult.split("/");
		expression.setResult(a[0]);
		expression.setTime(a[1]);		
		testcalc.setExpression(expression);
		hist.addToList(expression.getExp(), expression.getResult(), expression.getTime());
		testcalc.updateStat();
		testresult = a[0];
		String expectedresult = "-2";
		assertEquals(expectedresult, testresult);
		System.out.println("Checked that "+test+" is equal to "+expectedresult);
//		verify(stat).updateElement(anyString(), anyInteger());
		verify(hist).addToList(anyString(), anyString(), anyString()); 
		
		//			verify(stats).contaOperadores(anyString());
		//			verify(historico).adicionaExpressao(anyObject());
	}

	//ver os outros erros
	@Test
	public void testDivZero() {
		String test = "9/0";
		ExpressionC expression = new ExpressionC(test, "0", "0");
		testcalc.setExpression(expression);
		String testresult = testcalc.result();
		assertTrue(testcalc.isError());
		System.out.println("Checked that "+test+" produces an error of type: "+testresult);
	}
	
	@Test
	public void testNegSqrt() {
		String test = "sqrt(-4)";
		ExpressionC expression = new ExpressionC(test, "0", "0");
		testcalc.setExpression(expression);
		String testresult = testcalc.result();
		assertTrue(testcalc.isError());
		String[] a = testresult.split("/");
		System.out.println("Checked that "+test+" produces an error of type: "+a[0]);
	}

	@Test
	public void testArcSenOutOfBounds() {
		String test = "asin(10)";
		ExpressionC expression = new ExpressionC(test, "0", "0");
		testcalc.setExpression(expression);
		String testresult = testcalc.result();
		assertTrue(testcalc.isError());
		String[] a = testresult.split("/");
		System.out.println("Checked that "+test+" produces an error of type: "+a[0]);
	}

	@Test
	public void testTan90() {
		String test = "tand(90)";
		ExpressionC expression = new ExpressionC(test, "0", "0");
		testcalc.setExpression(expression);
		String testresult = testcalc.result();
		assertTrue(testcalc.isError());
		String[] a = testresult.split("/");
		System.out.println("Checked that "+test+" produces an error of type: "+a[0]);
	}
	
	@Test
	public void testZeroLog() {
		String test = "log(0)";
		ExpressionC expression = new ExpressionC(test, "0", "0");
		testcalc.setExpression(expression);
		String testresult = testcalc.result();
		assertTrue(testcalc.isError());
		String[] a = testresult.split("/");
		System.out.println("Checked that "+test+" produces an error of type: "+a[0]);
	}
	
	@Test
	public void testNotIntFact() {
		String test = "pi()!";
		ExpressionC expression = new ExpressionC(test, "0", "0");
		testcalc.setExpression(expression);
		String testresult = testcalc.result();
		assertTrue(testcalc.isError());
		String[] a = testresult.split("/");
		System.out.println("Checked that "+test+" produces an error of type: "+a[0]);
	}

}