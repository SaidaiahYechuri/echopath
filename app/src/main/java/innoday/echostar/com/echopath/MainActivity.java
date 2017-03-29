package innoday.echostar.com.echopath;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    JSONObject fromMeetingRoomObj = new JSONObject();
    JSONObject toMeetingRoomObj = new JSONObject();
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = (Button) findViewById(R.id.find);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Spinner fromSpinner = (Spinner) findViewById(R.id.from);
                Spinner toSpinner = (Spinner) findViewById(R.id.to);

                Location fromLocation = getMeetingRoomValues(fromSpinner, fromMeetingRoomObj);
                Location toLocation = getMeetingRoomValues(toSpinner, toMeetingRoomObj);
                new ShortestDistanceTask(fromLocation, toLocation).execute();
            }
        });

    }

    public Location getMeetingRoomValues(Spinner spinner, JSONObject meetingRoomObj){
        Location meetingRoomValues = new Location();
        try{
            meetingRoomValues = (Location) meetingRoomObj.get(spinner.getSelectedItem().toString());
        } catch (JSONException e){
            Log.e("onClick: ", e.getMessage(), e);
        }

        return meetingRoomValues;
    }

    @Override
    protected void onStart() {
        super.onStart();
        new HttpRequestTask().execute();
    }

    public void setSpinners(){
        Spinner from = (Spinner)findViewById(R.id.from);
        List fromMeetingRoomNames = getMeetingRoomNames(fromMeetingRoomObj);
        ArrayAdapter<String> fromAdapter = new ArrayAdapter<String>(this,
                R.layout.spinner_item, fromMeetingRoomNames);
        fromAdapter.setDropDownViewResource(R.layout.spinner_item);
        from.setAdapter(fromAdapter);

        Spinner to = (Spinner)findViewById(R.id.to);
        List toMeetingRoomNames = getMeetingRoomNames(toMeetingRoomObj);
        ArrayAdapter<Location> toAdapter = new ArrayAdapter<Location>(this,
                R.layout.spinner_item, toMeetingRoomNames);
        toAdapter.setDropDownViewResource(R.layout.spinner_item);
        to.setAdapter(toAdapter);
    }

    public List getMeetingRoomNames(JSONObject meetingRoomObj){
        List meetingRoomNames = new ArrayList();
        JSONArray meetingRoomsKeys = meetingRoomObj.names();
        for (int i = 0; i < meetingRoomsKeys.length(); i++) {
            try {
                meetingRoomNames.add(meetingRoomsKeys.get(i));
            }catch (JSONException e){
                Log.e("setSpinners: ",e.getMessage(), e);
            }
        }
        return meetingRoomNames;
    }


    private class HttpRequestTask extends AsyncTask<Void, Void, LocationsDTO> {

        @Override
        protected LocationsDTO doInBackground(Void... params) {
            try {
                final String url = "http://10.73.172.60:8080/echopath/location/locationsOnly";

                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                LocationsDTO locationsDTO = restTemplate.getForObject(url, LocationsDTO.class);
                return locationsDTO;
            } catch (Throwable e) {
                Log.e("MainActivity", e.getMessage(), e);
                throw  new  RuntimeException(e);
            }
        }

        @Override
        protected void onPostExecute(LocationsDTO locationsDTO) {
            try {
                fromMeetingRoomObj.put("From?", "");
                toMeetingRoomObj.put("To?", "");
            }catch (JSONException e) {
                Log.e("MainActivity", e.getMessage(), e);}

            for(Location location : locationsDTO.getLocations()){
                try {
                    fromMeetingRoomObj.put(location.getName(), location);
                    toMeetingRoomObj.put(location.getName(), location);
                }catch (JSONException e) {
                    Log.e("MainActivity", e.getMessage(), e);}
            }
            setSpinners();
        }

    }

    public class ShortestDistanceTask extends AsyncTask<Void, Void, TempShortestPath> {

        private static final String BASE_URL = "http://10.73.172.60:8080/echopath/location/";
        private Location fromLocation;
        private  Location toLocation;
        private TempShortestPath shortestPathDTO = new TempShortestPath();

        public ShortestDistanceTask(Location fromLocation, Location toLocation){
              this.fromLocation = fromLocation;
              this.toLocation = toLocation;
        }

        @Override
        protected TempShortestPath doInBackground(Void... params) {
            try {


                RestTemplate restOperations = new RestTemplate();
                restOperations.getMessageConverters().add(new MappingJackson2HttpMessageConverter());


                if (fromLocation != null && toLocation != null) {
                    shortestPathDTO = restOperations.getForObject(BASE_URL
                            + "shortestPath?fromID=" + fromLocation.getId() + "&toID="
                            + toLocation.getId(), TempShortestPath.class);
                }

            } catch (Throwable e) {
                Log.e("MainActivity", e.getMessage(), e);
                throw  new  RuntimeException(e);
            }

            return  shortestPathDTO;
        }

        @Override
        protected void onPostExecute(TempShortestPath shortestPathDTO) {
            ArrayList<EdgeDTO> edgeDtoMeetingRoomDirections = shortestPathDTO.getEdgeDTOs();
            sendInfoToDirectionActivity(edgeDtoMeetingRoomDirections);
        }
    }

    public void sendInfoToDirectionActivity(ArrayList<EdgeDTO> edgeDtoMeetingRoomDirections) {
        Intent showDirectionsIntent = new Intent(MainActivity.this, ShowDirectionsActivity.class);
        showDirectionsIntent.putExtra("meetingRoomLocationsIntent", edgeDtoMeetingRoomDirections);
        startActivity(showDirectionsIntent);
    }
}
