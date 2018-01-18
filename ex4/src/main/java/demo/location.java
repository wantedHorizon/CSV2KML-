package demo;

import java.util.ArrayList;
import java.util.Vector;

public class location {
	private double alt=0,lat=0,height=0;
	public Vector vec = new Vector();
	public location(){
		
	}


	public location(String a,String b ,String h,int line) {
		/**
		 * constractor to bulid location
		 */
		
			// TODO Auto-generated constructor stub
			this.alt=Double.parseDouble(a);
			this.lat=Double.parseDouble(b);
			this.height=Double.parseDouble(h);
			vec.add(line);
	}
	   public double getAlt() {
		return alt;
	}


	public void setAlt(double alt) {
		this.alt = alt;
	}


	public double getLat() {
		return lat;
	}


	public void setLat(double lat) {
		this.lat = lat;
	}


	public double getHeight() {
		return height;
	}


	public void setHeight(double height) {
		this.height = height;
	}


	public Vector getVec() {
		return vec;
	}


	public void setVec(Vector vec) {
		this.vec = vec;
	}


	public location(location x) {
		 this.alt=x.alt;
		 this.lat=x.lat;
		 this.height=x.height;
		 this.vec=x.vec;
		
	}
	   public String toString(){
		      return "alt:"+alt+"|lat:"+lat+"|h:"+height+"\n"+vec.toString();
		             
		    }


	public boolean CheckEqual(location x,int lineNUM) {
		boolean z=true;
		if(this.alt!=x.alt)
			return false;
		else if(this.lat!=x.lat)
			return false;
		else if(this.height!=x.height)
			return false;

		vec.add(lineNUM);


		return z;

	}//end equal check

}
