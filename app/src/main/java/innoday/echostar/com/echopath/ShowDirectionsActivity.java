package innoday.echostar.com.echopath;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

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
        RelativeLayout.LayoutParams params[] = setLayoutParameters(json_len);

        // Set image_view and text_view
        ImageView[] iv = new ImageView[json_len];
        TextView[] tv = new TextView[json_len];
        for (int i = 0; i < json_len; i++)
        {
            iv[i] = new ImageView(this);
            iv[i].setId(View.generateViewId());
            if (myList.get(i).getFace().toLowerCase().equals("left")) iv[i].setImageResource(R.drawable.left);
            if (myList.get(i).getFace().toLowerCase().equals("right")) iv[i].setImageResource(R.drawable.right);
            if (myList.get(i).getFace().toLowerCase().equals("straight")) iv[i].setImageResource(R.drawable.straight);
            if (myList.get(i).getFace().toLowerCase().equals("back")) iv[i].setImageResource(R.drawable.back);
            if (myList.get(i).getFace().toLowerCase().equals("stairs_down")) iv[i].setImageResource(R.drawable.stairs_down);
            if (myList.get(i).getFace().toLowerCase().equals("stairs_up")) iv[i].setImageResource(R.drawable.stairs_up);

            tv[i] = new TextView(this);
            tv[i].setId(View.generateViewId());
            String directionMessage = getDirectionsForMessage(myList, i);
            tv[i].setText(directionMessage);
            tv[i].setTextSize(13);
            tv[i].setTypeface(null, Typeface.BOLD);

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

    RelativeLayout.LayoutParams[] setLayoutParameters(int json_len){
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

    String getDirectionsForMessage(ArrayList<EdgeDTO> meetingRoomsLocations, int index)
    {
        String face = meetingRoomsLocations.get(index).getFace().toLowerCase();
        String to = meetingRoomsLocations.get(index).getTo().toLowerCase();
        String text1 = "";
        String text2 = "";
        String text3 = "";

        if (face.equals("straight")) {
            text1 = "Go ";
        }
        else text1 = "Take ";

        if (face.equals("stairs_up")) {
            text2 = "stairs up ";
        }
        else if (face.equals("stairs_up")){
            text2 = "stairs down ";
        }
        else text2 = face.toLowerCase()+ " ";

        if (to.contains("intersection")){
            text3 = "intersection";
        }
        else{
            text3 = to + " ";
        }


        StringBuilder directionMessages = new StringBuilder(14);
        directionMessages.append(text1)
                .append(text2)
                .append("and ")
                .append("continue ")
                .append(String.valueOf(meetingRoomsLocations.get(index).getDistance()))
                .append("m ")
                .append("to ")
                .append(text3);
        return directionMessages.toString();
    }

}

