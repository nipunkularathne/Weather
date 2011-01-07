package ucsc.android.weather;

import java.io.InputStream;
import java.net.URL;






import ucsc.android.object.WeatherParams;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;


public class ActivitySelectedPlace extends Activity {
	
	private TextView mainLocation;
	private TextView mainNature;
	private TextView mainTemp;
	private TextView mainHumidity;
	private TextView mainLatitude;
	private TextView mainWind;
	private TextView mainPressure;
	private ImageView mainImage;
	private TextView mainLongitude;
	private TextView mainVisibility;
	
	private TextView tempLocation;
	private ImageView tempImage;
	private TextView tempNature;
	private TextView tempCelsious;
	private TextView tempFar;
	private TextView tempTime;
	
	private TextView humiLocation;
	private ImageView humiImage;
	private TextView humiNature;
	private TextView humiHumidity;
	private TextView humiDewCelcius;
	private TextView humiDewFare;
	private TextView humiHeatCelsius;
	private TextView humiHeatFare;
	private TextView humiEveva;
	private TextView mainLocalTime;
	private TextView humiTime;
	
	private TextView windLocation;
	private TextView windTime;
	private ImageView windImage;
	private TextView windNature;
	private TextView windDirection;
	private TextView windDegree;
	private TextView windSpeed;
	
	private TextView pressLocation;
	private TextView pressTime;
	private ImageView pressImage;
	private TextView pressNature;
	private TextView press_bar;
	private TextView press_in;
	
	/*
	
	private TextView windLocation;
	private TextView tempTime;
	private TextView tv111;
	private TextView tv112;
	private TextView tv113;
	private TextView tv114;
	private ImageView humiImage;*/
	
	public String url = "http://api.wunderground.com/auto/wui/geo/WXCurrentObXML/index.xml";
    public String requestAppendedUrl = "";
    ProgressDialog progressDialog;
	/** Called when the activity is first created. */
    public String selectedPlaceCode;
    WeatherParams wp;
    
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.main);
	        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.mytitle2);
	    
	        
	        Button searchBtn = (Button) findViewById(R.id.bk);
	     //   searchBtn.destroyDrawingCache();
	        
	        TabHost tabs=(TabHost)findViewById(R.id.tabhost);
			
			tabs.setup();
			
			TabHost.TabSpec spec=tabs.newTabSpec("tag1");
			
			spec.setContent(R.id.tab1);
			spec.setIndicator("Main",getResources().getDrawable(R.drawable.main));
			tabs.addTab(spec);
			
			spec=tabs.newTabSpec("tag2");
			spec.setContent(R.id.tab2);
			spec.setIndicator("Temperature",getResources().getDrawable(R.drawable.temp));
			tabs.addTab(spec);
			
			spec=tabs.newTabSpec("tag3");
			spec.setContent(R.id.tab3);
			spec.setIndicator("Humidity",getResources().getDrawable(R.drawable.humi));
			tabs.addTab(spec);
			
			spec=tabs.newTabSpec("tag4");
			spec.setContent(R.id.tab4);
			spec.setIndicator("Wind",getResources().getDrawable(R.drawable.wind));
			tabs.addTab(spec);
			
			spec=tabs.newTabSpec("tag5");
			spec.setContent(R.id.tab5);
			spec.setIndicator("Pressure",getResources().getDrawable(R.drawable.press));
			tabs.addTab(spec);
     
      
			mainLocation = (TextView) findViewById(R.id.main_location);
     mainNature = (TextView) findViewById(R.id.main_nature);
        mainTemp = (TextView) findViewById(R.id.main_temp);
      mainHumidity = (TextView) findViewById(R.id.main_humd);
      mainLatitude = (TextView) findViewById(R.id.main_latitude);
      mainWind = (TextView) findViewById(R.id.main_wind);
      mainPressure = (TextView) findViewById(R.id.main_press);
      mainImage=(ImageView) findViewById(R.id.main_image);
      mainLongitude = (TextView) findViewById(R.id.main_longitude);
     mainVisibility = (TextView) findViewById(R.id.main_visi);
     
     tempLocation = (TextView) findViewById(R.id.temp_location);
     tempImage=(ImageView) findViewById(R.id.temp_image);
     tempNature = (TextView) findViewById(R.id.temp_nature);
     tempCelsious= (TextView) findViewById(R.id.temp_cel);
     tempFar = (TextView) findViewById(R.id.temp_far);
     
     humiLocation = (TextView) findViewById(R.id.humi_location);
     humiImage = (ImageView) findViewById(R.id.humi_image);
     humiNature = (TextView) findViewById(R.id.humi_nature);
     humiHumidity = (TextView) findViewById(R.id.humi_humi);
     humiDewCelcius = (TextView) findViewById(R.id.humi_dew_cel);
     humiDewFare = (TextView) findViewById(R.id.humi_dew_far);
     humiHeatCelsius = (TextView) findViewById(R.id.humi_heat_cel);
     humiHeatFare = (TextView) findViewById(R.id.humi_heat_far);
     humiEveva = (TextView) findViewById(R.id.humi_eveva);
     mainLocalTime = (TextView) findViewById(R.id.main_local_time);
     tempTime = (TextView) findViewById(R.id.temp_local_time);
    humiTime = (TextView) findViewById(R.id.humi_local_time);
    
    windLocation = (TextView) findViewById(R.id.wind_location);
    windTime = (TextView) findViewById(R.id.wind_local_time);
    windImage = (ImageView) findViewById(R.id.wind_image);
    windNature = (TextView) findViewById(R.id.wind_nature);
    windDirection = (TextView) findViewById(R.id.wind_direction);
    windDegree= (TextView) findViewById(R.id.wind_degree);
    windSpeed = (TextView) findViewById(R.id.wind_speed);
     
    pressLocation = (TextView) findViewById(R.id.press_location);
    pressTime = (TextView) findViewById(R.id.press_local_time);
    pressImage = (ImageView) findViewById(R.id.press_image);
    pressNature = (TextView) findViewById(R.id.press_nature);
    press_bar = (TextView) findViewById(R.id.press_bar);
    press_in= (TextView) findViewById(R.id.press_in);
    
      
        wp = (WeatherParams) getIntent().getSerializableExtra("wpobject");
        
        Log.v("ghhghghghghghghghg","testall");
       // mProgressDialog = Functions.getProgressDialog(this, getString(R.string.all_retriving_data));
      //  new WSGetTrainStations().execute(null, null, null);
        
  //  }
  
		    //System.out.print(result);
		    // here i have used a text view to show only one from the retrieved text. U can use these get methods to show the data to the client. Check the WeatherParams class for further reference.
		    mainLocation.setText(wp.getWlocation());
		    
		    mainNature.setText(wp.getWeather_nature());
		    mainTemp.setText(wp.getTemp_f());
		    mainHumidity.setText(wp.getRelative_humidity());
		    mainLatitude.setText(wp.getLatitude());
		    mainWind.setText(wp.getWind_string());
		    mainPressure.setText(wp.getPressure_mb());
		    Drawable drawable = LoadImageFromWebOperations(wp.getIcon());
		    mainImage.setImageDrawable(drawable);
		   mainLongitude.setText(wp.getLongitude());
		   mainVisibility.setText(wp.getVisibility_mi());
		   mainLocalTime.setText(wp.getObservation_time());
		   
		   tempLocation.setText(wp.getWlocation());
		   tempImage.setImageDrawable(drawable);
		   tempNature.setText(wp.getWeather_nature());
		   tempCelsious.setText(wp.getTemp_c());
		   tempFar.setText(wp.getTemp_f());
		   tempTime.setText(wp.getObservation_time());
		   
		   humiLocation.setText(wp.getWlocation());
		   humiImage.setImageDrawable(drawable);
		   humiTime.setText(wp.getObservation_time());
		   humiNature.setText(wp.getWeather_nature());
		   humiHumidity.setText(wp.getRelative_humidity());
		   humiDewCelcius.setText(wp.getDewpoString_c());
		   humiDewFare.setText(wp.getDewpoString_f());
		 //  humiHeatCelsius.setText("wp.getHeatIndexString_c()");
		//   humiHeatFare.setText("wp.getHeatIndexString_f()");
		//   humiEveva.setText("wp.getEvevaltion");
		//   humiTime.setText(wp.getObservation_time());
		   
		   windLocation.setText(wp.getWlocation());
		   windImage.setImageDrawable(drawable);
		   windTime.setText(wp.getObservation_time());
		   windNature.setText(wp.getWeather_nature());
		   windDirection.setText(wp.getwindDir());
		   windDegree.setText(wp.getWind_digree());
		   windSpeed.setText(wp.getWind_mph());
		   
		   pressLocation.setText(wp.getWlocation());
		   pressImage.setImageDrawable(drawable);
		   pressTime.setText(wp.getObservation_time());
		   pressNature.setText(wp.getWeather_nature());
		   press_bar.setText(wp.getPressure_mb());
		   press_in.setText(wp.getPressure_in());
		   		 
    	}
    	
   
    private Drawable LoadImageFromWebOperations(String url){
    	try
    	{
    	            InputStream is = (InputStream) new URL(url).getContent();
    	            Drawable d = Drawable.createFromStream(is, "src name");
    	            return d;
    	        }catch (Exception e) {
    	System.out.println("Exc="+e);
    	return null;
    	}
    	}

    
    
    	
    


}
