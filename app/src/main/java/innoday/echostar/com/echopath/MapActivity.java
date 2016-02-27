package innoday.echostar.com.echopath;
import android.app.Activity;
import android.os.Bundle;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Sheshank.Kodam on 2/19/2016.
 */

public class MapActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_activity);

        FragmentManager FM = getFragmentManager();
        FragmentTransaction FT = FM.beginTransaction();
        Marker_Activity MA = new Marker_Activity();
        FT.add(R.id.maplayout,MA);
        FT.commit();
    }
}