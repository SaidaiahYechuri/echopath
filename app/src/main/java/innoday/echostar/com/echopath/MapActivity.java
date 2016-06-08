package innoday.echostar.com.echopath;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.widget.Spinner;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

/**
 * Created by Sheshank.Kodam on 2/19/2016.
 */

public class MapActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Get the values from main activity. This code is not reqd.
        Bundle extra = getIntent().getExtras();
        ArrayList<LatLng> meetingRoomLocations = extra.getParcelableArrayList("meetingRoomLocationsIntent");

        setContentView(R.layout.map_activity);

        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("meetingRoomLocationsBundle", meetingRoomLocations);
        Marker_Activity ma = Marker_Activity.newInstance(bundle);


        // Start the fragment manager and transaction
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.maplayout, ma);
        fragmentTransaction.commit();
    }
}