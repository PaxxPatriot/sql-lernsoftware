package de.dhbw.studienarbeit.bakcend.objekte.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;

public class AufgabeTest {	
		@Test
		public void test() {
			List<String> mockList = mock(List.class);
			mockList.add("First");
			when(mockList.get(0)).thenReturn("Mockito");
			when(mockList.get(1)).thenReturn("JCG");
			assertEquals("Mockito", mockList.get(0));
			assertEquals("JCG", mockList.get(1));
		}
}
