package demo;

public class Read {
	public int READnum=-1,  linenumber=-1,signlPower=0,accu=0;
	public String mac="",SSID="";
	public double lat=0, lon=0,high =0; 
	
	Read(int readnum , int line ,String id, String mac , String signal ,String acc,double lat,double lon ,double high){
		this.READnum=readnum;
		this.linenumber=line;
		this.signlPower=(int)Double.parseDouble(signal);
		this.mac=mac;
		this.SSID=id;
		this.accu=Integer.parseInt(acc);
		this.lat=lat;
		this.lon=lon;
		this.high=high;
		
	}

	@Override
	public String toString() {
		return "Read [READnum=" + READnum + ", linenumber=" + linenumber + ", signlPower=" + signlPower + ", accu="
				+ accu + ", mac=" + mac + ", SSID=" + SSID + ", lat=" + lat + ", lon=" + lon + ", high=" + high + "]";
	}


	
	
	
	
	
	
}
