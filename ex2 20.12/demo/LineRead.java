package demo;

import java.util.ArrayList;
import java.util.Arrays;

public class LineRead {
	public  int lineNumber=-1,readnumber=0;
	public String ID="",Type="",Time="";
//	public Read[] samples;
	public double lat=0,lon=0,high=0;
	public ArrayList<Read> sampels=new ArrayList<Read>();

	LineRead(){
		
	}
	
	LineRead(String line, int num){
		String []str=line.split(",");
		this.lineNumber=num;
		this.Time=str[0];
		this.ID=str[1];
		this.lat=Double.parseDouble(str[2]);
		this.lon=Double.parseDouble(str[3]);
		this.high=Double.parseDouble(str[4]);
		int count=0;
		//Read[] samples=new Read[10];
;
		for (int i =5; i+3 < str.length; i+=4,count++) {
			Read temp=new Read(count,lineNumber,str[i],str[i+1],str[i+2],str[i+3],this.lat,this.lon,this.high);
			sampels.add(temp);
		}
		this.readnumber=sampels.size();
		
	}


	//**********************************************************************SET&&GET***********************************************************

	public int getLineNumber() {
		return lineNumber;
	}



	


	@Override
	public String toString() {
		return "LineRead [lineNumber=" + lineNumber + ", readnumber=" + readnumber + ", ID=" + ID + ", Type=" + Type
				+ ", Time=" + Time  + ", lat=" + lat + ", lon=" + lon
				+ ", high=" + high + "]\n"+ " samples=" + sampels;
	}


	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}







	public int getReadnumber() {
		return readnumber;
	}



	public void setReadnumber(int readnumber) {
		this.readnumber = readnumber;
	}



	public String getID() {
		return ID;
	}



	public void setID(String iD) {
		ID = iD;
	}



	public String getType() {
		return Type;
	}



	public void setType(String type) {
		Type = type;
	}



	


	public String getTime() {
		return Time;
	}



	public void setTime(String time) {
		Time = time;
	}



	



	public double getLat() {
		return lat;
	}



	public void setLat(double lat) {
		this.lat = lat;
	}



	public double getLon() {
		return lon;
	}



	public void setLon(double lon) {
		this.lon = lon;
	}



	public double getHigh() {
		return high;
	}



	public void setHigh(double high) {
		this.high = high;
	}


	
	
	//****************************************SET&&&&GET******************************************************************
	
	
	
}
