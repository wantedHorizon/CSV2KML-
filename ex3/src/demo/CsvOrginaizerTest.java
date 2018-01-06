package demo;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class CsvOrginaizerTest {
	String path=  "c:\\Test";//this path of test folder
	String	 w1=path+"\\wigle.csv";
	String	 w2=path+"\\wigle2.csv";
	CsvOrginaizer x1=new CsvOrginaizer(w1);
	CsvOrginaizer x2=new CsvOrginaizer(w2);
	
	 

	@Test
	public void testSortBYindex() {
		//fail("Not yet implemented");
	}

	@Test
	public void testIdReciver() {
		String id1=x1.idReciver(w1);
		String id2=x1.idReciver(w2);

		assertEquals("model=SHIELD Tablet", id1);
		assertEquals("model=Lenovo PB2-690Y", id2);

	}

	@Test
	public void testCorrectName() {
		assertFalse(x1.order[3].equals("Time"));
		x1.correctName(x1.order);
		assertTrue(x1.order[3].equals("Time"));
		
		assertFalse(x2.order[3].equals("Time"));
		x2.correctName(x2.order);
		assertTrue(x2.order[3].equals("Time"));
		
	}

	@Test
	public void testOrderFind() {
		String arr[]= {"MAC", "SSID", "AuthMode", "FirstSeen", "Channel", "RSSI", "CurrentLatitude", "CurrentLongitude", "AltitudeMeters", "AccuracyMeters", "Type"};

		assertArrayEquals(arr, x1.order);
		assertArrayEquals(arr, x2.order);
	}

	@Test
	public void testHeaderFind() {
		int arr1[]= {11,294};
		assertArrayEquals(arr1,x1.header);
		int arr2[]= {11,894};
		assertArrayEquals(arr2,x2.header);
	}

	@Test
	public void testSwitchColum() {
		String m1[][]=x1.Math1;
		String m2[][]= new String[m1.length][m1[0].length];
		int x=(int) (Math.random()*10);
		int y=(int) (Math.random()*10);
		System.out.println(x+ " "+y);
		if(x==y) {
			x=0;
			y=2;
		}
			

		System.out.println(m1.length +" "+m1[0].length);
		
		for (int i = 0; i < m2.length; i++) {
			for (int j = 0; j < m2[0].length; j++) {
				m2[i][j]=m1[i][j];
			}
		}
		assertArrayEquals(m1, m2);
		
		m1=x1.SwitchColum(m1, x, y);

		for (int i = 0; i < m2.length; i++) {
			assertEquals(m1[i][x], m2[i][y]);
			assertEquals(m1[i][y], m2[i][x]);

		}
		

	}

}
