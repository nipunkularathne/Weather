package ucsc.android.object;

import java.io.Serializable;

public class WeatherParams implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String location; //city
	private String latitude; //latitude
	private String longitude;//longtitude
	private String observation_time;//observation_time , last updated
	private String local_time; //local_time
	private String weather_nature; // weather
	private String temp_f; // temp_f
	private String temp_c; // temp_c
	private String relative_humidity; //relative_humidity
	private String wind_string;//wind_string
	private String pressure_mb; //pressure_mb
	private String pressure_in; //pressure_in
	private String dewpoString_f;
	private String dewpoString_c;
	private String visibility_mi;
	private String windDir;
	private String wind_degrees;
	private String wind_mph;
	private String icon;

	
	
	public String getWlocation() {
		return location;
	}

	public void setWlocation(String wloc ) {
		this.location = wloc;
	}

	
	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude ) {
		this.latitude = latitude;
	}

	
	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude ) {
		this.longitude = longitude;
	}
	
	
	
	public String getObservation_time() {
		return observation_time;
	}

	public void setObservation_time(String ob ) {
		this.observation_time = ob;
	}
	
	
	
	
	public String getLocal_time() {
		return local_time;
	}

	public void setLocal_time(String lc ) {
		this.local_time = lc;
	}
	
	
	public String getWeather_nature() {
		return weather_nature;
	}

	public void setWeather_nature(String wn ) {
		this.weather_nature = wn;
	}
	
	
	
	public String getTemp_f() {
		return temp_f;
	}

	public void setTemp_f(String fh ) {
		this.temp_f = fh;
	}
	
	
	
	public String getTemp_c() {
		return temp_c;
	}

	public void setTemp_c(String cel ) {
		this.temp_c = cel;
	}
	
	
	
	public String getRelative_humidity() {
		return relative_humidity;
	}

	public void setRelative_humidity(String rh ) {
		this.relative_humidity = rh;
	}
	
	
	
	public String getWind_string() {
		return wind_string;
	}

	public void setWind_string(String wst ) {
		this.wind_string= wst;
	}
	
	
	
	public String getPressure_mb() {
		return pressure_mb;
	}

	public void setPressure_mb(String pre ) {
		this.pressure_mb= pre;
	}
	
	
	
	
	public String getPressure_in() {
		return pressure_in;
	}

	public void setPressure_in(String prein ) {
		this.pressure_in= prein;
	}
	
	
	
	public String getDewpoString_f() {
		return dewpoString_f;
	}

	public void setDewpoString_f(String dew ) {
		this.dewpoString_f = dew;
	}
	
	
	
	public String getDewpoString_c() {
		return dewpoString_c;
	}

	public void setDewpoString_c(String dewc ) {
		this.dewpoString_c = dewc;
	}
	
	
	
	public String getVisibility_mi() {
		return visibility_mi;
	}

	public void setVisibility_mi(String vis ) {
		this.visibility_mi = vis;
	}
	
	public String getwindDir() {
		return windDir;
	}

	public void setwindDir(String wdir ) {
		this.windDir = wdir;
	}
	
	public String getWind_digree() {
		return wind_degrees;
	}

	public void setWind_digree(String wdigree ) {
		this.wind_degrees = wdigree;
	}
	
	public String getWind_mph() {
		return wind_mph;
	}

	public void setWind_mph(String mph ) {
		this.wind_mph = mph;
	}
	
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon ) {
		this.icon = icon;
	}
}
