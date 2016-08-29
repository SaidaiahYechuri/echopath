package innoday.echostar.com.echopath;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sheshank.Kodam on 7/4/2016.
 */
public class ShowDirectionsActivity extends Activity{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extra = getIntent().getExtras();
//        ArrayList<EdgeDTO> meetingRoomLocations = extra.getParcelableArrayList("meetingRoomLocationsIntent");
        ArrayList<EdgeDTO> myList = (ArrayList<EdgeDTO>) extra.get("meetingRoomLocationsIntent");
        // Define scroll view
        ScrollView scroll = new ScrollView(this);
        scroll.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        scroll.setBackgroundColor(Color.parseColor("#fbefeb"));

        // Define relative layout
        RelativeLayout layout = new RelativeLayout(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        layout.setLayoutParams(layoutParams);


        // Get json
        int json_len = myList.size();
//        String direction = "left";

        // Set layout parameters
        RelativeLayout.LayoutParams params[] = set_layout_parameters(json_len);

        // Set image_view and text_view
        ImageView[] iv = new ImageView[json_len];
        TextView[] tv = new TextView[json_len];
        for (int i = 0; i < json_len; i++)
        {
            iv[i] = new ImageView(this);
            iv[i].setId(View.generateViewId());
            if (myList.get(i).getFace().toLowerCase().equals("left")) iv[i].setImageResource(R.drawable.left2);
            if (myList.get(i).getFace().toLowerCase().equals("right")) {
                iv[i].setImageResource(R.drawable.right1);
            }
            if (myList.get(i).getFace().toLowerCase().equals("straight")) iv[i].setImageResource(R.drawable.straight1);
            if (myList.get(i).getFace().toLowerCase().equals("u-turn")) iv[i].setImageResource(R.drawable.uturn);

            tv[i] = new TextView(this);
            tv[i].setId(View.generateViewId());
            StringBuilder directionMessages = new StringBuilder(14);
            directionMessages.append("Take ")
                    .append(myList.get(i).getFace())
                    .append(". ")
                    .append("Go ")
                    .append(String.valueOf(myList.get(i).getDistance()))
                    .append("m");
            tv[i].setText(directionMessages.toString());
            tv[i].setTextSize(15);

        }

        // Align layout and view parameters
        int right_side_counter = 0;
        int next_line_counter = 0;
        for (int i=0; i < params.length; i++)
        {

            if (i % 2 != 0 && right_side_counter < json_len)
            {
                params[i].addRule(RelativeLayout.RIGHT_OF, iv[right_side_counter].getId());
                params[i].addRule(RelativeLayout.ALIGN_BOTTOM, iv[right_side_counter].getId());
                right_side_counter += 1;
            }

            if (i != 0 && i%2 == 0 && next_line_counter < json_len)
            {
                params[i].addRule(RelativeLayout.BELOW, iv[next_line_counter].getId());
                next_line_counter += 1;
            }

        }

        // Add views to the layout
        int iv_counter = 0;
        int tv_counter = 0;
        for (int i = 0; i < params.length; i++)
        {
            if (i % 2 == 0 && iv_counter < json_len) {
                layout.addView(iv[iv_counter], params[i]);
                iv_counter += 1;
            }

            if (i % 2 != 0 && tv_counter < json_len) {
                layout.addView(tv[tv_counter], params[i]);
                tv_counter += 1;
            }
        }

        // Add relative layout to scroll
        scroll.addView(layout);
        setContentView(scroll);
    }

    RelativeLayout.LayoutParams[] set_layout_parameters(int json_len){
        /**
         * input = json length
         * output = layout params
         */
        RelativeLayout.LayoutParams params[] = new RelativeLayout.LayoutParams[json_len*2];
        for (int i = 0; i < params.length; i++)
        {
            params[i] = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            if (i % 2 != 0 ) params[i].setMargins(40, 40, 40, 40);
        }
        return params;
    }
}

