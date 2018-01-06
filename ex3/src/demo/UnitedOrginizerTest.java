package demo;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UnitedOrginizerTest {
	String path= "c:\\Test";// this path is of the Test folder
	String UnitedcsvPath=path+"\\unitedCsv.csv";
	String combPath=path+"\\_comb_all_BM2_.csv";
	String testP = path+"\\unitedBeforeORG.csv";
	//Files.copy(testP, path+"\\test.csv", REPLACE_EXISTING);

	//UnitedOrginizer x= new UnitedOrginizer(testP);
		// TODO Auto-generated constructor 
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		String path= "c:\\Test";// this path is of the Test folder
		String testP = path+"\\unitedBeforeORG.csv";
		

		 File source = new File(testP);
	        File dest = new File(path+"\\test.csv");
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testLine2read() {
		/*
		//String line1="2017-12-03 08:37:49,model=SM-G950F_device=dreamlte,32.10309345225589,35.20773997080285,690.9058112860603,2,Ariel_University,ec:8c:a2:08:a9:3c,36,-75.0,Ariel_University,ec:8c:a2:08:7a:1c,44,-89.0" ; 
			;
		String line2="2017-10-27 16:15:07,model=ONEPLUS A3003,DIRECT-35-HP DeskJet 3830 series,[WPA2-PSK-CCMP][WPS][ESS],98:e7:f4:c6:4b:37,6,-83,32.16870993,34.81323603,39,4.550999641418457,WIFI,";

	//	System.out.println(y.xRead);
		//LineRead temp1=new LineRead(line1 ,1);
		LineRead temp2=new LineRead(line2 ,0);
		//System.out.println(temp2);

*/
		
	}

	@Test
	void testUnitedOrginizer() {
	}

	@Test
	void testReduceTo10() {
	}

	@Test
	void testSortBYindexVectorStringArrayArray() {
	}

	@Test
	void testFilterBYlocation() {
	}

	@Test
	void testUnitedFilterdCsv() {
	}

}
