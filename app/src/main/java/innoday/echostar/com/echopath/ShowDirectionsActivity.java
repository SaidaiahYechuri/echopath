package innoday.echostar.com.echopath;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView.LayoutParams;
import android.widget.Button;
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
        // Define scroll view
        ScrollView scroll = new ScrollView(this);
        scroll.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        scroll.setBackgroundResource(R.drawable.background);

        // Define relative mainLayout
        RelativeLayout mainLayout = new RelativeLayout(this);
        RelativeLayout.LayoutParams mainLayoutParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        mainLayout.setLayoutParams(mainLayoutParams);

        // Define relative mainLayout
        RelativeLayout directionsViewLayout = new RelativeLayout(this);
        RelativeLayout.LayoutParams directionsLayoutParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        directionsViewLayout.setLayoutParams(directionsLayoutParams);

        // get meeting room directions from main activity
        Bundle extra = getIntent().getExtras();
        ArrayList<EdgeDTO> meetingRoomDirections = (ArrayList<EdgeDTO>) extra.get("meetingRoomLocationsIntent");

        addShowMapButton(mainLayout);
        RelativeLayout.LayoutParams params[] = setLayoutParameters(meetingRoomDirections.size());
        ImageView[] iv = setImages(meetingRoomDirections);
        TextView[] tv = setdirectionText(meetingRoomDirections);
        alignViews(params, meetingRoomDirections, iv, tv);
        addViews(directionsViewLayout, params, meetingRoomDirections, iv, tv);
        scroll.addView(directionsViewLayout);
        mainLayout.addView(scroll);
        setContentView(mainLayout);

    }

    RelativeLayout.LayoutParams[] setLayoutParameters(int meetingRoomDirectionsSize){
        RelativeLayout.LayoutParams params[] = new RelativeLayout.LayoutParams[meetingRoomDirectionsSize*2];
        for (int i = 0; i < params.length; i++)
        {
            params[i] = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            if (i % 2 != 0 ) params[i].setMargins(40, 40, 40, 40);
        }
        return params;
    }
    String getDirectionsMessage(ArrayList<EdgeDTO> meetingRoomsLocations, int index){
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
        else if (face.equals("stairs_down")){
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
    ImageView[] setImages(ArrayList<EdgeDTO> meetingRoomDirections) {
        ImageView[] imageViews = new ImageView[meetingRoomDirections.size()];
        for (int direction = 0; direction < meetingRoomDirections.size(); direction++) {
            imageViews[direction] = new ImageView(this);
            imageViews[direction].setId(View.generateViewId());
            String face = meetingRoomDirections.get(direction).getFace().toLowerCase();
            switch (face) {
                case "left":
                    imageViews[direction].setImageResource(R.drawable.left);
                    break;
                case "right":
                    imageViews[direction].setImageResource(R.drawable.right);
                    break;
                case "straight":
                    imageViews[direction].setImageResource(R.drawable.straight);
                    break;
                case "back":
                    imageViews[direction].setImageResource(R.drawable.back);
                    break;
                case "stairs_down":
                    imageViews[direction].setImageResource(R.drawable.stairs_down);
                    break;
                case "stairs_up":
                    imageViews[direction].setImageResource(R.drawable.stairs_up);
                    break;
                default:
                    break;
            }
        }
        return imageViews;
    }
    TextView[] setdirectionText(ArrayList<EdgeDTO> meetingRoomDirections){
        TextView[] textView = new TextView[meetingRoomDirections.size()];
        for (int direction = 0; direction < meetingRoomDirections.size(); direction++){
            textView[direction] = new TextView(this);
            textView[direction].setId(View.generateViewId());
            String directionMessage = getDirectionsMessage(meetingRoomDirections, direction);
            textView[direction].setText(directionMessage);
            textView[direction].setTextSize(13);
            textView[direction].setTypeface(null, Typeface.BOLD);
        }
        return textView;
    }
    void alignViews(RelativeLayout.LayoutParams[] params, ArrayList<EdgeDTO> meetingRoomDirections, ImageView[] iv, TextView[] tv){
        // Align ImageView and TextView parameters
        int right_side_counter = 0;
        int next_line_counter = 0;
        int meetingRoomDirectionsSize = meetingRoomDirections.size();
        for (int i=0; i < params.length; i++) {
            if (i % 2 != 0 && right_side_counter < meetingRoomDirectionsSize) {
                params[i].addRule(RelativeLayout.RIGHT_OF, iv[right_side_counter].getId());
                params[i].addRule(RelativeLayout.ALIGN_BOTTOM, iv[right_side_counter].getId());
                right_side_counter += 1;
            }

            if (i != 0 && i%2 == 0 && next_line_counter < meetingRoomDirectionsSize) {
                params[i].addRule(RelativeLayout.BELOW, iv[next_line_counter].getId());
                next_line_counter += 1;
            }
        }
    }
    void addViews(RelativeLayout layout, RelativeLayout.LayoutParams[] params, ArrayList<EdgeDTO> meetingRoomDirections, ImageView[] iv, TextView[] tv){
        // Add views to the layout
        int imageViewCounter = 0;
        int textViewCounter = 0;
        int meetingRoomDirectionsSize = meetingRoomDirections.size();

        for (int i = 0; i < params.length; i++)
        {
            if (i % 2 == 0 && imageViewCounter < meetingRoomDirectionsSize) {
                layout.addView(iv[imageViewCounter], params[i]);
                imageViewCounter += 1;
            }

            if (i % 2 != 0 && textViewCounter < meetingRoomDirectionsSize) {
                layout.addView(tv[textViewCounter], params[i]);
                textViewCounter += 1;
            }
        }
    }

    void addShowMapButton(RelativeLayout mainLayout){
        Button showMapButton = new Button(this);
        showMapButton.setBackgroundResource(R.drawable.sm);
        showMapButton.setId(View.generateViewId());
        RelativeLayout.LayoutParams lp =
                new RelativeLayout.LayoutParams(
                        LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        lp.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        lp.addRule(RelativeLayout.CENTER_HORIZONTAL);
        mainLayout.addView(showMapButton, lp);

        showMapButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent showLayoutImageIntent = new Intent(v.getContext(), ShowLayoutImageActivity.class);
                startActivity(showLayoutImageIntent);

            }
        });
    }

}

