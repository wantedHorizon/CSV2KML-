package demo;

import java.io.File;
import java.util.Arrays;

public class FolderDemo {
	public String files[] ={null};
	boolean check=false;

	public int fileNum=0;
	
	//*********************************************gett&sett********************************
	public String[] getFiles() {
		return files;
	}
	public void setFiles(String[] files) {
		this.files = files;
	}

	public int getFileNum() {
		return fileNum;
	}

	public void setFileNum(int fileNum) {
		this.fileNum = fileNum;
	}
	
	
	public FolderDemo(String path) {
		// TODO Auto-generated constructor stub
		this.fileNum=countCsvFiles(path);
		if (this.fileNum>0) {
			this.check=true;
			
	
		this.files=fileNames(fileNum, path);
		//String f="f";
		CsvOrginaizer[] user=new CsvOrginaizer[fileNum];
		for (int i = 0; i < user.length; i++) {
			user[i]=new CsvOrginaizer(path+"\\"+files[i]);
			//user[i].Csv2kml(path+"\\"+files[i]);
			
		}
		
		}
		else {
			this.check=false;
			System.out.println("error csv files not found");

		}
		
	}
	public boolean checkExsitaence(String path) {
		boolean check=false;
		
		
		return check;
	}
	
	
	
	
	
	public static void main(String[] args) {/*
		// TODO Auto-generated method stub
		//countCsvFiles("c:\\new");
		String xx[];
		xx=(fileNames(countCsvFiles("c:\\new"), "c:\\new"));
		System.out.println(Arrays.toString(xx));*/
		FolderDemo x= new FolderDemo("c:\\new");
		//System.out.println(x.getFileNum()+"\n"+Arrays.toString(x.getFiles()));
		
	}
	public  int countCsvFiles(String directoryName){
		File directory = new File(directoryName);
		//get all the files from a directory
		File[] fList = directory.listFiles();
		int count=0;
		for (File file : fList){
			if (file.isFile()){
				if(file.getName().contains(".csv")) {
					//System.out.println(file.getName());
					count++;
				}
			}//a

		}//end for
		return count; 
	}//end countfiles 
	
	
	public  String[] fileNames(int count,String directoryName) {
		File directory = new File(directoryName);
		//get all the files from a directory
		File[] fList = directory.listFiles();
		String filesx[] =new String[count];
		int i=0;
		for (File file : fList){
			if (file.isFile()){
				if(file.getName().contains(".csv")) {
					filesx[i]=file.getName();
					i++;
				}
			}
		}
		return filesx;

	}// end list

}//end class
