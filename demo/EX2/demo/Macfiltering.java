package demo;

import java.util.ArrayList;

public class Macfiltering {
	public ArrayList<Read> Top4sampels=new ArrayList<Read>();
	
	Macfiltering(ArrayList<LineRead> line,String Mac,int signal) {
		for (int i = 0; i < line.size(); i++) {
			//LineRead temp=line.get(i);
			for (int j = 0; j < line.get(i).sampels.size(); j++) {
				if(line.get(i).sampels.get(j).mac.equalsIgnoreCase(Mac)) {
					Top4sampels.add(line.get(i).sampels.get(j));
					if(Top4sampels.size()>4)
						reduce2fourDIFF(Top4sampels);
						
				}
			}
	}
	}
	 Macfiltering(ArrayList<LineRead> line,String Mac) {
		// TODO Auto-generated constructor stub
		for (int i = 0; i < line.size(); i++) {
			//LineRead temp=line.get(i);
			for (int j = 0; j < line.get(i).sampels.size(); j++) {
				if(line.get(i).sampels.get(j).mac.equalsIgnoreCase(Mac)) {
					Top4sampels.add(line.get(i).sampels.get(j));
					if(Top4sampels.size()>4)
						reduce2four(Top4sampels);
						
				}
			}
			
		}
		
		
	}//end constractor
	 public void reduce2fourDIFF(ArrayList<Read> Top4sampels) {
		 
	 }
	public void reduce2four(ArrayList<Read> Top4sampels) {
		int minSignal=0,line=0;
		for (int i = 0; i < Top4sampels.size()-1; i++) {
			if(Top4sampels.get(i).signlPower>Top4sampels.get(line).signlPower)
				line=i;
			
		}
		Top4sampels.remove(line);
		
		
		
		
	}//REDUCE 

	public ArrayList<Read> getTop4sampels() {
		return Top4sampels;
	}

	public void setTop4sampels(ArrayList<Read> top4sampels) {
		Top4sampels = top4sampels;
	}

}
