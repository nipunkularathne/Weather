package ucsc.android.util;

import java.io.StringReader;
import ucsc.android.object.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import android.util.Log;

public class ParseXml {

	private DocumentBuilderFactory dbf;
	private DocumentBuilder db;
	private WeatherParams weatherpar;
	
	public ParseXml(){
		try{
			dbf = DocumentBuilderFactory.newInstance();
			db = dbf.newDocumentBuilder();
			weatherpar = new WeatherParams();
		}
		catch (Exception e){
			System.out.println("Error initialize XML parser = " + e);

		}
	}

	public WeatherParams setAllparams(String responce){
	//	Log.v("cityTest00000000000000000", "ERRor");
		
		try{
			dbf = DocumentBuilderFactory.newInstance();
			db = dbf.newDocumentBuilder();
				Document doc = db.parse(new InputSource(new StringReader(responce)));
				doc.getDocumentElement().normalize();
				
				
				
				 NodeList nodeList = doc.getElementsByTagName("display_location");
				 Node node = nodeList.item(0);
				 Element fstElmnt = (Element) node;
				 NodeList nameList = fstElmnt.getElementsByTagName("city");
				 Element nameElement = (Element) nameList.item(0);
				 nameList = nameElement.getChildNodes();
				 String city =  nameList.item(0).getNodeValue();
				 Log.v("cityTest1", city);
				 weatherpar.setWlocation(city);
				 
				 nameList = fstElmnt.getElementsByTagName("latitude");
				 nameElement = (Element) nameList.item(0);
				 nameList = nameElement.getChildNodes();
				 String latitude =  nameList.item(0).getNodeValue();
				 Log.v("cityTest2", latitude);
				 weatherpar.setLatitude(latitude);
				 
				 nameList = fstElmnt.getElementsByTagName("longitude");
				 nameElement = (Element) nameList.item(0);
				 nameList = nameElement.getChildNodes();
				 String longitude =  nameList.item(0).getNodeValue();
				 Log.v("cityTest3", longitude);
				 weatherpar.setLongitude(longitude);
				 
				 nodeList = doc.getElementsByTagName("observation_time_rfc822");
				 node = nodeList.item(0);
				 fstElmnt = (Element) node;
				 nameList = fstElmnt.getElementsByTagName("observation_time_rfc822");
				 nameElement = (Element) nameList.item(0);
				 nameList = nameElement.getChildNodes();
				 String observation_time =  nameList.item(0).getNodeValue();
				 Log.v("cityTest4", observation_time);
				 weatherpar.setObservation_time(observation_time);
				 
				 
				 
				 nodeList = doc.getElementsByTagName("temp_f");
				 node = nodeList.item(0);
				 fstElmnt = (Element) node;
				 nameList = fstElmnt.getElementsByTagName("temp_f");
				 nameElement = (Element) nameList.item(0);
				 nameList = nameElement.getChildNodes();
				 String temp_f =  nameList.item(0).getNodeValue();
				 Log.v("cityTest5", temp_f);
				 weatherpar.setTemp_f(temp_f);
				 
				 nodeList = doc.getElementsByTagName("temp_c");
				 node = nodeList.item(0);
				 fstElmnt = (Element) node;
				 nameList = fstElmnt.getElementsByTagName("temp_c");
				 nameElement = (Element) nameList.item(0);
				 nameList = nameElement.getChildNodes();
				 String temp_c =  nameList.item(0).getNodeValue();
				 Log.v("cityTest6", temp_c);
				 weatherpar.setTemp_c(temp_c);
				 
				 nodeList = doc.getElementsByTagName("relative_humidity");
				 node = nodeList.item(0);
				 fstElmnt = (Element) node;
				 nameList = fstElmnt.getElementsByTagName("relative_humidity");
				 nameElement = (Element) nameList.item(0);
				 nameList = nameElement.getChildNodes();
				 String relative_humidity =  nameList.item(0).getNodeValue();
				 Log.v("cityTest7", relative_humidity);
				 weatherpar.setRelative_humidity(relative_humidity);
				 
				 nodeList = doc.getElementsByTagName("wind_string");
				 node = nodeList.item(0);
				 fstElmnt = (Element) node;
				 nameList = fstElmnt.getElementsByTagName("wind_string");
				 nameElement = (Element) nameList.item(0);
				 nameList = nameElement.getChildNodes();
				 String wind_string =  nameList.item(0).getNodeValue();
				 Log.v("cityTest8", wind_string);
				 weatherpar.setWind_string(wind_string);
				 
				 nodeList = doc.getElementsByTagName("wind_dir");
				 node = nodeList.item(0);
				 fstElmnt = (Element) node;
				 nameList = fstElmnt.getElementsByTagName("wind_dir");
				 nameElement = (Element) nameList.item(0);
				 nameList = nameElement.getChildNodes();
				 String wind_dir =  nameList.item(0).getNodeValue();
				 Log.v("cityTest8", wind_string);
				 weatherpar.setwindDir(wind_dir);
				 
				 nodeList = doc.getElementsByTagName("wind_degrees");
				 node = nodeList.item(0);
				 fstElmnt = (Element) node;
				 nameList = fstElmnt.getElementsByTagName("wind_degrees");
				 nameElement = (Element) nameList.item(0);
				 nameList = nameElement.getChildNodes();
				 String wind_degrees =  nameList.item(0).getNodeValue();
				 Log.v("cityTest8", wind_degrees);
				 weatherpar.setWind_digree(wind_degrees);
				 
				 
				 nodeList = doc.getElementsByTagName("wind_mph");
				 node = nodeList.item(0);
				 fstElmnt = (Element) node;
				 nameList = fstElmnt.getElementsByTagName("wind_mph");
				 nameElement = (Element) nameList.item(0);
				 nameList = nameElement.getChildNodes();
				 String wind_mph =  nameList.item(0).getNodeValue();
				 Log.v("cityTest8", wind_mph);
				 weatherpar.setWind_mph(wind_mph);
				 
				 nodeList = doc.getElementsByTagName("pressure_mb");
				 node = nodeList.item(0);
				 fstElmnt = (Element) node;
				 nameList = fstElmnt.getElementsByTagName("pressure_mb");
				 nameElement = (Element) nameList.item(0);
				 nameList = nameElement.getChildNodes();
				 String pressure_mb=  nameList.item(0).getNodeValue();
				 Log.v("cityTest9", pressure_mb);
				 weatherpar.setPressure_mb(pressure_mb);
				 
				 nodeList = doc.getElementsByTagName("pressure_in");
				 node = nodeList.item(0);
				 fstElmnt = (Element) node;
				 nameList = fstElmnt.getElementsByTagName("pressure_in");
				 nameElement = (Element) nameList.item(0);
				 nameList = nameElement.getChildNodes();
				 String pressure_in=  nameList.item(0).getNodeValue();
				 Log.v("cityTest10", pressure_in);
				 weatherpar.setPressure_in(pressure_in);
				 
				 nodeList = doc.getElementsByTagName("dewpoint_f");
				 node = nodeList.item(0);
				 fstElmnt = (Element) node;
				 nameList = fstElmnt.getElementsByTagName("dewpoint_f");
				 nameElement = (Element) nameList.item(0);
				 nameList = nameElement.getChildNodes();
				 String dewpoint_f=  nameList.item(0).getNodeValue();
				 Log.v("cityTest11", dewpoint_f);
				 weatherpar.setDewpoString_f(dewpoint_f);
				 
				 
				 
				 nodeList = doc.getElementsByTagName("dewpoint_c");
				 node = nodeList.item(0);
				 fstElmnt = (Element) node;
				 nameList = fstElmnt.getElementsByTagName("dewpoint_c");
				 nameElement = (Element) nameList.item(0);
				 nameList = nameElement.getChildNodes();
				 String dewpoint_c=  nameList.item(0).getNodeValue();
				 Log.v("cityTest12", dewpoint_c);
				 weatherpar.setDewpoString_c(dewpoint_c);
				 
				 nodeList = doc.getElementsByTagName("visibility_km");
				 node = nodeList.item(0);
				 fstElmnt = (Element) node;
				 nameList = fstElmnt.getElementsByTagName("visibility_km");
				 nameElement = (Element) nameList.item(0);
				 nameList = nameElement.getChildNodes();
				 String visibility_km=  nameList.item(0).getNodeValue();
				 Log.v("cityTest12", visibility_km);
				 weatherpar.setVisibility_mi(visibility_km);
				 
				 nodeList = doc.getElementsByTagName("weather");
				 node = nodeList.item(0);
				 fstElmnt = (Element) node;
				 nameList = fstElmnt.getElementsByTagName("weather");
				 nameElement = (Element) nameList.item(0);
				 nameList = nameElement.getChildNodes();
				 String weather =  nameList.item(0).getNodeValue();
				 Log.v("cityTest13", weather);
				 weatherpar.setWeather_nature(weather);
				 
			
				 
				 nodeList = doc.getElementsByTagName("icon_url");
				 node = nodeList.item(0);
				 fstElmnt = (Element) node;
				 nameList = fstElmnt.getElementsByTagName("icon_url");
				 nameElement = (Element) nameList.item(0);
				 nameList = nameElement.getChildNodes();
				 String icon_url =  nameList.item(0).getNodeValue();
				 Log.v("cityTest13", icon_url);
				 weatherpar.setIcon(icon_url);
		
		
		
		}
			catch (Exception e){
			//	Log.v("cityTest", "ERRor");
				System.out.println("Error initialize XML parser = " + e);

			}
	
		return weatherpar;
		
	}
	
}
