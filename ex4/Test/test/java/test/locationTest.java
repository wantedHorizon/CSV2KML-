package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import demo.location;
import demo.*;
class locationTest {
	location x1 =new location("32.11","34.22","5.5",0);
	location x2 =new location("32.11","34.22","5.5",1);
	location x3 =new location("32.11","34.223","5.5",0);
	location x4 =new location("32.11","34.22","5.5",0);
	location x5 =new location();




	@Test
	void testCheckEqual() {
		
		assertTrue(x1.CheckEqual(x1,0));
		assertTrue(x1.CheckEqual(x1,5));
		assertFalse(x1.CheckEqual(x5,5));
		location x5=new location(x1);
		assertTrue(x1.CheckEqual(x5,5));
		assertTrue(x1.CheckEqual(x2,5));



	}

}
