package test;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import demo.FolderDemo;

class FolderDemoTest {
	static String TestPath="c:\\Test"   ;//plz enter here the test folder location 
	//String FolderPath="";
	String unitedPath=TestPath+"\\unitedCsv.csv";
	String	 wigglePath=TestPath+"\\wigle.csv";
	String combPath=TestPath+"\\_comb_all_BM2_.csv";
	String[] fileN= {"_comb_all_BM2_.csv","wigle.csv","unitedCsv.csv"};
	FolderDemo x=new FolderDemo(TestPath);
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
	void testTypeCSVcheck() {
		
	assertEquals(1, x.TypeCSVcheck(wigglePath));
	assertEquals(2, x.TypeCSVcheck(unitedPath));
	assertEquals(3, x.TypeCSVcheck(combPath));
	
		
	}

	

	
	@Test
	void testpathCorrection() {
		assertEquals("c:\\\\knew", x.pathCorrection("c:\\knew"));
		assertEquals("c:\\\\knew\\\\mon", x.pathCorrection("c:\\knew/mon"));
		assertEquals("c:\\\\knew\\\\mm\\\\zz", x.pathCorrection("c:\\knew//mm\\zz"));


	}

	@Test
	void testFileNames() {
		 for (int i = 0; i < fileN.length; i++) {
			 assertTrue(x.files.contains(fileN[i]));
		}
		
		
	}

}
