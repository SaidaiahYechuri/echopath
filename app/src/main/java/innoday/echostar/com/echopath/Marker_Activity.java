package innoday.echostar.com.echopath;

/**
 * Created by Sheshank.Kodam on 2/19/2016.
 */
import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;

public class Marker_Activity extends Fragment {
    public static Marker_Activity newInstance(Bundle b) {
        Marker_Activity marker_fragment = new Marker_Activity();
        marker_fragment.setArguments(b);
        return marker_fragment;
    }

    ArrayList<LatLng> locations = new ArrayList();
    Bundle b = null;
    GoogleMap googleMap;

    public void processMap(View v){
        if(googleMap == null){
            googleMap = ((MapFragment) getChildFragmentManager().findFragmentById(R.id.map)).getMap();
        }
        locations = b.getParcelableArrayList("meetingRoomLocationsBundle");
        System.out.print(locations);
        if(googleMap != null){
            for(LatLng location: locations){
                googleMap.addMarker(new MarkerOptions().position(location).title("EchoStar"));
                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 100));
            }
            // Instantiating the class PolylineOptions to plot polyline in the map
            PolylineOptions polylineOptions = new PolylineOptions();

            // drawing polyline
            polylineOptions.color(Color.BLUE);
            polylineOptions.width(7);
            polylineOptions.addAll(locations);
            googleMap.addPolyline(polylineOptions);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        b = getArguments();
        View v = inflater.inflate(R.layout.map_fragment_layout, container, false);
        processMap(v);
        return v;
    }
}

