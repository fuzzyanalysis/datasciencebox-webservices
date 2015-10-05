package dsbws;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;
import org.mockito.Mockito;

import com.datasciencebox.rs.webservices.DSBResources;

public class TestMockito {

	@Test
	public void test() {
		
		// create mock
		DSBResources testResource = Mockito.mock(DSBResources.class);
		
		// define return value
		when(testResource.getGeolocation("120.140.120.10")).thenReturn("43");
		
		// use mock in test
		
		Iterator i = mock(Iterator.class);
		when(i.next()).thenReturn("Hello").thenReturn("World");
		// act
		String result = i.next() + " " + i.next();
		// assert
		assertEquals("Hello World", result);
	}

}
