package ucsc.android.weather;





import java.net.URLEncoder;

import ucsc.android.object.WeatherParams;
import ucsc.android.util.ParseXml;
import ucsc.android.webservice.RestClient;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


public class Weatherapp extends ListActivity {

	public String url = "http://api.wunderground.com/auto/wui/geo/WXCurrentObXML/index.xml";
    public String requestAppendedUrl = "";
    ProgressDialog progressDialog;
	/** Called when the activity is first created. */
    public String selectedPlaceCode;
 
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
       requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		 setContentView(R.layout.place_list_view);
	        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.mytitle);
	        ListView lv = getListView();
	        
	   
     
        String[] countries = getResources().getStringArray(R.array.places_array);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,                     // Application context
                R.layout.place_list,     // layout description for each list item
                countries);                // String array of countries defined
        setListAdapter(arrayAdapter);

        
        lv.setOnItemClickListener(new OnItemClickListener() {
          public void onItemClick(AdapterView<?> parent, View view,
              int position, long id) {
          
        	  String selectedItemCode=URLEncoder.encode((String) ((TextView) view).getText());
        	   selectedItemCode= selectedItemCode+",LK";
        	   progressDialog = new ProgressDialog(Weatherapp.this);				
          		progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
          		progressDialog.setMessage(getResources().getString(R.string.loading));
               progressDialog.show();
               
               WebServiceWeather service = new WebServiceWeather(selectedItemCode);
           		service.execute(null,null,null); 
        	   
          
          }
        });
       
       
        lv.setTextFilterEnabled(true);
        Button searchBtn = (Button) findViewById(R.id.bk);
        
        searchBtn.setOnClickListener(new View.OnClickListener() {
      	
    		public void onClick(View view) {
    			onSearchRequested();
    			//	 finish();
    		}
    		 
    	});

   		
    }
	 public boolean onSearchRequested() {
	     Bundle appData = new Bundle();
	 //    appData.putLong("appid",1);
	     
	     startSearch(null, false, appData, false);
	     return true;
	 }
	 final Handler webServiceCallHandler = new Handler() {
	    	public void handleMessage(Message message) {				
			//	@SuppressWarnings("unchecked")
				String result = (String) message.getData().getString("result");
				Log.v("rrrrrrrrrrrrrrr",result);
				ParseXml px = new ParseXml();
				WeatherParams wp = new WeatherParams();
			    wp = px.setAllparams(result);
			   
			    Intent nextScreen = new Intent(Weatherapp.this, ActivitySelectedPlace.class);
				nextScreen.putExtra("wpobject", wp);
				Weatherapp.this.startActivity(nextScreen);
				
			    //System.out.print(result);
			    // here i have used a text view to show only one from the retrieved text. U can use these get methods to show the data to the client. Check the WeatherParams class for further reference.
			    
	    	}
	    	
	    };
	 class WebServiceWeather extends AsyncTask<Object, Object, Object> {

	    	String selectedPlace;
	    	WebServiceWeather(String selected){
	    		selectedPlace=selected;
	    	}
	    	
			@Override
			protected Object doInBackground(Object... params) {
				RestClient client = RestClient.getService(url);
		        
		      
		       String selectedItemCode = selectedPlace; //have to assign the code of the selected item here dynamically from the intergface
		       requestAppendedUrl = url +"?query="+selectedItemCode;
		       try {
		            client.Execute(requestAppendedUrl);
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		         
		        String response = client.getResponse();
		       
				
				Message message = webServiceCallHandler.obtainMessage();
				Bundle bundle = new Bundle();
				bundle.putString("result", response);
				message.setData(bundle);
				webServiceCallHandler.sendMessage(message);
				 progressDialog.dismiss();
				return null;
			}
	    	
	    }
 
}