package demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Csv2KmlTest {
	Csv2Kml x=new Csv2Kml();
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testTimecorrect() {
	String actual1	=x.Timecorrect("2017-10-27 16:14:37");
	String expected1  ="<TimeStamp><when>2017-10-27T16:14:37Z</when> </TimeStamp>";
		assertEquals(expected1, actual1);
		assertEquals("", x.Timecorrect("####^%%"));

	}

	@Test
	void testConverter() {
		
	}

}
