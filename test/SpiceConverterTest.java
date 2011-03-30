

import static org.junit.Assert.*;

import org.junit.Test;

import com.training.SpiceConverter;



public class SpiceConverterTest 
{
	@Test
	public void UseSpiceConverterShouldBeUsedOnlyIfSourceIsSpice()
	{
		SpiceConverter s = new SpiceConverter();
		s.convert("spice 123 delhi 30 true 50 200 23/7/2011 11:30");
		
		assertEquals("spice", s.getSource());
		
	}
	
	@Test
	public void NotUseSpiceConverterShouldBeUsedOnlyIfSourceIsNotSpice()
	{
		SpiceConverter s = new SpiceConverter();
		s.convert("airtel 123 delhi 30 true 50 200 23/7/2011 11:30");
		
		assertFalse(s.getSource().equals("spice"));
		
	}
	
	@Test
	public void HomeCallRateIsCorrect()
	{
		SpiceConverter s = new SpiceConverter();
		s.convert("spice 123 delhi 30 true 50 200 23/7/2011 11:30");
		
		assertEquals(15.0, s.getCallRate(), .001);
	}
	
	@Test
	public void VisitorCallRateIsCorrect()
	{
		SpiceConverter s = new SpiceConverter();
		s.convert("spice 123 delhi 30 false 50 200 23/7/2011 11:30");
		
		assertEquals(60.0, s.getCallRate(), .001);
	}
	
	
	
}
