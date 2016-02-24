package innoday.echostar.com.echopath;

/**
 * Created by Sheshank.Kodam on 2/19/2016.
 */
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Marker_Activity extends Fragment {
    GoogleMap googleMap;
    private static final LatLng Echostar = new LatLng(10,20);

    public void processMap(View v){
        if(googleMap == null){
            googleMap = ((MapFragment) getChildFragmentManager().findFragmentById(R.id.map)).getMap();
        }

        if(googleMap != null){
            googleMap.addMarker(new MarkerOptions().position(Echostar).title("This is the marked area"));
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Echostar,100));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.map_activity, container, false);
        processMap(v);
        return v;
    }
}
