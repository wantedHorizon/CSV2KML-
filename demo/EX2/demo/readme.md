# Csv to kml

About the project
-----------------------------
The goal of this project is to develop a complex system that enables the collection of geographic information, the production of insights
From this information and display the information in graphical tools.

This project consists of Java code classes.

System requirements
----------------------------
What was needed to build this project is Java software programmed into an operating system (eg Eclipse)

An app is required to save the following geographic information:
1. Geographic location in coordinates: lat, lon, alt.
2. Time.
3. Device ID: A unique number for each device.
4. A list of WiFi networks that include the network name and MAC.
5. Signal strength of the cellular network.

The classes
-------------
FolderDemo:

This class accepts a file folder and filters CSV files (CSV files are the ones you want)

FilterByTime:

This class accepts a CSV file and creates a new CSV file only for a time.
 Filtered time is the desired time in a certain range, including date and time

FilterByID:

This class accepts a CSV file and creates a new CSV file only for a ID 
You can register part of the ID and the classwill know what the ID is

FilterByLatLonAlt:

This class accepts a CSV file and creates a new CSV file only for a lat, a lon and a alt.

Csv2Kml:

This class accepts a CSV file and converts it to a KML file.
 This KML file includes the names of the WIFI networks and the description
 
united:

This class consolidates CSV files into a single CSV file.

This class has access to the other classes that create the files you want.

Image from experiment
----------------------
![default](https://user-images.githubusercontent.com/33933153/33527265-6615b688-d856-11e7-82f3-d3ee433d5d53.png)










 
