package demo;

import java.awt.EventQueue;

import javax.swing.*;

import com.sun.java.swing.SwingUtilities3;

import sun.swing.SwingUtilities2;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;
import java.awt.event.ActionEvent;


public class guiapp {
	public boolean threadinit = false;
	public boolean threadwork = false;
	public boolean showfilter = false;
	guiUnited gu1 = null;

	private JFrame frame;
	private JTextField importTxt;
	private JTextField filtertime1;
	private JTextField filtertime2;
	private JTextField filterlat1;
	private JTextField filterlon1;
	private JTextField filteralt1;
	private JTextField filterdevicename;
private JLabel numfileslbl = new JLabel("number of files: 0");
private JLabel lblNumberOfInes = new JLabel("number of lines: 0");
private JTextField algo1txt;
private JTextField algo2txt;
private JTextField lat1;
private JTextField lon1;
private JTextField alt1;
private JTextField lat2;
private JTextField lon2;
private JTextField alt2;
private JTextField lat3;
private JTextField lon3;
private JTextField alt3;
private JTextField signal1;
private JTextField signal2;
private JTextField signal3;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guiapp window = new guiapp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public guiapp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		JLabel lblImportData = new JLabel("Import Data");
		
		JLabel lblNumberOfInes = new JLabel("number of lines: 0");
		importTxt = new JTextField();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 573, 434);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton importBtn = new JButton("import");
		importBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showfilter = false;
				threadwork = true;
				if (threadinit == false) {
					new Thread(){
					      public void run(){
					    	  while (true) {
					    		  try{Thread.sleep(2000);}catch(InterruptedException ie){ie.printStackTrace();}
					    	  if (threadwork) {
					    		  String folder = "";
					    		  folder = importTxt.getText();
									System.out.println(folder);
									System.out.println(filtertime1.getText().length());
									String f1 = filtertime1.getText();
									String f2 = filtertime2.getText();
									String f3 = filterlat1.getText();
									String f4 = filterlon1.getText();
									String f5 = filteralt1.getText();
									String f6 = filterdevicename.getText();
									if (showfilter == false) {
										f1 = "x";
										f2 = "x";
										f3 = "x";
										f4 = "x";
										f5 = "x";
										f6 = "x";
									}
									gu1 = new guiUnited(folder,f1,f2,f3,f4,f5,f6);
									
									SecondALGO yysy=new SecondALGO("12/05/17 11:36 AM,model=SM-G950F_device=dreamlte,?,?,?,10,Ariel_University,a0:63:91:69:f6:af,6,-50,Ariel_University,c4:3d:c7:5a:79:1c,44,-53, ,a0:21:b7:79:da:8c,44,-54,Ariel_University,24:79:2a:2b:07:bc,36,-73,DIRECT-66-HP DeskJet 3630 series,30:e1:71:0d:e0:67,6,-73,Ariel_University,24:79:2a:2b:07:b8,11,-74, ,24:79:2a:ab:07:b7,36,-75,DIRECT-8A-HP DeskJet 3630 series,3c:52:82:ef:a4:8b,6,-78,Ariel_University,24:79:2a:2c:5c:18,11,-86,Ariel_University,1c:b9:c4:16:06:bc,48,-88"
									,importTxt.getText()+"\\filters\\unitedCsv.csv");
									
									
									
									
							        
							        SwingUtilities.invokeLater(new Runnable(){
							          public void run(){
							        	  numfileslbl.setText("number of files: " + gu1.filenum);
											System.out.println(gu1.linesnum);
											lblNumberOfInes.setText("number of lines: " + gu1.linesnum);
							          }
							        });
					    	  }
					        }
					        
					      }
					    }.start();
					    threadinit = true;
				}
				threadinit = true;
				
				
				//Task1 bl = new Task1();
				//Thread t = new Thread(bl);
				//t.start();
			}
		});
		importBtn.setBounds(139, 59, 87, 23);
		frame.getContentPane().add(importBtn);
		
		importTxt = new JTextField();
		importTxt.setText("c://knew");
		importTxt.setBounds(10, 60, 119, 20);
		frame.getContentPane().add(importTxt);
		importTxt.setColumns(10);
		
		
		lblImportData.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblImportData.setBounds(68, 11, 119, 26);
		frame.getContentPane().add(lblImportData);
		
		
		numfileslbl.setBounds(10, 91, 105, 14);
		frame.getContentPane().add(numfileslbl);
		
		
		lblNumberOfInes.setBounds(10, 116, 137, 14);
		frame.getContentPane().add(lblNumberOfInes);
		
		JButton btnNewButton = new JButton("clear");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				threadwork = false;
				lblNumberOfInes.setText("number of lines: 0");
				numfileslbl.setText("number of files: 0");
				importTxt.setText("");
			}
		});
		btnNewButton.setBounds(139, 93, 87, 37);
		frame.getContentPane().add(btnNewButton);
		
		JButton csvsave = new JButton("save to csv");
		csvsave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "csv saved at: " + importTxt.getText()+"/filters");
			}
		});
		csvsave.setBounds(10, 141, 109, 23);
		frame.getContentPane().add(csvsave);
		
		JButton kmlsave = new JButton("save to kml");
		kmlsave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Csv2Kml c2k=new Csv2Kml(importTxt.getText()+"\\filters\\unitedCsv.csv",importTxt.getText()+"\\filters\\convertedKML.kml");
				if (c2k.succ)
					JOptionPane.showMessageDialog(null, "kml saved at: " + importTxt.getText()+"/filters");
				else
					JOptionPane.showMessageDialog(null, "error - please change the path in the textbox.");
			}
		});
		kmlsave.setBounds(129, 141, 109, 23);
		frame.getContentPane().add(kmlsave);
		
		JLabel lblFilters = new JLabel("Filters");
		lblFilters.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFilters.setBounds(384, 11, 80, 26);
		frame.getContentPane().add(lblFilters);
		
		JLabel lblTime = new JLabel("time: (year-month-day h:min:sec)");
		lblTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTime.setBounds(275, 29, 210, 38);
		frame.getContentPane().add(lblTime);
		
		filtertime1 = new JTextField();
		filtertime1.setText("x");
		filtertime1.setBounds(331, 62, 86, 20);
		frame.getContentPane().add(filtertime1);
		filtertime1.setColumns(10);
		
		filtertime2 = new JTextField();
		filtertime2.setText("x");
		filtertime2.setBounds(448, 62, 86, 20);
		frame.getContentPane().add(filtertime2);
		filtertime2.setColumns(10);
		
		JLabel lblTo = new JLabel("to");
		lblTo.setBounds(427, 66, 46, 14);
		frame.getContentPane().add(lblTo);
		
		JLabel lblLocation = new JLabel("location:");
		lblLocation.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLocation.setBounds(275, 89, 68, 30);
		frame.getContentPane().add(lblLocation);
		
		filterlat1 = new JTextField();
		filterlat1.setText("x");
		filterlat1.setBounds(331, 127, 62, 20);
		frame.getContentPane().add(filterlat1);
		filterlat1.setColumns(10);
		
		JLabel lblAlt = new JLabel("lat");
		lblAlt.setBounds(353, 105, 46, 14);
		frame.getContentPane().add(lblAlt);
		
		filterlon1 = new JTextField();
		filterlon1.setText("x");
		filterlon1.setColumns(10);
		filterlon1.setBounds(403, 127, 62, 20);
		frame.getContentPane().add(filterlon1);
		
		JLabel lblLon = new JLabel("lon");
		lblLon.setBounds(427, 105, 46, 14);
		frame.getContentPane().add(lblLon);
		
		filteralt1 = new JTextField();
		filteralt1.setText("x");
		filteralt1.setColumns(10);
		filteralt1.setBounds(475, 127, 62, 20);
		frame.getContentPane().add(filteralt1);
		
		JLabel lblAlt_1 = new JLabel("alt");
		lblAlt_1.setBounds(501, 105, 46, 14);
		frame.getContentPane().add(lblAlt_1);
		
		JLabel lblDeviceName = new JLabel("device name:");
		lblDeviceName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDeviceName.setBounds(275, 169, 93, 14);
		frame.getContentPane().add(lblDeviceName);
		
		filterdevicename = new JTextField();
		filterdevicename.setText("x");
		filterdevicename.setBounds(366, 168, 86, 20);
		frame.getContentPane().add(filterdevicename);
		filterdevicename.setColumns(10);
		
		JButton filterbtn = new JButton("filter");
		filterbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showfilter = true;
				
				/*String folder = "";
				if (wiggleRadio.isSelected()) {
					folder = importTxt.getText();
					System.out.println(folder);
				}
				
				guiUnited gu1 = new guiUnited(folder, filtertime1.getText(), filtertime2.getText(),filterlat1.getText(),filterlon1.getText(),filteralt1.getText(),filterdevicename.getText());
				numfileslbl.setText("number of files: " + gu1.filenum);
				lblNumberOfInes.setText("number of lines: " + gu1.linesnum);*/
			}
		});
		filterbtn.setBounds(305, 210, 89, 23);
		frame.getContentPane().add(filterbtn);
		
		JButton filterclear = new JButton("clear");
		filterclear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showfilter = false;
				filtertime1.setText("x");
				filtertime2.setText("x");
				filterlat1.setText("x");
				filterlon1.setText("x");
				filteralt1.setText("x");
				filterdevicename.setText("x");
				
			}
		});
		filterclear.setBounds(416, 210, 89, 23);
		frame.getContentPane().add(filterclear);
		
		JLabel lblPositionByMac = new JLabel("position by mac:");
		lblPositionByMac.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPositionByMac.setBounds(10, 208, 93, 23);
		frame.getContentPane().add(lblPositionByMac);
		
		algo1txt = new JTextField();
		algo1txt.setBounds(92, 211, 106, 20);
		frame.getContentPane().add(algo1txt);
		algo1txt.setColumns(10);
		
		JLabel algo1lat = new JLabel("lat: ");
		algo1lat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		algo1lat.setBounds(351, 272, 290, 20);
		frame.getContentPane().add(algo1lat);
		
		JLabel algo1lon = new JLabel("lon: ");
		algo1lon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		algo1lon.setBounds(353, 302, 290, 20);
		frame.getContentPane().add(algo1lon);
		
		JLabel algo1alt = new JLabel("alt: ");
		algo1alt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		algo1alt.setBounds(351, 339, 290, 20);
		frame.getContentPane().add(algo1alt);
		
		JButton btnNewButton_1 = new JButton("find");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//c0:ac:54:f5:7b:a7
				Vector e1 = gu1.algo1(importTxt.getText()+"\\filters\\unitedCsv.csv", algo1txt.getText());
				algo1lat.setText("lat: " + e1.get(2));
				algo1lon.setText("lon: " + e1.get(3));
				algo1alt.setText("alt: " + e1.get(4));
				//System.out.println();
			}
		});
		btnNewButton_1.setBounds(200, 210, 68, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblPositionByLine = new JLabel("position by line:");
		lblPositionByLine.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPositionByLine.setBounds(10, 242, 93, 23);
		frame.getContentPane().add(lblPositionByLine);
		
		algo2txt = new JTextField();
		algo2txt.setColumns(10);
		algo2txt.setBounds(92, 242, 106, 20);
		frame.getContentPane().add(algo2txt);
		
		JButton button = new JButton("find");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SecondALGO yysy=new SecondALGO("12/05/17 11:36 AM,model=SM-G950F_device=dreamlte,?,?,?,10,Ariel_University,a0:63:91:69:f6:af,6,-50,Ariel_University,c4:3d:c7:5a:79:1c,44,-53, ,a0:21:b7:79:da:8c,44,-54,Ariel_University,24:79:2a:2b:07:bc,36,-73,DIRECT-66-HP DeskJet 3630 series,30:e1:71:0d:e0:67,6,-73,Ariel_University,24:79:2a:2b:07:b8,11,-74, ,24:79:2a:ab:07:b7,36,-75,DIRECT-8A-HP DeskJet 3630 series,3c:52:82:ef:a4:8b,6,-78,Ariel_University,24:79:2a:2c:5c:18,11,-86,Ariel_University,1c:b9:c4:16:06:bc,48,-88"
						,importTxt.getText()+"\\filters\\unitedCsv.csv");
				algo1lat.setText("lat: " + yysy.lat);
				algo1lon.setText("lon: " +yysy.lon);
				algo1alt.setText("alt: " + yysy.alt);
			}
		});
		button.setBounds(200, 242, 68, 23);
		frame.getContentPane().add(button);
		
		JLabel lblPositionByMacs = new JLabel("position by mac's signal:");
		lblPositionByMacs.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPositionByMacs.setBounds(10, 273, 137, 23);
		frame.getContentPane().add(lblPositionByMacs);
		
		lat1 = new JTextField();
		lat1.setBounds(41, 317, 54, 20);
		frame.getContentPane().add(lat1);
		lat1.setColumns(10);
		
		JLabel lblMac = new JLabel("mac1");
		lblMac.setBounds(10, 320, 46, 14);
		frame.getContentPane().add(lblMac);
		
		lon1 = new JTextField();
		lon1.setColumns(10);
		lon1.setBounds(105, 317, 54, 20);
		frame.getContentPane().add(lon1);
		
		alt1 = new JTextField();
		alt1.setColumns(10);
		alt1.setBounds(169, 317, 54, 20);
		frame.getContentPane().add(alt1);
		
		JLabel lblMac_1 = new JLabel("mac2");
		lblMac_1.setBounds(10, 344, 46, 14);
		frame.getContentPane().add(lblMac_1);
		
		JLabel lblMac_2 = new JLabel("mac3");
		lblMac_2.setBounds(10, 371, 46, 14);
		frame.getContentPane().add(lblMac_2);
		
		lat2 = new JTextField();
		lat2.setColumns(10);
		lat2.setBounds(41, 342, 54, 20);
		frame.getContentPane().add(lat2);
		
		lon2 = new JTextField();
		lon2.setColumns(10);
		lon2.setBounds(105, 342, 54, 20);
		frame.getContentPane().add(lon2);
		
		alt2 = new JTextField();
		alt2.setColumns(10);
		alt2.setBounds(169, 342, 54, 20);
		frame.getContentPane().add(alt2);
		
		lat3 = new JTextField();
		lat3.setColumns(10);
		lat3.setBounds(41, 368, 54, 20);
		frame.getContentPane().add(lat3);
		
		lon3 = new JTextField();
		lon3.setColumns(10);
		lon3.setBounds(105, 368, 54, 20);
		frame.getContentPane().add(lon3);
		
		alt3 = new JTextField();
		alt3.setColumns(10);
		alt3.setBounds(169, 368, 54, 20);
		frame.getContentPane().add(alt3);
		
		JLabel lblLat = new JLabel("lat");
		lblLat.setBounds(49, 304, 46, 14);
		frame.getContentPane().add(lblLat);
		
		JLabel lblLon_1 = new JLabel("lon");
		lblLon_1.setBounds(113, 304, 46, 14);
		frame.getContentPane().add(lblLon_1);
		
		JLabel lblAlt_2 = new JLabel("alt");
		lblAlt_2.setBounds(180, 304, 46, 14);
		frame.getContentPane().add(lblAlt_2);
		
		JLabel lblSignal = new JLabel("signal");
		lblSignal.setBounds(238, 304, 46, 14);
		frame.getContentPane().add(lblSignal);
		
		signal1 = new JTextField();
		signal1.setColumns(10);
		signal1.setBounds(233, 317, 54, 20);
		frame.getContentPane().add(signal1);
		
		signal2 = new JTextField();
		signal2.setColumns(10);
		signal2.setBounds(233, 342, 54, 20);
		frame.getContentPane().add(signal2);
		
		signal3 = new JTextField();
		signal3.setColumns(10);
		signal3.setBounds(233, 368, 54, 20);
		frame.getContentPane().add(signal3);
		
		JButton button_1 = new JButton("find");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (signal3.getText().length() > 0) {
					float sig1 = 1/Float.parseFloat(signal1.getText());
					sig1 *= sig1;
					float sig2 = 1/Float.parseFloat(signal2.getText());
					sig2 *= sig2;
					float sig3 = 1/Float.parseFloat(signal3.getText());
					sig3 *= sig3;
					float sigs = sig1 + sig2 + sig3;
					float lat1e = Integer.parseInt(lat1.getText()) * sig1 / sigs;
					float lat2e = Integer.parseInt(lat2.getText()) * sig2 / sigs;
					float lat3e = Integer.parseInt(lat3.getText()) * sig3 / sigs;
					algo1lat.setText("lat: " + (lat1e + lat2e + lat3e));
					float lon1e = Integer.parseInt(lon1.getText()) * sig1 / sigs;
					float lon2e = Integer.parseInt(lon2.getText()) * sig2 / sigs;
					float lon3e = Integer.parseInt(lon3.getText()) * sig3 / sigs;
					algo1lon.setText("lon: " + (lon1e + lon2e + lon3e));
					float alt1e = Integer.parseInt(alt1.getText()) * sig1 / sigs;
					float alt2e = Integer.parseInt(alt2.getText()) * sig2 / sigs;
					float alt3e = Integer.parseInt(alt3.getText()) * sig3 / sigs;
					algo1alt.setText("alt: " + (alt1e + alt2e + alt3e));
				}else if (signal2.getText().length() > 0) {
					float sig1 = 1/Float.parseFloat(signal1.getText());
					sig1 *= sig1;
					float sig2 = 1/Float.parseFloat(signal2.getText());
					sig2 *= sig2;
					float sigs = sig1 + sig2;
					float lat1e = Integer.parseInt(lat1.getText()) * sig1 / sigs;
					float lat2e = Integer.parseInt(lat2.getText()) * sig2 / sigs;
					algo1lat.setText("lat: " + (lat1e + lat2e));
					float lon1e = Integer.parseInt(lon1.getText()) * sig1 / sigs;
					float lon2e = Integer.parseInt(lon2.getText()) * sig2 / sigs;
					algo1lon.setText("lon: " + (lon1e + lon2e));
					float alt1e = Integer.parseInt(alt1.getText()) * sig1 / sigs;
					float alt2e = Integer.parseInt(alt2.getText()) * sig2 / sigs;
					algo1alt.setText("alt: " + (alt1e + alt2e));
				}else if (signal1.getText().length() > 0){
					algo1lat.setText("lat: " + lat1.getText());
					algo1lon.setText("lon: " + lon1.getText());
					algo1alt.setText("alt: " + alt1.getText());
				}
				
			}
		});
		button_1.setBounds(288, 320, 55, 65);
		frame.getContentPane().add(button_1);
		
		
		
		
		
	}
}
